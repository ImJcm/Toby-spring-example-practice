package com.imjcm.tobyspringexamplepractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class TobySpringExamplePracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(TobySpringExamplePracticeApplication.class, args);
	}

}
