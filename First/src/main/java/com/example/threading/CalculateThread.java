package com.example.threading;

//Join : main will not wait for t1.start() and t2.start() to finish and result will be unpredictable
// so using join t1.join t2.join, main will wait for t1, t2 calculate
public class CalculateThread {
  public static void main(String[] args) throws InterruptedException {
    MyThread t1 = new MyThread();
    MyThread t2 = new MyThread();
    long start = System.currentTimeMillis();
    t1.start();
    t2.start();
    t1.join();
    t2.join();
    System.out.println(t1.result-t2.result);
    long end = System.currentTimeMillis();
    

  }
  
  public static class MyThread extends Thread {
    private int result;    
    @Override
    public void run() {
      //logic
    }
  }
}
