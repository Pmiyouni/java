package day05;

import java.util.Scanner;

public class Ex01_grade {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] name = new String[100];  // 이름을 저장하는 문자열형 배열 선언
		int[] kor = new int[100];         // 국어를 저장하는 정수형 배열 선언 
		int[] eng = new int[100];         // 영어를 저장하는 정수형 배열 선언 
		int[] mat = new int[100];         // 수학을 저장하는 정수형 배열 선언  
		int[] total = new int[100];       // 총점을 저장하는 정수형 배열 선언 
		double[] avg = new double[100];   // 평균을 저장하는 실수형 배열 선언 
		char[] grade = new char[100];     // 학점을 저장하는 문자형 배열 선언 
		int cnt = 0; // cnt는 배열 index(요소)를 의미하므로 처음 0부터 시작하기위하여 초기값 설정

		while(true) {
			System.out.println("================성적등록================");
			System.out.println("1. 성적 등록 2. 성적리스트  0. 종료");
			System.out.println();
			System.out.print("메뉴 선택>   ");
			int menu = sc.nextInt(); // 메뉴 입력 받음
						
			// cnt 변수를 아용하여 배열의 index를 작성
			if (menu == 1) {    // 메뉴 중 1.성적 등록이냐?
				System.out.print("학생 이름  >");
				name[cnt] = sc.next();
				System.out.print("국어      >");
				kor[cnt] = sc.nextInt();
				System.out.print("영어      >");
				eng[cnt] = sc.nextInt();
				System.out.print("수학      >");
				mat[cnt] = sc.nextInt();

				total[cnt] = kor[cnt] + eng[cnt] + mat[cnt]; //총점 구하기 
				avg[cnt] = total[cnt] / (double) 3; // 평균 구하기 

				if (avg[cnt] >= 90) { // 학점 구하기
					grade[cnt] = 'A';
				} else if (avg[cnt] >= 80) {
					grade[cnt] = 'B';
				} else if (avg[cnt] >= 70) {
					grade[cnt] = 'C';
				} else if (avg[cnt] >= 60) {
					grade[cnt] = 'D';
				} else if (avg[cnt] < 60) {
					grade[cnt] = 'F';
				}

				cnt++; // 입력할 때마다 배열 요소를 나타내주는 변수로 하나 증가

			} else if (menu == 2) { // 메뉴 중 2. 성적리스트 이냐?
				System.out.println("이름\t국어\t영어\t수학\t총정\t평균\t학점");
				System.out.println("====================================================");
				
				for (int i = 0; i < cnt; i++) {
					// cnt가 입력 대이터 개수를 저장하였으므로 0부터이니 cnt보다 하나 작은 수만큼 성적 리스트 출력
					System.out.printf("%s\t%d\t%d\t%d\t%d\t%.2f\t%c\n", name[i], kor[i], eng[i],
							mat[i], total[i], avg[i], grade[i]);
					//%,2f는 소수점 이하 2자리
					//%s는 문자열
					//%c는 문자 하나
				}

			} else if (menu == 0) { // 0이면 종료
				break;

			} else {
				System.out.println("메뉴 선택 오류"); // 메뉴선택을 잘못 입력한 경우 
			}
			System.out.println();
		}
			System.out.println("프로그램 종료");
	  }
     }
