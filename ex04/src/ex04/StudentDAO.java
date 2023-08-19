package ex04;

import java.sql.*;
import java.util.*;


public class StudentDAO {//데이터베이스 관련 작업
	Connection con=Database.connect(); //con을 리턴 받음
	//학생수정
	public void update(Student vo) {
		try {
			String sql="update tbl_juso set name=?, juso =?, phone=? where no=?";
			    //받아서 나중에 넣을 것이라서 ?를 넣음, 직접 넣어도 됨
			PreparedStatement ps = con.prepareStatement(sql);//실행할 sql문을 ps에 넣어줌
			ps.setInt(4, vo.getNo());
			ps.setString(1, vo.getName());
			ps.setString(2, vo.getJuso());
			ps.setString(3, vo.getPhone());
			ps.execute(); //데이터베이스에 실행
			
		}catch(Exception e) {
			System.out.println("학생수정"+e.toString());
		}
	}
	//학생삭제
	public void delete(int number) {
		try {
			String sql="delete from tbl_juso where no = ?";
			    //받아서 나중에 넣을 것이라서 ?를 넣음, 직접 넣어도 됨
			PreparedStatement ps = con.prepareStatement(sql);//실행할 sql문을 ps에 넣어줌
			ps.setInt(1, number); //?에 number을 넣어줌
			
			ps.execute(); //데이터베이스에 실행
			
		}catch(Exception e) {
			System.out.println("학생삭제"+e.toString());
		}
		
	}
	//학생조회	
	public Student read(int no) {
		Student vo = new Student();
		try {
			String sql ="select * from tbl_juso where no=?";			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, no);
			ResultSet rs = ps.executeQuery(); //ps 결과를 rs에 넣어줌
			if(rs.next()) {// rs 다음값이 있으면 반복
				
				vo.setNo(rs.getInt("no"));
				vo.setName(rs.getString("name"));
				//getString, getint는 db 불러올때 사용
				vo.setJuso(rs.getString("juso"));
				vo.setPhone(rs.getString("phone"));
				
						
			}
		} catch(Exception e) {
			System.out.println("학생조회"+e.toString());
		}
		
		return vo;
	}
	//학생 등록
	public void insert(Student vo) {
		try {
			String sql="insert into tbl_juso(no,name,juso,phone) values(?,?,?,?)";
			    //받아서 나중에 넣을 것이라서 ?를 넣음, 직접 넣어도 됨
			PreparedStatement ps = con.prepareStatement(sql);//실행할 sql문을 ps에 넣어줌
			ps.setInt(1, vo.getNo());
			ps.setString(2, vo.getName());
			ps.setString(3, vo.getJuso());
			ps.setString(4, vo.getPhone());
			ps.execute(); //데이터베이스에 실행
			
		}catch(Exception e) {
			System.out.println("학생등록"+e.toString());
		}
	}
	
	//학생 목록 
	public List<Student> list(){//List<Student> 형 반환(리턴)
		List<Student> array = new ArrayList<Student>(); //리스트 설정
		try {
			String sql ="select * from tbl_juso order by name";			
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(); //ps 결과를 rs에 넣어줌
			while(rs.next()) {// rs 다음값이 있으면 반복
				Student vo = new Student();
				vo.setNo(rs.getInt("no"));
				vo.setName(rs.getString("name"));
				//getString, getint는 db 불러올때 사용
				vo.setJuso(rs.getString("juso"));
				vo.setPhone(rs.getString("phone"));
				array.add(vo); // array에 추가
						
			}
		} catch(Exception e) {
			System.out.println("학생목록"+e.toString());
		}
		
		return array;
	}
}
