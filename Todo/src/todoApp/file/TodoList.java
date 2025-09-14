package todoApp.file;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class TodoList {
	private static Path path = Paths.get("task");
	void add(BufferedReader br) throws IOException {
		String task = br.readLine();
		
		Files.writeString(path, task, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
	}
	
	void list() {
		
	}
	
	void delete(BufferedReader br) throws IOException {
		
	}
}
