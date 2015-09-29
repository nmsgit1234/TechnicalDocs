package com.tutorial.threads;

public class DecrementCounterThread implements Runnable{
	Counter cntr = null;
	
	public DecrementCounterThread(Counter cntrObj){
		this.cntr=cntrObj;
	}

	public void run(){
		for(;;){
		//cntr.increment();
		int before = cntr.getValue();
		System.out.println(Thread.currentThread().getName() + ": Before decrementing value is :" + cntr.getValue());
		
		try{
			Thread.sleep(1000);
		} catch(Exception ex){
			ex.printStackTrace();
		}		
		cntr.decrement();
		int after = cntr.getValue();
		boolean isSuccess = false;
		if (after == (before-1)) isSuccess = true;
		
		System.out.println(Thread.currentThread().getName() + ":After decrementing value is :" + cntr.getValue() + "status : " + isSuccess);
		}
	}
}