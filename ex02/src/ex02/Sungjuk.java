package ex02;

import java.util.*;

public class Sungjuk {

	public static  void run() { //static 사용하면 객체 생성을 하지 않아도 됨
		Scanner s = new Scanner(System.in); // s는 변수
		List<ScoreVO> array = new ArrayList<>();
		
		ScoreVO score = new ScoreVO("2023-1","홍길동",90,77,80);
		array.add(score);
		 score = new ScoreVO("2023-2","심청이",98,96,85); //선언은 한번만 가능, ScoreVO 지워야함
		array.add(score);
		 score = new ScoreVO("2023-3","강감찬",89,92,97);
		array.add(score);
		int count =3;
		
		boolean run = true;
		
		while(run) {
		System.out.println("\n\n ==============성적 관리===============");
		System.out.println("---------------------------------------------");
		System.out.println("1.입력 | 2.조회 | 3.목록 | 4.수정 |  5.삭제 | 0.종료");
		System.out.println("---------------------------------------------");
		System.out.print("메뉴 선택>  ");
		String menu = s.nextLine();
		
		switch(menu) {
		case "0": //종료
			System.out.println("프로그램 종료");
			run = false;
			break;
		case "1": //입력
			score = new ScoreVO();
			score.setNo("2023-"+(count+1));
			System.out.println("학번>"+ score.getNo());
			System.out.print("이름>");
			score.setName(s.nextLine());
			System.out.print("국어>");
		    score.setKor(Integer.parseInt(s.nextLine())); // Integer.parseInt는 문자를 숫자로 변환
		      //nextLine()는 앤터키 전 까지의 문자를 받으므로 이것을 점수에 사용하여 연산하여야 하므로 정수로 변환 
		    System.out.print("영어>");
		    score.setMat(Integer.parseInt(s.nextLine()));
		    System.out.print("수학");
		    score.setEng(Integer.parseInt(s.nextLine()));
		    array.add(score); // 입력을 위해 array에 추가
		    count++; // 학번을 위해 카운트 증가
		    System.out.println("입력완료!");			
			break;
		case "2":  //조회
			System.out.print("조회할 이름 입력>");
			String search = s.nextLine();
			score = search(array, search);
			if(score.getName()== null) {
				System.out.println(search+"학생이 없습니다");
			} else {
				score.print_port();
			}
//			for(ScoreVO vo : array) {
//				if(search.equals(vo.getName())) {
//					vo.setTot(vo.getKor()+vo.getEng()+vo.getMat());
//					vo.setAvg(vo.getTot()/3.);
//					vo.setGrade(getGrade(vo.getAvg())); 
//					vo.print_port(); //세로 출력 매서드
//				}
//			}
			break;
		case "3":  //목록 출력
			for(ScoreVO vo : array) {
				vo.setTot(vo.getKor()+vo.getEng()+vo.getMat());
				// get으로  세개의 과목 점수를 가져와서
				// setTot 호출하며 총점 구한 값을 보내 필드에 값 대입
				vo.setAvg(vo.getTot()/3.); // setAvg 호출하며 평균 구한 값을 보내 필드에 값 대입
				vo.setGrade(getGrade(vo.getAvg())); 
				// String grade = getGrade(vo.getAvg());
				// vo.setGrade(grade); 와 동일
				//같은 클래스에 있는 getGrade를 실행하여(매개변수 avg를 보내고) grade를 리턴받아 
				// setGrade에 보내서 필드에 값을 대입
				
				vo.print_land(); // 가로 출력 매서드
			}
			break;
		case "4":
			
			
			if(score.getName()== null) {
				System.out.println(update+"학생이 없습니다");
			} else {				
			
//			System.out.println("\n\n =수정할 데이터=========");
//			System.out.println("-----------------------------");
//			System.out.println("1.국어 | 2.영어 | 3.수학 | 0.종료");
//			System.out.println("------------------------------");
//			System.out.print("수정 과목 선택>  ");
//			String m = s.nextLine();
			System.out.print("수정 이름 입력>");
			String update = s.nextLine();			
			System.out.print("국어점수 입력>");
			int k = s.nextInt();
			System.out.print("영어점수 입력>");
			int e = s.nextInt();
			System.out.print("수학점수 입력>");
			int m = s.nextInt();
			score = cal(array, update, k,e,m);
			
			if(score.getName()== null) {
				System.out.println(update+"학생이 없습니다");
			} else {
				System.out.println("수정 완료!");
			}
				
			break;
			
//			System.out.print("삭제 이름 입력>");
//			String delete = s.nextLine();
//			score = search(array, delete);
//			if(score.getName()== null) {
//				System.out.println(delete+"학생이 없습니다");
//			} else {
			     
//				array.remove(score);
//				System.out.println("삭제 완료!");
//			}
//			}
//			break;
			
		case "5":
			System.out.print("삭제 이름 입력>");
			String delete = s.nextLine();
			score = search(array, delete);
			if(score.getName()== null) {
				System.out.println(delete+"학생이 없습니다");
			} else {
				array.remove(score);
				System.out.println("삭제 완료!");
			}
			
			break;
		
		default:
			System.out.println("입력 오류..메뉴 다시 선택하세요!");
		
		}
		
		
		
		System.out.println();
		}//while
		
	}// run
		// 학점구하기

	public static String getGrade(double avg) {// 필드가 static 이라 매서드를 static으로 함
		String grade = "";
		if (avg >= 90) {
			if (avg >= 95) {
				grade = "A+";
			} else {
				grade = "A0";
			}

		} else if (avg >= 80) {
			if (avg >= 85) {
				grade = "B+";
			} else {
				grade = "B0";
			}

		} else if (avg >= 70) {
			if (avg >= 75) {
				grade = "C+";
			} else {
				grade = "C0";
			}

		} else if (avg >= 60) {
			if (avg >= 65) {
				grade = "D+";
			} else {
				grade = "D0";
			}

		} else {
			grade = "F";
		}

		return grade;
	}

	// 검색하기 매서드
	public static ScoreVO search(List<ScoreVO> array, String name) {
		ScoreVO vo = new ScoreVO(); // ScoreVO 객체 생성
		for (ScoreVO score : array) { // for~each,array를 score에 넣음
			if (score.getName().equals(name)) {
				score.setTot(score.getKor() + score.getEng() + score.getMat());
				score.setAvg(score.getTot() / 3.);
				score.setGrade(getGrade(score.getAvg()));
				vo = score;
			}
		}
		return vo;

	}
	public static ScoreVO cal(List<ScoreVO> array, String name, int kor, int eng, int mat ) {
		ScoreVO vo = new ScoreVO(); // ScoreVO 객체 생성
		for (ScoreVO score : array) {
			if (score.getName().equals(name)) {
				if(kor != 0) score.setKor(kor);
				if(eng != 0) score.setKor(eng);
				if(mat != 0) score.setKor(mat);
				       
			vo.setTot(vo.getKor()+vo.getEng()+vo.getMat());
			vo.setAvg(vo.getTot()/3.);
			vo.setGrade(getGrade(vo.getAvg())); 
			vo.print_port(); //세로 출력 매서드}
			}
		}
	}
}// class
