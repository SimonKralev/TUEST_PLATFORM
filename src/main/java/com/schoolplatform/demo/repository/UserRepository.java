package com.schoolplatform.demo.repository;

import com.schoolplatform.demo.entities.User;
import com.schoolplatform.demo.entities.UserType;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByLoginUsername(String username);

    Optional<User> findById(Long id);

    List<User> findAllByTypeEquals(UserType role);
}
