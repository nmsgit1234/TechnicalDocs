package com.tutorial.io;

import static java.nio.file.FileVisitResult.*;
import java.nio.charset.*;
import java.nio.channels.*;
import java.nio.*;
import java.util.*;
import java.nio.file.*;
import java.io.*;
import java.nio.file.attribute.*;

public class PrintFiles
    extends SimpleFileVisitor<Path> {

    // Print information about
    // each type of file.
    @Override
    public FileVisitResult visitFile(Path file,
                                   BasicFileAttributes attr) {
        if (attr.isSymbolicLink()) {
            System.out.format("Symbolic link: %s ", file);
        } else if (attr.isRegularFile()) {
            System.out.format("Regular file: %s ", file);
        } else {
            System.out.format("Other: %s ", file);
        }
        System.out.println("(" + attr.size() + "bytes)");
        return CONTINUE;
    }

    // Print each directory visited.
    @Override
    public FileVisitResult postVisitDirectory(Path dir,
                                          IOException exc) {
        System.out.format("Directory: %s%n", dir);
        return CONTINUE;
    }

    // If there is some error accessing
    // the file, let the user know.
    // If you don't override this method
    // and an error occurs, an IOException 
    // is thrown.
    @Override
    public FileVisitResult visitFileFailed(Path file,
                                       IOException exc) {
        System.err.println(exc);
        return CONTINUE;
    }
	
	public static void main(String args[]) throws Exception{
		Path startingDir = Paths.get("C:/Users/nasiruddin.shaikh/git/TechnicalDocs/training/core_java/lab/lab19");
		PrintFiles pf = new PrintFiles();
		Files.walkFileTree(startingDir, pf);	
	}
}