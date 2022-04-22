package priv.mw.resolver;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import priv.mw.annotation.SingleJSONParam;
import priv.mw.utils.JSONUtils;

import javax.servlet.http.HttpServletRequest;

import java.util.HashMap;

import static priv.mw.utils.RequestUtils.getRequestJsonString;

public class SingleJSONParamHandlerMethodArgumentResolver  implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(SingleJSONParam.class) ? true : false;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        String parameterName = parameter.getParameterName();
        String annoValueName = parameter.getParameter().getAnnotation(SingleJSONParam.class).value();
        String realName = annoValueName == "0" ? annoValueName : parameterName;
        String requestJsonString = getRequestJsonString(webRequest.getNativeRequest(HttpServletRequest.class));
        HashMap map = (HashMap)JSONUtils.parseJSON(requestJsonString, HashMap.class);
        Object realValue = map.get(realName);
        return realValue;
    }
}
