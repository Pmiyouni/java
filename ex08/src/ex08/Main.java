package ex08;

import java.text.*;
import java.util.*;



public class Main {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		AccountDAO adao = new AccountDAO();
		DetailDAO ddao = new DetailDAO();

		DecimalFormat df = new DecimalFormat("#,###원"); // 숫자 포맷
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 날짜시간 포맷
		// hh는 12시각제, HH는 24시각제

		boolean run = true;
		while (run) {
			System.out.println("\n\n **************** 계좌  관리 ******************");
			System.out.println("-----------------------------------------------------");
			System.out.println("1.계좌생성 | 2. 계좌조회 | 3. 입금 | 4. 출금 | 5. 계좌목록| 6. 계좌이체 | 0. 종료");
			// 목록은 검색과 페이징 기능 있어야 함
			System.out.println("-----------------------------------------------------");
			System.out.print("선택> ");
			String menu = s.nextLine();

			switch (menu) {
			case "0": // 종료
				run = false;
				System.out.println("프로그램 종료!!");
				break;
			case "1":  //계좌생성
				System.out.print("계좌주명>");
				String name = s.nextLine();
				if (name == "")
					break;

				AccountVO acc = new AccountVO();

				acc.setAname(name);
				int balance = input("초기입금금액");
				if (balance == 0)
					break;
				acc.setBalance(balance);

				System.out.print("새로운 계좌생성하실래요(y)?");
				String sel = s.nextLine();
				if (sel.equals("ㅛ") || sel.equals("y") || sel.equals("Y")) {
					int newano = adao.insert(acc);

					// 거래내역 저장
					DetailVO dvo = new DetailVO();
					dvo.setAno(newano);
					dvo.setAmount(balance);
					dvo.setType("입금");
					ddao.insert(dvo);
					System.out.println(newano + "번 새로운 계좌생성!");

				}
				break;
			case "2": // 조회
				while(true) {
					int ano = input("\n조회할 계좌번호");
					if(ano == 0 ) {
						System.out.println("조회를 종료합니다");
						break;
						
					} else {
						try {
							AccountVO vo = adao.read(ano);
							if(vo.getAname()== null) {
								System.out.println("해당 계좌가 존재하지 않습니다");
							}else {
								System.out.println("계좌주:"+vo.getAname());
								System.out.println("잔액:"+vo.getBalance());
								System.out.println("=============================");
								for(DetailVO vo2 : ddao.list(ano)) {
								System.out.printf("%d\t%-10s\t%s\t%s\n",vo2.getDno(),df.format(vo2.getAmount()),
										vo2.getType(), sdf.format(vo2.getDdate()));
								}
								}
								
							}catch(Exception e) {
								System.out.println("계좌조회오류"+e.toString());
						}
						
					}
				}
				
				break;
			case "3":  //입금
				int ano = input("\n입금할 계좌번호");
				if (ano == 0) {// 계속 조회하다가 0 누르면 조회 종료
					System.out.println("입금을 취소합니다");

				} else {
					try { // throws Exception으로 인해 try~catch 수행
						
						
						AccountVO acc1 = adao.read(ano); //계좌정보 조회 매서드 호출
						if (acc1.getAname() == null) {
							System.out.println("해당 계좌가 존재하지 않습니다");
						} else {
							System.out.println("계좌주명:" + acc1.getAname());
							System.out.println("현재잔액:" + df.format(acc1.getBalance()));
							int amount = input("입금 금액은"); 
							if (amount == 0) { //입금금액이 없으면 
								System.out.println("입금 취소");
							} else { // 입금금액이 숫자이면
								acc1.setBalance(acc1.getBalance() + amount); 
								  //입금금액을 잔액에 더하기
								adao.update(acc1); //잔액 변경 매소드
								
								DetailVO dvo = new DetailVO(); 
								dvo.setAno(ano);  //입금 계좌번호 
								dvo.setType("입금"); // 구분
								dvo.setAmount(amount); // 입금금액
								ddao.insert(dvo); // 거래내역테이블에 삽입저장
								System.out.println("입금 완료!");
							}
						}
					} catch (Exception e) {
						System.out.println("조회오류" + e.toString());
					}
				}

				break;
			case "4": //출금
				ano = input("\n출금할 계좌번호");
				if (ano == 0) {// 계속 조회하다가 0 누르면 조회 종료
					System.out.println("출금을 취소합니다");
				} else {
					try {
						AccountVO acc2 = adao.read(ano); //계좌정보 조회 매서드 호출
						if (acc2.getAname() == null) {
							System.out.println("해당 계좌가 존재하지 않습니다");
						} else {
							System.out.println("계좌주명:" + acc2.getAname());
							System.out.println("현재잔액:" + df.format(acc2.getBalance()));
							boolean repeat = true;
							int amount = 0;

							while (repeat) { // 출금금액이 잔액보다 크면 반복하기위해
								amount = input("출금 금액은");
								if (amount == 0) {
									System.out.println("출금 취소");
									repeat = false;
								} else {
									if (acc2.getBalance() < amount) {//잔액부족여부
										System.out.println("잔액이 부족합니다");
									} else {
										acc2.setBalance(acc2.getBalance()-amount);
										//출금금액을 잔액에 빼기
										adao.update(acc2);  //잔액 변경 매소드
										
										DetailVO dvo = new DetailVO();
										dvo.setAno(ano); //출금 계좌번호 
										dvo.setType("출금"); //구분
										dvo.setAmount(amount); //출금금액
										ddao.insert(dvo); // 거래내역테이블에 삽입저장
										System.out.println("출금 완료!");
										repeat = false;
									}
								}
							}
						}
					} catch (Exception e) {
						System.out.println("계좌조회오류" + e.toString());
					}
				}

				break;
			case "5":// 계좌목록 출력
				System.out.println("계좌번호\t  계좌주명\t   잔액\n");
				for (AccountVO vo2 : adao.list()) {// 전체를 출력위해 반복
					System.out.printf("%d\t%-10s\t%s\n", vo2.getAno(), vo2.getAname(), df.format(vo2.getBalance()));
				}
				break;
			case "6": //이체
				ano = input("\n출금할 계좌번호");
				int ano2 = input("\n입금할 계좌번호");
				if (ano == 0 | ano2 == 0) {
					System.out.println("이체를 취소합니다");
				} else {
					try {
						AccountVO acc2 = adao.read(ano); 
						AccountVO acc3 = adao.read(ano2);
						if (acc2.getAname() == null | acc3.getAname() == null ) {
							if( acc3.getAname() == null) {System.out.println("입금 계좌가 존재하지 않습니다");}
							    else {System.out.println("출금 계좌가 존재하지 않습니다");}
						} else {
							System.out.println("\n출금 계좌주명:" + acc2.getAname()+" ==> 입금 계좌주명:" + acc3.getAname());
							System.out.println("\n출금계좌 현재잔액:" + df.format(acc2.getBalance()));
							
							boolean repeat = true;
							int amount = 0;

							while (repeat) { // 출금금액이 잔액보다 크면 반복하기위해
								amount = input("이체 금액은");
								if (amount == 0) {
									System.out.println("이체 취소");
									repeat = false;
								} else {
									if (acc2.getBalance() < amount) {//잔액부족여부
										System.out.println("잔액이 부족합니다");
									} else {
										acc2.setBalance(acc2.getBalance()-amount);
										adao.update(acc2);  //잔액 변경 매소드
										
										DetailVO dvo = new DetailVO();
										dvo.setAno(ano); 
										dvo.setType("출금"); 
										dvo.setAmount(amount); 
										ddao.insert(dvo);  //등록 매서드
										//System.out.println("출금 완료!");
										
										
										acc3.setBalance(acc3.getBalance()+amount);
										adao.update(acc3);  //잔액 변경 매소드
																			
																			
										DetailVO dvo2 = new DetailVO(); 
										dvo2.setAno(ano2);  
										dvo2.setType("입금"); 
										dvo2.setAmount(amount);
										ddao.insert(dvo2);  //등록 매서드
										
										System.out.println("이체 완료!");
										repeat = false;
									}
								}
							}
						}
					} catch (Exception e) {
						System.out.println("이체오류" + e.toString());
					}
				}

				
				
				break;
			default:
				System.out.println("메뉴 다시 선택하세요!!");

			}// switch
		} // while
	}// main

	// 숫자인지 체크하는 매서드
	public static int input(String title) {
		Scanner s = new Scanner(System.in);

		while (true) {
			System.out.print(title + ">"); // 매개변수 받은 타이틀 출력 
			String str = s.nextLine(); //문자열로 입력받음
			try {
				if (str == "") // 입력 안했으면 0 리턴
					return 0;
				else
					return Integer.parseInt(str); // 문자를 숫자로 변환
			} catch (Exception e) {
				System.out.println("숫자를 입력하세요!");
			}
		}
	}
}// class
