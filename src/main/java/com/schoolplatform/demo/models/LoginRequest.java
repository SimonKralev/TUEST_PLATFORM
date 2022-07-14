package com.schoolplatform.demo.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {
    @NotNull
    @Size(min = 2, max = 40)
    private String email;

    @NotNull
    @Size(min = 8, max = 20)
    private String password;
}
