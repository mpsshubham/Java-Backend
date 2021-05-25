package com.example.threading;

/**
 * extends Thread or implement Runnable
 * Extending thread class has certain advantages (extra functions like yield,interrupt) but u cannot extend other classes
 * Thread class in turn implements runnable
 * jstack pid > t.txt
 * find pid from task manager details tab java.exe and then google jstack review and paste your thread dump
 * jstack comes with jdk
 */ 
public class MultiThreading {
  
  public static void main(String[] args) {
    
    //MyThread thread = new MyThread();
    //thread.run();  //it does not create new call stack, it executes in the same thread
    //thread.start();  // this creates new call stack, parallel threads are created
    //thread.start();
    // you cannot write thread.start() two times, illegalthreadstateexception
    Thread thread1 = new Thread(new MyThread1());
    try {
    //thread1.setDaemon(true); 
    thread1.start();
    Thread.sleep(5000);
    }
    catch (Exception e) {
      System.out.println("Application has stopped forcefully");
      thread1.interrupt();  //this is last line of main, so we write this so that our custom threads also stop executing after this
      // dont use thread.interrupt() if your thread is not sleeping
    }
    // main thread will finish executing at this point, but thread1 is still running(sleep), so
    // we get an exception as we are forcefully terminating thread1 as application stops when main ends
  }
  
  public static class MyThread extends Thread {
 
    @Override
    public void run() {
      System.out.println(currentThread().getName());
    }
  }
  
  public static class MyThread1 implements Runnable {

    @Override
    public void run() {
      System.out.println("Thread "+Thread.currentThread().getName());
      try {
        Thread.sleep(10000);
      }
      catch (InterruptedException e) {
        System.out.println("Application has stopped forcefully");
      }
      System.out.println("after sleep");
    }   
  }
}