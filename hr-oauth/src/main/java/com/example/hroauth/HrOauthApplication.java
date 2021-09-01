package com.example.hroauth;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class HrOauthApplication  implements CommandLineRunner {
	
	@Value("${jwt.secret}")
	private String jwtSecret;
	
	@Value("${oauth.client.name}")
	private String clientName;
	
	@Value("${oauth.client.secret}")
	private String clientSecret;

	public static void main(String[] args) {
		SpringApplication.run(HrOauthApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("clientSecret: " + clientSecret);
		System.out.println("clientName: " + clientName);
		System.out.println("jwtSecret: " + jwtSecret);
		
	}

}
