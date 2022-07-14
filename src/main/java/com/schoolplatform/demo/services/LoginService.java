package com.schoolplatform.demo.services;

import com.schoolplatform.demo.entities.Login;
import com.schoolplatform.demo.models.LoginRequest;
import com.schoolplatform.demo.models.RegistrationRequest;

public interface LoginService {
    void createLogin(RegistrationRequest registrationRequest);
    Login findByUsername(String username);
}
