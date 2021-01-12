package net.ati.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DrugAuthenticationMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DrugAuthenticationMsApplication.class, args);
        System.out.println("Auth server is running....");

	}

}
