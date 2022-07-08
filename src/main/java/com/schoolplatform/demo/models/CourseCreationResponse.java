package com.schoolplatform.demo.models;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;

@Getter
@Setter
public class CourseCreationResponse {
    @NotNull
    @Size(min = 0, max = 50)
    private String title;

    @NotNull
    private Date date;
}
