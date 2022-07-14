package com.schoolplatform.demo.repository;

import com.schoolplatform.demo.entities.Login;
import com.schoolplatform.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Login, String> {

}
