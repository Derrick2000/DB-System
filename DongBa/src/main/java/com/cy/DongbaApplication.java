package com.cy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@EnableCaching
@SpringBootApplication
public class DongbaApplication {
	public static void main(String[] args) {
		SpringApplication.run(DongbaApplication.class, args);
	}
}
