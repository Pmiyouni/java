package ex11;
import java.util.*;

public class Facil {  //시설물관리 서브메뉴
	
	public static void run() { // static이므로 클래스 이름으로 호출 가능
		Scanner s=new Scanner(System.in);
		boolean run=true;
		FacilDAO fdao=new FacilDAO();
		CampDAO cdao=new CampDAO();
		while(run) {
			System.out.println("\n\n**************** 시설물관리 *****************************");
			System.out.println("------------------------------------------------------");
			System.out.println("|1.시설물목록|2.캠핑장시설물등록|3.캠핑장시설물삭제|0.메뉴|");
			System.out.println("------------------------------------------------------");
			System.out.print("선택>");
			String menu=s.nextLine();
			switch(menu) {
			case "0":
				run=false;
				System.out.println("메뉴로 돌아갑니다!");
				break;
			case "1": //시설물 목록
				List<FacilVO> farray=fdao.list();// 목록 매서드 결과를 리스트에 저장
				for(FacilVO vo:farray) { // 목록 출력
					System.out.printf("%s\t%s\n",vo.getFno(), vo.getFname());
				}
				break;
				
			case "2": //캠핑장 시설물 목록
				System.out.print("캠핑장번호>");
				String cno=s.nextLine();
				if(cno=="") {
					System.out.println("시설물등록을 취소합니다.");
					break;//switch
				}else {
					CampVO cvo=cdao.read(cno); // 캠핑장번호를 보내고 VO를 읽어옴
					if(cvo.getCname()==null) {
						System.out.println("등록된 캠핑장없습니다.");
					}else {
						System.out.println("캠핑장이름>" + cvo.getCname());
						System.out.println("-------------------------------------------");
						while(true) {
							//캠핑장에 등록된시설물
							List<CampFacilVO> array=fdao.list(cno);
							//  캠핑장별 시설조회 매서드를 리스트에 저장 
							if(array.size()==0) {
								System.out.println("등록된 시설물이 없습니다.");
							}else {
								for(CampFacilVO vo:array) {
									System.out.printf("%d:%s | ", vo.getFno(),vo.getFname());
								}
								System.out.println("\n-------------------------------------------");	
							}
							//전체시설물
							List<FacilVO> aarray=fdao.list();
							//시설물 전체 목록 매서드 결과를 시설물list에 저장 
							for(FacilVO vo:aarray) {
								System.out.printf("%d:%s | ", vo.getFno(),vo.getFname());
							}
							System.out.println("\n-------------------------------------------");	
							System.out.print("시설물번호>");
							String fno=s.nextLine();
							if(fno=="") {
								System.out.println("시설물 등록을 취소합니다.");
								break; //while
							}else {
								int error=checkFno(fno, array, aarray); 
								//시설물 번호 체크
								//시설물 번호, 캠핑장별 시설물 리스트, 전체 시설물 리스트 보냄
								
								if(error==0) { //시설물 에러가 없는 경우
									fdao.insert(cno, Integer.parseInt(fno));
						        // 캠핑장에 시설물 등록 매서드(캠핑장번호와 시설물번호 보냄)
									System.out.println("시설물 등록완료!");
								}
							}
						}
					}
				}
				break; //switch
			case "3":
				System.out.print("캠핑장번호>");
				cno=s.nextLine();
				if(cno=="") {
					System.out.println("시설물 삭제를 취소합니다.");
				}else {
					CampVO cvo=cdao.read(cno);
					if(cvo.getCname()==null) {
						System.out.println("등록된 캠핑장이 없습니다.");
					}else {
						System.out.println("캠핑장이름:" + cvo.getCname());
						while(true) {
							//캠핑장에 등록된 시설물 목록
							List<CampFacilVO> array=fdao.list(cno);
							if(array.size()==0) {
								System.out.println("등록된 시설물이 없습니다.");
								break;
							}else {
								for(CampFacilVO vo:array) {
									System.out.printf("%d:%s | ", vo.getFno(),vo.getFname());
								}
								System.out.println("\n------------------------------------------");
								System.out.print("삭제할시설물번호>");
								String fno=s.nextLine();
								if(fno=="") {
									System.out.println("시설물 삭제를 취소합니다.");
								}else {
									int error=checkDno(fno, array); 
									//삭제할 시설물이 있는지 체크
									
									if(error==0) { // 에러가 없으면
										fdao.delete(cno, Integer.parseInt(fno));
										//캠핑장 시설물 삭제
										System.out.println("시설물 삭제완료!");
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
	
	//삭제할 시설물번호가 있는지 체크하는 메서드
	public static int checkDno(String fno, List<CampFacilVO> array) {
		int error=0;
		try {
			int no=Integer.parseInt(fno); //시설물 번호 입력받음
			boolean find=false;
			for(CampFacilVO vo:array) { //캠핑장별 시설물 반복
				if(vo.getFno()==no) find=true; 
				// 시설물 번호와 입력받은 시설물 번호가 있으면 TRUE(삭제 가능) 
			}
			if(find==false) {
				System.out.println("등록되지않은 시설물 번호입니다.");
				error=1; // 삭제할 시설물 없으면 에러
			}
		}catch(Exception e) {
			error=2; // 잘못 입력한경우 에러
			System.out.println("숫자로입력하세요!");
		}
		return error; //에러값 리턴
	}
	
	//시설물번호를 체크하는 메서드
	public static int checkFno(String fno, List<CampFacilVO> array, List<FacilVO> aarray) {
		int error=0;
		try {
			int no=Integer.parseInt(fno); //시설물 번호를 숫자로 변경
			
			boolean find=false;
			for(CampFacilVO vo:array) { //캠핑장별 시설물 테이블 반복
				if(vo.getFno()==no) find=true; 
				// 입력 받은 캠핑장별 시설번호 와 시설번호가 같은 것이 있으면
				//즉 이미 해당 시설번호가 있으면 true 로 변경
			}
			if(find) { // true 이면 
				error=1; //이미 등록된 경우
				System.out.println("이미 등록된 시설물 입니다.");
			}
			
			
			find=false;
			for(FacilVO vo:aarray) { // 시설물 테이블 반복
				if(vo.getFno()==no) find=true; 
				//캠핑장별 시설물과 입력받은 번호가 같으면 true
			}
			if(find==false) {//시설물 목록에 입력받은 시설물 번호가 없음
				error=2; // 시설물이 없을때
				System.out.println("등록된 시설물이 없습니다.");
			}
		}catch(Exception e){ 
			error=3; // 잘못 입력한 경우
			System.out.println("숫자로 입력하세요!");
		}
		return error; //에러 값 리턴
	}
}//Facil
	

