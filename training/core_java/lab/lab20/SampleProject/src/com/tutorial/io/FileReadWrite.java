package com.tutorial.io;

import java.nio.file.*;
import java.io.*;
import java.nio.charset.*;
import java.nio.channels.*;
import java.nio.*;
import java.util.*;


public class FileReadWrite {

	public static void main(String args[]) throws Exception{
	
		//Reading a file
		Path outFilePath = Paths.get("fileoutput.txt");
		Path bufOutFilePath = Paths.get("buffileoutput.txt");
		Path unBufOutFilePath = Paths.get("unBuffileoutput.txt");
		Path byteChannelFilePath = Paths.get("byteChannelfileoutput.txt");
		
		
		
		String filePath = args[0];
		Path file = Paths.get(filePath);
		byte[] fileArray;
		fileArray = Files.readAllBytes(file);
		
		
		//Writing to a file
		try{
			Files.write(outFilePath,fileArray,StandardOpenOption.CREATE_NEW);
		} catch(Exception ex){
			System.out.println("Exception occured while writing to the file %s :" + ex.getMessage());
			ex.printStackTrace();
		}
		
		//Reading a file using buffer reader
		Charset charset = Charset.forName("US-ASCII");
		System.out.println("Reading a file using buffer reader ..");
		StringBuilder sbr = new StringBuilder();

		try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				sbr.append(line);
				System.out.println(line);
			}
		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		}		
		
		
		//Writing a file using buffer writer
		try (BufferedWriter writer = Files.newBufferedWriter(bufOutFilePath, charset)) {
			writer.write(sbr.toString(), 0, sbr.toString().length());
		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		}		
		
		//Reading a file using unbuffered stream
		try (InputStream in = Files.newInputStream(file);
			BufferedReader reader =
			  new BufferedReader(new InputStreamReader(in))) {
			String line = null;
			System.out.println("Reading a file using unbuffered stream");
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException x) {
			System.err.println(x);
		}		
		
		//Writing a file using unbuffered stream
		fileArray = Files.readAllBytes(file);
		try (OutputStream out = new BufferedOutputStream(
		  Files.newOutputStream(unBufOutFilePath, StandardOpenOption.CREATE, StandardOpenOption.APPEND))) {
		  out.write(fileArray, 0, fileArray.length);
		} catch (IOException x) {
		  System.err.println(x);
		}		
		
		//Reading using ByteChannel
		try (SeekableByteChannel sbc = Files.newByteChannel(file)) {
			ByteBuffer buf = ByteBuffer.allocate(10);

			// Read the bytes with the proper encoding for this platform.  If
			// you skip this step, you might see something that looks like
			// Chinese characters when you expect Latin-style characters.
			String encoding = System.getProperty("file.encoding");
			while (sbc.read(buf) > 0) {
				buf.rewind();
				System.out.print(Charset.forName(encoding).decode(buf));
				buf.flip();
			}
		} catch (IOException x) {
			System.out.println("caught exception: " + x);		
		}	
		
		String s = "Hello World! ";
		byte data[] = s.getBytes();
		ByteBuffer bb = ByteBuffer.wrap(data);
    		
		//Writing to a file using ByteChannel
		// Create the set of options for appending to the file.
		Set<OpenOption> options = new HashSet<OpenOption>();
		options.add(StandardOpenOption.APPEND);
		options.add(StandardOpenOption.CREATE);		
		try (SeekableByteChannel sbc =
		  Files.newByteChannel(byteChannelFilePath, options)) {
		  sbc.write(bb);
		} catch (IOException x) {
		  System.out.println("Exception thrown: " + x);
		}		
		
		
		//Creating Regular file
		Path newFile = Paths.get("newtxtfile.txt");
		try {
			// Create the empty file with default permissions, etc.
			Files.createFile(newFile);
		} catch (FileAlreadyExistsException x) {
			System.err.format("file named %s" +
				" already exists%n", file);
		} catch (IOException x) {
			// Some other sort of failure, such as permissions.
			System.err.format("createFile error: %s%n", x);
		}
		
		//Creating temproary files
		try {
			Path tempFile = Files.createTempFile(null, ".myapp");
			System.out.format("The temporary file" +
				" has been created: %s%n", tempFile)
		;
		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		}		
		
		
		
		
		
		
		
		
	}
}