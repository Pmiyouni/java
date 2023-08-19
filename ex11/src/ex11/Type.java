package ex11;
import java.util.*;
public class Type { //유형 서브메뉴 
	public static void run() { // static이므로 클래스 이름으로 호출 가능
		Scanner s=new Scanner(System.in);
		boolean run=true;
		
		CampTypeDAO tdao=new CampTypeDAO();
		CampDAO cdao=new CampDAO();
		
		while(run) {
			System.out.println("\n\n**************** 캠핑장 유형 관리 *********************");
			System.out.println("------------------------------------------------------");
			System.out.println("|1.유형목록|2.캠핑장유형등록|3.캠핑장유형삭제|0.메뉴|");
			System.out.println("------------------------------------------------------");
			System.out.print("선택>");
			String menu=s.nextLine();
			switch(menu) {
			case "0":
				run=false;
				System.out.println("메뉴로 돌아갑니다!");
				break;
			case "1": //유형 목록
				List<TypeVO> tarray=tdao.list();
				for(TypeVO vo:tarray) { 
					System.out.printf("%s\t%s\n",vo.getTno(), vo.getTname());
				}
				break;
				
			case "2": //캠핑장 유형 목록
				System.out.print("캠핑장번호>");
				String cno=s.nextLine();
				if(cno=="") {
					System.out.println("유형 등록을 취소합니다.");
					break;//switch
				}else {
					CampVO cvo=cdao.read(cno); 
					if(cvo.getCname()==null) {
						System.out.println("등록된 캠핑장없습니다.");
					}else {
						System.out.println("캠핑장이름>" + cvo.getCname());
						System.out.println("-------------------------------------------");
						while(true) {
							
							List<CampTypeVO> array=tdao.list(cno);
							
							if(array.size()==0) {
								System.out.println("등록된 유형이 없습니다.");
							}else {
								for(CampTypeVO vo:array) {
									System.out.printf("%d:%s | ", vo.getTno(),vo.getTname());
								}
								System.out.println("\n-------------------------------------------");	
							}
							//전체유형
							List<TypeVO> taarray=tdao.list();
							//유형 전체 목록 매서드 결과를 유형list에 저장 
							for(TypeVO vo:taarray) {
								System.out.printf("%d:%s | ", vo.getTno(),vo.getTname());
							}
							System.out.println("\n-------------------------------------------");	
							System.out.print("유형번호>");
							String tno=s.nextLine();
							if(tno=="") {
								System.out.println("유형 등록을 취소합니다.");
								break; //while
							}else {
								int error=checkFno(tno, array, taarray); 
																
								if(error==0) { 
									tdao.insert(cno, Integer.parseInt(tno));						    
									System.out.println("유형 등록완료!");
								}
							}
						}
					}
				}
				break; 
			case "3":
				System.out.print("캠핑장번호>");
				cno=s.nextLine();
				if(cno=="") {
					System.out.println("유형 삭제를 취소합니다.");
				}else {
					CampVO cvo=cdao.read(cno);
					if(cvo.getCname()==null) {
						System.out.println("등록된 캠핑장이 없습니다.");
					}else {
						System.out.println("캠핑장이름:" + cvo.getCname());
						while(true) {
							
							List<CampTypeVO> array=tdao.list(cno);
							if(array.size()==0) {
								System.out.println("등록된 유형이 없습니다.");
								break;
							}else {
								for(CampTypeVO vo:array) {
									System.out.printf("%d:%s | ", vo.getTno(),vo.getTname());
								}
								System.out.println("\n------------------------------------------");
								System.out.print("삭제할 유형 번호>");
								String tno=s.nextLine();
								if(tno=="") {
									System.out.println("유형 삭제를 취소합니다.");
								}else {
									int error=checkDno(tno, array); 
																		
									if(error==0) { 
										tdao.delete(cno, Integer.parseInt(tno));										
										System.out.println("유형 삭제완료!");
										break;
									}
								}
							}
						}
					}
				}
				break;
			default:
				System.out.println("메뉴를 다시선택하세요!");
			}//switch
		}//while
	}//run
	
	//삭제할 유형번호가 있는지 체크하는 메서드
	public static int checkDno(String tno, List<CampTypeVO> array) {
		int error=0;
		try {
			int no=Integer.parseInt(tno); 
			boolean find=false;
			for(CampTypeVO vo:array) { 
				if(vo.getTno()==no) find=true; 
				
			}
			if(find==false) {
				System.out.println("등록되지않은 유형 번호입니다.");
				error=1; 
			}
		}catch(Exception e) {
			error=2; 
			System.out.println("숫자로입력하세요!");
		}
		return error; //에러값 리턴
	}
	
	//유형번호를 체크하는 메서드
	public static int checkFno(String tno, List<CampTypeVO> array, List<TypeVO> tarray) {
		int error=0;
		try {
		     int  no=Integer.parseInt(tno); //유형 번호를 숫자로 변경
			
			boolean find=false;
			for(CampTypeVO vo:array) { //캠핑장별 유형 테이블 반복
				if(vo.getTno()==no) find=true; 
				// 입력 받은 캠핑장별 시설번호 와 시설번호가 같은 것이 있으면
				//즉 이미 해당 시설번호가 있으면 true 로 변경
			}
			if(find) { // true 이면 
				error=1; //이미 등록된 경우
				System.out.println("이미 등록된 유형 입니다.");
			}
			find=false;
			for(TypeVO vo:tarray) { // 유형 테이블 반복
				if(vo.getTno()==no) find=true; 
				//캠핑장별 유형과 입력받은 번호가 같으면 true
			}
			if(find==false) {
				error=2; 
				System.out.println("등록된 유형이 없습니다.");
			}
		}catch(Exception e){ 
			error=3; 
			System.out.println("숫자로 입력하세요!");
		}
		return error; 
	}
}