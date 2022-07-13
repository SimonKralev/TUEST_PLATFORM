package com.schoolplatform.demo.services;

import com.schoolplatform.demo.entities.User;
import com.schoolplatform.demo.entities.UserType;
import com.schoolplatform.demo.models.RegistrationRequest;
import com.schoolplatform.demo.models.RegistrationResponse;
import com.schoolplatform.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public RegistrationResponse createUser(RegistrationRequest registrationRequest) {
        User user = new User();

        user.setFirstname(registrationRequest.getFirstname());
        user.setLastname(registrationRequest.getLastname());
        user.setEmail(registrationRequest.getEmail());
        user.setPassword(registrationRequest.getPassword());
        user.setBio(registrationRequest.getBio());
        user.setType(UserType.valueOf(registrationRequest.getUserType()));

        userRepository.save(user);

        RegistrationResponse registrationResponse = new RegistrationResponse();
        registrationResponse.setFirstname(user.getFirstname());
        registrationResponse.setLastname(user.getLastname());

        return registrationResponse;
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findUserById(id);
    }

}
