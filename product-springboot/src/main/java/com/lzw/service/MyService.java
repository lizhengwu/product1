package com.lzw.service;

import com.lzw.aspect.TimeAspect;

public interface MyService {

	/**
	 * 切面编程
	 * @return
	 */
	@TimeAspect
	String sayHello();
}
