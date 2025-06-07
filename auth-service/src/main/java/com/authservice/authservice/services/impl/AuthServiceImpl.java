package com.authservice.authservice.services.impl;

import com.authservice.authservice.common.dtos.TokenResponse;
import com.authservice.authservice.common.dtos.UserRequest;
import com.authservice.authservice.common.entities.UserModel;
import com.authservice.authservice.repositories.UserRepository;
import com.authservice.authservice.services.AuthService;
import com.authservice.authservice.services.JwtService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final JwtService jwtService;

    public AuthServiceImpl(UserRepository userRepository, JwtService jwtService) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }

    @Override
    public TokenResponse createUser(UserRequest userRequest) {
        return Optional.of(userRequest)
                .map(this::mapToEntity)
                .map(userRepository::save)
                .map(userCreated -> jwtService.generateToken(userCreated.getId()))
                .orElseThrow(() -> new RuntimeException("Error creating user"));
    }

    @Override
    public UserModel mapToEntity(UserRequest userRequest) {
        return UserModel.builder()
                .email(userRequest.getEmail())
                .password(userRequest.getPassword())
                .role("USER")
                .build();

    }
    @Override
    public TokenResponse login(UserRequest userRequest){
        TokenResponse token = null;
        Optional<UserModel> usuario = userRepository.findByEmail(userRequest.getEmail());
        if(usuario.isPresent())
            token = jwtService.generateToken(usuario.get().getId());
        else
            token = new TokenResponse("");

        return token;
    }



}
