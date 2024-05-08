package com.nse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsMailApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsMailApplication.class, args);
	}

}
