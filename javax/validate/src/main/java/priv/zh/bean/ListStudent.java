package priv.zh.bean;

import priv.zh.annotation.StudentValidator;

import javax.validation.Valid;
import java.util.List;

public class ListStudent {
    @Valid
    @StudentValidator(message = "学生类级别校验")
    private List<Student> students;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }


}
