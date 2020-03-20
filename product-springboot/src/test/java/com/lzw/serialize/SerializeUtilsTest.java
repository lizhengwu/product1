package com.lzw.serialize;

import org.junit.jupiter.api.Test;

class SerializeUtilsTest {

	@Test
	void jdkSerialize() {
		SerializeUtils serializeUtils = new SerializeUtils();
		long start = System.currentTimeMillis();
		try {
			for (int i = 0; i < 10000; i++) {
				serializeUtils.jdkSerialize();
			}

		} catch (Exception e) {

		}
		long end = System.currentTimeMillis();

		System.out.println("total" + (end - start));
		System.out.println((end - start) / 10000);
	}

	@Test
	void kryoSerialize() {
		SerializeUtils serializeUtils = new SerializeUtils();
		long start = System.currentTimeMillis();
		try {
			for (int i = 0; i < 10000; i++) {
				serializeUtils.kryoSerialize();
			}

		} catch (Exception e) {

		}
		long end = System.currentTimeMillis();

		System.out.println("total" + (end - start));
		System.out.println((end - start) / 10000);
	}

	@Test
	void fastJsonSerialize() {
		SerializeUtils serializeUtils = new SerializeUtils();
		long start = System.currentTimeMillis();
		try {
			for (int i = 0; i < 1000; i++) {
				serializeUtils.fastJsonSerialize();
			}

		} catch (Exception e) {

		}
		long end = System.currentTimeMillis();

		System.out.println("total" + (end - start));
		System.out.println((end - start) / 1000);
	}

}