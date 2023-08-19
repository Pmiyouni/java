package ex10;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO {
	Connection con = Database.connect();
	
	//강좌 조회
	public CourseVO read(String ccode) {
		CourseVO vo=  new CourseVO();
		try {
			String sql ="select * from Courses where ccode=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, ccode);
			ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			vo.setCcode(rs.getString("ccode"));
			vo.setCname(rs.getString("cname"));
			
			
			}
		}catch(Exception e) {
			System.out.println("강좌조회오류"+e.toString());
		}
				
				
		return vo;
	}
	//강좌등록
	public void insert(CourseVO vo) {
		try {
			String sql ="INSERT INTO Courses(ccode,cname) VALUES(?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, vo.getCcode());// 1번째에 vo의 코드를 대입
			ps.setString(2, vo.getCname());
			
			ps.execute(); // 삽입 실행
		}catch(Exception e) {
			System.out.println("강좌 등록 오류"+e.toString());
		}
	}
	
	 // 새로운 과목코드 구하기
	public String getCode() {// 구하기 위한 것이라 매개변수 필요없음
		String ccode ="";
		try {
			String sql ="select max(ccode)+1 ncode from Courses";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				ccode = rs.getString("ncode");
			}
		
		}catch(Exception e) {
			System.out.println("새로운 과목코드 구하기 오류"+e.toString());
		}
		return ccode;
	}
	//강좌목록
	public List<CourseVO> list(){
		List<CourseVO> array = new ArrayList<>();
		try {
			String sql ="select * from Courses";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			CourseVO vo =new CourseVO();
			vo.setCcode(rs.getString("ccode"));
			vo.setCname(rs.getString("cname"));
						array.add(vo);
			}
		}catch(Exception e) {
			System.out.println("강좌목록오류"+e.toString());
		}
		return array;
	}
}


