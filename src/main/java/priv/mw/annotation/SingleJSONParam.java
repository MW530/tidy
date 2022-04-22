package priv.mw.annotation;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
/**
 * @param value: 单个参数在JSON中的名字，无则会对应匹配
 */
public @interface SingleJSONParam {
    String value() default "0";
}
