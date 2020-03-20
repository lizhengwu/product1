package com.lzw.guava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.Nullable;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Preconditions;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Collections2;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

public class MyGuavaUtils {

	public static void main(String[] args) {

	}

	/**
	 * 可重复的无序集合， list和Set的哼
	 */
	public void mlutiset() {
		Multiset<String> objects = HashMultiset.create();
		objects.add("1");
		objects.add("1");
		objects.add("1");
		int count = objects.count("1");
		int size = objects.size();
	}

	/**
	 * 不可变集合，关键是创建的时候需要copy 否则会影响原来的集合，
	 * {@link Arrays#asList(Object[])} 本来就是一个不可变数组
	 */

	public void immutableList() {
		List<String> stringList = new ArrayList<>();
		stringList.add("1");
		stringList.add("2");

		List<String> unmodifiableList = Collections.unmodifiableList(new ArrayList<>(stringList));
		List<String> unmodifiableList1 = Collections.unmodifiableList(stringList);
		try {
			stringList.add("4");
			unmodifiableList.add("4");
		} catch (Exception e) {

		}
		// jdk自带的会影响到原来的数组,不是真正意义上的快照
		System.out.println(stringList);
		System.out.println(unmodifiableList);

		List<String> stringList1 = new ArrayList<>();
		stringList1.add("3");
		stringList1.add("4");
		//需要拷贝
		ImmutableList<String> strings = ImmutableList.copyOf(stringList1);

		stringList1.add("5");
		//

		System.out.println(stringList1);
		System.out.println(strings);
	}

	/**
	 * 一个value是一个集合的{@link java.util.Map}
	 */
	public void mutilMap() {
		Multimap<String, String> multimap = ArrayListMultimap.create();
		multimap.put("leader", "hanhan");
		multimap.put("leader", "lizhengwu");

		System.out.println(multimap.get("lizhengwu"));
	}

	/**
	 * bitmap 里面是一个双向的map 既可以通过key找value 也可以通过value找Key
	 */
	public void bitMap() {
		HashBiMap<String, String> biMap = HashBiMap.create();

		biMap.put("leader", "hanhan");
		// value重复会报错
		// biMap.put("slaver", "hanhan");
		biMap.forcePut("slaver", "hanhan");

		biMap.put("leader", "lizhengwu");

		String lizhengwu = biMap.inverse().get("lizhengwu");

		System.out.println(lizhengwu);

	}

	/**
	 * 布隆过滤器
	 */
	public void bloom(){
		BloomFilter bloomFilter = BloomFilter.create(Funnels.integerFunnel(),100000);
	}

	/**
	 * 表格
	 */
	public void table() {
		HashBasedTable<String, String, String> hashBasedTable = HashBasedTable.create();
		hashBasedTable.put("1", "1", "11");
		hashBasedTable.put("1", "2", "12");
	}

	/**
	 * 函数式编程
	 */
	public void function() {
		List<String> strings = Lists.newArrayList("a", "b", "c", "d");
		Function<String, String> f1 = new Function<String, String>() {
			@Nullable
			@Override
			public String apply(@Nullable String input) {
				input += "%function1%";
				return input;
			}
		};

		Function<String, String> f2 = new Function<String, String>() {
			@Nullable
			@Override
			public String apply(@Nullable String input) {
				input += "%function2%";
				return input;
			}
		};

		// 传统java 实现方法1 并发
		List<String> collect = strings.parallelStream().map(f1).map(f2).collect(Collectors.toList());
		collect.forEach(System.out::println);

		// 传统java实现方法2
		java.util.function.Function<String, String> f3 = f1.andThen(f2);
		List<String> collectAndThen = strings.stream().map(f3).collect(Collectors.toList());
		collectAndThen.forEach(System.out::println);

		// guava 实现
		Function<String, String> compose = Functions.compose(f2, f1);
		Collection<String> transform = Collections2.transform(strings, compose);
		transform.forEach(System.out::println);
	}

	/**
	 * 校验
	 * @param
	 */
	public void validate(String a ){
		Preconditions.checkNotNull(a,"不能为空");
		Preconditions.checkArgument("null".equals(a),"");
	}

}
