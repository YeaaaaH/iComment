package com.fellas.usersservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"login"}),
                @UniqueConstraint(columnNames = {"email"})
        }
)
@Data
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "login")
    private String login;
    private String password;
    private String name;
    @Column(name = "surname")
    private String surName;
    @Column(name = "email")
    @Email(message = "Not proper format of email")
    private String email;
    private String gender;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate birthDay;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate registrationDate;
    private String avatarLink;
    @ManyToMany()
    @JoinTable(
            name = "users_roles",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )
    private List<Role> roles;
}
