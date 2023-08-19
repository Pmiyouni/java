package day09;

import java.util.Scanner;

public class 복습2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
	Scanner sc = new Scanner(System.in);
	int balance = 10000;
	

	while(true) {
		System.out.println("==========자판기========잔액: "+balance);
		System.out.println("1.콜라 2.사이다 3. 우유 0.종료");
		System.out.print("메뉴 선택> ");
		int menu = sc.nextInt();
		
		if( menu == 1) {
			 if(balance >= 1000) {
				 System.out.println("콜라선택");
				 balance -= 1000;
			 } else {
				 System.out.println("잔액 부족");
			 }				 
		} else if( menu == 2) {
			 if(balance >= 1200) {
				 System.out.println("사이다선택");
				 balance -= 1200;
			 } else {
				 System.out.println("잔액 부족");
			 }				 
		} else	if( menu == 3) {
			 if(balance >= 1500) {
				 System.out.println("우유선택");
				 balance -= 1500;
			 } else {
				 System.out.println("잔액 부족");
			 }				 
		} else	if( menu == 0) {
			  {
				 break;
			 }				 
		}
				
	}
	System.out.println("프로그램 종료");
		
		
		
	}

}
