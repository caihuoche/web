package com.anan.web;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

/**
 * @author yanghaiyu
 * @date 2018/04/24
 **/
public class LambdaTest {

	@Test
	public void t1(){
		new Thread(()-> System.out.println(2)).start();
	}

	@Test
	public void t2(){
		List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
		features.forEach(System.out::println);
		List collect = features.stream().map(x -> {
			System.out.println(x);
			return x;
		}).collect(Collectors.toList());
		features.stream().map(x-> x+"111").forEach(System.out::println);
	}

	// 使用lambda表达式和函数式接口Predicate
	@Test
	public void t3(){
		List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
		languages.stream().filter(s -> s.startsWith("J")).forEach(System.out::println);
	}

	@Test
	public  void t4(){
		List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");

		// 创建一个字符串列表，每个字符串长度大于2
		List<String> filtered = features.stream().filter(x -> x.length()> 2).collect(Collectors.toList());
		System.out.printf("Original List : %s, filtered list : %s %n", features, filtered);

		String collect = features.stream().collect(Collectors.joining(","));
		System.out.println(collect);
	}

	@Test
	public void t5(){
		List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
		List<String> collect = features.stream().limit(3).collect(Collectors.toList());
		System.out.println(collect);
		List<String> collect1 = features.stream().sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
		System.out.println(collect1);
	}
}
