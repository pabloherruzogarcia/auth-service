package com.authservice.authservice.services;

import com.authservice.authservice.common.dtos.TokenResponse;
import com.authservice.authservice.common.dtos.UserRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


public interface AuthService {
    TokenResponse createUser(UserRequest userRequest);

    Object mapToEntity(UserRequest userRequest);

    TokenResponse login(UserRequest userRequest);
}
