package day06;

import java.util.Scanner;

public class 랜덤숫자중복제거 {

	public static void main(String[] args) {
		
		// 랜덤숫자 3개를 받아 세 수가 모두 동일할때 까지 반복, 세수가 동일한 숫자이면 종료
		Scanner sc = new Scanner(System.in);
////		
//		int[] number = new int[3]; // 3칸의 정수형 배열 선언
//		System.out.print(">");    
//		
//		for(int i =0; i<1000 ; i++) { // 반복
//			sc.nextLine(); // 1줄 입력(엔터키 입력)
//			for(int j=0 ; j<number.length; j++) {  //배열을 number 배열의 수만큼 반복
//				number[j] = (int)(Math.random()*9)+1; // 각 배열 칸마다 랜덤숫자를 저장
//				System.out.print(number[j]+"  "); // 랜덤 숫자 배열 값 출력
//			}
//			if(number[0] == number[1] && number[1] == number[2]) { 
//				  // 0번째와 1번째, 1번째와 2번째가 동일 한지 물어봄
//				System.out.println("정답"); //정답이라고 출력 후 종료
//				break;
//			}
//			
	// lotto 배열에 중복없이 	랜덤 숫자가 나올때까지 계속 반복하다 성공하면 종료
		int[] lotto = new int[6]; // 6칸의 정수형 배열 선언
		boolean run = true ;  // boolean형 변수에 true 설정
		
	while(run) { // run이 true 일때 반복
		
		boolean a = true ;  // boolean형 변수에 true 기본값 설정
	
		for(int i =0 ; i<lotto.length; i++) { // 0부터 배열 수 만큼 6번 반복
			
			lotto[i] = (int)(Math.random()*9)+1; // 랜덤 숫자(1~9)를 각 배열 칸에 입력
			
			System.out.println("랜덤 숫자는..  "+lotto[i]); // 랜덤숫자 출력
			
			
			for(int j = 0; j <=i ; j++) {  // j는 0부터 밖의 for의 i 만큼 반복
				if(i != j) {   // 자기 배열 값을 서로 비교하면 당연히  같으므로 제외하기위해
		
					if (lotto[i]  ==  lotto[j]) { 
		     // i번째 배열 값을 기준으로 j는 0부터 i번째 까지 반복하며 일치하는 지 비교
						
						a = false; //일치하면 	boolean형 a변수에 false로 대입				
						break;  // 일치하였으므로 탈출
		
					} // 숫자가 일치하는지 조건이 물어보는 if문 종료
				} // 자기의 배열과 비교하지 않는지 조건을 물어보는 if문 종료
			} // 안의 for문 종료
		  } // 밖의 for문 종료
		
				if(!a) {  // 값이 일치하여 중복이 있으면 a변수에 false를 주었으므로
					System.out.println("중복 있음"); 
					System.out.println();
				}  else {
			          	run = false;
		         //중복이 아니면 성공이므로 while문을 종료하기위해 run변수에 false 대입
					   	} 
		}
	        System.out.println("중복 없이 성공!!");
			System.out.println(lotto[0]);
			System.out.println(lotto[1]);
			System.out.println(lotto[2]);
			System.out.println(lotto[3]);
			System.out.println(lotto[4]);
			System.out.println(lotto[5]);
		
		
		
		
		// lotto배열에 중복없이 1~9까지 값 넣기
//		int[] lotto = new int[6];	// 6칸의 정수형 배열 선언	
//		
//		
//		for(int j=0; j<lotto.length; j++) { // 0부터 배열 수 만큼 6번 반복
//			int num = (int)(Math.random()*9)+1; // 랜덤 숫자(1~9)를 각 배열 칸에 입력
//			System.out.println("랜덤 숫자는..  "+num); 
//			boolean find = false; // boolean형 변수에 false 기본값 설정
//			
//			for(int i=0; i< j ; i++) { // 0 부터 배열 수만큼 반복
//				if(num == lotto[i]) { // 입력받은 숫자와 배열의 숫자가 일치하는지 물어봄
//					System.out.println(num + "  중복 있음");  // 중복이라 출력
//					System.out.println();
//					find = true;  // 중복이 있으면 find 값을 true으로 대입
//					break;   // 중복이므로 종료
//				}  // if문 종료
//			} // 안 for문 종료
//			
//			if(!find) { // find 가 중복이면 true이므로 false이면 중복이 아닌 경우임
//				lotto[j] = num; // 중복이 아니면 해당 배열 칸에 입력 숫자 저장
//			} else { // 아니면, 즉 중복이면  숫자를 저장하지 않고 다시 배열 그자리 칸부터 시작해야 하므로  
//				j--;  
//		 // 반복문의 j 값이 하나가 자동  증가하므로 j 배열 회수를 하나 빼고 다시 밖의 for문으로 가서 반복
//			}
//		} // 밖의 for문 종료
//		
//		System.out.println(lotto[0]);
//		System.out.println(lotto[1]);
//		System.out.println(lotto[2]);
//		System.out.println(lotto[3]);
//		System.out.println(lotto[4]);
//		System.out.println(lotto[5]);
		
		}
	    }



	
// 블로그애서 참고(while문 사용)
		// lotto배열에 중복없이 1~9까지 값 넣기	다른 방법
// lotto배열에 중복없이 1~9까지 값 넣기
//	int[] lotto = new int[6];	// 6칸의 정수형 배열 선
//    int c = 0;
//
//  	while(c <  lotto.length){ // 0부터 배열 수 만큼 6번 반복
//	int num = (int)(Math.random()*9)+1; // 랜덤 숫자(1~9)를 각 배열 칸에 입력
//	System.out.println("랜덤 숫자는..  "+num); 
//	boolean find = false; // boolean형 변수에 false 기본값 설정
//	
//	for(int i=0; i< c ; i++) { // 0 부터 배열 수만큼 반복
//		if(num == lotto[i]) { // 입력받은 숫자와 배열의 숫자가 일치하는지 물어봄
//			System.out.println(num + "  중복 있음");  // 중복이라 출력
//			System.out.println();
//			find = true;  // 중복이 있으면 find 값을 true으로 대입
//			break;   // 중복이므로 종료
//		}  
//	} 
//	
//	if(!find) { // find 가 중복이면 true이므로 false이면 중복이 아닌 경우임
//		lotto[c] = num; // 중복이 아니면 c값의 배열 칸에 입력 숫자 저장
//	    c++; //중복없는 값 저장했으먄 다음 칸으로 이동위해 c변수 값 증가
//	}
//} 
//System.out.println(lotto[0]);
//System.out.println(lotto[1]);
//System.out.println(lotto[2]);
//System.out.println(lotto[3]);
//System.out.println(lotto[4]);
//System.out.println(lotto[5]);

//}
//}
