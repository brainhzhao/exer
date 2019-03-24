package priv.zh;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import priv.zh.bean.ListStudent;
import priv.zh.bean.Student;
import priv.zh.validate.ValidationTool;

import javax.validation.Valid;

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
        List<Student> stus=new ArrayList<>();
        List<String> list=new ArrayList<>();
        list.add("12");
        list.add("1212");
        Student student=new Student();
        student.setAge("1223");
        student.setEmail("zhaohengb@dcits.com");
        student.setId("12342323");
        student.setScore(-1);
        student.setSchool("");
        student.setClassName(list);
        Student student1=new Student();
        student1.setAge("1224");
        student1.setEmail("zhaohengb@dcits.com");
        student1.setId("12342323");
        student1.setScore(-1);
        student1.setSchool("");
        student1.setClassName(list);
        stus.add(student);
        stus.add(student1);
        ListStudent st=new ListStudent();
        st.setStudents(stus);
        List<String> validateMessage=ValidationTool.validate(st);
        for (String message : validateMessage) {
            System.out.println(message);
        }
        
    }
}
