package com.yasinkucuker.validationservice.repository;

import com.yasinkucuker.validationservice.model.CustomerCreditCardValidationHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerCreditCardValidationHistoryRepository extends JpaRepository<CustomerCreditCardValidationHistory, Long> {
}