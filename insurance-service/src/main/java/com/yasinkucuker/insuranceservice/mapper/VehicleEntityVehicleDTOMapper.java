package com.yasinkucuker.insuranceservice.mapper;

import com.yasinkucuker.insuranceservice.model.Car;
import com.yasinkucuker.insuranceservice.model.Motorcycle;
import com.yasinkucuker.insuranceservice.model.Vehicle;
import com.yasinkucuker.insuranceservice.model.dto.VehicleDTO;
import com.yasinkucuker.insuranceservice.model.enums.VehicleType;
import org.springframework.stereotype.Component;

@Component
public class VehicleEntityVehicleDTOMapper implements BaseMapper<VehicleDTO, Vehicle> {
    public VehicleDTO map(Vehicle vehicle, Object... params){
        VehicleDTO vehicleDTO = new VehicleDTO();
        vehicleDTO.setId(vehicle.getId());
        vehicleDTO.setModel(vehicle.getModel());
        vehicleDTO.setPlate(vehicle.getPlate());
        vehicleDTO.setYear(vehicle.getYear());
        if(vehicle instanceof Car){
            vehicleDTO.setVehicleType(VehicleType.CAR);
        }
        else if(vehicle instanceof Motorcycle){
            vehicleDTO.setVehicleType(VehicleType.MOTORCYCLE);
        }
        // vehicleDTO.setVehicleType(vehicle instanceof  Car ? VehicleType.CAR : VehicleType.MOTORCYCLE);
        return  vehicleDTO;
    }
}
