package com.yasinkucuker.insuranceservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(
		basePackages = {
				"com.yasinkucuker.clients.validation",
				"com.yasinkucuker.clients.notification"}
)
public class InsuranceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InsuranceServiceApplication.class, args);
	}

	/*
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(RestTemplate builder){return builder.build();}
	 */

}
