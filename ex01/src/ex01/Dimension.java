package ex01;

import java.util.Scanner;

public class Dimension {
	public static void run() {
		String[] names = new String[22];
		String[] addresses = new String[22];

		Scanner s = new Scanner(System.in);
		int index = 0;
		boolean run = true;
		while (run) {
			System.out.println("=============================");
			System.out.println("1.주소등록 | 2. 주소목록  | 0.종료  ");
			System.out.println("=============================");
			System.out.print("메뉴선택>");
			String menu = s.nextLine();
			switch(menu) {
			case "0":
				System.out.println("프로그램 종료");
				run = false;
				break; //반드시 적어야 함
			case "1":
				System.out.print("이름 입력>");
				String name = s.nextLine(); // nextLine()는 space도 입력 가능
				names[index] = name;
				System.out.print("주소입력>");
				String address = s.nextLine();
				addresses[index] = address;
				index++;
				System.out.println(index + "명 입력 완료!");
				break;
			case "2":
				for(int i =0; i <index; i++) {
					System.out.printf("%d\t%s\t%s\n",i+1,names[i],addresses[i]);
				}
				break;				
			default:
				System.out.println("메뉴를 다시 선택");
			}
			
//			String a = s.nextLine();
//			String b = s.next();			
//			System.out.println(a);
//			System.out.println(b);
		}
	}
}
