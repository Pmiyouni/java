package day02;

import java.util.Scanner;

public class 복습 {

	public static void main(String[] args) {
		
		// 숫자를 입력 받아 양수, 음력, 0 출력
//		Scanner sc = new Scanner(System.in);//콘솔에서 키보드로 입력 받음
//		System.out.println("숫자입력> ");
//		int a = sc.nextInt();
//		
//         if(a > 0) {
//        	 System.out.println("양수");
//         } else if(a < 0) {
//        	 System.out.println("음수");	
//         } else {
//        	 System.out.println("0");	
//         }
         
        // score에 따라 학점구하기
//		 Scanner sc= new Scanner(System.in);
//         System.out.print("점수 입력> ");
//         double score=sc.nextDouble();
//         
//         if(score >= 90) {
//        	 System.out.println("A");
//         }else if( score >= 80) {
//        	 System.out.println("B");
//         }else if( score >= 70) {
//        	 System.out.println("C");
//         }else if( score >= 60) {
//        	 System.out.println("D");
//         }else if(score < 60){
//        	 System.out.println("F");
//         }
        
		 // 숫자 하나를 입력 받아 0이아닌 짝수, 홀수, 0
//         Scanner sc= new Scanner(System.in);
//         System.out.print("숫자입력>");
//         int num = sc.nextInt();
//         
//         if(num == 0) {
//        	 System.out.println("0");
//         } else if( num % 2 == 0) {
//        	 System.out.println("0이 아닌 짝수");
//         } else if( num % 2 != 0) {
//         	 System.out.println("홀수");
//         }
	
//		계산기 프로그램
//		Scanner sc = new Scanner(System.in);
//		System.out.print("첫번째 숫자 입력==>");
//		int num1 = sc.nextInt();
//		System.out.print("두번째 숫자 입력==>");
//		int num2 = sc.nextInt();
//		
//		System.out.println("1.더하기  2.빼기  3.곱하기  4.나누기  5. 나머지");
//		System.out.print("메뉴선택> ");
//		int menu=sc.nextInt();
//		
//		if(menu == 1) {
//			System.out.println(num1+"+ "+num2+"= "+(num1+num2));
//		} else if(menu == 2) {
//			if (num1 < num2) {
//				System.out.println(num1+"- "+num2+"= "+-(num2-num1));
//			} else {
//			System.out.println(num1+"- "+num2+"= "+(num1-num2));}
//		} else if(menu == 3) {
//			System.out.println(num1+"* "+num2+"= "+(num1*num2));
//		} else if(menu == 4) {
//			System.out.println(num1+"/ "+num2+"= "+(num1/(double)num2));
//		} else if(menu == 5) {
//			System.out.println(num1+"% "+num2+"= "+(num1%num2));
//		} else {
//			System.out.println("입력 값 오류(1-5입력");
//		}
		//로그인 프로그램	
		String id="aa";
		String pw="1234";
		
		Scanner sc= new Scanner(System.in);
		System.out.print("아이디 입력>");
		String loginId= sc.next();
		System.out.print("비밀번호 입력>");
		String loginPw= sc.next();
		
		
		if(loginId.equals(id)  &&  loginPw.equals(pw)){		
			System.out.println("로그인 성공");
		} else if(!loginId.equals(id)) {
			System.out.println("아이디 실패");
		} else if(!loginPw.equals(pw)){
			System.out.println("비밀번호 실패");
		} 
	

		// 기본자료형은 같다를 ==로 표기하나 문자열(String)는 참조자료형equals()로 표기
		
		
		// loginId == id  => loginId.equals(id)
		// loginId != id  => !loginId.equals(id)
//		 
//		 if(!loginId.equals(id)) {
//			System.out.println("아이디 실패");
//		} else if(!loginPw.equals(pw)){
//			System.out.println("비밀번호 실패");
//		} else if(loginId.equals(id)  &&  loginPw.equals(pw)){
//				System.out.println("로그인 성공");
//		} 
//		 
//		 if(loginId.equals(id)){
//			 if(loginPw.equals(pw){
//				System.out.println("로그인 성공");
//			 } else  {
//				System.out.println("비밀번호 실패")
//			} 
//			}
//			 else {
//				System.out.println("아이디 실패");
//			} 
	
		
		
		
		
		
		
	}
	
}




