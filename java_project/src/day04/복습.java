package day04;

import java.util.Scanner;

public class 복습 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 입력");
		int number =sc.nextInt();
		
		// 입력 받은 수가 0이 아닌 짝수, 홀수, 0 출력
		if(number == 0) {
			System.out.println("0");
		} else if (number % 2 == 0) {
			System.out.println("0이 아닌 짝수");
		} else if (number % 2 != 0) {
			System.out.println("홀수");
	     }
		
		System.out.println();
		
		// 입력받은 수가 3의 배수, 5의 배수, 7의 배수, 둘다 아님
		if(number % 3 == 0 && number % 7 == 0) {
			System.out.println("3과 7의 배수");
       	} else if (number % 3 == 0) {
			System.out.println("3의 배수");
	     }  else if (number % 7 == 0) {
			System.out.println("7의 배수");
	     }  else  {
			System.out.println("둘다 아님");
	     }

		
			
}
}
