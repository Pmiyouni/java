package day07;

import java.util.Scanner;

public class 복습4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	Scanner sc = new Scanner(System.in);
	String[] name = new String[10];
	String[] account = new String[10];
	int[] balance = new int[10];
	int cnt = 0;
	
	while(true) {
		System.out.println("=======은행=======");
		System.out.println("1.게좌생성 2. 입금 3. 출금 4.계좌목록 5. 계좌이체 0. 종료");
		System.out.print("메뉴 선택>  ");
		int menu =sc.nextInt();
	    boolean k = false;
		
		if(menu == 1) {
			System.out.print("예금주 입력>");
			name[cnt] = sc.next();			
			System.out.print("계좌 입력>");
			account[cnt] = sc.next();			
			System.out.print("잔액 입력>");
			balance[cnt] = sc.nextInt();			
			cnt++;
			
		} else if(menu == 2) {
			System.out.print("계좌 입력>");
			String a = sc.next();	
			for(int i = 0; i<cnt ; i++) {
				if(a.equals(account[i])) {
					k = true;
					System.out.print("입금 금액 입력>");
					int b = sc.nextInt();
					balance[i] += b;
					System.out.printf("입금 완료 잔액은 => %d",balance[i] );
				} 
			}
				if(!k) {
					System.out.println("계좌번호 불일치");
				}					
				
			
			
			
		} else if(menu == 3) {
			System.out.print("계좌 입력>");
			String a = sc.next();	
			for(int i = 0; i<cnt ; i++) {
				if(a.equals(account[i])) {
					k = true;
					System.out.print("출금 금액 입력>");
					int b = sc.nextInt();
					if(b <= balance[i]) {
						balance[i] -= b;
						System.out.printf("출금 완료 잔액은 => %d",balance[i] );
						break;
					}	else {
						System.out.println("잔액 부족");
						
					} 
					
					}
				}  
				if(!k) {
					System.out.println("계좌번호 불일치");
				}					
				
				
			
			
		} else if (menu == 4) {
			System.out.println("=======계좌목록=======");
			for(int i=0; i<cnt; i++) {		
			System.out.printf("%s\t %s\t %d\t\n ", name[i], account[i], balance[i]);
			}
				
		}else if (menu == 5) {
			int ii =- 1;
			int jj = -1;
			System.out.print("출금 계좌 입력");
			String o = sc.next();
			System.out.print("입금 계좌 입력");
			String n = sc.next();
			System.out.print("이체 금액 입력");
			int m = sc.nextInt();
			for(int i =0; i<cnt; i++) {
				if(o.equals(account[i])) {
					ii = i;
						
				} 
			
				if(n.equals(account[i])) {
					 jj = i;
					
								} 
				}
			if(jj  ==  -1) {
				System.out.println("출금계좌 없음");
			} else if( ii == -1) {
				System.out.println("입금계좌 없음");
			} else {			
			if( balance[jj]>=m) {
				balance[ii] -= m;
				balance[jj] += m;
				System.out.printf("출금계좌 %s 입금예좌 %s  금액%,d\n",o,n,m);
			}	else {
				System.out.println("잔액 부족");
		}
		
			}
    	} else if(menu == 0) {
			break;
		}else {
			System.out.println("다시 입력");
		}
		System.out.println();
	}
	System.out.println("프로그램 종료");
	}

}
