package day09;

public class Fruit {

	String name;
	String color;
	boolean isSeed;
	
	//만드는 생성자
	public Fruit() {//객체를 생성할때 사용하는 것
		//기본 생성자
	// 특징 1. 클래스 이름과 동일
	   //  2. 리턴타입이 없다
		// 기본생성자는 다른 생성자가 없을때만 자동 생성
	}
	public void print() {
		System.out.printf("%s\t %s\t %b\n",name,color,isSeed);
	}
	
	// 오버로딩 :매개변수를 다르게 해서 동일한 이름을 가질수 있은 것
	// 
	public Fruit(String name ) {
		this.name = name;
	}
	public Fruit(String name,String color ) {
		this.name = name;
		this.color = color;
	}
	public Fruit(String name,String color,boolean isSeed) {
		this.name = name;
		this.color = color;
		this.isSeed = isSeed;
 	}
	//1) public Fruit(String name ) {
	// 	
	//}
	
}
