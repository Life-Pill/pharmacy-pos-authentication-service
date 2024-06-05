package com.pmj.authentication_service.service.Impl;

import com.pmj.authentication_service.dto.EmployerDTO;
import com.pmj.authentication_service.entity.Employer;
import com.pmj.authentication_service.repository.EmployerRepository;
import com.pmj.authentication_service.service.EmployerService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployerServiceIMPL implements EmployerService {

    private EmployerRepository employerRepository;
    private ModelMapper modelMapper;

    @Override
    public EmployerDTO getEmployerByUsername(String username) {
        Optional<Employer> employer = employerRepository.findByEmployerEmail(username);
        if (employer.isPresent()) {
            return modelMapper.map(employer, EmployerDTO.class);
        } else {
            // Handle case when employer is not found
            return null; // Or throw an exception, or return a default DTO
        }
    }
}
