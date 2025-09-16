package todoApp.List;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TodoApp {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TodoList todos = new TodoList();
		
		while (true) {
			System.out.print("1.추가 | 2.목룍 | 3.삭제 | 1, 2, 3이외의 숫자를 누르면 종료됨 : ");
			int choice = Integer.parseInt(br.readLine());
			
			switch(choice) {
			case 1 -> todos.add(br);
			case 2 -> todos.list();
			case 3 -> todos.delete(br);
			default -> {
				System.out.println("종료합니다.");
				return;
			}
			}
		}
		
	}
	
}