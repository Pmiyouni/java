package ex01;

import java.util.Scanner;// Scanner 대신 *을 적으면 java.util의 전부
    // Scanner는 java.util에서 실행
public class Condition {
	public static void run() {
		// if문 , switch~case
		Scanner s = new Scanner(System.in);
		System.out.print("점수 입력>");
		int grade = s.nextInt();
		String result = "";
		if (grade >= 90) {
			if (grade >= 95) {
				result = "A+";
			} else {
				result = "A0";
			}
		} else if (grade >= 80) {
			if (grade >= 85) {
				result = "B+";
			} else {
				result = "B0";
			}
			
		} else if (grade >= 70) {
			if (grade >= 75) {
				result = "C+";
			} else {
				result = "C0";
			}
			
		} else if (grade >= 60) {
			if (grade >= 65) {
				result = "D+";
			} else {
				result = "D0";
			}
			
		} else {
			result = "F";
		}
		System.out.println("학점 : " + result);

		System.out.print("시간: ");
		int time = s.nextInt();
		switch(time) {
		case 6 :
			System.out.println("일어나세요!");
			break;
		case 9 :
			System.out.println("출근하세요");
			break;
		case 12 :
			System.out.println("점심식사하세요!");
			break;
		case 18:
			System.out.println("퇴근하세요!");
			break;
		default:
			System.out.println("잘못입력");
		}
		
	}//run 종료
} //class 종료
