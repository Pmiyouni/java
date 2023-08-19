package ex11;

import java.sql.*;
import java.util.*;

public class CampTypeDAO {
	Connection con=Database.connect();
	//캠핑장에 타입삭제
	public void delete(String cno, int tno) {
		try {
			String sql="delete from camp_type where cno=? and tno=?";
						PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, cno);
			ps.setInt(2, tno);
			ps.execute();
		}catch(Exception e) {
			System.out.println("캠핑장에 유형삭제:" + e.toString());
		}
	}
	
	//캠핑장에 타입 등록
	public void insert(String cno, int tno) {
		try {
			String sql="insert into camp_type(cno, tno) values(?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, cno);
			ps.setInt(2, tno);
			ps.execute();
		}catch(Exception e) {
			System.out.println("캠핑장에 유형등록 오류:" + e.toString());
		}
	}
	//캠핑장별 타입목록
	public List<CampTypeVO> list(String cno){ 
		
		List<CampTypeVO> array=new ArrayList<>(); 
		try {
			String sql="SELECT * FROM VIEW_TYPE WHERE CNO=?"; 
			
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, cno);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				CampTypeVO vo=new CampTypeVO(); 
				vo.setTno(rs.getInt("tno")); 
				vo.setTname(rs.getString("tname")); 
				array.add(vo); 
			}
		}catch(Exception e) {
			System.out.println("캠핑장별 유형목록 오류:" + e.toString());
		}
		return array;
	}
	
	//타입전체목록
	public List<TypeVO> list(){ 
		List<TypeVO> array=new ArrayList<>(); 
		try {
			String sql="select * from  TYPE order by tno"; 
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				TypeVO vo=new TypeVO(); 
				vo.setTno(rs.getInt("tno")); 
				vo.setTname(rs.getString("tname"));
				array.add(vo); 
			}
		}catch(Exception e) {
			System.out.println("유형전체목록 오류:" + e.toString());
		}
		return array;
	}
}
