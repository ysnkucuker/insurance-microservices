package com.yasinkucuker.insuranceservice.service;

import com.yasinkucuker.insuranceservice.model.dto.InsurancePaymentRequest;
import com.yasinkucuker.insuranceservice.model.dto.InsurancePaymentResponse;

public interface InsuranceService {
    InsurancePaymentResponse payForInsurancePolicy(InsurancePaymentRequest paymentRequest);
}
