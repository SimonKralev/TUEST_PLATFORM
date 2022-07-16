package com.schoolplatform.demo.models;

import com.schoolplatform.demo.entities.User;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;

@Getter
@Setter
public class CourseResponse {
    private Long id;

    private User user;

    private String title;

    private String subject;

    private Timestamp date;

    private Double price;

    private String type;

    private String location;

    private String displayableLocation;

    private String visibility;

    private String displayableSubject;
}
