package com.mingdi;

/**
 * Print char from different arrays with multi-thread
 * Use wait/notify to hold the lock.
 * Producer/Consumer pattern
 */
public class TestLoopPrint1 {

	private static String s1 = "1234567";
	private static String s2 = "abcdefg";
//	private static volatile Object o t1ran = true;
	public static void main(String[] args) {
		Object o = new Object();
		Thread t1 = new Thread(()->{
			synchronized(o) {
				for(int i = 0;i<s1.length();i++) {
					System.out.println(s1.charAt(i));
					o.notify();
					try {
						o.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				o.notifyAll();
			}
		}) ;
		Thread t2 = new Thread(()->{
			synchronized(o) {
				for(int i = 0;i<s2.length();i++) {
					System.out.println(s2.charAt(i));
					o.notify();
					try {
						o.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				o.notifyAll();
			}
			
		}) ;
		
		t1.start();
		t2.start();
	}
}
