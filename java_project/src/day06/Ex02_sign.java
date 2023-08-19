package day06;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import javax.swing.text.DateFormatter;

public class Ex02_sign {

	public static void main(String[] args) {
		
		
	// 회원관리 프로그램 
	  Scanner sc = new Scanner(System.in);
	  // 이름, 아이디, 비밀번호 배열 선언
	  String[] name = new String[10]; // 10개 칸의 이름 문자열 배열 선언
	  String[] id = new String[10];  // 10개 칸의 아이디 문자열 배열 선언
	  String[] pw = new String[10];  // 10개 칸의 비밀번호 문자열 배열 선언
	  String[] date = new String[10]; //날짜 배열 선언
	  
	  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy년MM월dd일 hh:mm:ss");
	       // 날짜/시간 타입을 표현할때 사용
	  
	  int cnt  = 0; // 배열의 요소 개수를 세기위한 변수 선언, 0번째 방부터 시작
			  
	  while(true) { //반복
		  System.out.println("================ 마켓커리 ===============");
		  System.out.println("1. 회원 가입  2. 로그인  3. 회원목록    0.종료");
		  System.out.print("선택>  ");
		  int menu =sc.nextInt(); //메뉴 선택
		
		  
			if (menu == 1) {  // 회원 가입
				System.out.print(" 이름 입력>    "); 
				name[cnt] = sc.next(); // 이름 배열 각 칸에 입력
				System.out.print(" 아이디 입력>    ");
				String signid = sc.next();    // signid 변수에 아이디 입력받음 
				boolean a = false; // boolea형 변수를 선언하며 기본값으로 false 를 설정
					for(int i=0; i<cnt; i++) { //0부터 배열 개수 만큼 반복
						if(signid.equals(id[i])) { 
				    //입력받은 id와 배열의 저장된 id가 일치하는지 물어봄
							a = true;  // 일치하면 a 변수의 값을 true로 변경
							break;  // 일치하면 종료
						}
					}
					if(a) {  // a가 true 이냐? 즉 값이 일치하면  true 임
						System.out.println("중복된 아이디 입니다");
						continue;  // 다시 반복으로 입력받아야 함
					} else {
						id[cnt] = signid; // 입력받은 아이디를 아이디 배열 칸에 입력
				}
					
				
				
				System.out.print(" 비밀번호 입력>    ");
				pw[cnt] = sc.next();    // 비밀번호 배열 각 칸에 입력
				LocalDateTime now = LocalDateTime.now(); //현재날짜시간 구하는 문법			
				date[cnt] = dtf.format(now); //날짜 시간을 저장
				cnt++; // 하나 입력시 마다 배열 index 1씩 증가
			} 
			
			else if (menu == 2) { // 로그인

				System.out.print(" 로그인 아이디 입력>    ");
				String i = sc.next();  //i 변수에 로그인 할 아이디 입력
				System.out.print(" 로그인 할 비밀번호 입력>    ");
				String p = sc.next();  //p 변수에 로그인 할 비밀번호 입력
				boolean find = false; //아이디 오류 여부S를 체크할 변수

				for (int j = 0; j < cnt; j++) { // 0부터 배열 요소 개수 -1 까지 배열 index 반복
					if (i.equals(id[j])) { //입력 받은 아이디와 배열 요소의 값과 일치한지?
						 find = true ;  // 아이디가 일치하면 find 에 true로 대입
						      if (p.equals(pw[j])) {  // 입력 받은 비밀번호와 배열 요소의 값과 일치일한지?
						        	 System.out.println("로그인 성공"); //아이디와 비밀번호가 일치하면 로그인 성공
						        	 find = true ;  // 아이디가 일치하면 find 에 true로 대입						        	 
						     	    break; // 로그인 성공 후 탈출
						       } else {
							       System.out.println("비밀번호 오류"); //비밀번호가 다를때
   						        } 
					} //if 문 종료
				} // for 문 종료
			
				if(!find) {    // find가 false 이냐 (아이디가 일치하면 true을 줌)
					System.out.println("아이디 오류");
				} 
				
			} else if (menu == 3) {  //회원 목록
				System.out.println("==============  회원 목록 ===========");				
				System.out.printf("이름\t아이디\t비밀번호\t가입날짜\n");
				System.out.println("=====================================");

				for (int k = 0; k < cnt; k++) { //배열 수 만큼 반복하면서 출력
					System.out.printf("%s\t%s\t%s\t%s\n", name[k], id[k], pw[k], date[k]); 

				}
			} else if (menu == 0) { // 종료일때
				break; 

			} else {  // 메뉴 숫자 잘못 입력시
				System.out.println("다시 입력");

			}

			System.out.println();
		}
		System.out.println("프로그램 종료");

		}

	}
