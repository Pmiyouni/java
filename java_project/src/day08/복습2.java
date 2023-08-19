package day08;

import java.util.Scanner;

public class 복습2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int b = 10000;
		System.out.printf("========자판기=======  잔액 %,d\n",b);
		System.out.println("1.콜라(1000) 2.사이다(1200) 3.우유(1500) 0.종료");
		System.out.print("메뉴선택>  ");		
		int menu = sc.nextInt();
		boolean run = true;
		
		while(run) {
		if(menu ==  1) {
			if(b >= 1000) {
				System.out.println("콜라 선택");
				b -= 1000;
				
			} else {
				System.out.println("잔액 부족");
			}			
			
		}
		else if(menu ==  2) {
			if(b >= 1200) {
				System.out.println("사이다 선택");
				b -= 1200;
				
			} else {
				System.out.println("잔액 부족");
			}			
			
		}

		else if(menu ==  3) {
			if(b >= 1500) {
				System.out.println("우유 선택");
				b -= 1500;
			
				
			} else {
				System.out.println("잔액 부족");
			}			
			
		}
		
		else if(menu ==  0) {
			break;
			}	else {
				System.out.println("선택 오류");
			}
			
		System.out.println();
			
		}
		System.out.println("프로그램 종료");
		
	}

}
