package com.learnquest.demoapps;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileDemo {
	public static boolean contains(Path file, String text) {
		try {
			return Files.isRegularFile(file) && Files.lines(file).anyMatch(line -> line.contains(text));
		}
		catch (IOException e) {
			return false;
		}
	}

	public static void main(String[] args) throws IOException {
		PathMatcher javaFiles = FileSystems.getDefault().getPathMatcher("glob:**/*.java");
		Path cwd = Paths.get(System.getProperty("user.dir"));
		Stream<Path> javaPaths = Files.walk(cwd).filter(path -> javaFiles.matches(path));
		javaPaths.filter(path -> FileDemo.contains(path, "System")).forEach(System.out::println);
	}
}
