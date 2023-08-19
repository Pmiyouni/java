package day04;

import java.util.Scanner;

public class Ex02_login {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String id = "test";
		String pw = "1234";
		
		while(true) {
			System.out.println("=======로그인========");
			System.out.print("로그인 할 아이디>");
			String loginId = sc.next();
			System.out.print("로그인 할 비밀번호>");
			String loginPw = sc.next();
			
			if(loginId.equals(id) && loginPw.equals(pw)) {
				System.out.println("로그인 성공");
				break;
			} else {
				System.out.print("로그인 실패 \n 재시도(y/Y)>");
				String re =sc.next();
				if(!(re.equals("y") || re.equals("Y"))) {
					break;
				} 
				System.out.println();
			}
				
			
			
			
			
		
		}		

	}

}
