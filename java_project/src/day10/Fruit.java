package day10;

public class Fruit {
	String name;
	String color;
	boolean isSeed;
	
	
	public Fruit() { //기본생성자
			System.out.println("첫번째 생성자");
		
	}
	
	public Fruit(String name) {
		System.out.println("두번째 생성자");
		this.name = name;
	}
	
	public Fruit(String name, String color) {
		System.out.println("세번째 생성자");
		this.name = name;
		this.color = color;
		
	}
	
	public Fruit(String name, String color, boolean isSeed) {
		System.out.println("네번째 생성자");
		this.name = name;
		this.color = color;
		this.isSeed = isSeed;
		
	}
	public void print() {
		System.out.printf("%s   %s   %b\n", name, color,isSeed);
	}
}
