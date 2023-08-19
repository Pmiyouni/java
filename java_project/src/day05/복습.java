package day05;

import java.util.Scanner;

public class 복습 {

	public static void main(String[] args) {

		// 하나의 숫자를 입력받아 3배수, 5배수, 3과 5 배수, 둘다아님 출력
//		Scanner sc = new Scanner(System.in);
//		System.out.print("숫자입력>\t");
//		int num = sc.nextInt();
//
//		if (num % 3 == 0 && num % 5 == 0) {
//			System.out.println("3과 5의 배수");
//		} else if (num % 3 == 0) {
//			System.out.println("3의 배수");
//		} else if (num % 5 == 0) {
//			System.out.println("5의 배수");
//		} else {
//			System.out.println("둘다 아님");
//		}
		
		
		// 하나의 숫자를 입력 받아 1~입력받은 수까지의 합 출력
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자입력>\t");
		int num = sc.nextInt();
		
		int sum = 0;
		for(int i = 1; i<= num; i++) {
			sum += i;
		}
		System.out.printf("1부터 "+num+"까지의 합 츨력 : \t%d",sum);
		
		
		
		
		


	}

}
