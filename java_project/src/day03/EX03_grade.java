package day03;

import java.util.Scanner;

public class EX03_grade {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); //콘솔창 입력 위해
		
		while(true) { // 무한 반복
			System.out.println("============== 성       적  ===============");
			System.out.print("국어>  ");
			int kor = sc.nextInt(); // 국어 kor 변수에 입력 숫자 입력
			System.out.print("영어>  ");
			int eng = sc.nextInt(); // 영어 eng 변수에 입력 숫자 입력
			System.out.print("수학>  ");
			int mat = sc.nextInt(); // 수학 mat 변수에 입력 숫자 입력
			
			
			System.out.println("국어\t영어\t수학\t총점\t평균\t학점"); //\t는 출력할 때 tab키 삽입 
			System.out.println("===========================================");
			
			int sum =  kor+eng+mat; // 총점 구하기
			double avg = sum/(double)3; // 평균 구하기, 소수점 때문에 double을 사용 
			//System.out.println(kor+"	"+eng+"  	"+mat);
			System.out.println();
			//System.out.println("총점은			"+sum);
			//System.out.println("평균은                            "+avg);
			
			String hak=""; //String 변수는 초기값을 주어야 함, 만약 char이라면 무조건 초기값을 주어야 함
			if(avg >= 90) {
				 hak ="A학점"; // String hak ="A학점" -> if 마다 네임 스페이스가 다르면 중복 선언 가능({ 즉 중괄호로 구분하면 가능) 
				 // 중괄호 안에 선언된 변수는 그 중괄호 안에서만 사용 가능
			} else if(avg >= 80) {
				hak ="B학점";
			} else if(avg >= 70) {
				hak ="C학점";
			} else if(avg >= 60) {
				hak ="D학점";
			} else if(avg < 60)  {
				hak ="F학점";
			} 
			//System.out.println("학점은                                    "+hak);
			System.out.printf("%d\t%d\t%d\t%d\t%.2f\t%s\n",kor,eng,mat,sum,avg,hak);
			
			System.out.println();
			
			System.out.print("계속 성적 입력할까요?(Y/y)>");
			
			String tryLogin = sc.next();			
			if (!tryLogin.equals("Y") && !tryLogin.equals("y")) {
				break;
			}
		}
		System.out.println();	
		System.out.println("성적프로그램 종료");
	}
}
