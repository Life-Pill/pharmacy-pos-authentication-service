package com.pmj.authentication_service.service;

import com.pmj.authentication_service.dto.EmployerDTO;

public interface EmployerService {
    EmployerDTO getEmployerByUsername(String username);
}
