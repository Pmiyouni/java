package day08;

public class Calaulator {
	int num1;
	int num2;
	//매서드명 sum 리턴타입 없음  매개변수 없음 실행문구 num1+num2 출력
	  public void sum() {
		  System.out.println(num1+num2);
	  }
	
	
	//매서드명 sub 리턴타입 없음  매개변수 int 2개 실행문구 num1-num2 출력
	  public void sub(int a, int b) {
		  System.out.println(a-b);
	  }
	
	
	//매서드명 mul  리턴타입 있음  매개변수 없음 실행문구 필드num1*num2 리턴
	  public int mul() {
		  return num1 * num2;
	  }
	
	
	//매서드명 div  리턴타입 있음  매개변수 int 2개 실행문구 num1/num2 출력
	  public double div(int a, double b) {
		  return a/b;
	  }
	
}
