package com.tutorial.threads;

public class SBCounterThreadTest{
	
	public static void main(String args[]){
		SBCounter counter = new SBCounter();
		counter.setValue(10);
		Thread t1 = new Thread(new SBIncrementCounterThread(counter));
		//counter.setValue(20);
		Thread t2 = new Thread(new SBDecrementCounterThread(counter));
		//counter.setValue(30);
		Thread t3 = new Thread(new SBIncrementCounterThread(counter));
		//counter.setValue(40);
		Thread t4 = new Thread(new SBDecrementCounterThread(counter));
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}