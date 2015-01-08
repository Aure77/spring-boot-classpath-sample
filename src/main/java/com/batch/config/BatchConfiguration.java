package com.batch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@EnableAutoConfiguration
@EnableBatchProcessing
@PropertySource("batch-configuration.properties")
public class BatchConfiguration {
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	@Bean
	public Step testStep1(StepBuilderFactory stepBuilderFactory, @Value("${my.custom.value}") final String value) {
		return stepBuilderFactory.get("testStep1")
				.tasklet(new Tasklet() {					
					@Override
					public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
						System.out.println("testStep1 says " + value);
						return RepeatStatus.FINISHED;
					}
				})
				.build();
	}
	
	@Bean
	public Job job(JobBuilderFactory jobBuilderFactory, Step testStep1) throws Exception {
		return jobBuilderFactory.get("test")
				.incrementer(new RunIdIncrementer())
				.start(testStep1)
				.build();
	}
	
}
