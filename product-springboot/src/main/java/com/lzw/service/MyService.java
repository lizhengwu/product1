package com.lzw.service;

import com.lzw.spring.aspect.TimeAspect;

public interface MyService {

	/**
	 * 切面编程
	 * @return
	 */
	@TimeAspect
	String sayHello();
}
