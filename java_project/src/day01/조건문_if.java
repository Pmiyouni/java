package day01;

import java.util.Scanner;

public class 조건문_if {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int age=5;
//		if(age>=19) {
//			System.out.println("성인입니다");
//		}else if(age>=13) {
//			System.out.println("청소년입니다");
//		}else if(age>=8) {
//			System.out.println("초등학생입니다");
//		}else {
//			System.out.println("어린이입니다");
//		}
		
		//변수 a의 값에 따라 
//		int a=-3;
//		if(a>0) {
//			System.out.println("양수");
//		}else if(a==0) {
//			System.out.println("0");
//		} else  {
//			System.out.println("음수");
//		} 
		
	//변수 score의 값에 따라 
//		score 95 이상이면 A+ 
//		score 90 이상이면 A 
//		score 85 이상이면 B+
//		score 80 이상이면 B
//		score 75 이상이면 C+
//		score 70 이상이면 C
//		score 65 이상이면 D+
//		score 60 이상이면 D
//		score 60 미만이면 F
//			int score=68;
//			if(score>=90) {
//				if(score >=95) {
//					System.out.println("A+");	
//				} else {
//					System.out.println("A");
//			}
//			}else if(score>=80) {
//				if(score >=85) {
//					System.out.println("B+");	
//				} else {
//					System.out.println("B");
//			}				
//			}else if(score>=70) {
//				if(score >=75) {
//					System.out.println("C+");	
//				} else {
//					System.out.println("C");
//			}				
//			}else if(score>=60) {
//				if(score >=65) {
//					System.out.println("D+");	
//				} else {
//					System.out.println("D");
//			}				
//			}else if(score<60) {
//				System.out.println("F");
//			}
			
			// 변수 a값에 따라 양수, 음수,0
//			Scanner sc=new Scanner(System.in);//콘솔에서 입력위해
//			System.out.print("숫자입력>");
//			int a=sc.nextInt();//콘솔에서 입력
//			if(a>0) {
//				System.out.println("양수");//println은 줄바꿈
//			} else if(a==0) {
//				System.out.println("0");
//			} else {
//			System.out.println("음수");
//			}	
			
//		Scanner sc= new Scanner(System.in);
//		System.out.print("나이입력>");
//		int age=sc.nextInt();
//		
//		if(age>=19) {
//			System.out.println("성인");
//		}else if(age>=13) {
//			System.out.println("청소년"); 
//		}else if(age>=8) {
//		System.out.println("초등학생"); 
//		}else{
//		System.out.println("어린이"); 
//		}

		
     // 변수 num의 값에 따라 짝수, 홀수, 0 출력		
//			Scanner sc=new Scanner(System.in);//scanner이라는 타입의 sc 변수
//			System.out.print("숫자입력>");
//			int num=sc.nextInt();
//			if(num==0) {
//				System.out.println("0");
//			}else if(num%2==0) {
//				System.out.println("짝수");
//			}else if(num%2!=0) {
//				System.out.println("홀수"); 
//			} 
//		
		
		//num의 값에 따라 3과 5의 배수, 3의 배수, 5의 배수, 둘다아님
//		Scanner sc=new Scanner(System.in);
//		System.out.print("숫자입력>");
//		int num=sc.nextInt();
//		
//		if(num%3==0 && num%5==0) {
//			System.out.println("3과 5의 배수");
//		}else if(num%3==0) {
//			System.out.println("3의 배수");
//		}else if(num%5==0) {
//			System.out.println("5의 배수"); 
//		}else  {
//			System.out.println("둘다아님"); 
//		} 
		
		
		// 가장 큰수 출력
		System.out.println("방법 1");
		int a=10;
		int b=33;
		int c=50;
		if(a>b) {
		 if(a>c) {
			System.out.println("가장 큰수는 "+a);}
		} else if(b>c) {
			System.out.println("가장 큰수는 "+b);
		} else  {
			System.out.println("가장 큰수는 "+c);
		}
		System.out.println("==============");
		
		
		System.out.println("방법 2");		
		 a=60;
		 b=100;
		 c=50;
		if(a>b && a>c) {
			System.out.println("가장 큰수는 "+a);
		}  else if(b>c) {
			System.out.println("가장 큰수는 "+b);
		} else  if(c>b){
			System.out.println("가장 큰수는 "+c);
		}
	
	}
}









