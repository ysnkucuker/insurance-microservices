package com.yasinkucuker.insuranceservice.repository;

import com.yasinkucuker.insuranceservice.model.Accident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccidentRepository extends JpaRepository<Accident, Long> {
}
