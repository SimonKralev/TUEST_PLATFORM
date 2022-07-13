package com.schoolplatform.demo.services;

import com.schoolplatform.demo.entities.User;
import com.schoolplatform.demo.models.RegistrationRequest;
import com.schoolplatform.demo.models.RegistrationResponse;

public interface UserService {
    RegistrationResponse createUser(RegistrationRequest registrationRequest);
    User findUserByEmail(String email);
    User findUserById(Long id);
}
