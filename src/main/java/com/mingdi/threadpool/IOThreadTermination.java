package com.mingdi.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class IOThreadTermination {
  private boolean terminateFlag=false;
  public static void main(String[] args) {
    IOThreadTermination.getInstance().execute();
  }

  public static volatile IOThreadTermination INSTANCE = null;
  private IOThreadTermination() {

  }
  public static IOThreadTermination getInstance() {

    if(INSTANCE==null) {
      synchronized (IOThreadTermination.class) {
        if(INSTANCE == null) {
          INSTANCE = new IOThreadTermination();
        }
      }
    }
    return INSTANCE;
  }
  ExecutorService executor = Executors.newFixedThreadPool(5);

  public boolean isTerminateFlag() {
    return terminateFlag;
  }

  public void setTerminateFlag(boolean terminateFlag) {
    this.terminateFlag = terminateFlag;
    executor.shutdownNow();
  }
  public void execute() {
    IntStream.range(0,5).parallel().forEach(index->{
      IOTask task = new IOTask(index);
      executor.submit(task);
    });
  }
}
