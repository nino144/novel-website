package com.example.novel_website.service;

import com.example.novel_website.exception.InvaildAccountFieldException;
import com.example.novel_website.payload.Request.LoginRequest;
import com.example.novel_website.payload.Request.SignupRequest;
import com.example.novel_website.payload.Response.JwtResponse;
import com.example.novel_website.payload.Response.MessageResponse;

import org.springframework.security.authentication.BadCredentialsException;

public interface AuthService {
    JwtResponse authenticateUser(LoginRequest loginRequest) throws BadCredentialsException;
    MessageResponse registerUser(SignupRequest signUpRequest) throws InvaildAccountFieldException;
}