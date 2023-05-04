package com.learnquest.demoapps;

import static java.lang.System.out;  // Shortens the line on the slide

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.Reader;

public class PrintWithLineNumbers {

	public static void main(String[] args) {
		System.out.printf("Current working directory: %s%n", System.getProperty("user.dir"));
		
		try (InputStream inFile = new FileInputStream("src/com/learnquest/demos/HelloWorld.java");
			 Reader inStreamReader = new InputStreamReader(inFile);
			 LineNumberReader lineReader = new LineNumberReader(inStreamReader))
		{
//			Pre-Java 8:
//			String outputLine = null;
//			while ((outputLine = lineReader.readLine()) != null) {
//				System.out.printf("%d: %s%n", lineReader.getLineNumber(), outputLine);
//			}
			
			lineReader.lines().forEach(line -> out.printf("%d: %s%n", lineReader.getLineNumber(), line));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
