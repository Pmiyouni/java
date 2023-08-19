package day04;

import java.util.Scanner;

public class Ex03_calculator {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		boolean run = true; //변수 초기화
		
		while(run) {
			System.out.println("========== 계 산 기 ===========");
			System.out.println(" 첫번재 숫자 입력>");
			int num1 =sc.nextInt(); // 첫번째 숫자를 num1에 대입
			
			String cal =""; //문자열 초기화
			while(true) {
			System.out.println("연산자 선택>");
			//	Char cal = sc.next().charAt(0);
			 cal = sc.next(); // 연산자를 문자인 +,-,*,/,% 로 입력 받음
			 
			if(cal.equals("+") || cal.equals("-") || cal.equals("*") || cal.equals("/") || cal.equals("%"))
				// 입력받은 연산자가 입력이 제대로 입력되지않은 경우는 현재의 if문을 탈출	
			        { break;
					} else {
						System.out.println("사용할 수 없는 연산자입니다"); 
						// 조건이 참이 아닐 경우 사용할 수없는 연산자 입력이라고 출력 후 다시 연산자 입력하러 감
					}
				
			}	
			
			System.out.println(" 두번재 숫자 입력>");
			int num2 =sc.nextInt();
			
			if(cal.equals("+"))  {
			System.out.println(num1+" + "+num2+" = "+(num1+num2) );
			//System.out.printf("%d  +   %d    =    %d\n", num1,num2,(num1+num2));
			
			} else if(cal.equals("-")) {
				System.out.println(num1+" - "+num2+" = "+(num1-num2) );
			} else if(cal.equals("*")) {
					System.out.println(num1+" * "+num2+" = "+(num1*num2) );
			} else if(cal.equals("/")) {
					System.out.println(num1+" / "+num2+" = "+(num1/num2) );
			} else if(cal.equals("%")) {
					System.out.println(num1+" % "+num2+" = "+(num1%num2) );
			//System.out.printf("%d  %%   %d    =    %d\n", num1,num2,(num1%num2));
					
			} 
			
			System.out.printf("\n\n");
			
			}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}

