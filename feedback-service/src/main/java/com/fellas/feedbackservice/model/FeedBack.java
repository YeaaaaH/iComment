package com.fellas.feedbackservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "feedbacks")
@Data
public class FeedBack implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int rate;
    private String title;
    private String description;
    private String positive;
    private String negative;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    private long user_id;
    private long company_id;
}
