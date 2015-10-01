package com.tutorial.threads;

public class AtomicIncrementCounterThread implements Runnable{
	AtomicCounter cntr = null;
	
	public AtomicIncrementCounterThread(AtomicCounter cntrObj){
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