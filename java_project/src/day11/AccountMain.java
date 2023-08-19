package day11;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
		Scanner sc = new Scanner(System.in);
		List<Account> list = new ArrayList<Account>();
		int fAccount =100;
		
		
		while(true) {
			System.out.println("1.계좌생성 2. 입금 3.출금 4.계좌목록 5. 계좌이체 0.종료");
			System.out.print("메뉴선택>");
			int menu =sc.nextInt();
			
			
			if(menu == 1) {
				Account a = new Account();  //객체 생성시 new 사용
				System.out.print("예금주>");
				a.setName(sc.next());
				System.out.print("계좌번호>");
				a.setAccount(sc.next());
				System.out.print("잔액>");
				a.setBalance(sc.nextInt());
				System.out.println("계좌생성");
				list.add(a); // list에 객체를 추가
							
				
			} else if(menu == 2) {
				boolean f = false;
				System.out.print("계좌번호 입력>");
				String ii = sc.next();
				System.out.print("입금금액 입력>");
				int inmoney = sc.nextInt();
			
				for(Account k : list) {   //Account 타입을 의미, k는 변수로 맘대로사용
					
					if(ii.equals(k.getAccount())) { // 계좌번호가 일치하는지 비교	
					k.deposit(inmoney); // 입금 매서드 호출
					System.out.println("입금성공");
					f= true;
					break;
				}
				}
					if(!f) {
					System.out.println("계좌오류");
				}										
				
			}else if(menu == 3) {
				boolean f = false;
				System.out.print("계좌번호 입력>");
				String ii = sc.next();
				System.out.print("출금금액 입력>");
				int outmoney = sc.nextInt();
				for(Account k : list) { // 오른쪽에서 왼쪽으로 넘겨줌(0부터 저장 자료 끝까지)
					if(ii.equals(k.getAccount())) {
						if(k.withdraW(outmoney)) { // 출금매서드 호출이후 리턴값이 true를 받으면 성공
							System.out.println("출금성공");
							f= true;
							break;
						}else { // 리턴값이 true가 아니면
							System.out.println("잔액 부족");
						}
					}					
				}
				if(!f) {
					System.out.println("계좌오류");
				}
				
			}else if(menu == 4) {
				System.out.println("=============계좌목록==============");
				System.out.println("이름\t 계좌번호\t 잔액\t 날짜\n");
				for(Account k : list) { // 0~끝까지 
				k.print();
				}	 					
					
			}else if(menu == 5) {
				System.out.print("출금계좌> ");
				String outAccount = sc.next();
				System.out.print("입금계좌> ");
				String inAccount = sc.next();
				System.out.print("이체금액> ");
				int sendMoney = sc.nextInt();
				
				int outIndex = -1;
				int inIndex = -1;
				for(int i=0; i<list.size(); i++) {
					if(outAccount.equals(list.get(i).getAccount())) {
						outIndex = i;
					}
					if(inAccount.equals(list.get(i).getAccount())) {
						inIndex = i;
					}
				}
				if(outIndex == -1) {
					System.out.println("출금계좌 없음");
				}else if(inIndex == -1) {
					System.out.println("입금계좌 없음");
				}else {
					if(list.get(outIndex).withdraW(sendMoney)) {
						list.get(inIndex).deposit(sendMoney);
						System.out.println("이체성공");
					}else {
						System.out.println("잔액부족");
					}
				}
			
//				for(Account k : list) {   //Account 타입을 의미, k는 변수로 맘대로사용
//					if(i1.equals(k.getAccount())) {
//						if(k.withdraW(im)) { // 출금매서드 호출이후 리턴값이 true를 받으면 성공
//							System.out.println("출금성공");
//							f= true;
//							break;
//						}else {
//							System.out.println("잔액 부족");
//						}						
//					}
//				}
//				if(!f) {
//					System.out.println("출금계좌오류");
//				    
//				}
//				for(Account k : list) {   //Account 타입을 의미, k는 변수로 맘대로사용
//					if(i2.equals(k.getAccount())) {
//						k.deposit(im); 
//						System.out.println("이체성공");
//							f= true;
//							break;
//					}
//				}
//				if(!f) {
//					System.out.println("입금계좌오류");
//				    
//				}
//					
					
			}else if(menu == 0) {
				break;
			}else {
				System.out.println("선택 오류");
				
			}
		System.out.println();
		}
		System.out.println("프로그램 종료");
		
		// 배열인 경우 for each  
		//Account[] aaa= new Account[100]; // 배열이름음 aaa
		//for( Account k : aaa){ //배열일 경우는 : 뒤에 배열이름 적음
		//System.out.println(k.getId()); // 만약 private 필드가 아니면  k.필드 로 작성 
		//배열의 위치를 알려주지 않아도 자동으로 0부터 끝까지 수행하므로 배열 위치를 나타내지 않음
		// }
		
	}

}

