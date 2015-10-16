package com.tutorial.io;
import java.nio.charset.*;
import java.nio.channels.*;
import java.nio.*;
import java.util.*;
import java.nio.file.*;
import java.io.*;
import static java.nio.file.StandardOpenOption.*;

public class WorkingWithDirectories{

	public static void main(String args[]){
	
		//Get the root directories.
		Iterable<Path> dirs = FileSystems.getDefault().getRootDirectories();
		for (Path name: dirs) {
			System.err.println(name);
		}
	
		//Creating a directory
		Path dir = Paths.get("testdir");
		try{
			Files.createDirectory(dir);	
		} catch(Exception ex){
			ex.printStackTrace();
		}

		//Creating a temproary directory
		System.out.println("Creating a temproary directory #####################################");
		
		Path tempDirPath = Paths.get(".");
		try{
			Files.createTempDirectory(tempDirPath, "txt");
		} catch(Exception ex){
			ex.printStackTrace();
		}
		
		//Listing a directory content
		System.out.println("Listing a directory content #####################################");
		Path dir2 = Paths.get("C:/Users/nasiruddin.shaikh/git/TechnicalDocs/training/core_java/lab/lab19");
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir2)) {
			for (Path file: stream) {
				System.out.println(file.getFileName());
			}
		} catch (IOException | DirectoryIteratorException x) {
			// IOException can never be thrown by the iteration.
			// In this snippet, it can only be thrown by newDirectoryStream.
			System.err.println(x);
		}		
		
		//Filter the directory to list certain types of files only
		System.out.println("Filter the directory to list certain types of files only #####################################");
		try (DirectoryStream<Path> stream =
			 Files.newDirectoryStream(dir2, "*.{txt,java}")) {
			for (Path entry: stream) {
				System.out.println(entry.getFileName());
			}
		} catch (IOException x) {
			// IOException can never be thrown by the iteration.
			// In this snippet, it can // only be thrown by newDirectoryStream.
			System.err.println(x);
		}		
		
		//Creating symbolic link
		Path newLink = Paths.get("D:/testsymlink");
		Path target = Paths.get("xanadu.txt");
		try {
			Files.createSymbolicLink(newLink, target);
		} catch (IOException x) {
			System.err.println(x);
		} catch (UnsupportedOperationException x) {
			// Some file systems do not support symbolic links.
			System.err.println("Not supported: " + x);
		}		
		
		
		
	}
}