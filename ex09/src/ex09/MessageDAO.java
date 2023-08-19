package ex09;

import java.sql.*;
import java.util.*;

public class MessageDAO {
	Connection con=Database.connect();
	
	//받은메시지 삭제
	public void receiveDel(int mid) {
		try {
			String sql="UPDATE MESSAGES SET SDEL=1 WHERE MID=?";
			//sdel을 1로 변경-> 받은메시지 출력에서 0인경우만 출력함, 1은 출력제외
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, mid); //메시지 번호 입력받음
			ps.execute(); // 수정 실행
		}catch(Exception e) {
			System.out.println("받은메시지 삭제오류:" + e.toString());
		}
	}
	
	//보낸메시지 삭제
	public void sendDel(int mid) {// 메시지번호를 매개변수로 받음
		try {
			String sql="UPDATE MESSAGES SET RDEL=1 WHERE MID=?";
			//rdel을 1로 변경-> 보낸메시지 출력에서 0인경우만 출력함, 1은 출력제외
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, mid);
			ps.execute(); //수정 실행
		}catch(Exception e) {
			System.out.println("보낸메시지 삭제오류:" + e.toString());
		}
	}
	//메시지전송(메세지 추가)
	public void insert(MessageVO vo) {
		try {
			String sql="INSERT INTO MESSAGES(MID, SENDER, RECEIVER, SDATE, MESSAGE) ";
			sql+="VALUES(SEQ_MID.NEXTVAL, ?, ?, SYSDATE, ?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, vo.getSender());
			ps.setString(2, vo.getReceiver());
			ps.setString(3, vo.getMessage());
			ps.execute();//등록 실행
		}catch(Exception e) {
			System.out.println("메시지전송오류:" + e.toString());
		}
	}
	
	//받은메시지 목록
	public List<MessageVO> receiveList(String id){
		List<MessageVO> array=new ArrayList<>();
		try {
			String sql="SELECT M.*, UNAME FROM MESSAGES M, USERS U WHERE receiver=? AND sender=ID and sdel=0";
			//받은이 아이디를 입력받고 보낸이도 동일한 아이디를 찾으면서 삭제체크가 아닌 것
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, id); //받는이 아이디
			ResultSet rs=ps.executeQuery(); // sql 결과 받음
			while(rs.next()) {
				MessageVO vo=new MessageVO();
				
				vo.setMid(rs.getInt("mid"));
				vo.setSender(rs.getString("sender"));
				vo.setUname(rs.getString("uname"));
				vo.setMessage(rs.getString("message"));
				vo.setSdate(rs.getTimestamp("sdate"));
				array.add(vo);
			}
		}catch(Exception e) {
			System.out.println("받은메시지오류:" + e.toString());
		}
		return array;
	}

	//보낸메시지 목록
	public List<MessageVO> sendList(String id){//보낸 메시지가 여러개일 수 있으니 list 사용
		List<MessageVO> array=new ArrayList<>(); //Arraylist 생성
		try {
			String sql="SELECT M.*, UNAME FROM MESSAGES M, USERS U WHERE sender=? AND receiver=ID AND rDEL=0";
			//보낸이 아이디를 입력받고 받는이도 동일한 아이디를 찾으면서 삭제체크가 아닌 것
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, id); //?에 보낸이 아이디 대입
			ResultSet rs=ps.executeQuery();// sql 결과 받음
			while(rs.next()) {
				MessageVO vo=new MessageVO(); //객체 생성
				
				vo.setMid(rs.getInt("mid")); //번호
				vo.setReceiver(rs.getString("receiver")); //받은이
				vo.setUname(rs.getString("uname")); //이름
				vo.setMessage(rs.getString("message")); //메시지
				vo.setSdate(rs.getTimestamp("sdate")); //전송날짜
				
				array.add(vo);// 등록
			}
		}catch(Exception e) {
			System.out.println("보낸메시지오류:" + e.toString());
		}
		return array;
	}
}
