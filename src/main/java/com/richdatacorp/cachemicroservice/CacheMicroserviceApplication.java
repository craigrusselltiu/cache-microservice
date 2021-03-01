package com.richdatacorp.cachemicroservice;

import java.util.concurrent.Executor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@SpringBootApplication
@EnableAsync
public class CacheMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CacheMicroserviceApplication.class, args);
	}

	/**
	 * Executor bean to handle asynchronous threading.
	 * Credit from: https://stackoverflow.com/questions/46888314/proper-way-to-start-new-thread-from-service-layer-using-spring
	 * 
	 * @return - Async Executor
	 */
	@Bean
	public Executor asyncExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(2);
		executor.setMaxPoolSize(2);
		executor.setQueueCapacity(500);
		executor.setThreadNamePrefix("Expire");
		executor.initialize();
		return executor;
	}

}
