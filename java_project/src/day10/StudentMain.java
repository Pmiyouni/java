package day10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentMain {

	public static void main(String[] args) {
	
		// Student 형으로 객체 생성
	//List<Student> list = new ArrayList<Student>();	
	//Student s = new Student();
	//list.add(s); // list 객체에 add 매서드로 s 객체를 추가
	//s는 현재 필드만 가지고 있는 객체임
	//객체마다 각기 다른 기능들을 담당하고 있음
		//System.out.println(list.get(0).name));

	
	// 아래와 비교하여 참고할 것
	//String도 객체임
	//List<String> list1 = new ArrayList<String>(); 
	//String a = new String("안녕");
	//list1.add(a);//list1 객체에 add 매서드(배열에 추가)
	
		
	//String[] list2 = new String[10];
	//String  b = new String("안녕");
	//list2[0] = b; //b배열의 0번째에 넣어줌
		
		
	List<Student> list = new ArrayList<Student>();		

	Scanner sc = new Scanner(System.in);
	
	while(true) {
		System.out.println("=======학사관리시스템======");
		System.out.println("1.학생등록 2.학생리스트 3.학생검색  0.종료");
		System.out.print("메뉴>  ");
		int menu = sc.nextInt();
		
		
		if(menu ==1){ //학생 등록
			Student s = new Student();
			// s 객체를 생성
			// 한번 생성될때마다 heap에 저장
			// s 하나는 100번지 두번째 s는 200번지  계속 만들어지면 list에 이들 주소를 기억함
			// s는 객체지만 변수로 생각
			//스택만 접근 가능
			// int형은 스택에 데이터 저장이므로 ==은 비교
			// String형은 스택에 주소를 기억하고 heap 해당주소에 데이터 저장
			// 
			System.out.print("학번>");
			s.setNo(sc.next());
			System.out.print("이름>");
			s.setName(sc.next());
			System.out.print("학과>");
			s.setDept(sc.next());
			System.out.print("학년>");
			s.setYear(sc.nextInt());
			System.out.println(s.getName()+"학생 등록 완료");
			list.add(s);
			// (?) list에 s 추가
					
		} else if (menu == 2) { //학생리스트
			System.out.println("학번  이름   학과     학년");
			System.out.println("====================");
			for( int i=0; i<list.size(); i++) {
			//system.out.println(list.get(i).getNo()+list.get(i).getName()+list.get(i).getDept()+list.get(i).getYear());
				list.get(i).print();
				// list 어레이 리스트의 i번째
			}
		} else if(menu == 3) { //학셍 검색
			boolean find = false; // 조회 학번 오류를 위한 체크 변수
			System.out.print("조화할 학번>");
			String searchNo =sc.next();//학번 입력 받음
			
			for(int i=0; i< list.size(); i++) {  // 반복하면서 비교하기 위해
				if(searchNo.equals(list.get(i).getNo())) { 
					     //리스트에서 i번째의 학번을 리턴 받아 비교
					list.get(i).print(); // 해당 i번째 데이터를 가져와서 출력
					find = true; // 학번이 같으면 find 값을 변경
				}
			}
				if(!find) {//find가 false이면 학번이 같은 경우가 없는 경우
					System.out.println("조회할 수 없는 학번입니다");
			}
						
		} else if(menu == 0) {
			break;
		}else  {
			System.out.println("다시 입력");
    	}
	}	
	System.out.println("프로그램 종료");
	}

}
