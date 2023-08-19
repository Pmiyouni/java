package day10;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemberMain {

	public static void main(String[] args) {
		


Scanner sc = new Scanner(System.in);
List<Member> list = new ArrayList<Member>();
DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy년MM월dd일 hh:mm:ss");


while(true) {
	System.out.println("=====멤버관리=====");
	System.out.println("1.멤버등록 2.멤버리스트 3.검색 4.멤버수정 5.멤버삭제 0.종료");
	System.out.print("메뉴선택> ");
	int menu = sc.nextInt();
	
	if(menu == 1) {
		System.out.print("이메일>");
		String email = sc.next();
		System.out.print("비밀번호>");
		String pw = sc.next();
		System.out.print("이름>");
		String name = sc.next();
		String joinDate = dtf.format(LocalDateTime.now());
		
		Member m = new Member(email,pw,name,joinDate);
		
	
		list.add(m);
		System.out.println(name+"님 가입을 축하드립니다");
		
		
		
	}else if(menu == 2) {
		System.out.println("이메일  비밀번호  이름  가입날짜");
		
		for(int i =0; i<list.size(); i++) {
			list.get(i).print();
		}
		
	}else if(menu == 3) {
		System.out.print("검색할 이메일은>");
		String sm = sc.next();
		boolean find = false; 
		
		System.out.println("이메일   비밀번호  이름  가입날짜");
		for(int i = 0; i<list.size();i++) {
			list.get(i).print();
			find =true;
			break;
		}if(!find) {
			System.out.println("조회할 수 없는 이메일입니다");
	}
		
		
	}else if(menu == 4) {
		System.out.print("수정할 이메일>");
		String um = sc.next();
		boolean find = false;
	for(int i=0; i<list.size();i++) {
		if(um.equals(list.get(i).getEmail())) {
			System.out.print("수정할 비밀번호>");
			list.get(i).setPw(sc.next());
			
			
			find =true;
			//개체를 바꿈
			System.out.println("수정 완료");
			break;
			
		}if(!find) {
			System.out.println("조회할 수 없는 비밀번호입니다");
	}
	}
		
	}else if(menu == 5) {
		System.out.print("삭제할 이메일>");
		String dm = sc.next();
		for(int i=0; i<list.size();i++) {
			if(dm.equals(list.get(i).getEmail())) {
				list.remove(i); //삭제, 위치가 당겨짐
				System.out.println("삭제성공");
				break;
			}
		}
		
	}else if(menu == 0) {
		break;
	}else {
		System.out.println("다시입력");
	}
	System.out.println();
}
System.out.println("프로그램종료");
}

}