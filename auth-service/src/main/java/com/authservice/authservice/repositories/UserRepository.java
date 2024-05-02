package com.authservice.authservice.repositories;

import com.authservice.authservice.common.entities.UserModel;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    Optional<UserModel>findByEmail(String email);
}
