package ex10;

import java.text.*;
import java.util.*;

public class Student {
	public static void run() {

		Scanner s = new Scanner(System.in);
		boolean run = true;
		StudentDAO sdao = new StudentDAO();
		EnrolDAO edao = new EnrolDAO();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		  // import java.util

		while (run) {
			System.out.println("\n\n************* 학생관리 ***************");
			System.out.println("----------------------------------------");
			System.out.println("1.학생목록|2.학생조회|3.학생등록|0.메인메뉴");
			System.out.println("----------------------------------------");
			System.out.print("선택>");
			String menu = s.nextLine();

			switch (menu) {
			case "0":
				run = false;
				System.out.println("메인메뉴로 돌아갑니다!");
				break;
			case "1": 
				List<StudentVO> array = sdao.list(); // array.list()를 이렇게 2줄로 처리해도 됨
				for (StudentVO vo : array) {
					System.out.printf("%s\t%s\t%s\n", vo.getScode(), vo.getSname(), vo.getDept());
				}
				System.out.println(array.size() + "명 등록되었습니다");
				break;
				
			case "2": //학생조회
				while (true) {
					System.out.print("\n조회할 학번>");
					String scode = s.nextLine();
					if (scode == "") {
						System.out.println("조회를 취소합니다");
						break;
					} else {
						StudentVO vo = sdao.read(scode);// DAO의 읽어오는 매서드 실행하여 결과를 vo에 넣음
						
						if(vo.getSname() == null) {
							System.out.println("학생이 존재하지 않습니다");
						}else {
							System.out.println("학생이름:"+ vo.getSname());
							System.out.println("학생학과:"+ vo.getDept());
							System.out.println("------------------------------");
							
							//< 수강 신청한 강좌목록>
							
							List<EnrolVO> carry = edao.clist(scode); 
							//학번을 받아서 EnrolDAO의 목록 매서드 호출하여 리스트를 받아 carry에 넣음
							
							if(carry.size() == 0) { // list의 값이 하나도 없으면 종료
							System.out.println("수강 신청내역 없음");
							}else {
								for(EnrolVO v : carry) {
									System.out.printf("%s\t %s\t %d\t %s\n", v.getCcode(), v.getCname(), 
											v.getGrade(),sdf.format(v.getEdate()));
								}
							}
						}
					}
				}
				break;
			case "3":
				StudentVO vo = new StudentVO(); // VO 객체 생성
				vo.setScode(sdao.getCode());
				System.out.println("학번>" + sdao.getCode());// 동시에 하지 않으면 max 값으로 새학번 구함
			                                             	// 또는 동시에 할 경우는 시퀀스 사용
				System.out.print("이름>");
				String sname = s.nextLine();
				if (sname == "") {
					System.out.println("등록을 취소합니다");
				} else {
					System.out.print("학과>");
					String dept = s.nextLine();
					if (dept == "") {
						System.out.println("등록을 취소합니다");
					} else {
						vo.setSname(sname);
						vo.setDept(dept);
						sdao.insert(vo);
						System.out.println("새로운 학생이 등록되었습니다");
					}
				}
				
				break;
			default:
				System.out.println("메뉴를 다시 선택하세요");

			}// switch
		} // while
	}// main
}// class
