package todoApp.List;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TodoApp {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<String> todos = new ArrayList<>();
		
		while (true) {
			System.out.print("1.추가 | 2.목룍 | 3.삭제 | 1, 2, 3이외의 숫자를 누르면 종료됨 : ");
			int choice = Integer.parseInt(br.readLine());
			
			if (choice == 1) {
				System.out.print("할 일 목록 : ");
				String task = br.readLine();
				todos.add(task);
			} else if (choice == 2) {
				for (int i = 0; i < todos.size(); i++) {
					System.out.println((i+1) + " : " + todos.get(i));
				}
			} else if (choice == 3) {
				System.out.print("삭제할 번호 : ");
				int index = (Integer.parseInt(br.readLine())) -1;
				
				if (0 <= index && index < todos.size()) {
					todos.remove(index);
				}
			} else {
				System.out.println("종료합니다.");
				return;
			}
		}
		
	}
	
}