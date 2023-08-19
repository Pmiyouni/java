package day04;

import java.util.Scanner;

public class EX06_sum {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("======sum========= ");
			
			System.out.println("1.총합  2. 짝수의합  3. 홀수의 합  0. 종료");
			System.out.println("입력>");
			int menu = sc.nextInt();
			
					
			System.out.print("첫번째 입력>");
			int num1 = sc.nextInt();
			System.out.print("두번째 입력>");
			int num2 = sc.nextInt();
			

			int sum = 0;
			if (menu == 1) {
				for(int i = num1; i <= num2; i++) {
					sum += i;
				}
			} else if (menu == 2) {
				for (int i = num1; i <= num2; i++) {
					if (i % 2 == 0) {
						sum += i;
					}
				}
			} else if (menu == 3) {
				for (int i = num1; i <= num2; i++) {
					if (i % 2 != 0) {
						sum += i;
					}
				}

			} else if (menu == 0) {
				break;
			}
			System.out.println(sum);

		}

	}

}
