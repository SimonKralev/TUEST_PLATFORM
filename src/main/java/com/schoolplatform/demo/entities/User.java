package com.schoolplatform.demo.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "first_name", nullable = false)
    @NotNull
    @Size(min = 2, max = 20)
    private String first_name;

    @Column(name = "last_name", nullable = false)
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
    public User(Long id,
                String first_name,
                String lastname,
                String email,
                String password,
                String bio) {
        this.id = id;
        this.first_name = first_name;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.bio = bio;
    }
}