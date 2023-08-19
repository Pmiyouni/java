package day04;

import java.util.Scanner;

public class Ex08_회원가입 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String name = "";
		String id = "";
		String pw = "";
		boolean login = false;
		
		while(true) {
			System.out.println("=========회원 가입===========");
			if(login) {
				System.out.println("1.회원정보 2. 로그아웃  0.종료");
			} else {
			System.out.println("1.회원가입 2. 로그인   0.종료");
			}
			
			System.out.print("선택하시오>\t");
			int menu = sc.nextInt();
			
			if(menu == 1) {
				if(login) {
					System.out.println("이름\t아이디\t비밀번호");
					System.out.println("========================");
					System.out.println(name+"\t"+id+"\t"+pw);
				} else {
				 System.out.print("이름 입력>\t");
				name = sc.next();
				 System.out.print("아이디 입력>\t");
				 id = sc.next();
				 System.out.print("비밀번호 입력>\t");
				 pw = sc.next();
			} }
				else	if(menu == 2) {
					if(login) {
						login = false;
						System.out.println("로그아웃 되었습니다");
						System.out.println();
					} else {
				System.out.print("이름 입력>\t");
				String n = sc.next();
				System.out.print("아이디 입력>\t");
				String i = sc.next();
				System.out.print("비밀번호 입력>\t");
				String p = sc.next();
				
				if(!(i.equals(id))) {
					System.out.println("아이디 오류");
					
				}	else if(!(p.equals(pw))){
						System.out.println("비빌번호 오류");
						
					} else {
						System.out.println("로그인 성공");
						login = true;
					}
					
					}
			
			} else	if(menu == 0) {
				break;
			} else {
				System.out.println("0-3까지 입력 가능");
			}
		}
		System.out.println("프로그램 종료");
	}

}
