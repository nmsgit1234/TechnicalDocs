package com.tutorial.io;

import java.nio.file.*;
import java.io.*;
import java.nio.charset.*;
import java.nio.channels.*;
import java.nio.*;
import java.util.*;
import static java.nio.file.StandardOpenOption.*;
public class RandomAccessFileTest{

	public static void main(String args[]){
		String s = "I was here!\n";
		byte data[] = s.getBytes();
		ByteBuffer out = ByteBuffer.wrap(data);
		String filePath = "RandomAccessFileTest.txt";
		Path file = Paths.get(filePath);

		ByteBuffer copy = ByteBuffer.allocate(12);

		try (FileChannel fc = (FileChannel.open(file, READ, WRITE))) {
			// Read the first 12
			// bytes of the file.
			int nread;
			do {
				nread = fc.read(copy);
			} while (nread != -1 && copy.hasRemaining());

			// Write "I was here!" at the beginning of the file.
			fc.position(0);
			while (out.hasRemaining())
				fc.write(out);
			out.rewind();

			// Move to the end of the file.  Copy the first 12 bytes to
			// the end of the file.  Then write "I was here!" again.
			long length = fc.size();
			fc.position(length-1);
			copy.flip();
			while (copy.hasRemaining())
				fc.write(copy);
			while (out.hasRemaining())
				fc.write(out);
		} catch (IOException x) {
			System.out.println("I/O Exception: " + x);
		}
	}
}