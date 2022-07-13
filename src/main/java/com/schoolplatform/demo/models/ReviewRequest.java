package com.schoolplatform.demo.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewRequest {
    @NotNull
    private Long user;

    @NotNull
    private Long course;

    @NotNull
    private int rating;

    private String comment;

    @NotNull
    private String timeOfPosting;
}
