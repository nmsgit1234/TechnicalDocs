package com.tutorial.generics;

public class GenericsTest{
	
	public static void main(String args[]){
		Pair<String, Integer> p1 = new OrderedPair<String, Integer>("Even", 8);	
		Pair<String, String>  p2 = new OrderedPair<String, String>("hello", "world");
		
		//Generic method invocation
		Pair<Integer, String> p3 = new OrderedPair<>(1, "apple");
		Pair<Integer, String> p4 = new OrderedPair<>(2, "pear");
		boolean same = Util.compare(p3, p4);
		System.out.println(" is p1 and p2 same? : " + same);
	}
}