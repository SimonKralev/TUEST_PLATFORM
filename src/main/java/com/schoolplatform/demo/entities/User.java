package com.schoolplatform.demo.entities;

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
@Table(name = "users")
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

    @Column(name = "email", nullable = false, unique = true)
    @NotNull
    @Size(min = 2, max = 40)
    private String email;

    @Column(name = "password", nullable = false, unique = true)
    @NotNull
    @Size(min = 8, max = 20)
    private String password;

    @Column(name = "bio")
    private String bio;

    @OneToMany(mappedBy="teacher_id")
    private List<Course> courses;

    @OneToMany(mappedBy = "student_id") // enrollment id
    private List<Enrollment> enrollments;

    public User(String firstname, String lastname, String email, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
    }
}