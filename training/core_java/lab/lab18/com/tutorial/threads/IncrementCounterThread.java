package com.tutorial.threads;

public class IncrementCounterThread implements Runnable{
	Counter cntr = null;
	
	public IncrementCounterThread(Counter cntrObj){
		this.cntr=cntrObj;
	}

	public void run(){
		for(;;){
		
		cntr.increment();
		try{
			Thread.sleep(1000);
		} catch(Exception ex){
			ex.printStackTrace();
		}		
		//cntr.decrement();
		}
	}
}