package priv.zh.annotation;


import priv.zh.validateimpl.StudentValidatorImpl;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target({ElementType.TYPE,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = StudentValidatorImpl.class)
public @interface StudentValidator{
   String message() default "逻辑验证失败";
   Class<?>[] groups() default {};
   Class<? extends Payload>[] payload() default {};
}