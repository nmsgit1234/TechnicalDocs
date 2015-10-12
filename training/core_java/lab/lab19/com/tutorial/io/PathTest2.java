package com.tutorial.io;

import java.nio.file.*;
import java.io.*;
public class PathTest2{
	public static void main(String args[]){
		Path p1 = Paths.get("/home/logfile");
		// Result is file:///home/logfile
		System.out.format("%s%n", p1.toUri());	

		//To get absolute path
		Path p2 = Paths.get("xanadu.txt");
		// Result is file:///home/logfile
		System.out.format("%s%n", p2.toUri());	
		
		//Converting a path
		Path p3 = Paths.get("xanadu.txt");
		// Result is file:///home/logfile
		try {
			Path fp = p3.toRealPath();
			System.out.println("The real path is " + fp);
		} catch (NoSuchFileException x) {
			System.err.format("%s: no such" + " file or directory%n", p3);
			// Logic for case when file doesn't exist.
		} catch (IOException x) {
			System.err.format("%s%n", x);
			// Logic for other sort of file error.
		}		
		
		//Joining paths
		// Microsoft Windows
		Path p4 = Paths.get("C:\\home\\joe\\foo");
		// Result is C:\home\joe\foo\bar
		System.out.format("The joined path is %s%n", p4.resolve("bar"));
		
		//Creating path between 2 paths
		// Result is ../sally
		Path p1x = Paths.get("xanadu.txt");
		Path p2x = Paths.get("objecttest.txt");		
		Path p1x_to_p2x = p1x.relativize(p2x);
		System.out.format("The relative path of p1 to p2 is %s%n",p1x_to_p2x);
		// Result is ../joe
		Path p2x_to_p1x = p2x.relativize(p1x);
		System.out.format("The relative path of p2 to p1 is %s%n" , p2x_to_p1x);
		
		//Comparing 2 paths;
		//Path path = ...;
		//Path otherPath = ...;
		try{
			p1x = p1x.toRealPath();
			p2x = p2x.toRealPath();
			Path beginning = Paths.get("file");
			Path ending = Paths.get("xanadu.txt");
		if (p1x.equals(p2x)) {
			System.out.println("Both paths are equal");
		} else if (p1x.startsWith(beginning)) {
			// path begins with "/home"
			System.out.format("The path name starts with %s%n", beginning);
		} 		
		else if (p1x.endsWith(ending)) {
				System.out.format("The path name ends with %s%n", ending );
			}

		} catch(Exception ex){
		}


		}
}