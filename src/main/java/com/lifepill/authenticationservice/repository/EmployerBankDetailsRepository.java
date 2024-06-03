package com.lifepill.authenticationservice.repository;

import com.lifepill.authenticationservice.entity.EmployerBankDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

/**
 * The interface Employer bank details repository.
 */
@Repository
@EnableJpaRepositories
public interface EmployerBankDetailsRepository extends JpaRepository<EmployerBankDetails, Long> {

    EmployerBankDetails findByEmployerId(long employerId);
}
