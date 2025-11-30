package com.yasinkucuker.insuranceservice.service;

import com.yasinkucuker.insuranceservice.model.Vehicle;
import org.springframework.stereotype.Service;

@Service
public interface VehicleService {
    Vehicle findVehicleByPlate(String plate);
}
