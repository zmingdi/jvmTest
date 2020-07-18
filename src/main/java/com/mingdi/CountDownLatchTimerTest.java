package com.mingdi;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchTimerTest {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatchTimerTest t = new CountDownLatchTimerTest();
        t.test();
        System.out.printf("main thread finished!");
    }

    public void test() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        Thread t1 = new Thread(new CountDownLatchRunner(latch));
        Thread t2 = new Thread(new CountDownLatchRunner(latch));
        Thread t3 = new Thread(new CountDownLatchRunner(latch));


        t1.start();
        t2.start();
        t3.start();
        latch.await();
        System.out.println("test function finished!");
    }
}
class CountDownLatchRunner implements Runnable{

    CountDownLatch latch = null;
    public CountDownLatchRunner(CountDownLatch latch) {
        this.latch = latch;
    }
    @Override
    public void run() {
        long start = System.currentTimeMillis();
        try {
            Thread.sleep(1000+ new Random().nextInt(3000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + ": " + (System.currentTimeMillis()-start));
        latch.countDown();
    }
}
