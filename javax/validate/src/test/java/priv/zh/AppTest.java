package priv.zh;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import priv.zh.bean.Student;
import priv.zh.validate.ValidationTool;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void validate(){
        List<String> list=new ArrayList<>();
        list.add("12");
        list.add("1212");
        Student student=new Student();
        student.setAge("1234");
        student.setEmail("zhaohengb@dcits.com");
        student.setId("12342323");
        student.setScore(-1);
        student.setSchool("");
        student.setClassName(list);
        List<String> validateMessage=ValidationTool.validate(student);
        for (String message : validateMessage) {
            System.out.println(message);
        }
        
    }
}
