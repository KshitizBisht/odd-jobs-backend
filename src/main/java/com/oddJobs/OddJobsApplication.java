package com.oddJobs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableRetry
public class OddJobsApplication {

	public static void main(String[] args) {
		SpringApplication.run(OddJobsApplication.class, args);
	}

}
