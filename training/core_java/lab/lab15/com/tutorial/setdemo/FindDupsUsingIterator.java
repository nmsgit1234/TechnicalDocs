package com.tutorial.setdemo;
import java.util.*;

public class FindDupsUsingIterator {
    public static void main(String[] args) {
        Set<String> s = new HashSet<String>();
		s.add("one");
		s.add("two");
		s.add("three");
		s.add("one");
		s.add("two");
		s.add("three");
		
		Iterator iter = s.iterator();
		System.out.println("The set size is " + s.size());
		while(iter.hasNext()){
			System.out.println("The element in set is " + iter.next());
		}
	}
}
