package day10;

public class Calculator {
//클래스에서는 3가지(필드 생성자 매서드)만 존재
	
	int num1;
	int num2;
	
	//매서드 형식
	// 접근제한자 리턴타입 매서드명(매개변수){
	//  실행문}
	
	public void sum() {
	System.out.println(num1+num2);
	 
	}
	
	public void sub(int a, int b) {
		if( a > b) {
			System.out.println(a-b);
		} else {
		System.out.println(b-a);
		}
	}
	
	public int mul() {
		return num1 * num2;
	}
	
	public double div(int a, int b) {
		return a / b;
	}
	
	public void print() {
		System.out.printf("%d\t %d\t\n",num1,num2);
	}
	
	
	
	
}
