package ex06;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		//Database.connect(); //static 매서드는 클래스 관리이므로 객체 생성 안하고 클래스.매서드로 사용
		
		ProductDAO dao = new ProductDAO();
		SaleDAO sdao = new SaleDAO();
		
		DecimalFormat df = new DecimalFormat("#,###원");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Scanner s = new Scanner(System.in);
		boolean run = true;
		while(run) {
			System.out.println("\n\n **************** 상품  관리 ******************");
			System.out.println("-----------------------------------------------------");
			System.out.println("1.입력  | 2. 조회 | 3. 목록 | 4. 수정 |5. 삭제  | 0. 종료");
			System.out.println("6.판매정보조회 | 7. 판매정보등록");
			System.out.println("-----------------------------------------------------");
			System.out.print("선택> ");
			String menu = s.nextLine();
			
			switch(menu) {
			case "1": //입력
				ProductVO pro1 = new ProductVO(); //객체 생성
				System.out.print("상품 이름>");
				String pname = s.nextLine();
				if(pname =="") {
					System.out.println("입력을 종료합니다");
					break;
				} else {
					pro1.setPname(pname);
					while(true) { // 숫자를 입력할때 까지 반복
						System.out.print("상품가격>");
						String pprice = s.nextLine();
						if(isNumber(pprice)) {//리턴값이 true이냐?
							pro1.setPprice(Integer.parseInt(pprice));
							dao.insert(pro1);
							System.out.println("입력 완료");
					       break;//while 종료
						}
					}
				}
				break;//case 종료
			case "2"://조회
				while(true) {
					System.out.print("조회 상품코드>");
					String pcode = s.nextLine();
					if(pcode == "")break;
					if(isNumber(pcode)) {// 코드를 숫자로 입력했는지 여부 알아봄
						ProductVO pro2 = dao.read(Integer.parseInt(pcode));
						if(pro2.getPname() == null) {
							System.out.println("해당 상품 없음");
						} else {
							System.out.println("상품이름 :"+pro2.getPname());
							System.out.println("상품가격 :"+df.format(pro2.getPprice()));
							break;
						}//else
					} //if
			}//while
				break;
			case "3": // 목록
				for(ProductVO vo : dao.list()) {
					// dao 객체의 list()매서드의 값을 productVO에 대입
					System.out.printf("%d\t%-20s\t%s\n",//-20은  상품명을 20 자리 잡음(왼쪽 정렬)
					vo.getPcode(),vo.getPname(),df.format(vo.getPprice()));
					//df.format으로 하면 ,가 있으므로 %d 가 아닌 %s로 작성
					System.out.println("========================================");
				}	System.out.println(dao.list().size()+"개 상품 등록되어습니다"); 
				break;
			case "4":
				System.out.print("수정할 코드>");
				String pcode2 = s.nextLine();
				if(pcode2 == null) break;
				 if(isNumber(pcode2)) {
					 ProductVO pro4 = dao.read(Integer.parseInt(pcode2));
					  if(pro4.getPname() == null) {
						  System.out.println("수정할 상품 존재하지 않습니다!");
					  }  else {
					  System.out.println("상품이름:"+pro4.getPname());
						  System.out.println("상품가격:"+df.format(pro4.getPprice()));
						 	System.out.print("수정 상품은>");					  
						   String newName=s.nextLine();
							if(newName!="") pro4.setPname(newName);
							System.out.print("수정 가격은>");		
							String newPrice=s.nextLine();
							if(newPrice!="") pro4.setPprice(Integer.parseInt(newPrice));
							System.out.print("수정하실래요(y/Y)?");
						    String sel = s.nextLine();
						  if(sel.equals("y")||sel.equals("Y")||sel.equals("ㅛ")){
							  try {
								  dao.update(pro4);
								  System.out.println("상품수정완료");
							  } catch(Exception e) {
								  System.out.println("상품수정"+e.toString());
							  }
						  }  
					  } 
				 }
				 
				break;
			case "5":
				System.out.print("삭제코드>");
				String pcode = s.nextLine();
				if(pcode == null) break;
				 if(isNumber(pcode)) {
					 ProductVO pro2 = dao.read(Integer.parseInt(pcode));
					  if(pro2.getPname() == null) {
						  System.out.println("삭제할 상품 존재하지 않습니다!");
					  }  else {
					  System.out.println("상품이름:"+pro2.getPname());
						  System.out.println("상품가격:"+df.format(pro2.getPprice()));
						  System.out.print("삭제하실래요(y/Y)?");
						  String sel = s.nextLine();
						  if(sel.equals("y")||sel.equals("Y")||sel.equals("ㅛ")){
							  try {
								  dao.delete(Integer.parseInt(pcode));
								  System.out.println("상품삭제완료");
							  } catch(Exception e) {
								  System.out.println("상품삭제"+e.toString());
							  }
					
						  }  //if
					  } //if
				 }//if
				
				break;
			case "6":
				System.out.print("조회할 코드>");
				pcode = s.nextLine();
				if(pcode =="")break;
				if(isNumber(pcode)==false)break;
				ProductVO pro3 = dao.read(Integer.parseInt(pcode));
				if(pro3.getPname()==null) {
					System.out.println("상품 존재하지 않습니다");
				} else {
					System.out.println("상품이름:  "+pro3.getPname());
					System.out.println("상품가격:  "+df.format(pro3.getPprice()));
					System.out.println("수량\t    가격\t         금액\t       판매일");
					for(SaleVO vo: sdao.list(Integer.parseInt(pcode))) {
						System.out.printf("%d\t%s\t%s\t%s\n",vo.getQnt(),
								df.format(vo.getSprice()),
								df.format(vo.getQnt()*vo.getSprice()),
								sdf.format(vo.getSdate()));
						        }
				}
							
				break;
			case "7": //판메등록
				SaleVO so = new SaleVO(); //객체 생성
				System.out.print("상품 코드>");
				pcode = s.nextLine();
				if(pcode =="") {
					System.out.println("등록 종료");
					break;
				}
				if(isNumber(pcode)== false) {
					System.out.println("숫자로 입력");
					break;
				}
				ProductVO pro7 = dao.read(Integer.parseInt(pcode));
				
				if(pro7.getPname()==null) {
					System.out.println("상품 존재하지 않습니다");
				} else {
					System.out.println("상품이름:  "+pro7.getPname());
					System.out.println("상품가격:  "+df.format(pro7.getPprice()));
						
					System.out.println("--------------------------------------");
					
					while(true) { 		
						
							System.out.print("판매수량> ");
							String qnt = s.nextLine();
							System.out.print("판매가격:"+pro7.getPprice()+"원 > ");
							String sprice = s.nextLine();
							if(isNumber(qnt)&& isNumber(sprice) ) {//리턴값이 true이냐?
								so.setPcode(Integer.parseInt(pcode));
								so.setQnt(Integer.parseInt(qnt));
								so.setSprice(Integer.parseInt(sprice));
								sdao.sinsert(so);
								System.out.println("입력 완료");
						       break;
							}
				     }
				}
				break;//case 종료	
			case "0":
				run = false;
				System.out.println("프로그램 종료합니다");
				break;
			default :
				System.out.println("선택오류..다시 선택하세요!");
			}
		}
	}//main
	// 숫자인지 판별하는 매서드
		public static boolean isNumber(String str) {
			try {
				int number = Integer.parseInt(str);//문자를 정수로 변환
				return true;
			}catch(Exception e) {
				System.out.println("숫자로 입력하세요!");
				return false;
			}
		}
}//class