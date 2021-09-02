package com.example.hrconfigserver;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class HrConfigServerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(HrConfigServerApplication.class, args);
	}

	public void run(String... args) throws Exception {
		System.out.println("HrConfigServerApplication run");
	}

}
