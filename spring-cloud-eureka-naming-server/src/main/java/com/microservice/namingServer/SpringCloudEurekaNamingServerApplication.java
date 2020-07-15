package com.microservice.namingServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringCloudEurekaNamingServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudEurekaNamingServerApplication.class, args);
	}

}
