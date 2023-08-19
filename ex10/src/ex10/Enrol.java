package ex10;

import java.text.*;
import java.util.*;

public class Enrol {
	public static void run() {
		Scanner s = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:dd");

		boolean run = true;
		StudentDAO sdao = new StudentDAO();
		EnrolDAO edao = new EnrolDAO();
		CourseDAO cdao = new CourseDAO();
		while (run) {
			System.out.println("\n\n**************** 수강관리 *************************");
			System.out.println("-------------------------------------------------");
			System.out.println("1.수강목록|2.수강신청|3.수강취소|4.성적등록|0.메인메뉴");
			System.out.println("-------------------------------------------------");
			System.out.print("선택>");
			String menu = s.nextLine();
			switch (menu) {
			case "0":
				run = false;
				System.out.println("메인메뉴로 돌아갑니다!");
				break;
			case "2":
				System.out.print("학번>");
				String scode = s.nextLine();
				if (scode == "") {
					System.out.println("수강신청을 취소합니다.");
				} else {
					StudentVO svo = sdao.read(scode);
					if (svo.getSname() == null) {
						System.out.println("해당학생이 존재하지 않습니다.");
					} else {
						System.out.printf("%s(%s)\n", svo.getSname(), svo.getDept());
						while (true) {
							// 수강신청한 목록
							System.out.println("\n-----------------------------------");
							List<EnrolVO> carray = edao.clist(scode);
							if (carray.size() == 0) {
								System.out.println("수강신청 내역이 없습니다.");
							} else {
								for (EnrolVO v : carray) {
									System.out.printf("%s:%s|", v.getCcode(), v.getCname());
								}
							}
							System.out.println("\n-----------------------------------------------");

							// 수강신청할 목록
							List<CourseVO> aarray = cdao.list();
							for (CourseVO v : aarray) {
								System.out.printf("%s:%s|", v.getCcode(), v.getCname());
							}
							System.out.println("\n----------------------------------------------");

							System.out.println();

							System.out.print("과목코드>");
							String ccode = s.nextLine();
							if (ccode == "") {
								System.out.println("수강신청을 취소합니다.");
								break;
							}
							EnrolVO vo = edao.read(scode, ccode); // 읽어오기
							if (vo.getSname() != null) {
								System.out.println("이미 수강신청을 했습니다.");
							} else {
								CourseVO cvo = cdao.read(ccode);
								if (cvo.getCname() == null) {
									System.out.println("해당 강좌가 존재하지 않습니다.");
								} else {
									// 수강신청
									edao.insert(ccode, scode);
								}
							}
						}
					}

				}
				break;
			case "1":// 전체수강목록
				List<EnrolVO> earray = edao.list();
				for (EnrolVO vo : earray) {
					System.out.printf("%s\t%s\t%s\t%-10s\t%d\t%s\n", vo.getScode(), vo.getCcode(), vo.getSname(),
							vo.cname, vo.getGrade(), sdf.format(vo.getEdate()));
				}

				break;
			case "4": // 성적입력

				List<CourseVO> aarray = cdao.list();
				for (CourseVO v : aarray) {
					System.out.printf("%s:%s|", v.getCcode(), v.getCname());
				}
				System.out.println("\n----------------------------------------------");

				System.out.println();

				System.out.print("과목코드>");
				String ccode = s.nextLine();
				// System.out.println("과목명 :"+ccode);
				if (ccode == "") {
					System.out.println("성적입력을 취소합니다.");
					break;
				} else {

					List<EnrolVO> erray = edao.slist(ccode);
					for (EnrolVO e : erray) {
						System.out.printf("학번 :%s 이름: :%s 점수  :%d\n ", e.getScode(), e.getSname(), e.getGrade());

						String sscode = e.getScode();
						System.out.print("점수 입력>");
						String grade = s.nextLine();
						int egrade = Integer.parseInt(grade);

						if (egrade == 0) {
							System.out.println("이미 성적 입력되어있습니다");

						} else {
							edao.ingrade(ccode, sscode, egrade);
							System.out.printf("점수 %d점 입력완료 ", egrade);

						}
						System.out.println("\n----------------------------------------------");

					}
				}

				break;
			case "3":
				System.out.print("학번>");
				scode = s.nextLine();
				if (scode == "") {
					System.out.println("수강취소를 취소합니다.");
				} else {
					StudentVO svo = sdao.read(scode);
					if (svo.getSname() == null) {
						System.out.println("해당학생이 존재하지 않습니다.");
					} else {
						System.out.printf("%s(%s)\n", svo.getSname(), svo.getDept());

					}
				}
				while (true) {
					// 수강신청한 목록
					System.out.println("\n-----------------------------------");
					List<EnrolVO> carray = edao.clist(scode);
					if (carray.size() == 0) {
						System.out.println("수강신청 내역이 없습니다.");
					} else {
						for (EnrolVO v : carray) {
							System.out.printf("%s:%s|", v.getCcode(), v.getCname());
						}
					}
					break;
				}
				System.out.println("\n----------------------------------------");
				System.out.print("취소할 과목번호는>");
				String dccode = s.nextLine();
				if (dccode == "") {
					System.out.println("수강취소를 종료합니다.");
				} else {
					edao.delete(dccode, scode);
					System.out.println(dccode + "과목 수강취소 완료");
				}

				break;
			default:
				System.out.println("메뉴를 다시선택하세요!");
			}// switch
		} // while
	}
}