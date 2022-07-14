package com.schoolplatform.demo.repository;

import com.schoolplatform.demo.entities.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, String> {
}