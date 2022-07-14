package com.schoolplatform.demo.services;

import com.schoolplatform.demo.configuration.SecurityConfig;
import com.schoolplatform.demo.entities.Login;
import com.schoolplatform.demo.models.LoginRequest;
import com.schoolplatform.demo.models.RegistrationRequest;
import com.schoolplatform.demo.repository.LoginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class LoginServiceImpl implements LoginService {
    private final UserDetailsManager userDetailsManager;
    private final LoginRepository loginRepository;
    private final PasswordEncoder passwordEncoder;
    public Login findByUsername(String username) {
        return loginRepository.findById(username).orElse(null);
    }
    public void createLogin(RegistrationRequest registrationRequest) throws UsernameNotFoundException {
        Login login = new Login();
        login.setUsername(registrationRequest.getEmail());
        login.setPassword(registrationRequest.getPassword());
        List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(String.valueOf(new SimpleGrantedAuthority("ROLE_USER")));
        org.springframework.security.core.userdetails.User newUser = new org.springframework.security.core.userdetails.User(login.getUsername(), passwordEncoder.encode(login.getPassword()), true, true, true, true, authorities);
        userDetailsManager.createUser(newUser);
    }
}
