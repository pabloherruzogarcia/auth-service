package com.authservice.authservice.controllers.impl;

import com.authservice.authservice.common.dtos.TokenResponse;
import com.authservice.authservice.common.dtos.UserRequest;
import com.authservice.authservice.controllers.AuthApi;
import com.authservice.authservice.services.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController implements AuthApi {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @Override
    public ResponseEntity<TokenResponse> createUser(UserRequest userRequest) {
        return ResponseEntity.ok(authService.createUser(userRequest));
    }

    @Override
    public ResponseEntity<String> getUser(String userId) {
        return ResponseEntity.ok(userId);
    }
}
