package com.schoolplatform.demo.services;

import com.schoolplatform.demo.entities.User;
import com.schoolplatform.demo.models.RegistrationRequest;
import com.schoolplatform.demo.models.RegistrationResponse;

import java.security.Principal;
import java.util.Optional;

public interface UserService {
    RegistrationResponse createUser(RegistrationRequest registrationRequest);

    Optional<User> findUserByEmail(String email);

    Optional<User> findUserById(Long id);

    String getUserRole(String role, Principal principal);
}

