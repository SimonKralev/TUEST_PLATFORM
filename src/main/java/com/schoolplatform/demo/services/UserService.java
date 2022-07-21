package com.schoolplatform.demo.services;

import com.schoolplatform.demo.entities.User;
import com.schoolplatform.demo.entities.UserType;
import com.schoolplatform.demo.models.NewBioRequest;
import com.schoolplatform.demo.models.RegistrationRequest;
import com.schoolplatform.demo.models.RegistrationResponse;
import org.springframework.web.bind.annotation.RequestBody;

import java.security.Principal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UserService {
    RegistrationResponse createUser(RegistrationRequest registrationRequest);

    User findUserByEmail(String email);

    String getUserRole(String role, Principal principal);

    User findUserByLoginUsername(String name);

    String changeBio(@RequestBody NewBioRequest newBioRequest, Principal principal);

    User findById(Long userId);

    List<User> findAllByTypeEquals(UserType role);
}

