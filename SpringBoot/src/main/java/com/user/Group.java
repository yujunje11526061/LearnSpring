package com.user;

import java.io.Serializable;

public class Group implements Serializable {
    private Integer age;
    private String name;
    private User user;

    @Override
    public String toString() {
        return "Group{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", user=" + user +
                '}';
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
