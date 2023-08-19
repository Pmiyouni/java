package day04;

import java.util.Scanner;

public class Ex07_up_down {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int answer = (int)(Math.random()*31)+1;// 1~31까지 랜덤 숫자
		System.out.println("제시 숫자는 "+answer);
		int j=0;
		int t=10;
		
		
		while(true) {
			System.out.println("up & down 시도가능회수 :"+(t-j));
			System.out.println("숫자 입력>");
			int num = 0;
			if(sc.hasNextInt()) {// 숫자만 입력 받기 위해 
			 num = sc.nextInt();sc.nextLine();
			     // sc.nextInt();는 숫자를 받음
			     // sc.nextLine();는 숫자 뒤에 엔터키도 가져옴(그 공백도 지워줌)
			j=j+1; //j++;와 동일 // 숫자만 입력했을시 시도회수가 1씩 증가
			} else {
				sc.nextLine(); 
				//sc.next(); 공백 전 문자열 받아옴
				//sc.nextLine(); 공백 문자와 상관없이 콘솔 창 한 줄(Line)에 있으면 모두 문자열로 인식해 String 변수로 리턴한다.
				System.out.println("숫자만 입력 가능");
				System.out.println();
				continue;
			}
			if( num == answer) {
				System.out.println("정답 ok!!");	
				System.out.println("정답 시도 회수: "+j);
				if(j  == 1) {
					System.out.println("perfect");
				} else if(j  <=3) {
					System.out.println("good");
				}
				else if(j  <=5) {
					System.out.println("normal");
				}
				else  {
					System.out.println("soso");
				}
				break;
			} else 	if(j == 10) {
			System.out.println("정답횟수 초과");
			System.out.println("재시작(y/Y)?");
			String re = sc.next();
			if(!(re.equals("y") || re.equals("Y"))){
				break;
			}
			
			j = 0; //재시도를 위해 회수를 0으로 클리어
		} else	if( num > answer) {
			System.out.println("down");
		
		} else if(num < answer) {
			System.out.println("up");	
		
		} 
			System.out.println();
	}
		System.out.println("게임 종료");
		
	}	

	}
