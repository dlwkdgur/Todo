package todoApp.List;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TodoList {
	private List<String> todos = new ArrayList<>();
	
	void add(BufferedReader br) throws IOException {	
		System.out.print("지금 할 일 목록 : ");
		String task = br.readLine();
		todos.add(task);
	}
	
	void list() {
		if (todos.isEmpty()) {
			System.out.println("할 일이 없음");
		} else {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < todos.size(); i++) {
				sb.append(i+1).append(" : ").append(todos.get(i)).append("\n");
			}
			System.out.print(sb);
		}
	}
	
	void delete(BufferedReader br) throws IOException {
		System.out.print("삭제할 번호 : ");
		int deleteNumber = Integer.parseInt(br.readLine()) - 1;
		if (0 <= deleteNumber && deleteNumber < todos.size()) {
			todos.remove(deleteNumber);
			System.out.println("삭제 완료");
		} else {
			System.out.println("잘못된 번호임. 번호 다시 확인");
		}
	}
}
