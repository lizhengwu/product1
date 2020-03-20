package com.lzw.guava;

import org.junit.jupiter.api.Test;

class MyGuavaUtilsTest {
	MyGuavaUtils myGuavaUtils = new MyGuavaUtils();

	@Test
	void immutableList() {

		myGuavaUtils.immutableList();
	}

	@Test
	void mutilMap() {

		myGuavaUtils.mutilMap();
	}

	@Test
	void bitMap() {
		myGuavaUtils.bitMap();
	}

	@Test
	void func() {
		// myGuavaUtils.function();
		System.out.println(4%8);
	}
}