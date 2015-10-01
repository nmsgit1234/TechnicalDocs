package com.tutorial.threads;

public class AtomicCounterThreadTest{
	
	public static void main(String args[]){
		AtomicCounter counter = new AtomicCounter();
		counter.setValue(10);
		Thread t1 = new Thread(new AtomicIncrementCounterThread(counter));
		//counter.setValue(20);
		Thread t2 = new Thread(new AtomicDecrementCounterThread(counter));
		//counter.setValue(30);
		Thread t3 = new Thread(new AtomicIncrementCounterThread(counter));
		//counter.setValue(40);
		Thread t4 = new Thread(new AtomicDecrementCounterThread(counter));
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}