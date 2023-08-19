package day03;

import java.util.Scanner;

public class 복습2 {

	public static void main(String[] args) {
		
//		for(int i=0; i<5; i++) {
//			System.out.println("안녕하세요");
//		}


//		for(int i=1; i<=10; i=i+2) {
//			System.out.println(i);
//		}
		
		// 10부터 1까지 출력
//		for(int i=10; i>=1; i--) {
//			System.out.println(i);
//		}
		
//		for(int i=1; i<=10; i++) {
//			if( i ==10) {
//				System.out.print(i);
//			} else {
//			System.out.print(i+",");
//		    } 
//		}
//		
		//1-100 합 구하기
//		int sum = 0;
//		for(int i=1; i<=10; i++) {
//			sum =sum+i;
//		}
//			System.out.println(sum);
	
		// 1-100까지 7의 배수 갯수 구하기
//		int cnt =0;
//		for(int i=1; i<=100; i++) {
//			if(i % 7  == 0){
//			cnt = cnt + 1;
//			}
//		}
//			System.out.println("7의 배수 갯수는=> "+cnt+"개");
		
		// 6단 구구단
//		int dan = 6; //원하는 단으로 대입하여 변경 가능
//		System.out.println(dan+"단");
//		for(int i=1; i<=9; i++) {
//			if(i == 5) {
//				System.out.println();//공백줄 주기
//				continue; 
//			}
//			System.out.println(dan+" * "+i+" = "+dan*i);
//		}
//		System.out.println(dan+"단 끝");
		//break는 반복문 정지, continue는 반복문 건너띄기
		
		
		//while문
//		Scanner sc = new Scanner(System.in);
//		
//		 while(true) {
//			 System.out.print("숫자 입력>");
//			 int a =sc.nextInt();
//			 if( a > 0) {
//			 System.out.println("양수");
//		    }else if(a < 0) {
//			 System.out.println("음수");
//		    } else if(a ==0) {
//		    	break;
//		    }
//		 }
//		 System.out.println("반복문 종료");
		 
		 
		
		// 짝수, 홀수, 0이면 종료
		Scanner sc = new Scanner(System.in);
		
		 while(true) {
			 System.out.print("숫자 입력>");
			 int a =sc.nextInt();
			 
			 if(a == 0) { 
			    	break;
			  } else if( a % 2 == 0) {
			 System.out.println("짝수");
		      } else if(a % 2 != 0) {
			 System.out.println("홀수");
		    } 
		 }
		 System.out.println("반복문 종료");
		  
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
