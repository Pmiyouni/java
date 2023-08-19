package ex01;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {// 프로그램 시작 메서드
		//TypeSample.run();
		//Operation.run();
		//Condition.run();
		//Repeat.run();
		//Dimension.run();
		//Address.run(); 
		//Address1.run(); 
		
		Scanner s = new Scanner(System.in);
		
		boolean run = true;
		while (run) {
			System.out.println("============================================================");
			System.out.println("1.타입 | 2. 연산자 | 3. 조건문 | 4.배열 | 5. 주소관리| 0.종료");
			System.out.println("=============================================================");
			System.out.print("메뉴선택>");
			String menu = s.nextLine();
			switch (menu) {
			case "1":
				TypeSample.run();
				break;
			case "2":
				Operation.run();
				break;
			case "3":
				Condition.run();
				break;
			case "4":
				Dimension.run();
				break;
			case "5":
				Address1.run(); 
				break;
			case "0":
				break;
			
			}
			}
	}

}
