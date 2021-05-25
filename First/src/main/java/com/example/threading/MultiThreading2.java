package com.example.threading;

public class MultiThreading2 {
  
  public static void main(String[] args) {
    Animal a1 = new Animal("Tom", "Cat");
    Animal a2 = new Animal("Jerry", "Mouse");
    
    MyThread thread1 = new MyThread(a1); 
    MyThread thread2 = new MyThread(a1); 
    MyThread thread3 = new MyThread(a2); 
    MyThread thread4 = new MyThread(a2); 
    
    // using synchronized one of thread1, thread2 can execute simultaneously and same for thread3, thread4
    thread1.start();
    thread2.start();
    thread3.start();
    thread4.start();
  }
  
  public static class MyThread extends Thread {
   
    Animal animal;
    
    public MyThread(Animal animal) {
      this.animal = animal;
    }
    
    @Override
    public void run() {
      
      //try synchronized(Animal.class) // class level synchronisation, only one object of animal can run at a time
      //object level synchronisation
      synchronized (this.animal) {      
        System.out.println("Current Thread : " + currentThread().getName() + " Animal : "+ this.animal);
        try {
          Thread.sleep(10000);
        }
        catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }
}