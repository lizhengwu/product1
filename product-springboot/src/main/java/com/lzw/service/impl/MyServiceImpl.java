package com.lzw.service.impl;

import org.springframework.stereotype.Service;

import com.lzw.aspect.TimeAspect;
import com.lzw.service.MyService;

@Service
public class MyServiceImpl implements MyService {

	// @TimeAspect
	@Override
	public String sayHello() {
		return "hello lizhengwu";
	}
}
