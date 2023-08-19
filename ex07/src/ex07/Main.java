package ex07;

import java.text.*;
import java.util.*;

import ex07.ProductVO;
import ex07.SaleVO;

public class Main {

	public static void main(String[] args) {
		ProductDAO dao = new ProductDAOImpl();
		SaleDAO sdao = new SaleDAO();

		Scanner s = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("#,###원");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

		boolean run = true;
		while (run) {
			System.out.println("\n\n **************** 상품  관리 ******************");
			System.out.println("-----------------------------------------------------");
			System.out.println("1.입력  | 2. 조회 | 3. 목록 | 4. 수정 |5. 삭제  | 0. 종료");
			System.out.println("6.상품별 매출조회  | 7. 매출등록 | 8. 상품별 매출 현황");
			System.out.println("-----------------------------------------------------");
			System.out.print("선택> ");
			String menu = s.nextLine();

			switch (menu) {
			case "0": // 종료
				run = false;
				System.out.println("프로그램 종료!!");
				break;
			case "1": // 입력
				ProductVO pro = new ProductVO();
				System.out.print("상품이름> ");
				pro.setPname(s.nextLine());
				pro.setPprice(input("상품가격: "));
				try { //throws Exception 했기때문 여기서 작성
					dao.insert(pro);
					System.out.println("상품등록완료!!");
				} catch (Exception e) {
					System.out.println("상품등록 오류입니다");
				}
				break;
			case "2": // 조회
				while (true) {
					System.out.print("조회 상품코드> ");
					String pcode = s.nextLine();
					if (pcode == "")
						break;

					try {
						ProductVO vo = dao.read(Integer.parseInt(pcode));
						if (vo.getPname() == null) {
							System.out.println("해당 상품 존재하지 않습니다");
						} else {
							System.out.println("상품이름: " + vo.getPname());
							System.out.println("상품가격: " + df.format(vo.getPprice()));
						}
					} catch (Exception e) {
						System.out.println("상품조회 오류입니다");
					}
				}
				break;
			case "3": // 목록
				try {
					for (ProductVO vo : dao.list()) {
						System.out.printf("%d\t%-15s\t%s\n", vo.getPcode(), vo.getPname(), df.format(vo.getPprice()));
					}
					System.out.println(dao.list().size() + "개 상품 등록되었습니다");
				} catch (Exception e) {
					System.out.println("목록 출력 오류입니다");
				}
				break;
			case "4": // 수정
				System.out.print("수정할 상품코드> ");
				String pcode = s.nextLine();
				if(pcode=="")break;
				try {
					ProductVO pro3 = dao.read(Integer.parseInt(pcode));
					if (pro3.getPname() == null) {
						System.out.println("수정 상품 없습니다");
					} else {
						System.out.println("상품이름: " + pro3.getPname());
						System.out.print("새로운 상품 이름> ");
						String pname = s.nextLine();
						if (pname != "")
							pro3.setPname(pname);

						System.out.println("상품가격: " + df.format(pro3.getPprice()));
						int price = input("새로운 상품 가격> ");
						if (price != 0)
							pro3.setPprice(price);

						System.out.print("수정하실래요(y)?");
						String sel = s.nextLine();
						if (sel.equals("ㅛ") || sel.equals("y") || sel.equals("Y")) {
							dao.update(pro3);
							System.out.println("상품 수정 완료!!");
						}
					}
				} catch (Exception e) {
					System.out.println("상품정보수정 실패!!"+e.toString());
				}

				break;
			case "5": // 삭제
				System.out.print("삭제 상품코드> ");
				pcode = s.nextLine();

				try {
					ProductVO pro2 = dao.read(Integer.parseInt(pcode));
					if (pro2.getPname() == null) {
						System.out.println("삭제 상품 없습니다");
					} else {
						System.out.println("상품이름: " + pro2.getPname());
						System.out.println("상품가격: " + df.format(pro2.getPprice()));
						System.out.print("삭제하실래요(y)?");
						String sel = s.nextLine();
						if (sel.equals("ㅛ") || sel.equals("y") || sel.equals("Y")) {
							dao.delete(Integer.parseInt(pcode));
							System.out.println("상품 삭제 완료!!");
						}
					}
				} catch (Exception e) {
					System.out.println("상품삭제 오류입니다");// 연결된 판매정보 있으면 오류
				}
				break;
			case "6":
				int code = input("조회할 상품코드 ");
				if(code == 0) {
					System.out.println("조회를 종료합니다");
					break;
				} else {
					try {
						ProductVO pro4 = dao.read(code);
						if(pro4.getPname()==null) {
							System.out.println("조회할 상품 없음");
						} else {
							System.out.println("상품이름: " + pro4.getPname());
							System.out.println("상품가격: " + df.format(pro4.getPprice()));
							System.out.println("----------------------");
							for(SaleVO vo: sdao.list(code)) {
								System.out.printf("%d\t%d\t%s\t%s\t%s\n", vo.getPcode(),
									vo.getQnt(),df.format(vo.getSprice()),
									df.format(vo.getQnt()*vo.getSprice()),
									sdf.format(vo.getSdate()));
							}
						}
						
					} catch (Exception e) {
						System.out.println("상품별 판매목록"+e.toString());
						
					}
				}
				
				break;
			case "7":
				
				code = input("등록할 상품코드 ");
				if(code == 0)  {
					System.out.println("등록 종료");
					break;
				}
				try {
				ProductVO pro4 = dao.read(code);
				if(pro4.getPname()==null) {
					System.out.println("상품 존재하지 않습니다");
				} else {
					System.out.println("상품이름:  "+pro4.getPname());
					System.out.println("상품가격:  "+df.format(pro4.getPprice()));
						
					System.out.println("--------------------------------------");
					int qnt =input("상품수량");
					SaleVO svo =new SaleVO();
					svo.setPcode(code);
					svo.setQnt(qnt);
					int sprice =input("판매가격");
					if(sprice == 0) svo.setSprice(pro4.getPprice());
					else svo.setSprice(sprice);
					sdao.insert(svo);
					System.out.println("판매등록 완료");
					
				}
				} catch(Exception e) {
					System.out.println("매출등록"+e.toString());
				}
			case "8":   //상품별 매출 현황
				int sum_price = 0;  // 총판매금액 누적합계 변수
				int sum_qnt =0;     // 총수량 누적 합계 변수 
				
				for(SaleVO vo :sdao.sum_list()) {  //Arraylist 사용
					System.out.printf("%d\t%-20s\t%d\t%s\n",
							vo.getPcode(),vo.getPname(),
							vo.getQnt(),
							df.format(vo.getSprice()));
					sum_price += vo.getSprice(); //가격 누적
					sum_qnt += vo.getQnt();  //수량 누적
					
				}
				System.out.println("==========================================");
				System.out.printf("총판매수 :%d\t  총판매금액: %s\n", 
						        sum_qnt,df.format(sum_price));
				break;//case 종료	
			default:
				System.out.println("메뉴 다시 선택하세요!!");
			} // switch
		} // while
	} // main
	
	
    // 가격 입력하여 정수(숫자)로 입력
	public static int input(String title) { // 매개변수를 문자열로, 리턴값은 정수로
		int num = 0;  
		Scanner s = new Scanner(System.in);
		while (true) {
			System.out.print(title + ">"); //매개변수로 받은 문자열 출력
			try {
				String str = s.nextLine(); //데이터 입력
				if (str == "") { //입력을 안하고 엔터키 치면 
					return 0;     //0 리턴
				} else {
					return Integer.parseInt(str);//입력 문자열이 있으면 숫자로 바꾸어 리턴
				}
			} catch (Exception e) { // 숫자 입력이 아니면 
				System.out.println("숫자로 입력하세요");
			}
		}
	}
}// class
