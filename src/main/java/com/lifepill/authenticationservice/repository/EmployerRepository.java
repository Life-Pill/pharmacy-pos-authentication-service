package com.lifepill.authenticationservice.repository;


import com.lifepill.authenticationservice.entity.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import javax.management.relation.Role;
import java.util.List;
import java.util.Optional;


/**
 * The interface Employer repository.
 */
@Repository
@EnableJpaRepositories
public interface EmployerRepository extends JpaRepository<Employer,Long> {

    Optional<Employer> findByEmployerEmail(String employerEmail);

    boolean existsAllByEmployerEmail(String employerEmail);


}
