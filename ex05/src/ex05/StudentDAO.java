package ex05;

import java.sql.*;
import java.util.*;

public class StudentDAO {
	 // DAO( Data Access Objects) :데이터 접근 객체,데이터 베이스에 접근하기위한 객체의 정의
	Connection con = Database.connect();
	// 새로운 학번 구하기
	public String getNo() {
		String no ="";
		try {
			String sql="select max(sno)+1 no from students";  //no는 새이름
			PreparedStatement ps =  con.prepareStatement(sql);
			//쿼리문(질의문)을 String 형태의 sql 변수를 만들어 넣어줌
			
			ResultSet rs = ps.executeQuery();
			//쿼리 실행 결과를 갯수 상관없이 rs에 넣어줌
			if(rs.next()) { // rs의 다음것을 꺼내와서 반복, 없으면 자동 반복문 나감
				//한행만 출력하므로 if(rs.next()) 사용
				no =rs.getString("no"); 	 			
			}
			
		}catch(Exception e) { //예외사항이 생기면
			System.out.println("학번구하기"+e.toString());
		}		
		return no;
	}
	// select만 매서드(목록, 조회)에 리턴타입이 있음
	//학생 수정
	public void update(StudentVO vo) {
		try {
			String sql="update students set sname=?,dept=?,birthday=?, year=? where sno=?";
			  //마지막 컬럼명 year 뒤에는 ,가 안 붙임
			PreparedStatement ps =  con.prepareStatement(sql); // sql문을 ps에 넣어줌
			ps.setString(5,vo.getSno()); // 번호는 where 뒤로 5번째
			ps.setString(1,vo.getSname());  // ? 순서에 맞추어서 숫자 적어야 함
			ps.setString(2,vo.getDept());
			ps.setString(3,vo.getBirthday());
			ps.setInt(4,vo.getYear());			
			ps.execute(); // 실행
						
			
		}catch(Exception e) { //예외사항이 생기면
			System.out.println("학생수정"+e.toString());
		}
	}
	
	
	//학생 삭제
	public void delete(String sno) {
		try {
			String sql="delete from students where sno =?"; //sql문 수행
			PreparedStatement ps =  con.prepareStatement(sql); // sql문을 ps에 넣어줌
			ps.setString(1,sno); // 데이터를 받아서 ps에 넣어줌
			ps.execute(); // 실행
						
			
		}catch(Exception e) { //예외사항이 생기면
			System.out.println("학생삭제"+e.toString());
		}
	}
	//학생조회
	public StudentVO read(String sno) { //학번인 sno를 받음
		StudentVO vo = new StudentVO();// 생성자 호출
		try {
			String sql="select * from students where sno=?"; //sql문 수행
			PreparedStatement ps =  con.prepareStatement(sql);//con은 데이터베이스 연결해야하므로
			//sql문을 PreparedStatement ps 에 넣어줌
			// PreparedStatement는 미리 준비
			ps.setString(1, sno); // ?에 학번을 입력을 받아 ps에 넣어주어 sql문 실행
			ResultSet rs = ps.executeQuery();// select만 rs 사용(입력/삭제/수정은 필요없음)
			// ps에 쿼리 실행 결과(select)를 rs에 넣어줌
			//결과가 여러개일 수 있으므로 반복문 이용
			while(rs.next()) { // rs의 다음것을 꺼내와서 반복(다음것이 있는 동안), 없으면 false 이므로 반복문 나감
				
				vo.setSno(rs.getString("sno")); 
				// 쿼리의 데이터(rs에 있음)를 get으로 가져와서 자바 리스트(array)의 해당 필드에 대입
				vo.setSname(rs.getString("sname"));
				vo.setDept(rs.getString("dept"));
				vo.setBirthday(rs.getString("birthday"));
				vo.setYear(rs.getInt("year"));
				
				
			}
			
		}catch(Exception e) { //예외사항이 생기면
			System.out.println("학생조회"+e.toString());
		}
		return vo;
	}
	
	//학생입력
	public void insert(StudentVO vo) {
		try {
			String sql="insert into students(sno,sname,dept,birthday) values(?,?,?,?)"; //sql문 수행
			PreparedStatement ps =  con.prepareStatement(sql); // sql문을 ps에 넣어줌
			ps.setString(1,vo.getSno());  // 데이터를 받아서 ps에 넣어줌
			ps.setString(2,vo.getSname()); 
			ps.setString(3,vo.getDept());
			ps.setString(4,vo.getBirthday());
			ps.execute(); // 실행
						
			
		}catch(Exception e) { //예외사항이 생기면
			System.out.println("학생입력"+e.toString());
		}
	}
	//학생목록
	public List<StudentVO> list(){
		List<StudentVO> array = new ArrayList<StudentVO>(); //리스트
		try {
			String sql="select * from students order by sno desc"; //sql문 수행
			PreparedStatement ps =  con.prepareStatement(sql);//con은 데이터베이스 연결해야하므로
			//sql문을 PreparedStatement ps 에 넣어줌
			// PreparedStatement는 미리 준비
			ResultSet rs = ps.executeQuery();
			// ps에 쿼리 실행 결과(select)를 rs에 넣어줌
			//결과가 여러개일 수 있으므로 반복문 이용
			while(rs.next()) { // rs의 다음것을 꺼내와서 반복(다음것이 있는 동안), 없으면 false 이므로 반복문 나감
				StudentVO vo = new StudentVO(); //기본생성자
				vo.setSno(rs.getString("sno")); 
				// 쿼리의 데이터(rs에 있음)를 get으로 가져와서 자바 리스트(array)의 해당 필드에 대입
				vo.setSname(rs.getString("sname"));
				vo.setDept(rs.getString("dept"));
				vo.setBirthday(rs.getString("birthday"));
				vo.setYear(rs.getInt("year"));
				array.add(vo); //우리가 최종 필요로 하는 리스트에 추가(저장)
				
			}
			
		}catch(Exception e) { //예외사항이 생기면
			System.out.println("학생목록"+e.toString());
		}
		
		return array;
	}
}
