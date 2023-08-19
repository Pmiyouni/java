package day04;

import java.util.Scanner;

public class Ex01_drink {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		int balance =10000;
		
		while(run) {
			System.out.printf("============자판기========  잔액은[%,d]\n", balance);
			System.out.println("1. 콜라(1000) 2. 사이다(1200)  3. 우유(1500) 4.충전 0.종료");
			System.out.println("메뉴선택");
			int menu = sc.nextInt();
			
			if(menu == 1) {
				System.out.println("콜라 선택");
				if(balance < 1000) {
					System.out.println("잔액 부족!!");
			} else {
					balance -=1000;
				}
			} else if(menu == 2){
				System.out.println("사이다선택");
				if(balance < 1200) {
					System.out.println("잔액 부족!!");
				} else {
					balance -=1200;
				}
			} else if(menu == 3){
				System.out.println("우유 선택");
				if(balance < 1500) {
					System.out.println("잔액 부족!!");
				} else {
					balance -=1500;
				}
			} else if(menu == 4) {
				System.out.print("충전 금액>>>");
				int inMoney =sc.nextInt();
				balance += inMoney;
			}
			else if(menu == 0){
					run = false;
			} else {
				System.out.println("다시 선택");
			}
			System.out.println();

		}//whil문 중괄호 닫기
		
		System.out.println("종료"); //while 끝나고 나서 수행
	}

}
