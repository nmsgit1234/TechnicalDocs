package com.tutorial.threads;

public class IncrementCounterThread implements Runnable{
	Counter cntr = null;
	
	public IncrementCounterThread(Counter cntrObj){
		this.cntr=cntrObj;
	}

	public void run(){
		for(;;){
		System.out.println(Thread.currentThread().getName() + ": Before incrementing value is :" + cntr.getValue());
		
		cntr.increment();
		try{
			Thread.sleep(1000);
		} catch(Exception ex){
			ex.printStackTrace();
		}		
		//cntr.decrement();
		System.out.println(Thread.currentThread().getName() + ": After incrementing value is :" + cntr.getValue());
		}
	}
}