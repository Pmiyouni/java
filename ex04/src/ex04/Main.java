package ex04;

public class Main {

	public static void main(String[] args) {
		//Juso.run(); 
		// static 이므로 객체를 생성하지 않고
		// 바로 클래스명으로 호출 가능
		// 클래스명.매서드 실행
		StudentDAO dao = new StudentDAO();
		//조회
		//System.out.println(dao.read(11));
		
		//입력
//		Student stu = new Student(20,"박미연","인천","010-6656-3141");
//		dao.insert(stu);
		
		//삭제
		//dao.delete(11);
		
		//수정
		Student stu = new Student(13,"강감찬","속초","010-9999-5555");
		dao.update(stu);
		
		//목록출력
		for(Student vo : dao.list()){
		System.out.printf("%d\t%s\t%s\t%s\n",vo.getNo(),vo.getName(),vo.getJuso(),vo.getPhone());	
		}
		
		
	}
	

}
