package com.cydeo.repository;

import com.cydeo.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrganizationRepository extends JpaRepository<Organization,Long> {

    Optional<Organization> findById(Long organizationId);
}
