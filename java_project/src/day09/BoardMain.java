package day09;

public class BoardMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     
		// 생성자가 매ㅐ개변수가 2개임
		 Board  b = new  Board("자바",20,true);
		 b.cntUp();
		 b.print();
		 
		 
		 Board  b1 = new  Board("파이선",30,true);
		 System.out.println(b1.cntUp1(5));
		 b1.print();
		
	}

}
