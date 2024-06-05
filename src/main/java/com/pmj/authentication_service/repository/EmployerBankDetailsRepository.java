package com.pmj.authentication_service.repository;

import com.pmj.authentication_service.entity.EmployerBankDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

/**
 * The interface Employer bank details repository.
 */
@Repository
@EnableJpaRepositories
public interface EmployerBankDetailsRepository extends JpaRepository<EmployerBankDetails, Long> {

    /**
     * Find by employer id employer bank details.
     *
     * @param employerId the employer id
     * @return the employer bank details
     */
    EmployerBankDetails findByEmployerId(long employerId);
}
