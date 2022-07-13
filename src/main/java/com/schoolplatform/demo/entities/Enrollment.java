package com.schoolplatform.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "enrollments")
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "student_id")
    private User student;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "course_id")
    private Course course;

    @NotNull
    @Column(name = "registration_time")
    private Timestamp registrationTime;
}
