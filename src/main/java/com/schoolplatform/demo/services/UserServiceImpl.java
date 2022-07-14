package com.schoolplatform.demo.services;

import com.schoolplatform.demo.entities.Login;
import com.schoolplatform.demo.entities.User;
import com.schoolplatform.demo.entities.UserType;
import com.schoolplatform.demo.models.RegistrationRequest;
import com.schoolplatform.demo.models.RegistrationResponse;
import com.schoolplatform.demo.repository.LoginRepository;
import com.schoolplatform.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final LoginService loginService;

    private final LoginRepository loginRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Override
    public RegistrationResponse createUser(RegistrationRequest registrationRequest) {
        loginService.createLogin(registrationRequest);
        Login login = loginService.findByUsername(registrationRequest.getEmail());

        User user = new User();

        user.setFirstname(registrationRequest.getFirstname());
        user.setLastname(registrationRequest.getLastname());
        user.setBio(registrationRequest.getBio());
        user.setType(UserType.valueOf(registrationRequest.getUserType()));
        user.setLogin(login);

        userRepository.save(user);

        RegistrationResponse registrationResponse = new RegistrationResponse();
        registrationResponse.setFirstname(user.getFirstname());
        registrationResponse.setLastname(user.getLastname());

        return registrationResponse;
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        return userRepository.findUserByLoginUsername(email);
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

}
