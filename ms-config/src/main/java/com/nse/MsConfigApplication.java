package com.nse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer//This is making it a config-server
public class MsConfigApplication {
	public static void main(String[] args) {
		SpringApplication.run(MsConfigApplication.class, args);
	}

}
