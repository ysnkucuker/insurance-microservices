package com.yasinkucuker.insuranceservice.service.impl;

import com.yasinkucuker.clients.notification.NotificationClient;
import com.yasinkucuker.clients.notification.NotificationRequest;
import com.yasinkucuker.clients.validation.CreditCardValidationClient;
import com.yasinkucuker.clients.validation.CreditCardValidationRequest;
import com.yasinkucuker.clients.validation.CreditCardValidationResponse;
import com.yasinkucuker.insuranceservice.exception.CreditCardValidationException;
import com.yasinkucuker.insuranceservice.model.Customer;
import com.yasinkucuker.insuranceservice.model.Insurance;
import com.yasinkucuker.insuranceservice.model.Vehicle;
import com.yasinkucuker.insuranceservice.model.dto.InsurancePaymentRequest;
import com.yasinkucuker.insuranceservice.model.dto.InsurancePaymentResponse;
import com.yasinkucuker.insuranceservice.repository.CustomerRepository;
import com.yasinkucuker.insuranceservice.repository.InsuranceRepository;
import com.yasinkucuker.insuranceservice.service.CustomerService;
import com.yasinkucuker.insuranceservice.service.InsuranceService;
import com.yasinkucuker.insuranceservice.service.VehicleService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;


@Service
@Slf4j
@RequiredArgsConstructor
@Getter
public class InsuranceServiceImpl implements InsuranceService {

    @Value("${rabbitmq.exchanges.internal}")
    private String notificationExchange;

    @Value("${rabbitmq.queues.notification}")
    private String notificationQueue;

    @Value("${rabbitmq.routing-keys.internal-notification}")
    private String notificationRoutingKey;

    private final InsuranceRepository insuranceRepository;
    private final CustomerRepository customerRepository; // Not recommended!
    private final CustomerService customerService;
    private final VehicleService vehicleService;
    private final RestTemplate restTemplate; // Main methodunda @bean anotasyonuna bak
    private final CreditCardValidationClient creditCardValidationClient;

    //private final CreditCardValidationClient creditCardValidationClient;
    private final NotificationClient notificationClient;
    //private final RabbitMQMessageProducer mqMessageProducer;


    @Override
    @Transactional
    public InsurancePaymentResponse payForInsurancePolicy(InsurancePaymentRequest paymentRequest) {
        // get Customer entity from database
        // Customer customer = customerRepository.getById(paymentRequest.getCustomerID()); // Not recommended!
        Customer customer = customerService.findCustomer(paymentRequest.getCustomerID());
        Vehicle vehicle = vehicleService.findVehicleByPlate(paymentRequest.getVehiclePlate());

        // validate credit card number
        CreditCardValidationRequest validationRequest = CreditCardValidationRequest.builder()
                .customerId(paymentRequest.getCustomerID())
                .creditCardNumber(paymentRequest.getCreditCard().getCardNumber())
                .build();

        /* Eurekaya kayıt olduktan sonra
        CreditCardValidationResponse validationResponse = restTemplate.postForObject("http://VALIDATIOIN-SERVICE/creditcards/validate",
                validationRequest, CreditCardValidationResponse.class);
         */
         /*CreditCardValidationResponse validationResponse = restTemplate.postForObject("http://localhost:8081/creditcards/validate",
                validationRequest, CreditCardValidationResponse.class);*/

        // OpenFeign ile
        CreditCardValidationResponse validationResponse = creditCardValidationClient.validateCreditCard(validationRequest);

        // pay insurance policy amount
        if (validationResponse.isValid()) {
            // retrieve payment
            log.info("Payment retrieved successfully!");

            // save transaction to database
            insuranceRepository.save(Insurance.builder()
                    .customer(customer)
                    .vehicle(vehicle)
                    .insuranceAmount(paymentRequest.getInsuranceAmount())
                    .insuranceExpiryDate(LocalDate.now().plusYears(1))
                    .build());
            log.info("Insurance transaction saved to database successfully!");

            // notify customer about insurance policy
            NotificationRequest notificationRequest = NotificationRequest.builder()
                    .toCustomerId(customer.getId())
                    .message("Hello " + customer.getFullName() + ", Insurance policy successfully generated!")
                    .toCustomerPhone(customer.getPhoneNumber())
                    .build();

            /*restTemplate.postForObject("http://localhost:8082/notifications",
                    notificationRequest, Boolean.class);*/
            notificationClient.sendNotification(notificationRequest);
            // mqMessageProducer.publish(notificationRequest, notificationExchange,notificationRoutingKey);

        } else {
            String creditCardNumberAsStr = String.valueOf(validationRequest.getCreditCardNumber());
            throw new CreditCardValidationException(String.format("Credit card number is not valid : %s",
                    creditCardNumberAsStr.substring(0, 4) + "********" + creditCardNumberAsStr.substring(12, 16)));
        }

        // return result
        return InsurancePaymentResponse.builder()
                .customerID(paymentRequest.getCustomerID())
                .vehiclePlate(paymentRequest.getVehiclePlate())
                .insuranceAmount(paymentRequest.getInsuranceAmount())
                .dateOfExpiry(LocalDate.now().plusYears(1))
                .isPaid(Boolean.TRUE)
                .build();
    }
}