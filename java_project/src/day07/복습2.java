package day07;

import java.util.Scanner;

public class 복습2 {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		int b = 10000;
		String[] product = new String[100];
		int cnt = 0;
		int c1 = 0;
		int c2 = 0;
		int c3 = 0;

		while(true) {
			System.out.printf("==========메뉴 선택=========잔액 :  %,d\n",b);
			System.out.println("1. 콜라(1000) 2. 사이다(1200)  3. 우유(1500)  4. 구매목록  0. 종료");
			System.out.print("메뉴 선택> ");
			int menu = sc.nextInt();
		
			
			if(menu == 1) {
				if( b < 1000) {
					System.out.println("잔액 부족");
				} else {
					System.out.println("콜라 선택");
					product[cnt++] = "콜라"; // 후치 증가, cnt 위치에 저장하고나서 1 증가
					b -= 1000;	
					c1++;
				}
				
			} else if(menu == 2) {
				if( b < 1200) {
					System.out.println("잔액 부족");
				} else {
					System.out.println("사이다 선택");
					product[cnt++] = "사이다";
					b -= 1200;
					c2++;
				}
			} else if(menu == 3) {
				if( b < 1500)  {
					System.out.println("잔액 부족");
				} else {
					System.out.println("우유 선택");
					product[cnt++] = "우유";
					b -= 1500;
					c3++;
				}
			}  else if(menu == 4) {
				System.out.println("=구매 목록= 수량");	 
					System.out.printf("콜라\t  %d 개 \n", c1);
					System.out.printf("사이다\t  %d 개 \n", c2);
					System.out.printf("유우\t  %d 개 \n", c3);
									
		}	else if(menu == 0) {
				break;
			} else  {
				System.out.println("메뉴선택 오류");
			}
		}
			System.out.println("프로그램 종료");
		
	}

}
