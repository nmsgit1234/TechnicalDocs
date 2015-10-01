package com.tutorial.threads;

public class AtomicDecrementCounterThread implements Runnable{
	AtomicCounter cntr = null;
	
	public AtomicDecrementCounterThread(AtomicCounter cntrObj){
		this.cntr=cntrObj;
	}

	public void run(){
		for(;;){
		try{
			Thread.sleep(1000);
		} catch(Exception ex){
			ex.printStackTrace();
		}		
		cntr.decrement();
		}
	}
}