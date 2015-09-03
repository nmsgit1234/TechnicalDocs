package com.tutorial.design;

import com.tutorial.shapes.RectanglePlus;

public class RelatableTest {

	public static void main(String args[]){
		Relatable rectangle1 = new RectanglePlus(100,100);
		Relatable rectangle2 = new RectanglePlus(200,200);
		
		System.out.println("Is rectangle1 larger than rectangle2 : " + rectangle1.isLargerThan(rectangle2));
	}


}