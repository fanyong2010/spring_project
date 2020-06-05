package com.offcn.pojo;


import javax.persistence.*;

@Entity
@Table(name = "tab_user")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String userName;

    @Column
    private int age;

    @Column
    private String pwd;


    public User() {

    }

    public User(Long id, String userName, int age, String pwd) {
        this.id = id;
        this.userName = userName;
        this.age = age;
        this.pwd = pwd;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

}
