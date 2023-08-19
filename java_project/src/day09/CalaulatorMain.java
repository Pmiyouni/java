package day09;

public class CalaulatorMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Calaulator c = new Calaulator();
		
		
		//String a= "홍길동";
		//String b = new String("홍길동")
		 // 동일한 내용으로 String은 클래스임
				
		c.num1 = 10;
		c.num2 = 5;
		
		c.sum();
		c.sub(5, 4);
		
		System.out.println(c.mul());
		System.out.printf("%.2f",c.div(10,2.3));
		
		
		
		
		
	}

}
