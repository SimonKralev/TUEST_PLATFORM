package com.schoolplatform.demo.controllers.rest;

import com.schoolplatform.demo.models.LoginRequest;
import com.schoolplatform.demo.models.RegistrationRequest;
import com.schoolplatform.demo.models.RegistrationResponse;
import com.schoolplatform.demo.services.LoginService;
import com.schoolplatform.demo.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

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

    @GetMapping("/my-profile/role")
    public String getUserRole (String role, Principal principal){
        return userService.getUserRole(role, principal);

    }

}

