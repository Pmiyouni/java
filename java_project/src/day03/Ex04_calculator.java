package day03;

import java.util.Scanner;

public class Ex04_calculator {

	public static void main(String[] args) {
		//
		Scanner sc = new Scanner(System.in);

		boolean run = true; 
		boolean con = true; 
		int result = 0;
		int num1=0;
		 //첫번째 입력숫자를 num1에 대입
		while (run) { //run변수에 true가 있어서 무한 반복
			System.out.println("=====계산기======");
		
			if(con) {
				System.out.print(" 첫번째 숫자 입력>");
				 num1 = sc.nextInt(); 
			}
				
           
			System.out.println("1. 더하기  2. 빼기  3. 곱하기  4. 나누기  5. 나머지");
			System.out.println("메뉴 선택>");
			int menu = sc.nextInt(); // 메뉴선택에 해당하는 숫자를 menu 변수에 대입
			System.out.print(" 두번째 숫자 입력>");
			int num2 = sc.nextInt(); // 두번째 입력숫자를 num2에 대입

			System.out.println();
			switch (menu) {
			case 1: // 메뉴선택으로 입력한 숫자가 1인 경우 
				result = num1+num2;
				System.out.printf("%d +  %d  = %d\n", num1, num2, result);
				// 4 + 2 = 6
				break;
			case 2: // 메뉴선택으로 입력한 숫자가 2인 경우 
				result = num1-num2;
				System.out.printf("%d -  %d  = %d\n", num1, num2, result);
				break;
			case 3: // 메뉴선택으로 입력한 숫자가 3인 경우 
				result = num1*num2;
				System.out.printf("%d *  %d  = %d\n", num1, num2, result);
				break;
			case 4: // 메뉴선택으로 입력한 숫자가 4인 경우 
				result = num1/num2;
				System.out.printf("%d /  %d  = %d\n", num1, num2, result);
				break;
			case 5: // 메뉴선택으로 입력한 숫자가 5인 경우 
				result = num1%num2;
				System.out.printf("%d %%  %d  = %d\n", num1, num2, result);// printf에서 나머지 %는 %%로 표기
				break;
											
			default: // 해당되는 case 문이 없을 경우  즉 1-5가 아닌 경우 
				System.out.println("입력 오류(1~5까지 입력)");
				
			}	
			while(true) {
			System.out.print("1.종료 2.새로하기 3. 이어하기>");
			int end = sc.nextInt();
			if(end  == 1) {
				run =  false;
				 System.out.println("계산기 종료");
				break;
			} else if(end  == 2) {
				con=true;
				num1=0;
				break;
			} else if(end  == 3) {
				 con=false;
				 num1 =result;
				 break;
			} else {
				System.out.println("1-3까지 입력");
			}
		}		
						
		   System.out.println();
		}
		
	
	}

}
