package priv.mw.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import priv.mw.exception.ClientException;
import priv.mw.exception.ServerException;
import priv.mw.exception.TokenExpiredException;

import java.util.HashMap;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    /**
     * code:
     *      200： 正常,
     *      400：客户端错误，
     *      401：认证失败，
     *      404：地址不存在，
     *      500：内部服务器错误
     */

    private int code;
    private Object data;
    private String msg;

    /**
     * @description must be called first to get the initial Result object
     * @param data returned content
     * @return new Result Object
     */
    public static Result data(Object data){
        Result result = new Result();
        result.setCode(200);
        result.setData(data);
        result.setMsg("ok");
        return result;
    }

    /**
     *
     * @param code the override code
     * @return existing Result object
     */
    public Result code(int code){
        this.setCode(code);
        return this;
    }

    /**
     *
     * @param msg the override message
     * @return existing Result object
     */
    public Result msg(String msg){
        this.setMsg(msg);
        return this;
    }

    public static Result getResult(Exception e){
        if(e instanceof ClientException){
            return Result.data("").msg(e.getMessage()).code(400);
        }else if(e instanceof ServerException){
            return Result.data("").msg(e.getMessage()).code(500);
        }else if(e instanceof TokenExpiredException){
            return Result.data("").msg("身份认证过期！").code(400);
        }else{
            return Result.data("").msg("未知错误").code(500);
        }
    }
}
