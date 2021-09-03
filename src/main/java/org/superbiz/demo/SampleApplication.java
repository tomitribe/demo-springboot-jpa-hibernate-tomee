package org.superbiz.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SampleApplication extends SpringBootServletInitializer {
	
	public static void main(String[] args) {
		SpringApplication.run(SampleApplication.class, args);
	}
}
