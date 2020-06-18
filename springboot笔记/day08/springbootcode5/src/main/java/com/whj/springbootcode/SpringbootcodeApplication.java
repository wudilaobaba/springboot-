package com.whj.springbootcode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.whj")
public class SpringbootcodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootcodeApplication.class, args);
	}

}
