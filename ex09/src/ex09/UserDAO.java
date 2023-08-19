package ex09;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
	Connection con = Database.connect();
	
	//포인트증가
		public void updatePoint(String id) {//보낸아이디 받아서 수행
			try {
				String sql="UPDATE USERS SET POINT=POINT+10 WHERE ID=?";
				//user테이블에 포인트가 있으므로 해당아이디 찾아서 메시지 1건에 포인트 10 증가 
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1, id); // ?에 아이디 대입
				ps.execute(); // 수정 실행
			}catch(Exception e) {
				System.out.println("포인트증가오류:" + e.toString());
			}
		}
	
	//사용자 삭제
	public void delete(String uid) throws Exception{//매개변수는 아이디 받고, 리턴값은 없음
                       // try~catch는 실행하는 main에서 하라고 던져줌  
		String str = " delete from users where id=?"; 
		PreparedStatement ps = con.prepareStatement(str);
		ps.setString(1, uid); //메개변수 받은 아이디를 ?에 대입
		ps.execute(); // 삭제 실행
		}
	
	
	// 사용자 등록
	public void insert(UserVO vo) {// 매개변수는 VO로 받고 리턴값은 없음
		try {
			String sql="insert into users(id,uname,phone) values(?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, vo.getId()); // 매개변수 받은 VO의 아이디를 1번째 ?에 대입
			ps.setString(2, vo.getUname());
			ps.setString(3, vo.getPhone());
			
			ps.execute(); // 등록 실행
			
		} catch(Exception e) {
			System.out.println("사용자 등록 오류"+e.toString());
		}
		}
	
	
	//사용자 수정
	public void update(UserVO vo) {// 수정할 VO를 받아서 수행
		try {
			String sql="update users set uname=?, phone=? where id =?"; 
		      	// 아이디 같은 데이터의 이름과 전화 수정
			PreparedStatement ps = con.prepareStatement(sql);// sql문 저장
			ps.setString(3, vo.getId());// 3번째 ?에 VO에서 아이디 대입
			ps.setString(1, vo.getUname()); // 1번째 ?에 VO에서 이름 대입
			ps.setString(2, vo.getPhone()); // 2번째 ?에 VO에서 전화 대입
			ps.execute(); //수정 실행
			} catch(Exception e) {
				System.out.println("사용자 수정 오류"+e.toString());
			}
	}
	
	//사용자 조회
	public UserVO read(String uid) {
		UserVO vo = new UserVO(); //객체 생성
		try {
		String sql="select * from users where id =?"; // 아이디 같은 데이터 추출
		PreparedStatement ps = con.prepareStatement(sql);// sql문 저장
		ps.setString(1, uid);//?에 매개변수로 받은 아이디 대입
		ResultSet rs = ps.executeQuery(); // sql 결과값을 rs에 저장
		while(rs.next()){ 
			 vo.setId(rs.getString("id"));
			 vo.setUname(rs.getString("uname"));
			 vo.setPoint(rs.getInt("point"));
			 vo.setPhone(rs.getString("phone"));
			 
			//목록은 arraylist에 VO를 추가 후 리턴
			//조회는 VO에 저장하여 리턴
		}
		} catch(Exception e) {
			System.out.println("사용자 조회 오류"+e.toString());
		}
		return vo;
	}
	
		
	//사용자 목록
	public List<UserVO> list(){ // 매개변수 없음, list 리턴
		List<UserVO> array = new ArrayList<>(); // Arraylist 생성
		
		try {
			String sql="select * from users"; // user 테이블 데이터 모두 추출
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();// sql문 실행후 결과 저장
			while(rs.next()) { // 다음 데이터가 있는 동안(데이터 개수 만큼 반복)
				UserVO vo = new UserVO();  //객체 생성
				
				vo.setId(rs.getString("id")); //db의 데이터를 list에 저장
				vo.setUname(rs.getString("uname"));
				vo.setPoint(rs.getInt("point"));
				vo.setPhone(rs.getString("phone"));
			
				array.add(vo);				
			}
		} catch (Exception e) {
			System.out.println("사용자 조회오류"+e.toString());
		}
		return array; 
	}
}
