package com.zhengwu.rpcservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("feignProvider")
public interface HelloService {

	@GetMapping( value = "/hello/{name}")
	String callHello(@PathVariable("name") String name);

}
