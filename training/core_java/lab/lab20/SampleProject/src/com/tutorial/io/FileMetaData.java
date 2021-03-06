package com.tutorial.io;

import java.nio.file.*;
import java.nio.file.attribute.*;
import java.io.*;

public class FileMetaData{

	public static void main(String args[]) throws Exception{
		String fileName = args[0];
		Path file = Paths.get(fileName);
		
		//#####################
		// Basic File attribute
		//#####################

		BasicFileAttributes attr = Files.readAttributes(file, BasicFileAttributes.class);

		System.out.println("creationTime: " + attr.creationTime());
		System.out.println("lastAccessTime: " + attr.lastAccessTime());
		System.out.println("lastModifiedTime: " + attr.lastModifiedTime());

		System.out.println("isDirectory: " + attr.isDirectory());
		System.out.println("isOther: " + attr.isOther());
		System.out.println("isRegularFile: " + attr.isRegularFile());
		System.out.println("isSymbolicLink: " + attr.isSymbolicLink());
		System.out.println("size: " + attr.size());	

		//Updating the time stamp
		long currentTime = System.currentTimeMillis();
		FileTime ft = FileTime.fromMillis(currentTime);
		Files.setLastModifiedTime(file, ft);
		
		//#####################
		// Basic File attribute
		//#####################
		System.out.println("############### DOS file attributes #####################");
		try {
			DosFileAttributes attr2 =
				Files.readAttributes(file, DosFileAttributes.class);
			System.out.println("isReadOnly is " + attr2.isReadOnly());
			System.out.println("isHidden is " + attr2.isHidden());
			System.out.println("isArchive is " + attr2.isArchive());
			System.out.println("isSystem is " + attr2.isSystem());
		} catch (UnsupportedOperationException x) {
			System.err.println("DOS file" +
				" attributes not supported:" + x);
		}
		
		//#####################
		// POSIX File attribute
		//#####################
		try {
			PosixFileAttributes attr3 =
				Files.readAttributes(file, PosixFileAttributes.class);
			System.out.format("%s %s %s%n",
				attr3.owner().getName(),
				attr3.group().getName(),
				PosixFilePermissions.toString(attr3.permissions()));		
		} catch (UnsupportedOperationException x) {
			System.err.println("POSIX file" +
				" attributes not supported:" + x);
		}
		
		//#####################
		// Determining MIME Type
		//#####################
		try {
			String type = Files.probeContentType(file);
			System.out.format("The mimetype of %s is %s%n",file,type);
			if (type == null) {
				System.err.format("'%s' has an" + " unknown filetype.%n", file);
			} else if (!type.equals("text/plain")) {
				System.err.format("'%s' is not" + " a plain text file.%n", file);
				//continue;
			}
		} catch (IOException x) {
			System.err.println(x);
		}		
		
		//#####################
		// Default file system
		//#####################
		PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.*");
		System.out.format("The default file system is %s%n",matcher);
		
		//#####################
		// Path string separator
		//#####################
		String separator = FileSystems.getDefault().getSeparator();
		System.out.format("The path string separator is %s%n", separator);
		
		//#####################
		// File System's File Stores
		//#####################
		for (FileStore store: FileSystems.getDefault().getFileStores()) {
		   System.out.format("The filestore name is %s%n",store.name());
		   System.out.format("The filestore total space is %s%n",store.getTotalSpace());
		}		
		
		
		
		}

}