package priv.mw.advice;

import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import priv.mw.exception.AuthException;
import priv.mw.exception.ClientException;
import priv.mw.exception.CommonException;
import priv.mw.exception.ServerException;

@RestControllerAdvice
public class ExceptionResponseAdvice {

    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public Exception handleException(Exception exception){
        System.out.println(exception);
        return exception;
    }
}
