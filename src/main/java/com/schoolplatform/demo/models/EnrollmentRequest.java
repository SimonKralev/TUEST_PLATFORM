package com.schoolplatform.demo.models;
import com.schoolplatform.demo.entities.Course;
import com.schoolplatform.demo.entities.User;
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
public class EnrollmentRequest {

    @NotNull
    private Long student;

    @NotNull
    private Long course;

    @NotNull
    private String registrationTime;
}