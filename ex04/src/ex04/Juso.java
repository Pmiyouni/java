package ex04;

import java.util.*;

public class Juso {
	public static void run() {
		Scanner s = new Scanner(System.in);
		boolean run = true;
		//샘플데이터
		List<Student>  array  = new ArrayList<Student>();
		
		Student stu = new Student(10,"홍길동","인천","010-5555-6666");
		array.add(stu);
		Student stu2 = new Student(11,"심청이","서울","010-1010-1234");
		  //stu 객체를 중복 사용 가능하려면 Student을 삭제해야함(중복선언이므로) 
		array.add(stu2);
		Student stu3 = new Student(12,"강감찬","부산","010-7895-3030");
		array.add(stu3);
		int last =12; //12까지 입력되었음
		
		while(run) {
		System.out.println("\n=======================================");
		System.out.println("1.등록 |2.목록 |3.조회 |4.수정 |5.삭제 |0.종료");
		System.out.println("========================================");
		System.out.print("메뉴 선택>");
		String menu = s.nextLine();//엔터키까지 들어가야하므로 String 변수 설정
			
		switch(menu) {
		case "0":
			run = false;
			System.out.println("프로그램 종료");
			break;
		case "1":
			Student newStu = new Student(); //새로운 객체 생성, 기본생성자
			               
			newStu.setNo(++last); //학번이 1증가
			System.out.println("<학번>"+ newStu.getNo());//학번가져옴
			System.out.print("이름>");
			newStu.setName(s.nextLine());//입력받아 set
			System.out.print("주소>");
			newStu.setJuso(s.nextLine());
			System.out.print("전화번호>");
			newStu.setPhone(s.nextLine());
			array.add(newStu);
			System.out.println("전체학생수:"+array.size()+"명");
			
			break;
		case "2": //목록
		 for(Student vo : array) {
			 System.out.printf("%d\t%s\t%s\t%s\n",
					 vo.getNo(),vo.getName(),vo.getJuso(),vo.getPhone());
		 }
		 	System.out.println(array.size()+"명이 등록되었습니다");
			break;
		case "3": //조회
			System.err.print("조회할 학번>");
			String search =s.nextLine();
			for(Student vo : array) {
				if(vo.getNo()== Integer.parseInt(search)){
					System.out.println("이름>"+vo.getName());
					System.out.println("주소>"+vo.getJuso());
					System.out.println("전화>"+vo.getPhone());
			   }
			}
			break;
		case "4": // 수정
			System.out.print("수정할 학번> ");
			String update = s.nextLine();
			for(Student vo : array) {
				if(vo.getNo() == Integer.parseInt(update)) {
					System.out.println("이름>"+vo.getName()+"  > ");
					String newName = s.nextLine();
					if(newName!="") vo.setName(newName);
					System.out.println("주소>"+vo.getJuso()+"  > ");
					String newJuso = s.nextLine();
					if(newJuso!="") vo.setJuso(newJuso);
					System.out.println("전화>"+vo.getPhone()+ "  >  ");
					String newPhone = s.nextLine();
					if(newPhone!="") vo.setPhone(newPhone);
					System.out.println(vo.toString());
					break;
					}
				}
			
			break;
		case "5": // 삭제
			System.out.print("삭제할 학번> ");
			String delete = s.nextLine();
			
			for(Student vo : array) {
			if(vo.getNo() == Integer.parseInt(delete)) {
				array.remove(vo); 
			//array에서는 삭제 하지 않지만 vo는 그대로 있으므로 아래 vo.getName 사용 가능 
				System.out.println(vo.getName()+"학생 삭제완료");
				break;
				}
			}
			break;			
		default :
			System.out.println("다시 선택하세요!");
		  } //switch		
		} // while
	}//run
}//class
