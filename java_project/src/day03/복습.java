package day03;

import java.util.Scanner;

public class 복습 {

	public static void main(String[] args) {

		// 입력 숫자를 양수, 음수, 0 출력
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자입력>");
		int num = sc.nextInt();

//		if( num  == 0 ) {
//			System.out.println("0");
//		} else if(num > 0){	
//			System.out.println("양수");		
//		} else if(num < 0) {
//			System.out.println("음수");
//		}	

		// 입력 숫자를 0이 아닌 짝수, 홀수, 0 출력
//		if (num == 0) {
//			System.out.println("0");
//		} else if (num % 2 == 0) {
//			System.out.println("0이 아닌 짝수");
//		} else if (num % 2 != 0) {
//			System.out.println("홀수");
//		}
		
		// 
		if(num % 3 == 0 && num % 7 == 0) {
			System.out.println("3과 7의 배수");			
		} else if(num % 3 == 0) {
			System.out.println("3의 배수");			
		} else if(num % 7 == 0) {
			System.out.println("7의 배수");			
		} else {
			System.out.println("둘다 아님");
		}

		
		

	}

}
