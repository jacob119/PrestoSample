package org.jacob.presto.domain;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserInfo {
    public UserInfo(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<UserInfo> getUserInfo() throws SQLException {
        List<UserInfo> userInfoList = new ArrayList<>();

        return userInfoList;
    }

}
