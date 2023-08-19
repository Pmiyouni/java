package day06;

import java.util.Scanner;

public class 복습 {

	public static void main(String[] args) {
		
//아이디와 비밀번호를 입력받아 "아이디가 틀렸습니다", "비밀번호가 틀렸습니다", "로그인 성공" 출력
	
	//  방법 1	
//		Scanner sc = new Scanner(System.in);
//		String id = "test"; //회원 가입한 아이디
//		String pw = "1234"; //회원 가입한 비밀번호
//				
//		System.out.print("아이디 입력> ");
//		String i = sc.next();
//		System.out.print("비밀번호 입력>  ");
//		String p = sc.next();
//		
//		if(!(i.equals(id))) { // id.equals(i)와 동일
//			System.out.println("아이디가 틀렸습니다");						
//		} else if(!(p.equals(pw))) {
//			System.out.println("비밀번호가  틀렸습니다");
//		} else {
//			System.out.println("로그인 성공");
//		}
//		
//       다른 방법으로 
//		if(i.equals(id)) {
//			if(p.equals(pw)) {
//				System.out.println("로그인 성공");
//			} else {
//				System.out.println("비밀번호가 틀렸습니다");
//			}
//		}	else {
//				System.out.println("아이디가 틀렸습니다");
//			}
		
	//1~100 까지 합
//	 int sum =0;
//	 for(int i = 1; i <=100; i++) {
//		 sum +=i;
//	 }
//		
//		System.out.printf("1-100 까지 합> %,d ",sum);
		
		
	 	//5단 출력
	   int dan = 5;
	   System.out.println("5단 출력");
	   
	   for(int i=1; i<=19; i++) {		  
		   System.out.printf("%d\t *\t %d\t =\t %d\n", dan,i,dan*i);
	   }
	   
		
		
		
		
		
		
	}

}
