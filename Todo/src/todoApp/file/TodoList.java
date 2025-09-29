package todoApp.file;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TodoList {
	private final static Path path = Paths.get("task.txt");
	private List<String> todos;
	
	TodoList () throws IOException {
		if (!Files.exists(path)) {//파일이 존재하지 않을 경우
			Files.createFile(path);
		}
		try (Stream<String> lines = Files.lines(path)) {
			todos = lines.collect(Collectors.toList());
		} catch(IOException e) {
			System.out.println("파일을 읽어들이는데 실패했습니다. 프로그램을 종료합니다.");
			System.exit(1);
		}
	}
	
	void add(BufferedReader br) throws IOException { //할 일 추가하는 메소드
		System.out.print("지금 할 일 목록 : ");
		String task = br.readLine();
		if (task == null || task.isBlank()) {
			System.out.println("할 일을 다시 입력해주세요.");
		} else {
			todos.add(task);
			System.out.println("추가 완료");
		}
	}
	
	void list() throws IOException { //저장된 할일들은 출력함
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
	
	void delete(BufferedReader br) throws IOException { //지정된 번호의 할일을 삭제함
		System.out.print("삭제할 번호 : ");
		
		String delete = br.readLine(); 
		
		try {
			int deleteNumber = Integer.parseInt(delete);
		if (0 < deleteNumber && deleteNumber <= todos.size()) {//할일이 존재하는 번호 이내임
			todos.remove(deleteNumber - 1);
			System.out.println("삭제 완료");
		} else {
			System.out.println("잘못된 번호임. 번호 다시 확인");
		}
		} catch (NumberFormatException e) {
			if (delete == null || delete.isBlank()) {
				System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
			} else {
				if (todos.removeIf(todo -> todo.equals(delete))) {
					System.out.println("삭제 완료 : " + delete);
				} else {
					System.out.println("없는 할 일 목록임. 다시 입력해주세요");
				}
			}
		}
		
	}
	
	void allDelete() throws IOException {//모든 할 일을 삭제함
		todos.clear();
		System.out.println("삭제 완료");
	}
	
	void save() throws IOException {
		Files.write(path, todos, StandardCharsets.UTF_8);
	}
}
