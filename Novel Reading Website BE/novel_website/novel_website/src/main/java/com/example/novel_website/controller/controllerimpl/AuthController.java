package com.example.novel_website.controller.controllerimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.novel_website.payload.Request.LoginRequest;
import com.example.novel_website.payload.Request.SignupRequest;
import com.example.novel_website.payload.Response.JwtResponse;
import com.example.novel_website.payload.Response.MessageResponse;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.novel_website.service.AuthService;
import com.example.novel_website.exception.InvaildAccountFieldException;

@CrossOrigin
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthService authService;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        try {
            JwtResponse response = authService.authenticateUser(loginRequest);
            return ResponseEntity.ok(response);
        } catch (BadCredentialsException e) {
            return ResponseEntity.badRequest().body("Invaild username or password");
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignupRequest signUpRequest) {
        try {
            MessageResponse response = authService.registerUser(signUpRequest);
            return ResponseEntity.ok(response);
        } catch (InvaildAccountFieldException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}