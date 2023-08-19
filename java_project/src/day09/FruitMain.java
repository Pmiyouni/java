package day09;

public class FruitMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Fruit apple = new Fruit(); //new Fruit() 생성자
		 // 생성자가 없으면 자동 생성(컴파일시)
		apple.name= "사과";
		apple.color = "빨강";
		apple.isSeed = true;
		apple.print();
    	//	Fruit.banana =new  Fruit("바나나");
		//Fruit.banana =new  Fruit("바나나","노랑");
	
		//호출하는 생성자
		
		Fruit banana =new  Fruit("바나나");
		banana.color = "노랑";
		banana.isSeed = true;
		banana.print();
		
	
//		Fruit melon =new  Fruit("멜론","초록");
//		melon.isSeed =true;
//		melon.print();
		
		Fruit orange =new Fruit("오렌지","주황",true);
		orange.print();
		
		
		//Fruit banana =new  Fruit("바나나");
		//banana.print();
		// 결과는 바나나 null false(기본값)
		
		
		//Fruit melon =new  Fruit("멜론");
		//melon.print();
		//이런경우 ??
		//null  null  false
	}

}
