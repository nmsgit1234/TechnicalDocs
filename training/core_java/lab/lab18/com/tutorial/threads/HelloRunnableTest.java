package com.tutorial.threads;

public class HelloRunnableTest implements Runnable {

    public void run() {
        System.out.println("Hello from a thread!" + Thread.currentThread().getName());
		try{
			Thread.sleep(5000);
		} catch(Exception ex){
			ex.printStackTrace();
		}
		
    }

    public static void main(String args[]) {
		System.out.println("Main thread id is :" + Thread.currentThread().getId());
		HelloRunnableTest thread1 = new HelloRunnableTest();
		for(int i=0;i< 10;i++){
			(new Thread(new HelloRunnable())).start();
		}
    }

}