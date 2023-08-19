package day10;

import java.util.ArrayList;
import java.util.List;

public class ArrayListEx {

	public static void main(String[] args) {
	
		String[] a= new String[10];
		a[0] = "안녕";
		a[1] = "반가워요";
		a[2] = "잘있어요";
		
		a[0] ="안녕하세요"; // 값 대입
		System.out.println(a[0]); // 배열 출력
				
		ArrayList<String> b = new ArrayList<String>(); //어레이리스트 생성
		b.add("안녕"); // b[0]번째 값 추가  //add는 매서드
		b.add("반가워요"); // b[1]번째 값 추가
		b.add("잘있어요"); // b[2]번째 값 추가
		System.out.println(b.get(0)); // 값 확인
		b.set(0, "안녕하세요");  // 0번째 값 변경
		  // set는 매서드, 매개변수는 2개
		
		
		for( int i =0; i<3; i++) { //a 배열의 값 출력
			System.out.println(a[i]);
		}		
		
		// b.size() 는 매서드로  배열의 길이를 의미함(길이가 가변적일때)
		// length 는 배열의 값 고정일때  
		for( int i =0; i<b.size(); i++) {
			System.out.println(b.get(i)); //어레이 리스트에서 값을 가져와서 출력
			// 소괄호() 있으면 생성자나 매서드
			// get는 매서드, 매개변수 1개(int)
		}
	}
}

     //arraylist // 정해진 배열 개수가 있는 것이 아니고 값이 들어갈때마다 증가
	 //List<String> b = new ArrayList<String>(); //인터페이스에서는 List로 