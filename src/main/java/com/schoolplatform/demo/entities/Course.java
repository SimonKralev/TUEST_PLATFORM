package com.schoolplatform.demo.entities;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id")
    @NotNull
    private User teacher_id;

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

    @OneToMany(mappedBy = "course_id") // enrollment id
    private List<Enrollment> enrollments;

    public void setType(String type) {
        if (type.equals(CourseType.IN_PERSON.name())) {
            this.type = CourseType.IN_PERSON;
        }
        else {
            this.type = CourseType.ONLINE;
        }
    }

    public String getDisplayableSubject() {
        List<String> subjectImages = List.of(new String[]{"science", "literature", "language", "astronomy"});
        if (!subjectImages.contains(subject)) {
            return "default.png";
        }
        return subject + ".png";
    }

    public String getDisplayableLocation() {
        if (type == CourseType.ONLINE) {
            return "Online";
        }
        return location;
    }
}