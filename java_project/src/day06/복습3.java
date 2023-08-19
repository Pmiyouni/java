package day06;

import java.util.Scanner;

public class 복습3 {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 int answer = (int)(Math.random()*31)+1;
		 System.out.println( "제시숫자>  "+answer);
	     int cnt = 0;
		 boolean run = true;
		 int c =10;
		 
		 while(run) {
			
			for(int i=1; i<=c; i++) {
			System.out.print("숫자를 입력하세요>  ");
			int a= sc.nextInt();
			cnt = i;
		
			if( a > answer) {
				System.out.println("down");
				
			} else if( a < answer) {
				System.out.println("up");
			
			} else {
				System.out.println("정답!!");
				System.out.printf("시도횟수는 %d 번",+cnt);
				run = false;
				break;
			} }
			if ( run == true) {
				System.out.println("시도횟수 초과");
				break;
			}
			System.out.println();
					 }
		  System.out.println("프로그램 종료");
	
	}
}
