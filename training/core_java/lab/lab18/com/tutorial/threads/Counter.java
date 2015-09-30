package com.tutorial.threads;

class Counter {
    private int c = 0;

    public synchronized void increment() {
		int before = getValue();
		System.out.println(Thread.currentThread().getName() + ": Before incrementing value is :" + getValue());
        c++;
		int after = getValue();
		boolean isSuccess=false;
		if (after == (before +1)) isSuccess = true;
		System.out.println(Thread.currentThread().getName() + ":After incrementing value is :" + getValue() + "status : " + isSuccess);
	}

    public synchronized void decrement() {
        c--;
    }

    public synchronized int getValue() {
        return c;
    }
	
    public synchronized void  setValue(int num) {
        this.c = num;
    }
	

}