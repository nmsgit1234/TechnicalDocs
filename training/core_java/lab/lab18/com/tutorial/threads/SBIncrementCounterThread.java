package com.tutorial.threads;

public class SBIncrementCounterThread implements Runnable{
	SBCounter cntr = null;
	
	public SBIncrementCounterThread(SBCounter cntrObj){
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