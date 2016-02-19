package me.wonwoo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;

@SpringBootApplication
@EnableSpringConfigured
public class SpringAopExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAopExampleApplication.class, args);
	}

}
