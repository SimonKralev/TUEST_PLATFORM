package com.schoolplatform.demo.controllers.rest;

import com.schoolplatform.demo.models.LoginRequest;
import com.schoolplatform.demo.models.RegistrationRequest;
import com.schoolplatform.demo.models.RegistrationResponse;
import com.schoolplatform.demo.services.LoginService;
import com.schoolplatform.demo.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class UserRestController {

    private final UserService userService;
    private final LoginService loginService;

    @PostMapping("/register")
    public RegistrationResponse registerUser(@RequestBody RegistrationRequest registrationRequest){
        return userService.createUser(registrationRequest);
    }
}

