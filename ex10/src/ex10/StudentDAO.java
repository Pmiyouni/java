package ex10;

import java.sql.*;
import java.util.*;

public class StudentDAO {
	Connection con = Database.connect();

	// 학생 조회
	public StudentVO read(String scode) {
		StudentVO vo = new StudentVO();
		try {
			String sql = "select * from students where scode=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, scode);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				vo.setScode(rs.getString("scode"));
				vo.setSname(rs.getString("sname"));
				vo.setDept(rs.getString("dept"));

			}
		} catch (Exception e) {
			System.out.println("학생목록오류" + e.toString());
		}
		return vo;
	}

	// 학생등록
	public void insert(StudentVO vo) {
		try {
			String sql = "INSERT INTO students(scode,sname,dept) VALUES(?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, vo.getScode());// 1번째에 vo의 코드를 대입
			ps.setString(2, vo.getSname());
			ps.setString(3, vo.getDept());
			ps.execute(); // 삽입 실행
		} catch (Exception e) {
			System.out.println("학생 등록 오류" + e.toString());
		}
	}

	// 새로운 학번 구하기
	public String getCode() {// 구하기 위한 것이라 매개변수 필요없음
		String scode = "";
		try {
			String sql = "select max(scode)+1 ncode from students";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				scode = rs.getString("ncode");
			}

		} catch (Exception e) {
			System.out.println("새로운 학번 구하기 오류" + e.toString());
		}
		return scode;
	}

	// 학생목록
	public List<StudentVO> list() {
		List<StudentVO> array = new ArrayList<>();
		try {
			String sql = "select * from students";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				StudentVO vo = new StudentVO();
				vo.setScode(rs.getString("scode"));
				vo.setSname(rs.getString("sname"));
				vo.setDept(rs.getString("dept"));
				array.add(vo);
			}
		} catch (Exception e) {
			System.out.println("학생목록오류" + e.toString());
		}
		return array;
	}
}
