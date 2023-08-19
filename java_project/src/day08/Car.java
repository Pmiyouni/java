package day08; //패키지 선언

public class Car {   //클래스 선언
	  // 필드(인스턴스 변수)
	String name;  // 멤버변수 선언
	String tire;
	String color;
	int speed;
	
	public void run() { // 매서드는 클래스 안에 위치
		// 매서드의 이름은 run 
		// void는 리턴 값이 없음
		speed = speed +2; //기능
		
	}
	

	public String getcolor() { //매소드 정의
		return color; // 스트링 타입의 color 돌려줌(반드시 String 형)
	}
	
    public void speedrun(int a) {//void는 리턴 값이 없음
    	    // // 매개변수는 호출할때 a를 넘겨줌(int형으로)		
    	speed += a; 
	    }
    
  // public void speedrun(int speed) {
  //  	this.speed = this.speed +speed;  // 내자신을 갖고 있을때 this로 표현	
  //   	    }
    
     //c1.c2.c3의 int 인 getSpeed 매서드를 만드시오
  	//실행문구는 speed 리턴	
    public int getspeed() {
    	return speed;
    }
    
    
    
}
