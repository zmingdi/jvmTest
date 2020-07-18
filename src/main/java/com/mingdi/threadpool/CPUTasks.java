package com.mingdi.threadpool;

import java.util.Random;
import java.util.concurrent.Callable;

public class CPUTasks implements Callable <Integer> {

  private Integer workLoad;
  private Integer taskId;
  public CPUTasks(Integer id) {
    this.taskId = id;
    this.workLoad = new Random().nextInt(20);
    System.out.printf("task %d created, to iterate %d times. \n",id, workLoad);
  }
  @Override
  public Integer call() throws Exception {
    while(--workLoad>0) {
      if(CPUThreadTermination.terminateFlag) {
        // Flag detection, if true, some other thread had completed their work, shall terminate now.
        break;
      }
      Thread.sleep(1000);
    }
    if(!CPUThreadTermination.terminateFlag) {
      CPUThreadTermination.terminateFlag = true;
    }
    System.out.printf("task %d complete, %d times executed.\n",this.taskId,workLoad);
    return workLoad;
  }
}
