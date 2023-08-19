package ex10;

import java.text.*;
import java.util.*;

public class Course {
	public static void run() {
		Scanner s = new Scanner(System.in);
		boolean run = true;
		CourseDAO cdao = new CourseDAO();
		EnrolDAO edao = new EnrolDAO();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		while (run) {
			System.out.println("\n\n************* 강좌관리 **************");
			System.out.println("---------------------------------------");
			System.out.println("1.강좌목록|2.강좌조회|3.강좌등록|0.메인메뉴");
			System.out.println("---------------------------------------");
			System.out.print("선택>");
			String menu = s.nextLine();

			switch (menu) {
			case "0":
				run = false;
				System.out.println("메인메뉴로 돌아갑니다!");
				break;
				
			case "1":
				List<CourseVO> array = cdao.list(); // array.list()를 이렇게 2줄로 처리해도 됨
				for (CourseVO vo : array) {
					System.out.printf("%s\t%s\n", vo.getCcode(), vo.getCname());
				}
				System.out.println(array.size() + "과목 등록되었습니다");
				break;
				
			case "2":
				while (true) {
					System.out.print("\n조회할 강좌코드>");
					String ccode = s.nextLine();
					if (ccode == "") {
						System.out.println("조회를 취소합니다");
						break;
					} else {
						CourseVO vo = cdao.read(ccode);// DAO의 읽어오는 매서드 실행하여 결과를 vo에 넣음

						if (vo.getCname() == null) {
							System.out.println("강좌가 존재하지 않습니다");
						} else {
							System.out.println("강좌명:" + vo.getCname());
							System.out.println("---------------------");

							// 학생목록
							List<EnrolVO> sarry = edao.slist(ccode);
							// 과목코드를 보내서 EnrolDAO의 특정과목 학생목록을 리턴받아 리스트에 저장
							if (sarry.size() == 0) {
								System.out.println("수강 신청 학생이 없습니다");
							} else {
								for (EnrolVO v : sarry) {
									System.out.printf("%s\t %s\t %d\t %s\n", 
										v.getScode(), v.getSname(), v.getGrade(),
										sdf.format(v.getEdate()));
								}
							}
						}
					}
				}
				break;
				
			case "3":
				CourseVO vo = new CourseVO();
				vo.setCcode(cdao.getCode());
				System.out.println("강좌코드>" + cdao.getCode());
				     // 동시에 하지 않으면 max 값으로 새학번 구함
				     // 동시에 하려면 시퀀스 사용 
				System.out.print("강좌명>");
				String cname = s.nextLine();
				if (cname == "") {
					System.out.println("등록을 취소합니다");
				} else {
					vo.setCname(cname);
					cdao.insert(vo);
					System.out.println("새로운 강좌가 등록되었습니다");
				}
				break;

			default:
				System.out.println("메뉴를 다시 선택하세요");

			}// switch
		} // while
	}// main
}// class
