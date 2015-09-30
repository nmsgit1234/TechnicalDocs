package com.tutorial.threads;

class SBCounter {
    private int c = 0;
	public Object lock1 = new Object();
	public Object lock2 = new Object();
	

    public void increment() {
		synchronized(lock1) {
			int before = getValue();
			System.out.println(Thread.currentThread().getName() + ": Before incrementing value is :" + getValue());
			c++;
			int after = getValue();
			boolean isSuccess=false;
			if (after == (before +1)) isSuccess = true;
			System.out.println(Thread.currentThread().getName() + ":After incrementing value is :" + getValue() + "status : " + isSuccess);
		}
	}

    public synchronized void decrement() {
		synchronized(lock1) {
			c--;
		}
    }

    public synchronized int getValue() {
        return c;
    }
	
    public synchronized void  setValue(int num) {
        this.c = num;
    }
	

}