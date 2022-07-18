package com.schoolplatform.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "users_info")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(name = "type")
    private UserType type;

    @Column(name = "firstname", nullable = false)
    @NotNull
    @Size(min = 2, max = 20)
    private String firstname;

    @Column(name = "lastname", nullable = false)
    @NotNull
    @Size(min = 2, max = 20)
    private String lastname;

    @Column(name = "bio")
    @Size(min = 0, max = 500)
    private String bio;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "login_id")
    private Login login;

    @OneToMany()
    @JsonIgnore
    @JoinColumn(name = "teacher_id")
    private List<Course> courses;

    @OneToMany(mappedBy = "student") // enrollment id
    @JsonIgnore
    private List<Enrollment> enrollments;

    @OneToMany()
    @JsonIgnore
    @JoinColumn(name = "user_id")
    private List<Review> reviews;
}