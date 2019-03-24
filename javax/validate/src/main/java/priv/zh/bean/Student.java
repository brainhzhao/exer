package priv.zh.bean;


import priv.zh.annotation.ListNotHasNull;
import priv.zh.annotation.StudentValidator;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

/**
 * @author zhaoheng
 * @version 1.0
 * student validator bean
 */

public class Student implements Serializable{
    private static final long serialVersionUID=1L;

    // 学生姓名
    @NotNull(message="姓名不可以为位置")
    private String name;
    // 学生年龄
    @Size(min=1,max=3,message="年龄怎么可以为三位数")
    private String age;
    // 学校
    private String school;
     
    private String id;
    @DecimalMin(value="0.00",message="分数不能低于0啊")
    @DecimalMax(value="100.00",message="分数不能超过100分哦")
    private float score;
    
    @Pattern(regexp="^.*@\\..*",message="邮件格式不对")
    private String email;



    @ListNotHasNull(message="列表不能为空")
    @Valid
    private List<String> className;

    public List<String> getClassName() {
        return className;
    }

    public void setClassName(List<String> className) {
        this.className = className;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the age
     */
    public String getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(String age) {
        this.age = age;
    }

    /**
     * @return the school
     */
    public String getSchool() {
        return school;
    }

    /**
     * @param school the school to set
     */
    public void setSchool(String school) {
        this.school = school;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the score
     */
    public float getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(float score) {
        this.score = score;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }


}