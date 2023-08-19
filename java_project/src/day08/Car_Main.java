package day08; 

public class Car_Main { 
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Car c1 = new Car(); // 클래스명 객체명  = new 클래스명();		
		Car c2 = new Car();
		
		c1.name = "그랜저"; //객체명.속성명 = 속성값;
		c1.tire = "한국";
		c1.color = "검정";
		c1.speed = 5;
		c1.run();  //객체명.매서드명(); 메소드 호출
		System.out.println(c1.name+"\t"+c1.tire+"\t"+c1.color+"\t"+c1.speed);
		
		
		c2.name ="제네시스";
		c2.tire= "넥센";
		c2.color = "검정";
		c2.speed = 10;
		c2.run();
		System.out.println(c2.name+"\t"+c2.tire+"\t"+c2.color+"\t"+c2.speed);
		
		//c3 객체 민들고
	    //c3은 객체변수 또는 참조변수
		//c3객체의 run()메서드 호출	
		
		Car c3 = new Car();
		c3.name = "소나타";
		c3.tire = "금호";
		c3.color = "노랑";
		c3.speed = 8;
		c3.run(); //객체 내 존재하지 않지만 메서드 호출 
		c3.run(); // 두번 호출함
		System.out.println(c3.name+"\t"+c3.tire+"\t"+c3.color+"\t"+c3.speed);
		// 메서드 호출 위치 상관없음
		
		System.out.println(c1.getcolor());
		System.out.println(c2.getcolor());
		System.out.println(c3.getcolor());
		//System.out.println(c1.run()); //에러인 이유는 run매서드의 리턴타입이 void이기 때문
        // 돌려주는 값이 없으므로 출력이 안됨  
		
		c1.speedrun(9);
		System.out.println(c1.name+"\t"+c1.tire+"\t"+c1.color+"\t"+c1.speed);
		
		//c1.c2.c3의 int 인 getSpeed매서드 호출	
		System.out.println(c1.getspeed()); //리턴값 받아서 출력
		System.out.println(c2.getspeed());
		System.out.println(c3.getspeed());
		
	}

}
