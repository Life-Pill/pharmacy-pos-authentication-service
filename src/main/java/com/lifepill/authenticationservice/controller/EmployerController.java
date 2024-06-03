package com.lifepill.authenticationservice.controller;

import com.lifepill.authenticationservice.dto.EmployerWithoutImageDTO;
import com.lifepill.authenticationservice.service.EmployerService;
import com.lifepill.authenticationservice.util.StandardResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * Controller class for managing employer-related operations.
 */
@RestController
@RequestMapping("lifepill/v1/employers")
@AllArgsConstructor
public class EmployerController {

    private EmployerService employerService;


    /**
     * Saves an employer without an image.
     *
     * @param cashierWithoutImageDTO DTO containing details of the employer without image.
     * @return A string indicating the success of the operation.
     */
    @PostMapping("/save-without-image")
    public ResponseEntity<StandardResponse> saveCashierWithoutImage(@RequestBody EmployerWithoutImageDTO cashierWithoutImageDTO) {
        employerService.saveEmployerWithoutImage(cashierWithoutImageDTO);

        System.out.println(cashierWithoutImageDTO.getEmployerId());
        return new ResponseEntity<>(
                new StandardResponse(201, "successfully saved", cashierWithoutImageDTO),
                HttpStatus.CREATED
        );
    }
}