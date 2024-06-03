package com.lifepill.authenticationservice.service;


import com.lifepill.authenticationservice.dto.AuthenticationRequestDTO;
import com.lifepill.authenticationservice.dto.AuthenticationResponseDTO;
import com.lifepill.authenticationservice.dto.EmployerAuthDetailsResponseDTO;
import com.lifepill.authenticationservice.dto.RegisterRequestDTO;

public interface AuthService {

    AuthenticationResponseDTO register(RegisterRequestDTO registerRequest);
//    AuthenticationResponseDTO authenticate(AuthenticationRequestDTO request);
//    EmployerAuthDetailsResponseDTO getEmployerDetails(String username);
}