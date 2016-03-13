package com.condoc.db;

import com.easyliteorm.annotation.Entity;
import com.easyliteorm.annotation.GenerationType;
import com.easyliteorm.annotation.Id;

/**
 * Created by Jo on 3/13/2016.
 */
@Entity
public class Doctor {
    @Id(strategy = GenerationType.AUTO)
    private int id;
    private String username;
    private String password;
    private String name;
    private int age;
    private String gender;
    private int practiceYears;
    private String specialization;
    private String location;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getPracticeYears() {
        return practiceYears;
    }

    public void setPracticeYears(int practiceYears) {
        this.practiceYears = practiceYears;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}