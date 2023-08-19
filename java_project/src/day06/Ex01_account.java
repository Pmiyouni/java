package day06;

import java.util.Scanner; 
//자바의 경우 java.util 패키지 안에 Scanner 클래스가 있으므로 다음과 같이 import 를 쓴 후 해당 클래스 경로를 호출하도록 한다

public class Ex01_account {

	public static void main(String[] args) {
		
		// 계좌관리 프로그램
		Scanner sc	 = new Scanner(System.in); // scanner 객체 생성, System.in은 사용자로부터 입력을 받기위한 입력스트림
		//Scanner 뿐만 아니라 다른 입력 방식들도 사용자로부터 입력을 받기 위해서는 System.in 이 들어간다
		String[] name = new String[10];    // 이름 문자열 배열 10개 선언
		String[] account = new String[10]; // 계좌번호 문자열 배열 10개 선언
		int[] balance = new int[10];       // 잔액 정수형 배열 10개 선언
		int cnt = 0;  // 배열 index를 0부터 시작하여 1씩 증가를 위해
		
		while(true) { //반복문
			System.out.println("============= 은 행 ============ ");
			System.out.println("1.계좌생성  2. 입금   3. 출금   0.종료" );
			System.out.print("선택>    ");
			int menu  = sc.nextInt(); //메뉴 선택
						
			if( menu == 1) {  // 계좌생성
				
				System.out.print("예금주 입력 >  ");  
				name[cnt] = sc.next();          // 예금주 입력
				System.out.print("계좌번호 입력 >  ");
				account[cnt] = sc.next();       // 계좌번호 입력 
				System.out.print("잔액 입력 >  ");
				balance[cnt] = sc.nextInt();    // 잔액 입력 
				cnt += 1;    // 입력시 마다 배열 index 하나씩  증가
						
			} else if(menu == 2) { //입금
				boolean k = true;  // boolean 변수는 기본값을 true 주고 입금시 값을 변경할 계획
				
				System.out.print("계좌번호 입력 >  ");
				String a = sc.next();   // 입금할 계좌번호 입력
				
				for(int i = 0; i< cnt ;i++) {  // 0부터 배열-1까지 반복
					
					if( a.equals(account[i])) { //입력 계좌번호와 배열의 계좌번호가 일치하는지 물어봄 
						k = false ;  // 계좌번호가 일치하면 k변수에 false를 대입
						System.out.print("입금 금액 입력 >  ");
						int b = sc.nextInt();  // b 변수에 입금금액 입력
						balance[i] += b;	  // 잔액의 해당 배열칸에 index에 입금
						System.out.printf("%,d원 임금 완료   잔액은  %,d\n",b, balance[i]); // 입금 금액 출력
					
						break;      //  입금 완료하고나서 더이상 반복 작업이 필요 없으므로 탈출  
						} 
					} // 반복문 종료
				
				if(k) { // boolean형 k 변수가 true이냐?
					System.out.println(" 입금 계좌번호 오류"); 
					//계좌번호가 일치하면 k에 false값을 주었으므로 아직 기본값인 true이면 계좌번호가 불일치하여 입금을 못한상태
						}
			
				
		  } else if(menu == 3) { // 출금
			  boolean k = true;  // boolean 변수는 기본값을 true 주고 출금시 값을 변경할 계획
			  
			    System.out.print("계좌번호 입력 >  ");
				String a = sc.next();  // 출금할 계좌번호 입력
			  
			for(int i = 0; i<= cnt ;i++) { // 0부터 배열-1까지 반복
				
				if( a.equals(account[i])) { //입력 계좌번호와 배열의 계좌번호가 일치하는지 물어봄 
					System.out.print("출글 금액 입력 >  ");
					int b = sc.nextInt();  // b 변수에 출금금액 입력
					     k = false; // 계좌번호가 일치하면 k변수에 false를 대입
					if(b <= balance[i]) {   // 입력한 출금금액이 일치하는 배열의 잔액보다 작지 않으면 출금이 가능함 
					
						balance[i] -= b; // 해당 배열의 잔액에서 입금금액을 뻼
						System.out.printf("%,d원 출금 완료   잔액은  %,d\n",b, balance[i]);
	
						break;    //  출금 완료하고나서 더이상 반복 작업이 필요 없으므로 탈출  
				
					} else {
						System.out.println("잔액 부족"); 
						   // 입력한 출금금액이 일치하는 배열의 잔액보다 작으면 잔액부족으로 출금 안됨
	
						break;      //  잔액부족으로 출금이  안되므로 더이상 반복 작업이 필요 없으므로 탈출 사용은 해사용
					}
				}
			}// for 반복문 종료
			if(k){  //boolean형 k 변수가 true이냐?
				//계좌번호가 일치하면 k에 false값을 주었으므로 아직 기본값인 true이면 계좌번호가 불일치하여 출금을 못한상태
				System.out.println(" 출금 계좌번호 오류");  
			}
			
		  } else if(menu==0)   	{ // 메뉴선택이 0 이면 종료
		       break; // while 문 탈출
		  } else   	{  // 메뉴선택이 잘못 입력되면 가능
		      System.out.println("메뉴선택 오류(0~3 선택)");
		  }
		}
		System.out.println("프로그램 종료");
	}
	}
