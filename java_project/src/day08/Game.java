package day08;

import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		// 숫자야구게임

		Scanner sc = new Scanner(System.in);
		int a;	// 볼 개수 카운트	변수
		int s;  // 스트라이크 개수 카운트 변수

		int[] b = new int[3]; // 제시할 숫자 3개 배열 변슈
		int[] num = new int[3]; // 입력할 숫자 변수 
	
		

		for(int i=0; i<3; i++){ 
			b[i] = (int) (Math.random() * 9) + 1; // 1~9 숫자를 3개 받기
			for(int j=0; j<i; j++){
				if(b[i] == b[j]){ // 중복 체크(중복 제거)
					i--;
				}
				
			}
		}
			for(int j =0; j<3; j++) { //랜덤 숫자 보여주기(게임 진행시 주석처리 할 것
			System.out.println(b[j]);
			}
	

		System.out.println("\n==숫자 야구 게임==\n"); 

		System.out.println("10변의 기회가 있습니다\n");

		for (int n = 1; n <= 10; n++) { // 10회 기회를 주기 위해

			System.out.printf("%d 번째 기회입니다\n", n); 
			a = 0;		// 볼 갯수 카운트를 0으로 설정
			s = 0;      // 스트라이크 갯수 카운트를 0으로 설정
			
			for (int i = 0; i < 3; i++) { // 3개의 숫자 입력
				
				System.out.print(" \n숫자를 입력하시요(중복제외)>"); 

				num[i] = sc.nextInt(); // 배열에 입력한 숫자 입력

				for (int j = 0; j < 3; j++) { // index i번째 입력 숫자와 제시된 3개의 숫자를 비교

					if (num[i] == b[j]) { // 값이 같냐?

						if (i == j) { // 위치가 같냐?
							s++;	// 스트라이크 카운트 변수에 1 증가																				
						} else { 	// 값은 같은데 위치가 같지 않으면													
							a++;    // 볼 카운트 변수에 1 증가
						}
						
				}
			}
			}

			if (s == 3) { // 스트라이크가 3개이야?
				System.out.println("성공!! 축하합니다~~\n"); //성공
				break;
				}
			if (s == 0 && a == 0) { // 스트라이크가 0 이고 볼이 0이냐?
				System.out.println("삼진아웃!!  다시 도전하셔요~~\n"); 
			} else {
				System.out.printf(" 스트라이크: %d \n", s);  // 스트라이크 개수 출력
				System.out.printf(" 볼:  %d  \n",  a);     // 볼 개수 출력
				System.out.printf(" 아웃: %d\n",(3-s-a));  // 아웃 개수 출력
				
				System.out.println("아깝네요~ 다시 도전해보셔요~~\n");
			}

		}

		System.out.println("게임종료!!");
	}

}
