package day09;

import java.util.Scanner;

public class 복습 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//반복하면서 입력받는데 정답보다 크면 down, 작으면 up, 정답이면 반복문 종료
		Scanner sc = new Scanner(System.in);
		int answer =(int)(Math.random()*31)+1; // 랜덤 정답
		// System.out.println("제시숫자:  "+answer); //출력은 주석처리
		
		while(true) {
			System.out.print("숫자 입력>");
			int a = sc.nextInt();
			if(a  < answer) {
				System.out.println("up");
			}else if(a  > answer) {
					System.out.println("down");
			}else if(a  == answer) {
						System.out.println("성공!! 정답");
						break;
					}
			}
		System.out.println("프로그램 종료");
	}

}
