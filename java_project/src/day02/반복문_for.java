package day02;

import java.util.Scanner;

public class 반복문_for {

	public static void main(String[] args) {
//		for(int i=0; i<5; i++) {//i++ <===>i=i+1;
//		System.out.println("안녕하세요");
//		}
		
//		for(int a=0; a<10; a++) {
//			System.out.println(a);
//		}
//		
//		for(int b=1; b<=10; b=b+2) {
//			System.out.println(b);
//		}	
		
//		for(int i=0; i<10; i=i+2) {
//			System.out.println(i);
//		}
		
//		for(int i=3; i<=100; i++) {
//			System.out.println(i);
//		}
		
//		1부터 10까지 가로 출력
//		출력예시 1,2,3,4,5,6,7,8,9,10
//      (유의) 마지막 10 뒤에는 , 안붙임
//		for(int i=1; i<=10; i++) {
//			if( i!= 10) {
//			System.out.print(i+",");
//			} else {
//				System.out.print(i);
//			}
//				
//		}
		
		//1-100까지 홀수 출력
		for(int i=1; i<=100; i=i+2) {
			System.out.println(i);
		}
		
		//1-100까지 짝수 출력
		for(int i=0; i<=100; i=i+2) {
			System.out.println(i);
		}
	
		
		
//		for(변수 선언; 조건식; 증감값){
//			
//		}
//		반복문을 for를 이용하여 1-100까지의 합
	int sum = 0;
	
	for(int i=1;i<=100;i++) {
	    sum = sum + i; //sum +=i
		System.out.println("sum = sum + "+i);
	}
		System.out.println("1-100합은=> "+sum);
		
		
		//구구단 출력
		
		int dan = 7;// dan 변수에 원하는 단의 숫자를 대입
		
		for(int i=1; i<=9; i++) {
			System.out.println(dan+" * "+i+" = "+(dan*i));
		}
		
			
		//(방법 1)1-100까지 3의 배수의 개수 구하기
		
		int cnt = 0;
		for(int j=0; j<=100;j=j+3) {
			if( j != 0) {	//0은 제외임, 1부터이므로		
			System.out.println(j);
			cnt = cnt + 1; //cnt++;
			// 3의 배수일때만 1추가
		}
		}
		System.out.println("1-100까지 3의 배수의 개수는 "+ cnt);
		System.out.println("=========================");
		
		
		//(방법 2)1-100까지 3의 배수의 개수 구하기
		
		int cnt2 =0;
		for(int i=1; i<=100;i=i+1) {
			if(i % 3 == 0) {
			cnt2 = cnt2 + 1; //cnt++;
			// 3의 배수일때만 1추가
		}
		}
		System.out.println("1-100까지 3의 배수의 개수는 "+ cnt2);
//		
	
		// 1~100 까지의 3의 배수 갯수, 5의 배수 갯수 구하기
		
		// 방법 1
		int cnt1 = 0;
		int cnt2 = 0;
		
		for(int i=1; i<=100; i++) {
			if(i % 3 == 0) {
				cnt1++;
			}
			if(i % 5 == 0) {
				cnt2++;
			}			
				}
		System.out.println("3의 배수 갯수는 ==>"+ cnt1);
		System.out.println("5의 배수 갯수는 ==>"+ cnt2);
		
		// 방법 2
		int cnt1 = 0;
		int cnt2 = 0;
		
		for(int i=1; i<=100; i++) {
			
			if(i % 3 == 0 && i % 5 == 0) {
				cnt1++;
				cnt2++;
			} else	if(i % 3 == 0) {
				cnt1++;
			} else	if(i % 5 == 0) {
				cnt2++;
			}			
				}
		System.out.println("3의 배수 갯수는 ==>"+ cnt1);
		System.out.println("5의 배수 갯수는 ==>"+ cnt2);
		
		//원하는 입력 숫자 범위 합 출력
		Scanner sc = new Scanner(System.in);
		System.out.print("몇 부터 >");
		int a = sc.nextInt();
		System.out.print("몇 까지 >");
		int b = sc.nextInt();
		
		int sum = 0;
		for(int i=a; i<=b; i++) {
			sum+=i; //sum=sum+i;
			System.out.println(i);
		}
		System.out.println(sum);
		
		
		//피즈버즈 놀이
		//입력 받은 수의 범위에서 3의 배수는 피즈, 5의 배수는 버즈, 3과 5의 배수는 피즈버즈
		Scanner sc = new Scanner(System.in);
		System.out.print("몇 부터 >");
		int a = sc.nextInt();
		System.out.print("몇 까지 >");
		int b = sc.nextInt();
		
		for(int i=a; i<=b; i++) {	
			if(i % 3 == 0 && i % 5 == 0) {//if(i % 15 == 0)
				System.out.println("피즈버즈");
			} else	if(i % 3 == 0) {
				System.out.println("피즈");
			} else	if(i % 5 == 0) {
				System.out.println("버즈");
			} else {
				System.out.println(i);
			}
		}
	
	}
}
