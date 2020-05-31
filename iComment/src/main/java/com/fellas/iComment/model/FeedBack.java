package com.fellas.iComment.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class FeedBack implements Serializable {
    private long id;
    private int rate;
    private String title;
    private String description;
    private String positive;
    private String negative;
    private String date;
    private long user_id;
    private long company_id;
}
