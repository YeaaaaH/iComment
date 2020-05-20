package com.fellas.iComment.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Company implements Serializable {
    private long id;
    private String name;
    private String description;
    private Double averageRate;
    private long category_id;
}
