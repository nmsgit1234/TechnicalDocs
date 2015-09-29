package com.tutorial.threads;

public class CounterThreadTest{
	
	public static void main(String args[]){
		Counter counter = new Counter();
		counter.setValue(10);
		Thread t1 = new Thread(new IncrementCounterThread(counter));
		counter.setValue(20);
		Thread t2 = new Thread(new DecrementCounterThread(counter));
		counter.setValue(30);
		Thread t3 = new Thread(new IncrementCounterThread(counter));
		counter.setValue(40);
		Thread t4 = new Thread(new DecrementCounterThread(counter));
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}