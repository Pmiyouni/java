package day04;

import java.util.Scanner;

public class 계산기_char형 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		
		while(run) {
			System.out.println("========== 계 산 기 ===========");
			System.out.println(" 첫번재 숫자 입력>");
			int num1 =sc.nextInt();
			
		
			System.out.println("연산자 선택>");
		//	String str = sc.next();
		//	char  cal = str.charAt(0); // char형으로 받음
			char  cal = sc.next().charAt(0); // char형으로 받음
			
			
			System.out.println(" 두번재 숫자 입력>");
			int num2 =sc.nextInt();
			
			if(cal == '+')  {// char형은 '(작은 따옴표)로 표시
				             // String형은 .equals()을 사용하지만 char형은  == 로 사용
			System.out.println(num1+" + "+num2+" = "+(num1+num2) );
			//System.out.printf("%d  +   %d    =    %d\n", num1,num2,(num1+num2));
			
			} else if(cal == '-') {
				System.out.println(num1+" - "+num2+" = "+(num1-num2) );
			} else if(cal == '*') {
					System.out.println(num1+" * "+num2+" = "+(num1*num2) );
			} else if(cal == '/') {
					System.out.println(num1+" / "+num2+" = "+(num1/num2) );
			} else if(cal == '%') {
					System.out.println(num1+" % "+num2+" = "+(num1%num2) );
			//System.out.printf("%d  %%   %d    =    %d\n", num1,num2,(num1%num2));
					
			} else {
				System.out.println("연산자 입력 오류..다시입력하세요");
			}
			
			System.out.printf("\n\n");
			
			
		
		
		
		
		
		
		
		
		
		
		
		}
	}

}
