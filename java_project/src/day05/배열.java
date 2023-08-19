package day05;

public class 배열 {

	public static void main(String[] args) {
		 
		// 배열 선언 방법 1
		 // 배열 선언(문자형 배열에 값 저장)
		// String names[]와 동일하나 중요하지 않음
		// index가 [0]번째 방은 홍길동
		// index가 [1]번째 방은 이순신
		// index가 [2]번째 방은 심청이
		
		System.out.println(names[0]);
		System.out.println(names[1]);
		System.out.println(names[2]);
	//	System.out.println(names[3]);  index범위 벗어나서 예외발생(에러)
		
		// 배열 선언 방법 2
		String[] names1 = new String[5]; // 5칸짜리 배열 만들기
		// index => [0],[1],[2],[3],[4]
		
				names1[0] = "장동건";
				names1[1] = "원빈";
				names1[2] = "이정재";
				names1[3] = "정우성";
				names1[4] = "이병헌";
		
		// 배열 길이 확인
		System.out.println("배열의 길이 : "+names1.length);
		
//		System.out.println(names1[0]); // 0번째 방의 값 출력
		
		for(int i=0; i<names1.length ; i++) {  
			// 배열의 값을 반복문을 통해 0번째 방부터 4번째 방(5개 배열)까지 출력
			System.out.println(names1[i]);
		}
		
		
		
		
		
		
		
		

		
		
		
		

	}

}
