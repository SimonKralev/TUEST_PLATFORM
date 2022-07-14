package com.schoolplatform.demo.configuration;

import com.schoolplatform.demo.entities.RoleType;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.sql.DataSource;

//.antMatchers( "/courses/{course_id}/post-review", "/courses/{course_id}/reviews")

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeRequests()
//                .antMatchers( "/courses/create")
//                .hasAnyRole(RoleType.USER.toString(), RoleType.ADMIN.toString())
                .antMatchers("/home")
                .authenticated()
                .antMatchers("/signup", "/css/**", "/js/**", "/images/**", "/login", "/courses/create", "/register", "/courses/all", "/courses/{course_id}", "/my-profile", "/courses/{course_id}/post-review", "/courses/{course_id}/reviews")
                .hasAnyRole(RoleType.USER.toString(), RoleType.ADMIN.toString())
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/authenticate")
                .defaultSuccessUrl("/home", true)
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    @Bean
    public UserDetailsManager userDetailsManager() {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager();
        jdbcUserDetailsManager.setDataSource(dataSource);
        return jdbcUserDetailsManager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationFailureHandler authenticationFailureHandler() {
        return new CustomAuthenticationFailureHandler();
    }

}
