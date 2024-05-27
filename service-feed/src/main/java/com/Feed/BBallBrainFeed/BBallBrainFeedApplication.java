package com.Feed.BBallBrainFeed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.Feed.BBallBrainFeed.Feign")
public class 	BBallBrainFeedApplication {

	public static void main(String[] args) {
		SpringApplication.run(BBallBrainFeedApplication.class, args);
	}

}
