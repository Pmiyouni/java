package ex01;

import java.util.Scanner;

public class Repeat {
	public static void run() {
		// 반복문(while, for)
		Scanner s = new Scanner(System.in);
		boolean run = true;

		while (run) {
			System.out.println("=============================----=============");
			System.out.println("1.100까지합 |2. 100까지짝수합 |3. 100까지 홀수합| 0.종료");
			System.out.println("===================================-==========");
			System.out.print("선택>");
			String menu = s.nextLine(); // nextLine()는 String 이면서 enter 받을때까지
			int tot = 0;
			switch (menu) {
			case "0":
				System.out.println("프로그램 종료됩니다!");
				run = false;
				break;
			case "1":
				for (int i = 1; i <= 100; i++) {
					tot += i; // tot=tot+i;
				}
				System.out.println("1~100까지 합: " + tot);
				break;
			case "2":
				for (int i = 2; i <= 100; i += 2) {
					tot += i;
				}
				System.out.println("1~100까지 짝수합: " + tot);
				break;
			case "3":
				for (int i = 1; i < 100; i += 2) {
					tot += i;
				}
				System.out.println("1~100까지 홀수합: " + tot);
				break;
			default:
				System.out.println("메뉴 다시 선택");
			}
		}
	}
}
