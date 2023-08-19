package day07;

import java.util.Scanner;

public class Ex01_login_account {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		String[] name = new String[10]; //회원이름 10개 배열 선언
		String[] id = new String[10]; // 아이디 10개 배열 선언
		String[] pw = new String[10]; // 비밀번호 10개 배열 선언
		String[] account = new String[10]; // 계좌번호 10개 배열 선언
		int[] balance = new int[10]; //잔액 10개 배열 선언
		int cnt = 0;   // 입력시 배열 칸수를 저장하는 변수
		int logi = -1;  
		    // 배열에서 해당 index을 저장하는 변수로 배열은 0부터 시작하므로 구분을 위해 -1로 초기값 설정

		while (true) { // 반복
		
			System.out.println("=======스마트뱅킹=======");
			if(logi == -1) { 
			System.out.println("1.회원가입 2 로그인 3.회원목록  0. 종료");
			      // 값이 -1이면 보여주는 메뉴(로그인시)
			} else {
			System.out.println("1. 마이페이지 2. 로그아웃 3. 입금  4. 출금 5.계좌이체  0.종료");
			      // 값이 -1이 아니면 보여주는 메뉴(비로그인시)
			}
			System.out.print("메뉴선택>  ");
			int menu = sc.nextInt(); // 메뉴 입력 받음
			
			if (menu == 1) { // 회원가입 또는 마이페이지
				if (logi != -1) { // -1이 아니면 이미 로그인을 한 상태이므로 
					// 마이페이지 
					System.out.println("==========회원 목록===========");
					System.out.printf(" 이름  아이디  비밀번호  계좌번호\n");
					System.out.printf("%s\t%s\t%s\t%s\n", name[logi], id[logi], pw[logi], account[logi]);
						// 해당 index의 이름, 아이디, 비밀번호, 계좌번호 출력
				} else {
					System.out.print("이름 입력>");
					name[cnt] = sc.next();
					System.out.print("아이디 입력>");
					id[cnt] = sc.next(); 
					System.out.print("비밀번호 입력>");
					pw[cnt] = sc.next();
					System.out.print("계좌번호 입력>");
					account[cnt] = sc.next();
					System.out.println(name[cnt]+"님의 회원 가입을 축하드립니다");
					cnt++;  // 입력할때 마다 1씩 증가
				}

			} else if (menu == 2) { // 로그인 또는 로그아웃

				if (logi != -1) {
					// 로그아웃
					System.out.println("로그아웃 성공");
					logi = -1; // 로그인 메뉴로 변경 위해					
				} else {
					// 로그인
					System.out.print("로그인할 아이디 입력>");
					String a = sc.next(); //입력 받은 아이디 저장
					System.out.print("로그인할 비밀번호 입력>");
					String b = sc.next(); // 입력받은 비밀번호 저장
					boolean find = false; // 오류 체크 할 변수에 초기값 설정
					
					for (int i = 0; i < cnt; i++) {
						if (a.equals(id[i]) && b.equals(pw[i])) {
							System.out.println("로그인 성공");
							logi = i; // 로그인 성공한 index를 기억하기 위해 저장
							find = true; //로그인 성공 후 값 변경
							break; // 로그인 성공 후 탈출
						}
					}
					if (find == false) { // 초기값이 그대로 이면 로그인을 못한것이므로
						System.out.println("로그인 실패");
					}
				}

			} else if (menu == 3) { //회원목록 또는 입금
				if (logi != -1) { // -1 값이 아니면 로그인을 하여 index 값이 저장된상태임
					// 입금
					System.out.print("입금금액  입력>");
					//int mo = sc.nextInt();
					//balance[logi] += mo;
					balance[logi] += sc.nextInt();
					System.out.printf("입금 성공!!  계좌는 %s   잔액은 %,d", account[logi],balance[logi]);
				} else {
					// 회원 목록
					System.out.println("==========회원 목록==========");
					System.out.printf(" 이름\t아이디\t비밀번호\t계좌번호\t잔액");
					System.out.println("==========================");
					for (int i = 0; i < cnt; i++) { //배열 저장갯수(cnt) 만큼 반복하여 출력
						System.out.printf("%s\t%s\t%s\t%s\t%d\n", name[i], id[i], pw[i], account[i], balance[i]);
					}
				}

			} else if (menu == 4 && logi != -1 ) { // 메뉴선택이 4이고 로그인 성공 이후인지 물어봄
				//출금
				System.out.print("출금금액 입력>");
				int mo = sc.nextInt(); // 출금 금액 입력 받음
				System.out.print("비밀번호 입력>");
				String pp = sc.next(); // 비밀번호 입력 받음
				if(pp.equals(pw[logi])) {  // 입력 받은 비밀번호와 해당 배열 index의 비밀번호가 같은지?
					if(balance[logi] >= mo) {  // 잔액이 출금금액보다 큰거나 같은지?
				     balance[logi]-= mo; // 출금
				     System.out.printf("출금 성공!! 계좌는 %s   잔액은 %,d\n", account[logi],balance[logi]);
					} else {
						System.out.println("한도 초과");
					}
				} else {
					System.out.println("비밀번호가 틀렸습니다");
				}
				
			} else if (menu == 5 && logi != -1) {// 메뉴선택이 5이고 로그인 성공 이후인지 물어봄
				// 계좌 이체	
				System.out.print("이체 계좌 입력>");
				String aa = sc.next();  // 이체 금액 입력 받음
				System.out.print("이체 금액 입력>");
				int mm = sc.nextInt();  // 이체 금액 입력 받음
				System.out.print("비밀번호 입력>"); 
				String ss = sc.next();   // 비밀번호 입력 받음
				boolean find = false;
				
				if(ss.equals(pw[logi])) {  // 이체위해 받은 비밀번호와 해당 배열 index의 비밀번호가 같은지? 
					for (int i = 0; i < cnt; i++) {
						if (aa.equals(account[i])) {  //계좌가 일치하는지?
							find = true;
							if (balance[logi]>=mm) {// 잔액이 이체금액보다 큰거나 같은지? 
								balance[logi] -= mm; // 해당 잔액에서 이체금액 만큼 차감					
								balance[i] += mm;    // 계좌번호가 일치하는 이체금액 만큼 더함  
								System.out.printf("이체금액 %,d 완료", mm);
							} else {
								System.out.println("한도 초과");
							}
							break;
							}
						}
					} else {
						System.out.println("비밀번호가 틀렸습니다");
						find = true;
					}
				
				if (find == false) { // 위에서 계좌가 값으면 값을 true로 변경
						System.out.println("잘못된 계좌정보입니다");
					}
			}  else if (menu == 0) { //종료 선택시
				break;

			} else { // 메뉴선택이 잘못 입력시
				System.out.println("다시 입력");
			}
			System.out.println();
		}
		System.out.println("스마트뱅킹 종료");
	}
}
