package priv.zh.validateimpl;

import priv.zh.annotation.StudentValidator;
import priv.zh.bean.Student;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StudentValidatorImpl implements ConstraintValidator<StudentValidator, Student> {

    @Override
    public void initialize(StudentValidator constraintAnnotation){

    }

    @Override
    public boolean isValid(Student value, ConstraintValidatorContext context){

        if(Integer.parseInt(value.getAge())>300){
            context.buildConstraintViolationWithTemplate("年龄不能大于300岁").addPropertyNode(value.getAge()).addConstraintViolation();
            return false;
        }
        return true;
    }
}