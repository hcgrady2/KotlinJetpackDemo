package com.hc.common.db;

import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "tb_juser")
public class JUser {

    public String name = "哈哈哈";
    @PrimaryKey(autoGenerate = true)
    int jId;
    int age = 20;

    private JUser() {
    }

    public JUser(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "JUser{" +
                "jId=" + jId +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
