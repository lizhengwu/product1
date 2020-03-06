package com.lzw.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWordController {

	@GetMapping("/helloWord/{name}")
	public Map hellWord(@PathVariable("name") String name) {
		Map<String, String> hello = new HashMap<>();
		hello.put(name, "hello");
		return hello;
	}
}
