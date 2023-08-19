package day10;

public class AnimalMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		
		Animal dog = new Animal();
		//dog.name ="강아지"; // private 필드라 직접 대입 안됨
		dog.setName("강아지");
		dog.setSound("멍멍");
		dog.setLeg(4);
	
		
		Animal cat = new Animal();
		
		cat.setName("고양이");
		cat.setSound("야옹");
		cat.setLeg(4);
		
		
		Animal ck = new Animal();
		
		ck.setName("삐약");
		ck.setSound("꼬끼오");
		ck.setLeg(2);
	
		
		Animal s = new Animal();
		
		s.setName("뱀뱀");
		s.setSound("쉭쉭");
		s.setLeg(0);
		
		dog.print();
		cat.print();
		ck.print();
		s.print();
		
		
	
	}
}
