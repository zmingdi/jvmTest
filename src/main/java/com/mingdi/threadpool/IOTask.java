package com.mingdi.threadpool;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 * IO focus job, stimulate blocking io and no check flag interval
 */
public class IOTask implements Callable<Integer> {
  private Integer taskId;
  public Integer workload;
  public IOTask(Integer taskId) {
    this.workload = new Random().nextInt(20)+2;
    this.taskId = taskId;
    System.out.printf("task %d created, to work %d times\n", taskId, workload);
  }
  @Override
  public Integer call() throws Exception {
    while(--workload>0) {
      if(IOThreadTermination.getInstance().isTerminateFlag()) {
        break;
      }
      Thread.sleep(1000);
    }
    System.out.printf(" task %d completed first!!!\n", this.taskId);
    IOThreadTermination.getInstance().setTerminateFlag(true);
    return 0;
  }
}
