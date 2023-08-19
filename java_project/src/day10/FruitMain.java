package day10;

public class FruitMain {

	public static void main(String[] args) {
		
		Fruit apple = new Fruit();
		apple.name = "사과";
		apple.color = "빨강";
		apple.isSeed = true;	
		apple.print();
		
		
		Fruit banana = new Fruit("바나나");
		banana.color = "노랑";
		banana.isSeed = true;
		banana.print();
		
		Fruit melon = new Fruit("멜론","초록");
		melon.isSeed = true;
		melon.print();
				
	
		Fruit orange = new Fruit("오렌지","주황",true);
		orange.print();
	}

}
