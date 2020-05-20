package com.fellas.iComment.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Role implements Serializable  {
    private long id;
    private String name;
}
