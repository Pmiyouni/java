package day03;

import java.util.Scanner;

public class 수량연습 {

	public static void main(String[] args) {
		// 자판기 프로그램 
				Scanner sc = new Scanner(System.in);

				boolean run = true; // run 변수에 참값(true)을 대입
				int balance = 10000; // 잔액을 의미하는 변수이며 10000을 대입

				while (run) { //run이 true이므로 무한반복함
					System.out.println("======자판기========잔엑 :" + balance + "원");
					System.out.println("1.콜라(1000) 2.사이다(1200) 3.우유(1500) 4.충전 0.종료");
					System.out.print("메뉴선택");
					int menu = sc.nextInt(); //menu변수에 콘솔창에서 입력한 숫자를 menu에 대입			
					int su;
					
					switch (menu) {
					case 1:
						System.out.print("수량선택");
						su = sc.nextInt(); 
						System.out.println("콜라 선택=>"+su+"개");
						
						if (balance < (1000 * su)) { // 콜라 금액이 1000원이므로 잔액이 부족한지 조건을 지정
							System.out.println("잔액 부족!!");  // 콜라 금액보다 작으면 '잔액부족'이라고 출력
						} else {			// 아니면 (금액이 충분하면) 금액 만큼 빼기		
							balance = balance - (1000*su); // balance -=1000와 동일
//							System.out.println("잔액은 " + balance);
						}
						break;//case마다 존재, 없으면 하단 문장으로 내려가니 주의
					case 2:
						System.out.print("수량선택");
						su = sc.nextInt(); 
						System.out.println("사이다 선택=>"+su+"개");

						if (balance < (1200*su)) { // 사이다 금액이 1200원이므로 잔액이 부족한지 조건을 지정
							System.out.println("잔액 부족!!"); // 금액이 부족하면 잔액 부족 출력
						} else {					
							balance = balance - (1200* su); // 사이다 금액만큼 빼기
//							System.out.println("잔액은 " + balance);
						}
						break;
					case 3:
						System.out.print("수량선택");
						su = sc.nextInt(); 
						System.out.println("우유 선택=>"+su+"개");

						if (balance < (1500* su)) { // 우유 금액이 1500원이므로 잔액이 부족한지 조건을 지정
							System.out.println("잔액 부족!!"); // 금액이 부족하면 잔액 부족 출력
						} else {					
							balance = balance - (1500* su); // 우유 금액만큼 빼기
//							System.out.println("잔액은 " + balance);
						}
						break;
					case 4:	
						System.out.print("충전할 금액  >"); // 4일 경우 충전 금액인 숫자 입력 위해
						int inputMoney = sc.nextInt(); // 충전 할 금액을 콘솔창에서 받음 
						balance += inputMoney; //잔액 balance변수에 더함
						break;
					case 0:
						run = false; // while문을 탈출해야하는데 break를 또 사용하면 case break와 중복되므로 사용하지않고 false를 사용
						break; //case문 탈출
					default:
						System.out.println("입력 오류(0-4 범위)");
					}

					System.out.println();

				}
				System.out.println("프로그램 종료");
				
				
	}

}
