package com.tutorial.io;

import java.io.*;
public class ObjectIODemo {
	public static void main(String args[]){
	
		ForkBlur fbObj = new ForkBlur();
		//ObjectInputStream ois = new ObjectInputStream();
/*
		try{
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("objecttest.txt"));
			oos.writeObject(fbObj);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
*/
		try{
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("objecttest.txt"));
			ForkBlur fbObj1 = (ForkBlur)ois.readObject();
		} catch(Exception ex){
			ex.printStackTrace();
		}
}
}