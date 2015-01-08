package com.batch;

import org.springframework.boot.SpringApplication;

import com.batch.config.BatchConfiguration;

public class BatchApplication {
	public static void main(String[] args) {
		System.exit(SpringApplication.exit(SpringApplication.run(BatchConfiguration.class, args)));
	}
}