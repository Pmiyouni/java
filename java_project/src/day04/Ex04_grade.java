package day04;

import java.util.Scanner;

public class Ex04_grade {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("=======성적=========");
			System.out.print("국어> \t");
			int kor = sc.nextInt();
			System.out.print("영어> \t");
			int eng = sc.nextInt();
			System.out.print("수학> \t");
			int mat = sc.nextInt();
			
			System.out.println("국어\t영어\t수학\t총점\t평균\t학점");			
			System.out.println("============================================");
			//System.out.println(kor+"\t"+eng+"\t"+mat+"\t");
			
			int sum = kor+eng+mat;
			double avg = sum /(double)3;
			
			String hak ="";
			if( avg >= 90 ) {
				hak = "A학점";
			} else if( avg >=80 ) {
				hak = "B학점";
			} else if( avg >=70 ) {
				hak = "C학점";
			} else if( avg >=60) {
				hak = "D학점";
			} else if( avg < 60 ) {
				hak = "F학점";
			}
			
			System.out.printf("%d\t%d\t%d\t%d\t%.2f\t%s\n",kor,eng,mat,sum,avg,hak);
			System.out.println("\n\n");
		}
	}

}
