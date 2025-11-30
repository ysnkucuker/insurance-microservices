package com.yasinkucuker.insuranceservice.service.impl;


import com.yasinkucuker.insuranceservice.exception.VehicleNotFoundException;
import com.yasinkucuker.insuranceservice.model.Vehicle;
import com.yasinkucuker.insuranceservice.repository.VehicleRepository;
import com.yasinkucuker.insuranceservice.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;

    @Override
    @Transactional(readOnly = true)
    public Vehicle findVehicleByPlate(String plate) {
        return vehicleRepository.findByPlate(plate)
                .orElseThrow(() -> new VehicleNotFoundException("Vehicle with plate " + plate + " is not found!"));
    }
}
