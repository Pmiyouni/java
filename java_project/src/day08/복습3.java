package day08;

import java.util.Scanner;

public class 복습3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	 Scanner sc = new Scanner(System.in);
	 String[] name = new String[10];
	 String[] account = new String[10];
	 int[] balance = new int[10];
	 
	 while(true) {
		
		 System.out.println("=======은행 ========");
		 System.out.println("1.계좌생성 2. 입금 3. 출금 4. 계좌목록 0.종료");
		 System.out.print("메뉴 선택>");
 		 int menu = sc.nextInt();
 		 int cnt = 0;
		 
		 if(menu == 1) {
			 System.out.print("예금주 >");
			name[cnt] = sc.next();
			 System.out.print("계좌입력 >");
			account[cnt] = sc.next();			
			System.out.print("잔액 >");
			balance[cnt] = sc.nextInt();
			cnt++;
			 		 
		 }
		 else if(menu == 2) {
			 boolean k = false;
			System.out.print("임급 계좌 >");
			String a = sc.next();
			System.out.print("입금 금액 >");
			int b = sc.nextInt();
		for(int i=0; i <cnt; i++) {
				System.out.println(i);
				if(a.equals(account[i])) {
					balance[i] += b;
					k = true;
					System.out.printf("임금완료 %,d원",b);
					break;
				}
			}
			if(k == false ) {
				System.out.println("계좌오류");
			}
			 		 
		 }
		 
		 else if(menu == 3) {
			 boolean k = false;
				System.out.print("출금 계좌 >");
				String a = sc.next();
				System.out.print("출금 금액 >");
				int b = sc.nextInt();
				for(int i = 0; i<cnt ; i++) {
					if(a.equals(account[i])) {
						k= true;
						if( b <= balance[i])
						balance[i] -= b;						
						System.out.printf(" 출금완료 %,d원",b);
						break;
						
						
					} else {
						System.out.println("잔액 부족");
					}
				}
				if(!k) {
					System.out.println("계좌오류");
				}
				 		 
			 }
		 
		 else if(menu == 0) {
				break;
				 		 
			 }
		 System.out.println();
	 }
	 System.out.println("프로그램 종료");
		
	}

}
