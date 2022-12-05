package com.ptit.personal;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@Slf4j
@SpringBootApplication
public class MyApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MyApplication.class);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("Application running...");
	}
}
