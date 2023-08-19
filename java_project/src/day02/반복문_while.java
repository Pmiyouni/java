package day02;

import java.util.Scanner;

public class 반복문_while {

	public static void main(String[] args) {
//	 for(변수 선언; 조건식; 증감값){
//		
//	}
		// for 문과 다르게 while문은 조건만 있음
//	 int a = 9;
//	 while(a > 10) {// 조건이 참일 경우 실행
//		 // while(true) : 무한루프로 실행
//		 System.out.println("반복");
//	 }

//	 int i = 1;
//	 while(i<=10) {//조건을 먼저 물어보고 참이면 실행
//		 System.out.println(i);
//		 i++;
// 	 }

//      숫자 입력을 반복하다가 0이 입력되면 반복 종료(break 사용)		
//		Scanner sc = new Scanner(System.in);
//		while (true) {// true이므로 무한반복
//			System.out.print("숫자 입력 >");
//			int num = sc.nextInt();		
//			if (num == 0) {
//				break;
//			}
//    }
//		System.out.println("반복 종료");

		
		
		// < 응용 문제 >
		// 반복해서 숫자를 입력받아 출력하는데
		// 3의 배수는 피즈, 5의 배수는 버즈, 3과 5의 배수는 피즈버즈, 아니면 입력숫자 출력
		// 0이 입력되면 반복 종료(break문 사용)
		Scanner sc = new Scanner(System.in);
		while (true) {// true이므로 무한반복
			System.out.print("숫자 입력 >");
			int num = sc.nextInt();

			if (num == 0) {
				break; // 0 입력 되면 if문 탈출
			} else if (num % 3 == 0 && num % 5 == 0) {// 3과 5의 배수냐?
				System.out.println("피즈버즈");
			} else if (num % 3 == 0) { // 3의 배수냐?
				System.out.println("피즈");
			} else if (num % 5 == 0) { // 5의 배수냐?
				System.out.println("버즈");
			} else {
				System.out.println(num);
			}
		}
			System.out.println("반복 종료");
		
		
		

	}

}
