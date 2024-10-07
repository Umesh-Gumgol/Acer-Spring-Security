package com.acer.repository;

import com.acer.entity.AcerUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AcerUserRepository extends JpaRepository<AcerUser, Long> {

  Optional<AcerUser> findByEmail(String email);
    Optional<AcerUser> findByUsername(String username);
}