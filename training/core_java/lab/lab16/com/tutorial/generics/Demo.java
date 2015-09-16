package com.tutorial.generics;

import java.util.*;

class Demo {
	static void printStudentNames(List<String> names) {
		for(String name:names) {
		System.out.println("String name:"+name);
		}
	}

	public static void main(String[] args) {
		Demo demo = new Demo();
		demo.printStudentNames(new ArrayList<>());   
		// It saved typing here in a method call too.
		List<String> names = new ArrayList<>();
		printStudentNames(names);
		List<String> copyOfNames = new ArrayList<>(names);  
		// It saved typing here in a copy contructor invocation too.
	}
}
