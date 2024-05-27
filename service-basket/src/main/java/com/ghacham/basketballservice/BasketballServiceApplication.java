package com.ghacham.basketballservice;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.ghacham.basketball.repository")
@EntityScan(basePackages = "com.ghacham.basketball.entities")
@ComponentScan(basePackages = "com.ghacham.basketball.controller")
@ComponentScan("com.ghacham.basketball.services")
@EnableFeignClients(basePackages = "com.ghacham.basketball.clients")
public class BasketballServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(BasketballServiceApplication.class, args);
		System.out.println("HELLO-----");
	}
}
