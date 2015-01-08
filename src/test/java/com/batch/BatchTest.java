package com.batch;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.batch.config.BatchConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BatchConfiguration.class, loader = AnnotationConfigContextLoader.class)
public class BatchTest {

	@Test
	public void test() {
		SpringApplication.run(BatchConfiguration.class);
	}

}