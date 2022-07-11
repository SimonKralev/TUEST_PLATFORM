package com.schoolplatform.demo.models;

import com.schoolplatform.demo.entities.Course;
import com.schoolplatform.demo.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnrollmentResponse {

    @NotNull
    private User student_id;

    @NotNull
    private Course course_id;

    @NotNull
    private Date registration_time;
}
