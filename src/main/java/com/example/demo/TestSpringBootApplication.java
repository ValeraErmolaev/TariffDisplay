package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.core.JmsTemplate;

@SpringBootApplication
public class TestSpringBootApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(TestSpringBootApplication.class, args);
		JmsTemplate jms = ctx.getBean(JmsTemplate.class);
		jms.convertAndSend("javainuse", "test message");
	}

}
