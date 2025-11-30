package com.yasinkucuker.insuranceservice.initializer;

import com.yasinkucuker.insuranceservice.model.*;
import com.yasinkucuker.insuranceservice.repository.AccidentRepository;
import com.yasinkucuker.insuranceservice.repository.CustomerRepository;
import com.yasinkucuker.insuranceservice.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Month;

@Configuration
public class TestDataInitializer implements ApplicationRunner {

    private final CustomerRepository customerRepository;
    private final AccidentRepository accidentRepository;
    private final VehicleRepository vehicleRepository;

    @Autowired
    public TestDataInitializer(CustomerRepository customerRepository, AccidentRepository accidentRepository, VehicleRepository vehicleRepository) {
        this.customerRepository = customerRepository;
        this.accidentRepository = accidentRepository;
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("START................");

        if(customerRepository.findAll().size() == 0){


        Customer customer1 = new Customer("Yasin Küçüker", "Tuzla İstanbul", 1111111, "05431129459");
        Customer customer2 = new Customer("Emre Küçüker", "Karaman", 123131, "054532665");
        Customer customer3 = new Customer("Ali Yahya", "Konya", 21312312, "156156456");

        Vehicle car1 = new Car("Hyundai Accent", "32AD232", 2020, "yellow");
        Vehicle car2 = new Car("Honda Accord", "70AD213", 2022, "blue");
        Vehicle moto1 = new Motorcycle("Yamaha", "42RET321", 2024, 250);
        Vehicle moto2 = new Motorcycle("Kawasaki", "35OO232", 2023, 233);
        Vehicle moto3 = new Motorcycle("Yamakazi", "65WE21312", 2022, 233);

        car1.setCustomer(customer1);
        car2.setCustomer(customer2);
        moto1.setCustomer(customer1);
        moto2.setCustomer(customer3);
        moto3.setCustomer(customer2);

        Accident accident1 = new Accident(LocalDate.of(2022, Month.APRIL, 22));
        Accident accident2 = new Accident(LocalDate.of(2024, Month.AUGUST, 05));
        Accident accident3 = new Accident(LocalDate.of(2020, Month.JANUARY, 15));

        car1.getAccidents().add(accident1);
        car2.getAccidents().add(accident1);
        moto1.getAccidents().add(accident3);
        moto3.getAccidents().add(accident1);
        moto2.getAccidents().add(accident2);


        customerRepository.save(customer1);
        customerRepository.save(customer2);
        customerRepository.save(customer3);

        accidentRepository.save(accident1);
        accidentRepository.save(accident2);
        accidentRepository.save(accident3);

        vehicleRepository.save(car1);
        vehicleRepository.save(car2);
        vehicleRepository.save(moto1);
        vehicleRepository.save(moto2);
        vehicleRepository.save(moto3);
        }


        System.out.println("FINISH--------------------");
    }
}
