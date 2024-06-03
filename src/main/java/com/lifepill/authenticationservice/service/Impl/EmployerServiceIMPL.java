package com.lifepill.authenticationservice.service.Impl;


import com.lifepill.authenticationservice.dto.BranchDTO;
import com.lifepill.authenticationservice.dto.EmployerWithoutImageDTO;
import com.lifepill.authenticationservice.entity.Employer;
import com.lifepill.authenticationservice.exception.EntityDuplicationException;
import com.lifepill.authenticationservice.repository.EmployerBankDetailsRepository;
import com.lifepill.authenticationservice.repository.EmployerRepository;
import com.lifepill.authenticationservice.service.APIClient;
import com.lifepill.authenticationservice.service.EmployerService;
import com.lifepill.authenticationservice.util.StandardResponse;
import jakarta.ws.rs.NotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

/**
 * EmployerServiceIMPL is a service class that implements the EmployerService interface.
 * It provides the functionality to manage employers in the system.
 */
@Service
@Transactional
@AllArgsConstructor
public class EmployerServiceIMPL implements EmployerService {

    private EmployerRepository employerRepository;
    private EmployerBankDetailsRepository employerBankDetailsRepository;
    private ModelMapper modelMapper;
    private APIClient apiClient;

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployerServiceIMPL.class);

    /**
     * This method is used to save an employer without an image.
     * It first checks if the employer already exists in the system by their id or email.
     * If the employer already exists, it throws an EntityDuplicationException.
     * If the employer does not exist, it retrieves the branch associated with the employer by its id.
     * If the branch does not exist, it throws a NotFoundException.
     * If the branch exists, it maps the EmployerWithoutImageDTO to an Employer entity and saves it in the database.
     * If the employer is not found after saving, it throws a NotFoundException.
     * If the employer is saved successfully, it returns a success message.
     *
     * @param employerWithoutImageDTO The employer data transfer object without an image.
     * @throws EntityDuplicationException If the employer already exists.
     * @throws NotFoundException          If the associated branch is not found.
     */
    @Override
    public void saveEmployerWithoutImage(EmployerWithoutImageDTO employerWithoutImageDTO) {
        // check if the employer already exists email or id
        if (employerRepository.existsById(employerWithoutImageDTO.getEmployerId())
                || employerRepository.existsAllByEmployerEmail(employerWithoutImageDTO.getEmployerEmail())) {
            throw new EntityDuplicationException("Employer already exists");
        } else {

            ResponseEntity<StandardResponse> standardResponseResponseEntity =
                    apiClient.getBranchById((int) employerWithoutImageDTO.getBranchId());

            if (standardResponseResponseEntity.getStatusCode() != HttpStatus.OK) {
                String errorMessage = Objects.requireNonNull(standardResponseResponseEntity.getBody()).getMessage();
                throw new NotFoundException(errorMessage);
            }

            BranchDTO branchDTO = modelMapper.map(
                    Objects.requireNonNull(standardResponseResponseEntity.getBody())
                            .getData(), BranchDTO.class
            );

            //check if the branch is existing
            assert branchDTO != null;
            if (branchDTO.getBranchId() == 0) {
                throw new NotFoundException("Branch not found for the given branch id:"
                        + employerWithoutImageDTO.getBranchId());
            }

            Employer employer = modelMapper.map(employerWithoutImageDTO, Employer.class);

            String savedEmployer = String.valueOf(employerRepository.findByEmployerEmail(employerWithoutImageDTO.getEmployerEmail()));
            if (savedEmployer != null) {
                employerRepository.save(employer);
                long employerId = employer.getEmployerId();
                employerWithoutImageDTO.setEmployerId(employerId);

            } else {
                throw new NotFoundException("Employer not found after saving");
            }
        }
    }

}