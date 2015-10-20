package com.tutorial.io;
import java.nio.charset.*;
import java.nio.channels.*;
import java.nio.*;
import java.util.*;
import java.nio.file.*;
import java.io.*;
import static java.nio.file.StandardOpenOption.*;

public class Links{

	public static void main(String args[]){
	
		//Creating symbolic link
		Path newLink = Paths.get("testsymlink");
		Path target = Paths.get("xanadu.txt");
		try {
			Files.createSymbolicLink(newLink, target);
		} catch (IOException x) {
			System.err.println(x);
		} catch (UnsupportedOperationException x) {
			// Some file systems do not support symbolic links.
			System.err.println("Not supported: " + x);
		}		
		
		//Creating a Hard link
		Path hardLink = Paths.get("testhardlink");
		Path target2 = Paths.get("C:/Users/nasiruddin.shaikh/git/TechnicalDocs/training/core_java/lab/lab19/xanadu.txt");
		try {
			Files.createLink(hardLink, target2);
		} catch (IOException x) {
			System.err.println(x);
		} catch (UnsupportedOperationException x) {
			// Some file systems do not
			// support adding an existing
			// file to a directory.
			System.err.println(x);
		}		
		
		//Detecting a symbolic link
		boolean isSymbolicLink = Files.isSymbolicLink(newLink);
		System.out.format("Is %s a symbolic link? : %s%n",newLink,isSymbolicLink );
		
		//Finding the target of a symbolic link
		try {
			System.out.format("Target of link" +
				" '%s' is '%s'%n", newLink,
				Files.readSymbolicLink(newLink));
		} catch (IOException x) {
			System.err.println(x);
		}		
		
	}
}