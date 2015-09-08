package com.tutorial.exception;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class AdvancedListOfNumbers {

    private List<Integer> list;
    private static final int SIZE = 10;

    public AdvancedListOfNumbers () {
        list = new ArrayList<Integer>(SIZE);
        for (int i = 0; i < SIZE; i++) {
            list.add(new Integer(i));
        }
    }

    public void writeList() {
	// The FileWriter constructor throws IOException, which must be caught.
		try {
			PrintWriter out = new PrintWriter(new FileWriter("OutFile.txt"));

			for (int i = 0; i < SIZE; i++) {
				// The get(int) method throws IndexOutOfBoundsException, which must be caught.
				out.println("Value at: " + i + " = " + list.get(i+1));
			}
			out.close();
		} catch(IOException|IndexOutOfBoundsException ex){
			//ex.printStackTrace();
			System.out.println("Catched the exception " + ex.getClass());
		}
    }
	
	public static void main(String args[]){
		AdvancedListOfNumbers listOfNum = new AdvancedListOfNumbers();
		listOfNum.writeList();
	}
}