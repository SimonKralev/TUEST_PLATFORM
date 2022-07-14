package com.schoolplatform.demo.models;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

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
    private String date;

    @NotNull
    private Double price;
    @NotNull
    private String type;
    @NotNull
    @Size(min = 1, max = 50)
    private String location;

    @NotNull
    private String visibility;

    public String getLocation(String location) {
        if (location.isEmpty()) {
            return null;
        }
        return location;
    }
}