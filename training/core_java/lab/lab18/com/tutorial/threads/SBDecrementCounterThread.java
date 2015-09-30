package com.tutorial.threads;

public class SBDecrementCounterThread implements Runnable{
	SBCounter cntr = null;
	
	public SBDecrementCounterThread(SBCounter cntrObj){
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