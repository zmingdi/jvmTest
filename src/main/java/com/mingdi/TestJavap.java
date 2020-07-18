package com.mingdi;

import java.util.stream.IntStream;

import org.openjdk.jol.info.ClassLayout;

public class TestJavap{

//	private int x = 1;
	
//	public TestJavap( int p ) {
//		x = p;
//	}
	public int plus() {
		int a=1,b=2;
		return a+b;
	}
	
	public static void main(String[] args) throws InterruptedException {
		TestJavap test = new TestJavap();
		System.out.println(ClassLayout.parseInstance(test).toPrintable());
		synchronized(test) {
			int c = test.plus();
			System.out.println(c);
			System.out.println(ClassLayout.parseInstance(test).toPrintable());
		}
		IntStream.range(1,10).parallel().forEach(System.out::println);
//		System.out.println(Thread.currentThread().hashCode());
//		System.out.println(ClassLayout.parseInstance(test).toPrintable());
//		Thread.sleep(8000);
//		System.out.println(ClassLayout.parseInstance(test).toPrintable());
	}
}
