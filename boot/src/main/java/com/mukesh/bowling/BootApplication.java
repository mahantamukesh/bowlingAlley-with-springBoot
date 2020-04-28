package com.mukesh.bowling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

@SpringBootApplication
@ComponentScan(basePackages = "com.mukesh.bowling")
public class BootApplication implements CommandLineRunner {


	@Autowired
	private ApplicationContext appContext;
	public static void main(String[] args) {
		SpringApplication.run(BootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		String[] beans = appContext.getBeanDefinitionNames();
		Arrays.sort(beans);
		for (String bean : beans) {
			System.out.println(bean);
		}

	}

}
