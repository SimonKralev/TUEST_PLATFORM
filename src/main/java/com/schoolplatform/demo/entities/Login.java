package com.schoolplatform.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class Login {

    @Id
    @Column(name = "username")
    @Size(min = 3, max = 14)
    private String username;

    @Column(name = "password")
    @Size(min = 3, max = 255)
    private String password;

    @Column(name = "enabled")
    private boolean enabled;
}
