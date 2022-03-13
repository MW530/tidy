package priv.mw.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import priv.mw.exception.TokenExpiredException;
import priv.mw.utils.JWTUtils;
import priv.mw.utils.Result;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


public class TidyJWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private static final String tokenHeaderName = "Authorization";

    ObjectMapper mapper = new ObjectMapper();

    private UserDetailsService tidyUserDetailsService;

    @Autowired
    public void setTidyUserDetailsService(UserDetailsService tidyUserDetailsService) {
        this.tidyUserDetailsService = tidyUserDetailsService;
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        String token = request.getHeader(tokenHeaderName);
        String name = JWTUtils.parseTokenToName(token);
        res.setContentType("application/json;charset=utf-8");
        // 此处在springMVC外部了，不能依靠统一响应来抛出异常了
        if(name == null){
            String s = mapper.writeValueAsString(Result.getResult(new TokenExpiredException()));
            res.getWriter().println(s);
            return;
        }
        UserDetails userDetails = tidyUserDetailsService.loadUserByUsername(name);

        if(userDetails.isEnabled()){
            String s = mapper.writeValueAsString(Result.data("错误！").code(403).msg("账号被封禁！"));
            res.getWriter().println(s);
            return;
        }
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        chain.doFilter(req, res);
    }
}
