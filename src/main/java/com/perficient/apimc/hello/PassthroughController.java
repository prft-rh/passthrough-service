package com.perficient.apimc.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/")
public class PassthroughController {

	@Autowired
	RestTemplate rest;
	
	@Value("echo-service-url")
	String echoServiceUrl;
		
	@GetMapping("/passthrough")
	public String passthrough(@RequestParam String message) {
		
		return rest.getForObject(echoServiceUrl + "?message" + message, String.class);		
	}
}
