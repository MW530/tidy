package priv.mw.advice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import priv.mw.utils.Result;

@RestControllerAdvice
public class MyResponseBodyAdvice implements ResponseBodyAdvice<Object> {

    ObjectMapper mapper = new ObjectMapper();

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        //处理返回值是String的状况
        //处理字符串类型数据
        if(o instanceof String){
          try {
            return mapper.writeValueAsString(Result.data(o));
           } catch (JsonProcessingException e) {
              e.printStackTrace();
          }
        }

        // 处理错误
        if(o instanceof  Exception){
            return Result.getResult((Exception) o);
        }

        return o instanceof Result ? o : Result.data(o);
    }
}
