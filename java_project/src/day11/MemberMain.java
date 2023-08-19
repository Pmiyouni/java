package day11;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemberMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		List<Member> list = new ArrayList<Member>();
		Long id = 100l;//Long 타입
	
		
		while(true) {
			System.out.println("1.멤버등록  2.멤버리스트 3. 멤버검색 0.종료");
			System.out.print("메뉴선택>");
			int menu = sc.nextInt();
			
			if(menu == 1) { 
				System.out.print("이메일 입력>");
				String email = sc.next();
				System.out.print("비밀번호 입력>");
				String pw = sc.next();
				System.out.print("이름 입력>");
				String name = sc.next();
				
				Member m = new Member(id++,email,pw,name);
				list.add(m); // list에 객체를 추가
				
				
			}else if(menu == 2) { 
				System.out.println("번호\t 이메일\t 비밀번호\t  이름\t 가입날짜");
				System.out.println("=================");
//				for(int i=0; i<list.size(); i++) {
//					list.get(i).print();
//					}
				for(Member m : list) {//향상된 for문 또는 for each
					// 앞에는 객체 : 담겨야 할 것
					// list 전부 빠질때까지
					m.print();
				}
			}else if(menu == 3) { 
				boolean find = false;
				System.out.print("아이디 입력>");
				Long s = sc.nextLong(); //id는 long 타입
				System.out.println("번호\t이메일\t비밀번호\t이름\t가입날짜");
				for(Member m : list) {
					if(s.equals(m.getId())){
						// s==m.getId()도 가능, 참조클랫스 데이터는 자동으로 변환 가능
						// equal는 heap 과 비교 즉 참조형과 비교 
						// ==는 스택과 비교 즉값과 비교
						m.print();
						System.out.println("로그인 성공");
						find =true;
						break;
					}
					}
					if(!find) {
						System.out.println("조회할 수 없는 아이디입니다");
										
				}
				
			}else if(menu == 0) { 
				 break;
			} else {
				System.out.println("다시 입력");
			}
		System.out.println();	
			}
					System.out.println();
				
		
		
		
		
	}

}
