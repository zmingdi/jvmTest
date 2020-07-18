package com.mingdi;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Print char from different arrays with multi-thread
 * TODO: use countDownlatch::Condition to make accurate switch.
 */
public class TestLoopPrint4 {

	public static volatile int notifier = 0;

	public static volatile boolean inProgress = true;

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService service = Executors.newFixedThreadPool(5);
		Future<Integer> result = service.submit(new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				System.out.println("==== pool :" + Thread.currentThread().getName());
				Thread.sleep(5000);
				return new Random().nextInt();
			}
		});
		System.out.println("==== main :" + Thread.currentThread().getName());
		System.out.println(result.get());
//		Lock lock = new ReentrantLock();
//		Condition c1 = lock.newCondition();
//		Condition c2 = lock.newCondition();
//		Thread t1 = new Thread(() -> {
//			lock.lock();
//			while ( TestLoopPrint4.notifier < 10) {
//				while(TestLoopPrint4.notifier%2==1) {
//					try {
//						c1.await();
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//				System.out.println("A");
//				TestLoopPrint4.notifier++;
//				c2.signal();
//			}
//			lock.unlock();
//		});
//		Thread t2 = new Thread(() -> {	
//			lock.lock();
//			while ( TestLoopPrint4.notifier < 10) {
//				while(TestLoopPrint4.notifier%2==0) {
//					try {
//						c2.await();
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//				System.out.println("B");
//				TestLoopPrint4.notifier++;
//				c1.signal();
//			}
//			lock.unlock();
//		});
//		t1.start();
//		t2.start();
	}
}
