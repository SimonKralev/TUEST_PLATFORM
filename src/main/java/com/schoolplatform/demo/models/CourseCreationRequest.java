package com.schoolplatform.demo.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseCreationRequest {

    @Size(min = 2, max = 50)
    private String title;

    @Size(min = 2, max = 20)
    private String subject;

    @NotNull
    private Date date;

    @NotNull
    private Double price;

    @NotNull
    private String type;

    @NotNull
    @Size(min = 1, max = 50)
    private String location;
}
