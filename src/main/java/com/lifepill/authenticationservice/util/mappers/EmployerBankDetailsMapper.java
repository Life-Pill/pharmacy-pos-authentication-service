package com.lifepill.authenticationservice.util.mappers;


import com.lifepill.authenticationservice.dto.EmployerBankDetailsDTO;
import com.lifepill.authenticationservice.entity.EmployerBankDetails;

public class EmployerBankDetailsMapper {

    public static EmployerBankDetailsDTO toDTO(EmployerBankDetails employerBankDetails) {
        // Map fields from EmployerBankDetails to EmployerBankDetailsDTO
        EmployerBankDetailsDTO dto = new EmployerBankDetailsDTO();
        dto.setBankName(employerBankDetails.getBankName());
        return dto;
    }

    public static EmployerBankDetails toEntity(EmployerBankDetailsDTO dto) {

        EmployerBankDetails entity = new EmployerBankDetails();
        entity.setBankName(dto.getBankName());
        return entity;
    }
}
