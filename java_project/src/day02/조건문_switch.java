package day02;

import java.util.Scanner;

public class 조건문_switch {

	public static void main(String[] args) {
//		Scanner sc =  new Scanner(System.in);
//		System.out.print("숫자입력>");
//		//int a = sc.nextInt();
//		String a=sc.next();
//		
//		switch(a) {//범위 표현 안됨. if문으로 대체 가능
//		case "1":
//			System.out.println("1을 선택");
//			break;
//		case "2":
//			System.out.println("2를 선택");
//			break;
//		case "3":
//			System.out.println("3를 선택");
//			break;
//		    default: //else 개념
//				System.out.println("입력 오류(1-3 숫자 입력");
//				
//		}
     
		
		// 월을 입력 받아 해당월의 영어로 출력
//	   Scanner sc =  new Scanner(System.in);
//	   System.out.print("월 입력>");
//       int month = sc.nextInt();
       
//       switch(month) {
//       case 1: 
//    	   System.out.println("January");
//    	   break; // case마다 존재
// break 문이 없으면 switch 문을 나오지 않고 break 문을 만날 때까지 아래의 다른 case 문들을 순차적으로 실행해요.
//       case 2:
//    	   System.out.println("February");
//    	   break;
//       case 3:
//    	   System.out.println("March");
//    	   break;
//       case 4:
//    	   System.out.println("April");
//    	   break;
//       case 5:
//    	   System.out.println("May");
//    	   break;
//       case 6:
//    	   System.out.println("June");
//    	   break;
//       case 7:
//    	   System.out.println("July");
//    	   break;
//       case 8:
//    	   System.out.println("August");
//    	   break;
//       case 9:
//    	   System.out.println("September");
//    	   break;
//       case 10:
//    	   System.out.println("October");
//    	   break;
//       case 11:
//    	   System.out.println("November");
//    	   break;
//       case 12:
//    	   System.out.println("December");
//    	   break;
//    	   default :
//    		   System.out.println("입력 오류");
//          }
      
      // switch 문을 if 문으로 변경
	   Scanner sc =  new Scanner(System.in);
	   System.out.print("월 입력>");
       int month = sc.nextInt();
       
       
       if(month == 1) { // String 일경우 month.equals("1")
    	   System.out.println("January");
       } else if (month == 2) {
    	   System.out.println("February");
       } else if (month == 3) {
    	   System.out.println("March");
       } else if (month == 4) {
    	   System.out.println("April");
       } else if (month == 5) {
    	   System.out.println("May");
       } else if (month == 6) {
    	   System.out.println("June");
       } else if (month == 7) {
    	   System.out.println("January");
       } else if (month == 8) {
    	   System.out.println("August");
       } else if (month == 9) {
    	   System.out.println("September");
       } else if (month == 10) {
    	   System.out.println("October");
       } else if (month == 11) {
    	   System.out.println("November");
       } else if (month == 12) {
    	   System.out.println("December");
       } else  {
    	   System.out.println("입력 오류(1-12월을 입력하세요");
       }
   	}
	}

       
