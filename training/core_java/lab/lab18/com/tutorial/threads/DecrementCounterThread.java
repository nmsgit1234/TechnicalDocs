package com.tutorial.threads;

public class DecrementCounterThread implements Runnable{
	Counter cntr = null;
	
	public DecrementCounterThread(Counter cntrObj){
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