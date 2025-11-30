package com.yasinkucuker.insuranceservice.repository;

import com.yasinkucuker.insuranceservice.model.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
}
