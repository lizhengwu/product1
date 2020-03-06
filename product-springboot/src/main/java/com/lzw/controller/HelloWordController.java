package com.lzw.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.lzw.service.MyService;

@RestController
public class HelloWordController {

	@Autowired
	private MyService myService;


	@GetMapping("/helloWord/{name}")
	public Map hellWord(@PathVariable("name") String name) {
		Map<String, String> hello = new HashMap<>();
		hello.put(name, "hello");

		hello.put("aspect", myService.sayHello());

		return hello;
	}



}
