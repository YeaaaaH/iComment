package com.fellas.iComment.model;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String login;
    private String password;
    private String name;
    @Column(name = "surname")
    private String surName;
    private String email;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<FeedBack> feedBacks;
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "users_roles",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "role_id") }
    )
    private List<Role> roles;
}
