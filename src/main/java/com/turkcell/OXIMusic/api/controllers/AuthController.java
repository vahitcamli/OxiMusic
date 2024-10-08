package com.turkcell.OXIMusic.api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.OXIMusic.business.abstracts.AuthService;
import com.turkcell.OXIMusic.dtos.requests.login.LoginRequest;
import com.turkcell.OXIMusic.dtos.requests.register.RegisterRequest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {
	private final AuthService authService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@Valid @RequestBody RegisterRequest request)
    {
        authService.register(request);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public String login(@Valid @RequestBody LoginRequest request)
    {
        return authService.login(request);
    }
    @PostMapping("/refresh-token")
    public ResponseEntity<?> refreshToken(@RequestParam String username, @RequestParam String refreshToken) {
        String newAccessToken = authService.refreshToken(username, refreshToken);
        return ResponseEntity.ok(newAccessToken);
    }
    
}
