package day09;

public class Calaulator {

	
	int num1;
	int num2;
	
	public void sum() {
		System.out.println(num1+num2);
	}
	
	public void sub(int a, int b) {
		if( a > b) {
			System.out.println("b가 큰 경우 :"+(a-b));
		} else {
		   System.out.println("a가 큰 경우 : "+(a-b));
	}
	}
	public int mul() {
		return num1 * num2;
	}
   
	public double div(int a, double b) {
		return a/b;
	}

}


