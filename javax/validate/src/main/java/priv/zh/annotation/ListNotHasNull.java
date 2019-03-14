package priv.zh.annotation;


import priv.zh.validateimpl.ListNotHasNullValidatorImpl;

import javax.validation.Payload;
import javax.validation.Constraint;
import java.lang.annotation.*;

/**
 * @author zhaoheng
 * @version 1.0
 * list's item is not null
 */

@Target({ElementType.ANNOTATION_TYPE,ElementType.FIELD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy=ListNotHasNullValidatorImpl.class)
public @interface ListNotHasNull {
    int value() default 0;
    String message() default "列表中不能有空值";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    @Target({ElementType.ANNOTATION_TYPE,ElementType.FIELD,ElementType.METHOD})
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    @interface List{
        ListNotHasNull[] value() default {};
    }
}
