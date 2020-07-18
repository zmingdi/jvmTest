package com.mingdi.threadpool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class CPUThreadTermination {
  public static volatile Boolean terminateFlag = false;
  public static void main(String[] args) {
    ExecutorService executor = Executors.newFixedThreadPool(5);
    IntStream.range(0,5).parallel().forEach(index->{
      CPUTasks task = new CPUTasks(index);
      executor.submit(task);
    });
    executor.shutdown();
  }
}
