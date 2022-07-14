package com.schoolplatform.demo.models;


import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Getter
@Setter
public class ReviewResponse {

    @NotNull
    private int rating;

    private String comment;

    @NotNull
    private Timestamp timeOfPosting;
}