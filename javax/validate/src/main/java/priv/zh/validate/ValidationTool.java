package priv.zh.validate;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.ConstraintViolation;

import java.util.ArrayList;
import java.util.Set;
import java.util.List;

/**
 * @author zhaoeheng
 * @version 1.0
 * bean validation
 */
public class ValidationTool{
    private static ValidatorFactory validatorFactory=Validation.buildDefaultValidatorFactory();

    /**
     * @param 
     */
    public static <T> List<String> validate(T t){
        Validator validator=validatorFactory.getValidator();
        Set<ConstraintViolation<T>> constraintViolations=validator.validate(t);
        List<String> result=new ArrayList<>();
        for (ConstraintViolation<T> constraintVio : constraintViolations) {
            result.add(constraintVio.getMessage());
        }
        return result;
    }
}