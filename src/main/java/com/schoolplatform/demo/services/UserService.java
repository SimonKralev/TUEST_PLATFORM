package com.schoolplatform.demo.services;

import com.schoolplatform.demo.models.RegistrationRequest;
import com.schoolplatform.demo.models.RegistrationResponse;

public interface UserService {
    public RegistrationResponse createUser(RegistrationRequest registrationRequest);
}
