package todoApp.file;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;

public class TodoList {
	private static Path path = Paths.get("task.txt");
	List<String> todos;
	
	TodoList () throws IOException {
		if (!Files.exists(path)) {//파일이 존재하지 않을 경우
			Files.createFile(path);
		}
		todos = Files.lines(path).collect(Collectors.toList());
	}
	
	void add(BufferedReader br) throws IOException {
		System.out.print("지금 할 일 목록 : ");
		String task = br.readLine();
		
		todos.add(task);
		System.out.println("추가 완료");
	}
	
	void list() throws IOException {
		int size = todos.size();
		if (size > 0) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < size; i++) {
				sb.append(i + 1).append(" : ").append(todos.get(i)).append("\n");
			}
			System.out.print(sb);
		} else {
			System.out.println("할 일 없음");
		}
	}
	
	void delete(BufferedReader br) throws IOException {
		System.out.print("삭제할 번호 : ");
		int deleteNumber = Integer.parseInt(br.readLine());
		if (0 < deleteNumber && deleteNumber <= todos.size()) {//할일이 존재하는 번호 이내임
			todos.remove(deleteNumber - 1);
			System.out.println("삭제 완료");
		} else {
			System.out.println("잘못된 번호임. 번호 다시 확인");
		}
	}
	
	void save() throws IOException {
		Files.write(path, todos, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
	}
}
