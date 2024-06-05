package com.pmj.authentication_service.dto;

import com.pmj.authentication_service.entity.enums.Gender;
import com.pmj.authentication_service.entity.enums.Role;
import lombok.*;

import java.util.Date;

/**
 * The type Employer auth details response dto.
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class EmployerAuthDetailsResponseDTO {
    private long employerId;
    private int branchId;
    private String employerNicName;
    private String employerFirstName;
    private String employerLastName;
    private String employerEmail;
    private String employerPhone;
    private String employerAddress;
    private double employerSalary;
    private String employerNic;
    private boolean isActiveStatus;
    private Gender gender;
    private Date dateOfBirth;
    private Role role;
    private int pin;
    private byte[] profileImage;
}
