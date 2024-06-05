package com.pmj.authentication_service.service;


import com.pmj.authentication_service.dto.AuthenticationRequestDTO;
import com.pmj.authentication_service.dto.AuthenticationResponseDTO;
import com.pmj.authentication_service.dto.EmployerAuthDetailsResponseDTO;
import com.pmj.authentication_service.dto.RegisterRequestDTO;

public interface AuthService {

    AuthenticationResponseDTO register(RegisterRequestDTO registerRequest);
    AuthenticationResponseDTO authenticate(AuthenticationRequestDTO request);
    EmployerAuthDetailsResponseDTO getEmployerDetails(String username);
}