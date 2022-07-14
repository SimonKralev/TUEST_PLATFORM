package com.schoolplatform.demo.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnrollmentResponse {

    @NotNull
    private Long student;

    @NotNull
    private Long course;

    @NotNull
    private Timestamp registrationTime;
}