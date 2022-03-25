package priv.mw.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.http.HttpRequest;
import priv.mw.utils.JWTUtils;
import priv.mw.utils.Result;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class JWTFilter extends FormAuthenticationFilter {

    ObjectMapper mapper = new ObjectMapper();
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        //Bearer
        HttpServletRequest req = (HttpServletRequest) request;
        String rawToken = req.getHeader("Authorization");
        response.setContentType("text/json;charset=utf-8");
        if(rawToken == null || "".equals(rawToken)){
            try {
                response.getWriter().println(mapper.writeValueAsString(Result.data("").msg("未认证，请先认证！").code(401)));
                return false;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }else {
            String token = rawToken.substring(7);
            boolean tokenValid = JWTUtils.checkToken(token);
            if(!tokenValid){
                try {
                    response.getWriter().println(mapper.writeValueAsString(Result.data("").msg("认证已过期，请重新登录！").code(401)));
                    return false;
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }else {
                return  true;
            }
        }
    }
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        HttpServletRequest req = (HttpServletRequest) request;
        String token = req.getHeader("Authorization");
        response.setContentType("text/json;charset=utf-8");
        if(token == null || "".equals(token)){
            return false;
        }else {
            boolean tokenValid = JWTUtils.checkToken(token);
            if(!tokenValid){
                return  false;
            }else{
                return true;
            }
        }
    }

    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
        return super.executeLogin(request, response);
    }
}
