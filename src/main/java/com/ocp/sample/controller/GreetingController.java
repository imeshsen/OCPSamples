package com.ocp.sample.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ocp.sample.DemoApplication;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s! ";
	private final AtomicLong counter = new AtomicLong();
	private static final Logger logger = LogManager.getLogger(DemoApplication.class);

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		logger.info("Application GET method..");
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
}
