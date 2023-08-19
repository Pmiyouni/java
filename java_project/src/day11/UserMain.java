package day11;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserMain {

	public static void main(String[] args) {
		
		
	Scanner sc = new Scanner(System.in);
	List<User> list = new ArrayList<User>(); //어레이 리스트
		//user 객체를 list 에 저장
	while(true) {
			System.out.println("======회원가입시스템=======");
			System.out.print("1.회원가입 2. 로그인 3. 리스트 0.종료\n");
			System.out.print("메뉴선택>");
			int menu =sc.nextInt();
			
			if(menu ==1 ) { //화원가입
				User user = new User();
				System.out.print("이름>");
				user.setName(sc.next()); // 필드가 private라서 set 매서드 이용
				//객체의 name을 입력받음, 매개변수를 입력받아 보냄
				System.out.print("아이디>");
				user.setId(sc.next());
				System.out.print("비밀번호>");
				user.setPw(sc.next());
				
				list.add(user);
				System.out.println(user.getName()+"회원가입을 축하합니다");
				
			}else if(menu ==2 ) { //로그인
				System.out.print("아이디>");
				String ii = sc.next();
				System.out.print("비밀번호>");
				String pp = sc.next();
				// & | 는 조건 모두 반드시 실행
				//&&는 앞의 조건이 false는 뒤에는 실행 안함
				//||는 앞의 조건이 true이면 뒤에는 실행 안함
				for(int i =0; i<list.size(); i++) {
				if(ii.equals(list.get(i).getId()) && pp.equals(list.get(i).getPw())) {
					// list 의 get 매서드로 i번째 id(private라 getId() 사용)를 가져옴 
					System.out.println("로그인 성공");
					break;
				} if (i == list.size()-1){ 
					// 배열은 0부터이므로 사이즈-1 만큼 돌고 내려왔다면 로그인을 못한 것이므로
						System.out.println("로그인실패");
					}
				}
				
			
			}else if(menu ==3 ) { //리스트
				System.out.println("이름\t아이디\t비밀번호\n가입날짜");
				for(int i =0; i<list.size(); i++) {
					list.get(i).print();
				}
				
				
				
			}else if(menu ==0 ) {
				break;
			} else {
				System.out.println("다시 입력");
			}
			System.out.println();		
		}
		
		System.out.println("프로그램 종료");

	}

}
