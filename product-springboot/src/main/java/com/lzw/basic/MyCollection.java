package com.lzw.basic;

import java.time.Clock;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class MyCollection {


	public static void main(String[] args) {
		// testLinkedList();
		Map weakHashMap = weakHashMap();
		System.out.println(weakHashMap);
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

	private static void testHashMap() {
		Map<String, Object> objectObjectHashMap = new HashMap<>();

		Map<String, Object> a = new LinkedHashMap<>();

	}

	/**
	 * 依靠LinkedHashMap来实现LRU算法
	 *
	 * @return
	 */
	private static Map lruLinkedListHashMap() {

		Map linkedHashMap = new LRUCache(4);
		linkedHashMap.put("1", "1");
		linkedHashMap.put("2", "2");
		linkedHashMap.put("3", "3");
		linkedHashMap.put("4", "4");
		linkedHashMap.put("5", "5");
		linkedHashMap.put("6", "6");


		return linkedHashMap;

	}


	/**
	 * key 没有强引用，会被垃圾回收掉
	 *
	 * @return
	 */
	private static Map weakHashMap() {

		Map weakHashMap = new WeakHashMap();
		weakHashMap.put("1", "1");
		weakHashMap.put("2", "2");
		weakHashMap.put("3", "3");
		weakHashMap.put(new String("33"), "3");
		weakHashMap.put(new String("44"), "3");
		weakHashMap.put(new String("55"), "3");

		System.gc();
		System.runFinalization();


		return weakHashMap;
	}

}
