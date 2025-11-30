package com.yasinkucuker.insuranceservice.controller;

import com.yasinkucuker.insuranceservice.model.dto.InsurancePaymentRequest;
import com.yasinkucuker.insuranceservice.model.dto.InsurancePaymentResponse;
import com.yasinkucuker.insuranceservice.service.InsuranceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class InsuranceController {

    private final InsuranceService insuranceService;

    @PostMapping("/insurances/payment")
    public InsurancePaymentResponse payForInsurancePolicy(@RequestBody InsurancePaymentRequest paymentRequest) {
        return insuranceService.payForInsurancePolicy(paymentRequest);
    }

}
