package day02;

public class 반복문_break_continue {

	public static void main(String[] args) {
		//break 는 반복문 종료

//		for(int i=1; i<10; i++) {
//			System.out.println(i);
//			if(i ==4) {
//				break; //반복문 빠져나옴
//			}
//		}
//		
//		for(int i=1; i<=10; i++) {
//		
//			if(i==4) {
//				continue; // 실행하지 않고 건너띄어서 다음 반복하러감
//			}
//			System.out.println(i);
//		}
		
		
		
//            break 와 continue를 사용하여 출력
// 				출력 예시)		
//		        7 * 1  =  7
//				7 * 2  =  14
//				7 * 3  =  21
//				7 * 4  =  28
//
//				7 * 6  =  42
//				7 * 7  =  49
//				7 * 8  =  56

		
		int dan=7;
//      for문 이용	
		System.out.println("for문 이용");	
		for(int i=1; i<=9; i++) {
			if(i == 5) { 
				System.out.println();//공백줄 표시
				continue;
			} else if (i ==9) {
				break;
			} else {
		System.out.println(dan+" * "+i+"  =  "+(dan*i));
		}
		}
		
		
//		while문 사용
		System.out.println("================");	
		System.out.println("while문 이용");	
        int dan2=7;
		int a=0;
		while(a <=9) {
			a++;
			if(a == 5) { 
				System.out.println();
				continue;
			} else if (a ==9) {
				break;
			} else {
		System.out.println(dan+" * "+a+"  =  "+(dan2*a));
		}
		}
		
		
		
		
		
		
		
		
	}

}
