package com.lzw.basic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MyCollection {

	public static void main(String[] args) {
		// testLinkedList();
	}

	private static void testArrayList() {
		List<String> list = new ArrayList<>(5);
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		// 在第新增六个的时候内部数组会扩容到7
		list.add("6");
	}

	private static void safeArrayList() {
		Collection<Object> objects = Collections.synchronizedCollection(new ArrayList<>());
		objects.add("1");

		CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
		copyOnWriteArrayList.add("1");
	}

	private static void testLinkedList() {
		List<String> a = new LinkedList<>();
		a.add("1");
		a.add("2");
		a.add("3");
		a.add("4");
		a.add("5");
		a.add("6");
	}

	private static void testHashMap(){

	}

}
