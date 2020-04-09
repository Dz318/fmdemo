package com.example.fmdemo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/***
 * Created by dz on 2020-4-1
 */
@Data
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String userName;
    private Integer age;
    private String address;
    private String city;
}
