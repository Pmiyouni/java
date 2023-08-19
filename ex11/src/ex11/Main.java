package ex11;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		
				Scanner s = new Scanner(System.in);
				boolean run = true;
				
				CampDAO cdao = new CampDAO();
				
				while (run) {
					System.out.println("\n\n**************** 캠핑장 관리 *****************************");
					System.out.println("------------------------------------------------------");
					System.out.println("1.캠핑장목록|2.캠핑장조회|3.캠핑장정보수정|0.종료|");
					System.out.println("4.시설물관리|5.유형관리|6.캠핑장등록");
					System.out.println("------------------------------------------------------");
					System.out.print("선택>");
					String menu = s.nextLine();
					switch (menu) {

					case "0":
						run = false;
						System.out.println("프로그램을 종료합니다!");
						break;

					case "1": // 캠핑장목록
						List<CampVO> array = cdao.list();
						for(CampVO vo : array) {
							System.out.printf("%s\t%-20s\t%s\t%s\n",
									vo.getCno(), vo.getCname(), vo.getJuso(), vo.getTel());
						}
						System.out.println(array.size() + "개 등록되었습니다.");
						break;
					case "2": //캠핑장 조회
						while(true) {
							System.out.print("\n조회할번호>");
							String cno=s.nextLine();
							if(cno=="") {
								System.out.println("조회를 취소합니다.");
								break;
							}else {
								CampVO cvo=cdao.read(cno);
								   // 번호 cno를 매개변수로 보내 DAO의 read 매서드를 실행하여 cvo에 저장
								if(cvo.getCname()==null) {
									System.out.println("해당이 존재하지 않습니다.");
								}else {
									System.out.println("캠핑장이름:" + cvo.getCname());
									System.out.println("캠핑장주소:" + cvo.getJuso());
									System.out.println("캠핑장전화:" + cvo.getTel());
								}
							}
						}
						break;
					case "3"://캠핑장 정보 수정
						while(true) {
							System.out.print("수정할캠핑장번호>");
							String cno=s.nextLine();
							if(cno=="") {
								System.out.println("수정을 취소합니다.");
								break;
							}else {
								CampVO cvo=cdao.read(cno);
								//데이터 존재여부와 수정전 기존 데이터를 보여주기 위해 
								
								if(cvo.getCname()==null) {
									System.out.println("캠핑장이 존재하지 않습니다.");
								}else { //수정할 캠핑장이 있으면
									System.out.println("캠핑장이름:" + cvo.getCname());
									System.out.print("새로운캠핑장이름>");
									String nname=s.nextLine(); // 수정내용 입력받음
									if(nname != "") cvo.setCname(nname); // 입력내용을 VO에 셋팅
									
									System.out.println("캠핑장주소:" + cvo.getJuso());
									System.out.print("새로운캠핑장주소>");
									String njuso=s.nextLine();
									if(njuso != "") cvo.setJuso(njuso);
									
									System.out.println("캠핑장전화:" + cvo.getTel());
									System.out.print("새로운캠핑장전화>");
									String ntel=s.nextLine();
									if(ntel != "") cvo.setTel(ntel);
									
									//System.out.println(cvo.toString());
									System.out.print("수정하실래요(Y)?");
									String sel=s.nextLine();
									if(sel.equals("Y")||sel.equals("y")||sel.equals("ㅛ")) {
										//수정작업
										cdao.update(cvo); // VO를 보내면서 DAO의 수정매서드 호출 
										
										System.out.println("수정이 완료되었습니다.");
									}else {
										System.out.println("수정이 취소되었습니다.");
									}
									break;
								}
							}
						}
						break;
					case "6": // 캠핑장 등록
						CampVO cvo=new CampVO(); // VO 객체 생성
						cvo.setCno(cdao.getNo()); 
						   //새로운 번호 생성하는 매서드 호출하여 vo의 번호에 대입
						System.out.println("새로운번호>" + cvo.getCno());
						System.out.print("캠핑장이름>");
						String cname=s.nextLine(); // 캠핑장명 변수에 입력받음
						if(cname.equals("")) {
							System.out.println("등록을 취소합니다.");
						}else {
							System.out.print("캠핑장주소>");
							String juso=s.nextLine(); // 주소 입력받음
							System.out.print("캠핑장전화>");
							String tel=s.nextLine(); // 전화번호 입력받음
							cvo.setCname(cname); //입력받은 값을 vo의 각 해당 값으로 셋팅
							cvo.setJuso(juso);
							cvo.setTel(tel);
							//System.out.println(cvo.toString());
							
							cdao.insert(cvo); //번호를 매개변수로 보내면서 등록
							System.out.println("새로운 캠핑장이 등록되었습니다.");
						}
						break;
					case "4":// 시설물 관리
						Facil.run(); //시설물 관리 매서드 호출
						break;
					case "5":// 유형 관리
						Type.run(); //시설물 관리 매서드 호출
						break;
						
						
					default:
						System.out.println("메뉴를 다시선택하세요!");
					}//switch
				}//while
			}//main
		}//Main

