package priv.zh.model;

import java.io.Serializable;


public class Student implements Serializable{
    private final static long serialVersionUID=1L;
    private String id;
    private String name;
    private String sex;
    private String age;

    public Student(String id,String name,String sex,String age){
        this.id=id;
        this.name=name;
        this.sex=sex;
        this.age=age;
    }

    public Student(){
        this("1","zhaoheng","男","23");
    }
    /**
     * @return the id
     */
    public String getId() {
        return id;
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
     * @return the sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex the sex to set
     */
    public void setSex(String sex) {
        this.sex = sex;
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
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    public String toString(){
        return "name:"+name;
    }
}