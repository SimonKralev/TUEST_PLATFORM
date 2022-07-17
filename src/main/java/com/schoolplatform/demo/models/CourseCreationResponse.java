package com.schoolplatform.demo.models;
import com.schoolplatform.demo.entities.User;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@Getter
@Setter
public class CourseCreationResponse {
    @NotNull
    private Long id;

    @NotNull
    private User user;

    @NotNull
    @Size(min = 1, max = 50)
    private String title;

    private String subject;

    private Timestamp date;

    private Double price;

    private String location;
}
