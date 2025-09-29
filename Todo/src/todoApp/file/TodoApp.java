package todoApp.file;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TodoApp {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TodoList todos = new TodoList();
		
		while (true) {
			int choice;
			while(true) {
				try {
					System.out.print("1.추가 | 2.목룍 | 3.삭제 | 33.전체 삭제 | 이외의 숫자를 누르면 종료됨 : ");
					choice = Integer.parseInt(br.readLine());
					break;
				} catch(NumberFormatException e) {
					System.out.println("잘못된 입력임, 숫자만 입력해야됨");
				}
			}
			
			
			switch(choice) {
			case 1 -> todos.add(br);
			case 2 -> todos.list();
			case 3 -> todos.delete(br);
			case 33 -> todos.allDelete();
			default -> {
				todos.save();
				System.out.println("종료합니다.");
				return;
			}
			}
		}
	}
}
