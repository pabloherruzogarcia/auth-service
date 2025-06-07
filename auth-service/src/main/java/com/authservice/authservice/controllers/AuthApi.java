package com.authservice.authservice.controllers;

import com.authservice.authservice.common.constants.ApiPathConstants;
import com.authservice.authservice.common.dtos.TokenResponse;
import com.authservice.authservice.common.dtos.UserRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RequestMapping(ApiPathConstants.V1_ROUTE + ApiPathConstants.AUTH_ROUTE)
@RestController
public interface AuthApi {
    @PostMapping(value = "/register")
    ResponseEntity<TokenResponse> createUser(@RequestBody @Valid UserRequest userRequest);
    @GetMapping
    ResponseEntity<String> getUser(String userId);
    @PostMapping(value = "/login")
    ResponseEntity<TokenResponse> login(@RequestBody @Valid UserRequest userRequest);


}
