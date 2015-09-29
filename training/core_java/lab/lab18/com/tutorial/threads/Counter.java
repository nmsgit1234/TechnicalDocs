package com.tutorial.threads;

class Counter {
    private int c = 0;

    public synchronized void increment() {
        c++;
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