package ex09;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		UserDAO udao = new UserDAO();

		boolean run = true;
		while (run) {
			System.out.println("\n\n**************** 메인메뉴 *****************************");
			System.out.println("----------------------------------------------------------");
			System.out.println("1.사용자목록|2.사용자조회|3.사용자수정|4.사용자등록|5.사용자삭제|0.종료");
			System.out.println("6.메시지관리");
			System.out.println("----------------------------------------------------------");
			System.out.print("선택>");
			String menu = s.nextLine();
			switch (menu) {
			case "0": //종료
				run = false;
				System.out.println("프로그램을 종료합니다!");
				break;
			case "1": //목록
				for (UserVO vo : udao.list()) {
					// DAO의 list 매서드 리턴값인 리스트 값을 VO에 넣어서 반복하여 출력, 다음 데이터가 있는동안 반복
					System.out.printf("%s\t%s\t%d\t%s\n", vo.getId(), vo.getUname(), vo.getPoint(), vo.getPhone());
				}
				System.out.println(udao.list().size() + "명 등록되어있습니다");
				break;
			case "2": //조회
				System.out.print("조회할 id> ");
				String id = s.nextLine();
				if (id == "") {
					System.out.println("조회를 종료합니다");
					break;
				} else {
					UserVO uvo = udao.read(id);
					// UserVO 타입의 uvo 변수에 DAO의 read 매서드 호출 *매개변수는 입력한 아이디
					if (uvo.getUname() == null) {
						System.out.println("사용자가 존재하지 않습니다"); // null값이면 해당 정보 없음
					} else {
						System.out.println("사용자 이름:" + uvo.getUname()); // 조회결과 출력
						System.out.println("사용자 전화:" + uvo.getPhone());
						System.out.println ("사용자포인트:" + uvo.getPoint());
					}
				}
				break;
			case "3": //수정
				System.out.print("수정할 id> ");
				id = s.nextLine(); // 아이디 입력 받음
				if (id == "") {
					System.out.println("수정을 종료합니다");
				} else {
					UserVO uvo = udao.read(id);
					// read 매서드로 기존 저장된 데이터 불러옴
					if (uvo.getUname() == null) {
						System.out.println("사용자가 존재하지 않습니다");
					} else {
						System.out.print("이름:" + uvo.getUname() + ">");
						// read에서 읽어와서 이름 보여줌
						String uname = s.nextLine(); // 이름 입력
						if (uname != "")
							uvo.setUname(uname);
						// 이름이 비어있지 않으면 수정
						System.out.print("전화:" + uvo.getPhone() + ">");
						String phone = s.nextLine();
						if (phone != "")
							uvo.setUname(phone);
						System.out.println(uvo.toString()); // 출력으로 확인
						System.out.print("수정하실래요(Y)?");
						String sel = s.nextLine();
						if (sel.equals("y") || sel.equals("Y") || sel.equals("ㅛ")) {

							udao.update(uvo); // 수정된 VO 보내고 update 매서드 호출
							System.out.println("수정이 완료되었습니다");
						} else {
							System.out.println("수정이 취소되었습니다");
						}
					}
				}
				break;
			case "4": //등록
				System.out.print("등록할 id> ");
				id = s.nextLine(); // 아이디 입력 받음
				if (id == "") { // 아이디가 입력 안되면(엔터) 종료
					System.out.println("등록을 종료합니다");
				} else {
					UserVO uvo = udao.read(id); // 아이디를 보내 기본데이터를 읽어옴
					if (uvo.getUname() == null) { // 기존 이름이 없어야 새로 등록이 가능
						System.out.print("이름 > ");
						String sname = s.nextLine();
						if (sname == null) { // 이름은 필수 입력해야하므로 체크
							System.out.println("이름을 꼭 입력하세요!");
							break;
						} else {
							uvo.setId(id); // 아이디 입력받음
							uvo.setUname(sname); // 이름 입력받음
							System.out.print("전화>  ");
							String phone = s.nextLine();// 전화 입력받음
							uvo.setPhone(phone);
							System.out.println(uvo.toString());
							System.out.print("등록하실래요(Y)? ");
							String sel = s.nextLine();
							if (sel.equals("y") || sel.equals("Y") || sel.equals("ㅛ")) {
								udao.insert(uvo);
								System.out.println("등록이완료되었습니다.");
							} else {
								System.out.println("등록이취소되었습니다.");
							}
						} // 등록 처리 부분
						break;// 이름이 null값일때 break->break
					} else {
						System.out.println("사용중인 아이디입니다");
						// uvo.getUname() == null일때는 데이터가 존재함
					}
				} // id == "" 이아니었을때 부분
				break;
			case "5": //삭제
				System.out.print("삭제할ID>");
				id = s.nextLine(); // 아이디 입력받음
				if (id == "") {
					System.out.println("삭제를 취소합니다.");
				} else {
					UserVO uvo = udao.read(id);// 읽어옴
					if (uvo.getUname() == null) {
						System.out.println("사용자가 존재하지 않습니다.");
					} else {
						System.out.println("사용자이름:" + uvo.getUname());
						System.out.print("삭제하실래요(Y)? ");
						String sel = s.nextLine();
						if (sel.equals("Y") || sel.equals("y") || sel.equals("ㅛ")) {

							try { // 삭제시 오류 체크

								udao.delete(id); // 삭제 매서드 호출
								System.out.println("사용자가 삭제되었습니다.");

							} catch (Exception e) { // 오류시
								System.out.println("사용자 삭제를 실패했습니다.");
							}

						} else {
							System.out.println("삭제를 취소했습니다."); // y 아님
						}
					}
				}
				break;
			case "6": //메시지관리
				System.out.print("아이디>");
				id=s.nextLine(); //아이디 입력
				if(id=="") {
					System.out.println("메시지관리를 취소합니다.");
				}else {
					UserVO uvo=udao.read(id); //아이디 보내서 읽어오기
					if(uvo.getUname()==null) {
						System.out.println("사용자가 존재하지않습니다.");
					}else {
						Messages.run(uvo); // UserVO를 보내서 실행
						//Messages.java의 run(), private라서 클래스이름.메서드이름 호출
					}
				}
				break;
			default:
				System.out.println("메뉴를 다시 선택하세요");
				break;
			} // switch
		} // while
	}// main
} // class
