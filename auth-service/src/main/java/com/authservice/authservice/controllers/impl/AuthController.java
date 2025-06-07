package com.authservice.authservice.controllers.impl;

import com.authservice.authservice.common.dtos.TokenResponse;
import com.authservice.authservice.common.dtos.UserRequest;
import com.authservice.authservice.controllers.AuthApi;
import com.authservice.authservice.services.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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

    @Override
    public ResponseEntity<TokenResponse> login( UserRequest userRequest) {

        if(authService.login(userRequest).getAccessToken().isEmpty())
            return ResponseEntity.ofNullable(authService.login(userRequest));
        else
            return ResponseEntity.ok(authService.login(userRequest));

    }
}
