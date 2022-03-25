package priv.mw.resolver;

import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import priv.mw.annotation.UserId;
import priv.mw.domain.Essay;
import priv.mw.exception.ServerException;
import priv.mw.exception.TokenExpiredException;
import priv.mw.utils.JWTUtils;
import priv.mw.utils.JSONUtils;

import javax.servlet.http.HttpServletRequest;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import static priv.mw.utils.RequestUtils.getRequestJsonString;

@Component
public class UserIdHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {
    private final String[] userMethodIdExpList = {"uid", "id"};

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        if (parameter.hasParameterAnnotation(UserId.class)) {
            return true;
        }
        return false;
    }
    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        String token = webRequest.getHeader("Authorization");
        Integer id = JWTUtils.parseTokenToId(token.substring(7));
        if(id == null){
            throw  new TokenExpiredException("token过期！");
        }
        // 直接简单参数int-userId
        if(parameter.getParameterAnnotation(UserId.class).value() == "base"){
            if(parameter.getParameterType() != Integer.class){
                throw new RuntimeException("UserId注解base模式下，参数必须为Integer类型");
            }
            return id;
        }else{  //对象的属性自动赋值
            Class<?> type = parameter.getParameter().getType();
            String requestJsonString = getRequestJsonString(webRequest.getNativeRequest(HttpServletRequest.class));
            Object o = JSONUtils.parseJSON(requestJsonString, type);
            Parameter rawParameter = parameter.getParameter();
            for (String s : userMethodIdExpList) {
                PropertyDescriptor pd = new PropertyDescriptor(s,type);
                Method writeMethod = pd.getWriteMethod();
                writeMethod.invoke(o, id);
                return o;
            }
            Essay essay = new Essay();
            throw new ServerException("UserId注解obj模式下，参数对象必须含有uid/id字段");
        }
    }
}
