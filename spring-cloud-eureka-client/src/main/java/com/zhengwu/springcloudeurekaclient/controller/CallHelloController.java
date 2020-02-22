package com.zhengwu.springcloudeurekaclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.zhengwu.rpcservice.HelloService;

@RestController
public class CallHelloController {

	@Autowired
	private  HelloService helloService;



	@GetMapping("/callhello/{name}")
	public String callHelloByFeign(@PathVariable String name) {

		return helloService.callHello(name);
	}

}
