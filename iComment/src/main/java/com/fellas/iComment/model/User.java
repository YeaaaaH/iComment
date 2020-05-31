package com.fellas.iComment.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class User implements Serializable {
    private long id;
    private String login;
    private String password;
    private String name;
    private String surName;
    private String email;
    private String gender;
    private String birthDay;
    private String registrationDate;
    private String avatarLink;
    private List<Role> roles;
}
