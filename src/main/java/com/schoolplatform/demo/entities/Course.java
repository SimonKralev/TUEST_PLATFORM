package com.schoolplatform.demo.entities;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
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
    private User user;

    @Column(name = "title", nullable = false)
    @NotNull
    @Size(min = 1, max = 40)
    private String title;

    @Column(name = "subject")
    @Size(min = 1, max = 50)
    private String subject;

    @Column(name = "date", nullable = false)
    @NotNull
    private Timestamp date;

    @Column(name = "price")
    private Double price;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private CourseType type;

    @Column(name = "visibility")
    @Enumerated(EnumType.STRING)
    @ColumnDefault("PUBLIC")
    private CourseVisibility visibility;

    @Column(name = "location")
    @Size(min = 1, max = 50)
    private String location;

    @OneToMany(mappedBy = "course")
    private List<Enrollment> enrollments;

    @OneToMany(mappedBy = "course")
    private List<Review> reviews;

    public int enrolledStudentsCount() {
        return enrollments.size();
    }

    public Double averageRating() {
        double totalRating = 0;
        for (Review review:
             reviews) {
            totalRating += review.getRating();
        }
        return totalRating / reviews.size();
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