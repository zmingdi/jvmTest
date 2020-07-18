package com.mingdi;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.stream.IntStream;

public class CountDownLatchTest {

	public static void main(String[] args) throws InterruptedException {
		
		int latches = new Random().nextInt(10);
		CountDownLatch latch = new CountDownLatch(latches);
		IntStream.range(0, latches).forEach(index -> {
			new Thread(() -> {
				System.out.println(Thread.currentThread().getName());
				latch.countDown();
				/*
				 * when countDown hit, decrease the latch count, not related to current thread.
				 */
//				try {
//					Thread.sleep(20);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
				System.out.println(Thread.currentThread().getName()+ " print again.");
			}).start();
		});
		latch.await();
		
		System.out.println("Completed!!");
	}
}
