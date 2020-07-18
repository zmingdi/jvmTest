package com.mingdi;

public class TestLoopPrint3 {

	public static volatile int notifier = 0;
	public static Object lock = new Object();
	public static volatile boolean inProgress = true;
	public static void main(String[] args) {
		
		Thread t1 = new Thread(new Runner(1,1));
		Thread t2 = new Thread(new Runner(2,2));
		Thread t3 = new Thread(new Runner(3,3));
		t1.start();
		t2.start();
		t3.start();

		inProgress = false;
	}
}

class Runner implements Runnable {

	int toPrint = 0;
	int whenToPrint = 0;

	public Runner( int toPrint, int whenToPrint) {
		this.toPrint = toPrint;
		this.whenToPrint = whenToPrint;
	}
	@Override
	public void run() {
		while(TestLoopPrint3.notifier<10) {
			synchronized(TestLoopPrint3.lock) {
				while(whenToPrint != (TestLoopPrint3.notifier%3+1)) {
					TestLoopPrint3.lock.notify();
					try {
						TestLoopPrint3.lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				if(TestLoopPrint3.notifier>=10 ) {
					break;
				}
				System.out.println(this.toPrint);
				TestLoopPrint3.notifier++;
				TestLoopPrint3.lock.notifyAll();
				
			}
		}

		
	}
	
}
