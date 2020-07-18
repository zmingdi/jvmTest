package com.mingdi;


/**
 * print out char from different array one by one by using multi-thread.
 * Use volatile flag to switch active thread worker.
 */
public class TestLoopPrint2 {
	private static String s1 = "1234567";
	private static String s2 = "abcdefg";
	private static volatile boolean t1ran = false;

	public static void main(String[] args) {
		Thread t1 = new Thread(() -> {
			for (int i = 0; i < s1.length(); i++) {
				while(t1ran) {}
				System.out.println(s1.charAt(i));
				t1ran = !t1ran;
			}
		});
		Thread t2 = new Thread(() -> {
			for (int i = 0; i < s2.length(); i++) {
				while(!t1ran) {}
				System.out.println(s2.charAt(i));
				t1ran = !t1ran;
			}
		});

		t1.start();
		t2.start();
	}
}
