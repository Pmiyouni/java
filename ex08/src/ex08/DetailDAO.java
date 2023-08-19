package ex08;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class DetailDAO {
	Connection con = Database.connect();

	// 거래내역 등록
	public void insert(DetailVO vo) { 
		try {
			String sql = "INSERT INTO DETAIL(DNO,ANO,AMOUNT,TYPE,DDATE) "
					+ "VALUES(SEQ_DNO.NEXTVAL,?,?,?,SYSDATE)";
			//sql 문으로 detail 테이블에 데이터 저장위해
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, vo.getAno()); // 계좌번호 저장
			ps.setInt(2, vo.getAmount()); // 금액 저장
			ps.setString(3, vo.getType()); //구분 저장
			ps.execute(); // 실행

		} catch (Exception e) {
			System.out.println("계좌내역등록오류" + e.toString());
		}
	}

	// 거래 목록 (조회에서 계좌정보 아래 거래목록 출력)
	public List<DetailVO> list(int ano) { //여러개의 목록이므로 list 사용
		List<DetailVO> array = new ArrayList<DetailVO>();
		try {
			String sql = "select * from detail where ano=? order by dno desc";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, ano); //?에 계좌번호 대입 
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {// 목록이므로 여러개일수도 있음
				
				DetailVO vo = new DetailVO();
				vo.setDno(rs.getInt("dno")); // db의 정보를 list에 대입
				vo.setAno(rs.getInt("ano"));
				vo.setAmount(rs.getInt("amount"));
				vo.setType(rs.getString("type"));
				vo.setDdate(rs.getTimestamp("ddate"));
				array.add(vo); // listdp 저장
			}

		} catch (Exception e) {
			System.out.println("거래내역오류" + e.toString());
		}
		return array; // arraylist 리턴
	}
}
