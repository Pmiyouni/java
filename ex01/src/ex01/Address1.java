package ex01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Address1 {
	public static void run() {
		List<Student> array = new ArrayList<>();
		Student stu = new Student("20231", "홍길동", "인천 서구 경서동"); // 생성자 호출, 생성자 오버로딩
		// 생성하면서 값을 넣음
		array.add(stu);
		stu = new Student("20232", "심청이", "인천 부평구 계산동");
		// 위에서 Student를 선언하였으므로 다시 하면 중복됨, Student 지워야함
		array.add(stu);
		stu = new Student("20233", "강감찬", "서울 강서구 화곡동");

		array.add(stu);

		Scanner s = new Scanner(System.in);
		// int count = 3;
		boolean run = true;
		while (run) {
			System.out.println("============================================================");
			System.out.println("1.주소등록 | 2. 주소목록 | 3. 주소검색 | 4.주소수정 | 5. 주소 삭제 | 0.종료");
			System.out.println("=============================================================");
			System.out.print("메뉴선택>");
			String menu = s.nextLine();
			switch (menu) {
			case "5":
				System.out.print("삭제할 이름> ");
				String delete = s.nextLine();
				boolean find = false;
				for (Student st : array) {// array를 st에 넣고->반복. st는 Student 타입임
					if (delete.equals(st.getSname())) { // 찾았을때
						find = true;
						array.remove(st);// for문 객체
						System.out.println("삭제완료");
						break;
						}
					}
				
				if (!find)
					System.out.println(delete + " 학생이 없습니다");
				break;
			case "4":
				System.out.print("수정할 이름> ");
				String update = s.nextLine();
				 find = false;
				for (Student st : array) {// array를 st에 넣고->반복. st는 Student 타입임
					if (update.equals(st.getSname())) { // 찾았을때
						find = true;
						System.out.println("이름은 " + st.getSname());
						System.out.println("주소는 " + st.getAddress());
						System.out.println("새로운 주소>");
						String newAdd = s.nextLine();
						if (newAdd != "") {
							st.setAddress(newAdd);
							System.out.println("새로운 주소로 수정되었습니다");
						}
					}
				}
				if (!find)
					System.out.println(update + " 학생이 없습니다");
				break;
			case "3":
				System.out.print("검색할 이름> ");
				String search = s.nextLine();
				find = false;
				for (Student st : array) {// array를 st에 넣고->반복. st는 Student 타입임
					if (search.equals(st.getSname())) { // 찾았을때
						System.out.println(st.toString());
						find = true;
					}

				}
				if (!find)
					System.out.println(search + " 학생이 없습니다");
				break;
			case "0":
				run = false;
				System.out.println("프로그램 종료");
				break;
			case "2":
				for (Student st : array) {
					System.out.println(st.toString());
				}
				break;
			case "1":
				stu = new Student(); // 기본생성자로 호출하여 생성

				stu.setSno("2023" + (array.size() + 1));
				System.out.println("학번> " + stu.getSno());

				System.out.print("이름> ");
				stu.setSname(s.nextLine());

				System.out.print("주소> ");
				stu.setAddress(s.nextLine());

				array.add(stu); // 빈공간에 알아서 들어감

				System.out.println(array.size() + "명 등록 완료");
				break;

			default:
				System.out.println("다시 선택하셔요!");

			}// switch
		} // while
	}// run
}// class
