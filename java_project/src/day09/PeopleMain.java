package day09;

public class PeopleMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	Peolple  p = new Peolple();// 첫번째 생성자
	p.setName("홍길동"); 
	p.setAge(90); 
	p.ageUp();
	p.print();
	
	Peolple  p1 = new Peolple("이순신", 80);// 두번째 생성자
	p1.ageUp1(5);
	p1.print();
	
	
	//System.out.println(p.getname()+"만 나이"+ p.koreanAge());
	//System.out.println(p1.getname()+"만 나이"+ p1.koreanAge());
	
	
	
	
	
	
	
	
	
	
	
	}
}
	
	
	
	
	
	 
	
	
	
	
		 
