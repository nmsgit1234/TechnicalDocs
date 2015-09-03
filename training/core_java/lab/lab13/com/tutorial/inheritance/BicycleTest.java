package com.tutorial.inheritance;

public class BicycleTest {
	public static void main(String args[]){
		MountainBike mbike = new MountainBike(200,100,20,1);
		Object bikeObj = mbike;
		Bicycle bicycle = mbike;
		System.out.println("The bicycle heigh is " + bicycle.speed);
	
	}








}