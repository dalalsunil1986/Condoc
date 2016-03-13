package com.condoc.db;

import com.easyliteorm.annotation.Entity;
import com.easyliteorm.annotation.GenerationType;
import com.easyliteorm.annotation.Id;

/**
 * Created by Jo on 3/13/2016.
 */
@Entity
public class Admin {
    @Id(strategy = GenerationType.AUTO)
    private int id;
    private String username;
    private String password;
    private String name;
    private int age;
    private String gender;

}