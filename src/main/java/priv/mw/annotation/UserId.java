package priv.mw.annotation;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
/**
 * @param value obj: 对象注入；base：基础类型注入
 */
public @interface UserId {
    String value() default "obj";
}
