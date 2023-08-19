package day10;

public class CalculatorMain {

	public static void main(String[] args) {
	
		Calculator c = new Calculator();
		
		c.num1 = 10;
		c.num2 = 5;
		
		c.sum();
	//	c.print();		
		
		c.sub(10,5);		
		System.out.println(c.mul());		
		System.out.printf("%.2f",c.div(5,2));
		
    Calculator c1 = new Calculator();
		
		c1.num1 = 9;
		c1.num2 = 4;
		
		c1.sum();		
		c1.sub(7,2);		
		System.out.println(c1.mul());		
		System.out.printf("%.2f",c1.div(10,3));
		
		
		
		
		
		
		
		
		
		

	}

}
