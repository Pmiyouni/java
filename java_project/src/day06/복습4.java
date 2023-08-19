package day06;

public class 복습4 {

	public static void main(String[] args) {
		
//		int[] a = {12,3,4,5,34};
//		
//		for(int i = 0 ; i<a.length ; i++) {
//			if( i == a.length-1) {
//			System.out.print(a[i]);
//			break;
//		}else {
//			System.out.print(a[i]+",");
//		}

		
		
//      int[] b = new int[10];
		//b[0] = 8;
		//b 배열에 1~10 값을 넣으시요
		
//		for(int i=1; i<=10; i++) {
//			b[i-1] = i;
//			System.out.println(b[i-1]);
//		}
//		
		
		// c 배열의 총합 출력
//		int[] c = {2,4,6,8,10};
//		int sum=0;
//		for(int i =0; i<c.length; i++) {
//			sum += c[i];
//		}
//		System.out.println(sum);
		
		//d 배열의 0번째 방에 배열 요소의 값을 더하여 총합 구하기
//		int[] d = {10,2,30,15,20};
//		for(int i=1; i<d.length; i++) {
//			d[0] += d[i];
//				}
//		System.out.printf("총합은==>%d",d[0]);
		
		
		// 배열의 요소의 값을 하나 앞칸으로 값을 이동후 0번째 배열 값을 마지막 배열값으로 넣음
		int[] e = {2,4,6,8,10};  // 정답은 {4,6,8,19,2}
		int t = e[0]; //임시저장
		
		for(int i = 1 ; i<e.length ; i++) {
			e[i-1] = e[i];
		}
		
		e[e.length-1] = t; // 마지막 칸에 전에 저장한 임시저장(e[0]값 저장) 값을 대입
		
		for(int i = 0; i < e.length ; i++) {	// 각각의 배열 요소의 값 출력		 
		   System.out.printf("%d 번쨰 숫자 \t %d\n", i, e[i]);
		 }
		
		
	}

}
