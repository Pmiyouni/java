package day05;

import java.util.Scanner;

public class EX02_account {

	public static void main(String[] args) {
	
		//계좌관리 프로그램
		Scanner sc = new Scanner(System.in); 
		String[] name = new String[10]; // 이름 저장 문자열형 변수
		String[] account = new String[10]; // 계좌번호 문자열형 변수
		int[] balance = new int[10];  // 잔액을 저장할 정수형 변수
		int cnt = 0;  // 배열의 개수를 알려 줄 변수
		
		while(true) {
			System.out.println("===========인천일보은행===========");
			System.out.println("1. 계좌생성 2. 입금  3. 출금 4. 계좌목록  0. 종료");
			System.out.print("메뉴선택>  "); 
			int menu = sc.nextInt(); // 메뉴선택을 위해 변수에 받음
			
			if(menu == 1) { //1. 계좌생성이냐?
				System.out.print("예금주 >  ");
				name[cnt] = sc.next();
				System.out.print("계좌번호 입력>  ");
				account[cnt] = sc.next();
				System.out.print("잔액은?  ");				
				balance[cnt] = sc.nextInt();
				cnt ++;  //계좌 생성할 때마다 cnt를 1씩 증가
	
				
			} else if(menu == 2) { //2. 입금이냐?
				System.out.print("입금 계좌는?   ");
				String a = sc.next();
				System.out.print("임금 금액은?   ");
				int b = sc.nextInt();
				boolean s = false; // boolean 변수로 true와 false로 변경하여 사용
				
				for( int i = 0; i < cnt ; i++) { //입력 받은 index 수 만큼 반복 
				if(a.equals(account[i])) { 
					//배열의 요소마다 저장한 값과 입금 받은 계좌가 맞는지 조건 작성
					balance[i] += b; //잔액에 입금 금액을 더함
					System.out.printf("%,d원 입금 완료 ",b);
					s = true;
					break;				
					} 
				 
				}	
				if( !s) {
					 System.out.println("입금 계좌 오류");
										
				 } 
				
			
			}	else if(menu == 3) { //3. 출금이냐?
			System.out.print("출금 계좌는?   ");
			String a = sc.next();
			System.out.print("츌금 금액은?   ");
			int b = sc.nextInt();
			boolean s = false;
			
			for(int i = 0; i<cnt ; i++) {
			if(a.equals(account[i])) {
				//배열의 요소마다 저장한 값과 입금 받은 계좌가 맞는지 조건 작성
				if(balance[i] < b) {
				 System.out.println(" 진액 부족");
				} else {
					balance[i] -= b;
					System.out.printf("%,d원 출금 완료 ",b);
					s = true;
					break;
				}
			}
			}
			if( !s) {
				 System.out.println("출금 계좌 오류");
			}
		
	
			} else 	if(menu == 4) { //4. 계좌목록이냐?
				System.out.println("예금주\t계좌번호\t잔액");
				System.out.println("=========================");
				for(int i=0; i<cnt; i++) {
					System.out.printf("%s\t%s\t%,d\n", name[i],account[i],balance[i]);
				}
				
	
			} else 	if(menu == 0) {
				break;
	
			} else {
				System.out.println("메뉴선택 오류");
			}
			System.out.println();
		}
		
			System.out.println("프로그램 종료");	
		}

}
