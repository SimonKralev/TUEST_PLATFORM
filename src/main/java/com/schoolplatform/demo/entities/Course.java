package com.schoolplatform.demo.entities;

import com.schoolplatform.demo.entities.User;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacherid")
    @NotNull
    private User teacherid;

    @Column(name = "title", nullable = false)
    @NotNull
    @Size(min = 1, max = 40)
    private String title;

    @Column(name = "subject")
    @Size(min = 1, max = 50)
    private String subject;

    @Column(name = "date", nullable = false)
    @NotNull
    private Date date;

    @Column(name = "price")
    private Double price;

    @Column(name = "type")
    @Enumerated
    private CourseType type;

    @Column(name = "location")
    @Size(min = 1, max = 50)
    private String location;

    public void setType(String type) {
        if (type == CourseType.IN_PERSON.name()) {
            this.type = CourseType.IN_PERSON;
        }
        else {
            this.type = CourseType.ONLINE;
        }
    }
}