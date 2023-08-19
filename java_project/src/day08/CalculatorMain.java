package day08;

public class CalculatorMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Calaulator c  = new Calaulator();
		 
		 c.num1 = 10;
		 c.num2 = 5;
		 
		 c.sum();
		 c.sub(6,5);
		 System.out.println(c.mul());
		 System.out.println(c.div(7,3.4));
	}

}
