package ex09;


	  import java.util.*;
	  import java.text.*;
	
	  public class Messages {
		public static void run(UserVO uvo) {
			    //static 이라 객체생성 안하고 클래스에서 사용 가능
		
			Scanner s=new Scanner(System.in);
			
			MessageDAO ddao=new MessageDAO(); //MessageDAO 객체 생성
			
			UserDAO udao=new UserDAO();   //UserDAO  객체 생성
			
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//시간표시
			boolean run=true;
			while(run) {
				System.out.println("\n\n**메시지관리**");
				System.out.println("----------------------------------------------------");
				System.out.println("1.받은메시지|2.보낸메시지|3.메시지전송|4.메시지삭제|0.메인메뉴");
				System.out.println("----------------------------------------------------");
				
				uvo = udao.read(uvo.getId()); //uvo는 UserVO 타입의 받은 매개변수
				System.out.printf("이름:%s\t 포인트:%d\n",uvo.getUname(), uvo.getPoint());
				System.out.print("선택>");
				String menu=s.nextLine();
				switch(menu) {
				case "0":
					System.out.println("메인으로 돌아갑니다.");
					run=false;
					break;
				case "1"://받은메시지
					for(MessageVO vo:ddao.receiveList(uvo.getId())) { 
						// UserVO의 아이디를 MessageDAO의 receiveList 매서드를 호출하여 받은 메시지VO를 출력
						System.out.printf("%d\t%s(%s)\t%s\t%s\n",
								vo.getMid(), vo.getSender(),
								vo.getUname(), sdf.format(vo.getSdate()), vo.getMessage());
						System.out.println("---------------------------------------------------------------------------------");
					}
					//받은 메시지삭제
					while(true) {
						System.out.print("삭제할 받은 메시지번호>");
						String mid=s.nextLine();
						if(mid=="") break;
						System.out.print("삭제하실래요(y)? ");
						String sel=s.nextLine();
						if(sel.equals("Y")||sel.equals("y")||sel.equals("ㅛ")) {
							
							ddao.receiveDel(Integer.parseInt(mid));
							// 받은메시지 삭제 매서드 호출
							// 메시지번호를 스트링으로 받았기때문에 숫자(정수)로 변환
							System.out.println("받은 메시지가 삭제되었습니다.");
							break;
						}
					}
					break;
				case "2"://보낸메시지
					for(MessageVO vo:ddao.sendList(uvo.getId())) {//arraylist 이므로 for 이용
						System.out.printf("%d\t%s(%s)\t%s\t%s\n",
								vo.getMid(), vo.getReceiver(),
								vo.getUname(), sdf.format(vo.getSdate()), vo.getMessage());
						System.out.println("-------------------------------------------------------------------------");
					}
					//보낸 메시지삭제
					while(true) {
						System.out.print("삭제할 보낸 메시지번호>");
						String mid=s.nextLine(); //메시지 번호 입력받음
						if(mid=="") break;
						System.out.print("삭제하실래요(y)? ");
						String sel=s.nextLine();
						if(sel.equals("Y")||sel.equals("y")||sel.equals("ㅛ")) {
							
							ddao.sendDel(Integer.parseInt(mid));
							// 보낸메시지 삭제 매서드 호출
							// 메시지번호를 스트링으로 받았기때문에 숫자(정수)로 변환
							System.out.println("보낸 메시지가 삭제되었습니다.");
							break;
						}
					}
					break;	
				case "3": //메시지 전송
					while(true) {
						System.out.print("받을아이디>");
						String receiver=s.nextLine(); //받을 아이디 입력받음(보내는이는 알기때문에 표시안함)
						if(receiver=="") {
							System.out.println("전송을 취소합니다.");
							break;
						}else {
							UserVO vo=udao.read(receiver);//UserDAO의 read 매서드 호출  
							
							if(vo.getUname()==null) {
								System.out.println("해당 아이디가 존재하지 않습니다.");
							}else {
								//메시지 입력받아서 전송
								MessageVO mvo=new MessageVO(); //메시지VO객체 생성
								
								mvo.setSender(uvo.getId()); // 아이디는 보내는이
								mvo.setReceiver(receiver); // 입력받은 받을 아이디 대입
								
								System.out.print("메시지>");
								String message=s.nextLine(); // 메시지 입력
								if(message=="") {
									System.out.println("메시지 전송을 취소합니다.");
								}else {
									mvo.setMessage(message); //입력받은 메시지 대입
									
									ddao.insert(mvo); //전송 메시지등록 매서드 호출
									
									udao.updatePoint(uvo.getId()); // 보낸아이디를 보내서 UserDAO의 포인트 매서드 실행
									System.out.println("메시지가 전송되었습니다.");
								}
								break;
							}
						}
					}
					break;
				default:
					System.out.println("메뉴를 선택하세요!");
				}
			   }
		      }
	         }
