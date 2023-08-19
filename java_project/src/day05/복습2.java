package day05;

import java.util.Scanner;

public class 복습2 {

	public static void main(String[] args) {
	  
		
		Scanner sc = new Scanner(System.in);
		int b = 10000;
		
		while(true) {
			System.out.printf("=========자판기=========   잔액은 %,d원\n",b);
			System.out.println("1. 콜라(1000) 2. 사이다(1200)   3. 우유(1500)  4. 충전   0. 종료");
			System.out.print("메뉴를 선택하세요==>   ");
			int a = sc.nextInt();
			
		   
			
		if(a == 1) {
			System.out.println("콜라 선택");
			System.out.print("원하는 개수는?   ");
			int c = sc.nextInt();
			if( b < 1000 *c) {
				System.out.println("잔액 부족");
			} else {
				b = b - (1000 * c);
			}
			
		} else if(a == 2) {
			System.out.println("사이다 선택");
			System.out.print("원하는 개수는?   ");
			int c = sc.nextInt();
			if( b < 1200 * c) {
				System.out.println("잔액 부족");
			} else {
				b = b - (1200 * c);
			}
			
		} else if(a == 3) {
			System.out.println("우유 선택");
			System.out.print("원하는 개수는?   ");
			int c = sc.nextInt();
			if( b < 1500 * c) {
				System.out.println("잔액 부족");
			} else {
				b = b - (1500 * c);
			}
		} else if(a == 4 ) {
			System.out.print("충전 금액>>>");
			int m = sc.nextInt();
				b = b + m;
			
		} else if(a == 0) {
			break;
		} else {
			System.out.println("메뉴선택 오류(1-4까지 입력하세요)");
			
		}
		System.out.println();
		
		}
		
		System.out.println("프로그램 종료");
		
		
		
		
		
		
		
		

	}

}
