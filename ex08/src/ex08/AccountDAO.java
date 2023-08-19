package ex08;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO {
	Connection con = Database.connect();

    // 잔액 변경 (입금/출금에 모두 사용하는 매서드)
	public void update(AccountVO vo) {
		try {
			String sql = "update account set balance=? where ano=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, vo.getBalance());
			ps.setInt(2, vo.getAno());
			ps.execute();
		} catch (Exception e) {
			System.out.println("잔액변경 오류" + e.toString());
		}
	}

	// 계좌목록 (전체 출력)
	public List<AccountVO> list() { 

		List<AccountVO> array = new ArrayList<AccountVO>();
		// 목록이라 Arraylist 사용
		try {
			String sql = "select * from account ";
			  // account 테이블 정보를 모두 추출
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(); // sql문 수행
			while (rs.next()) { 
				AccountVO vo = new AccountVO(); 
				
				vo.setAno(rs.getInt("ano")); // db의 결과정보를 list에 저장
				vo.setAname(rs.getString("aname"));
				vo.setBalance(rs.getInt("balance"));
				array.add(vo); // list에 데이터 저장
				}

		} catch (Exception e) {
			System.out.println("계좌목록 오류" + e.toString());
		}

		return array; // 출력을 위하여 list를 리턴함
	}

	// 계좌생성
	public int insert(AccountVO v) {
		int ano = 0;
		try {
			String sql = "INSERT INTO ACCOUNT(ANO,ANAME,BALANCE)"
					+ " VALUES(SEQ_ANO.NEXTVAL,?,?)";  //테이블 정보 입력
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, v.getAname()); //첫번째 ?는 계좌주명
			ps.setInt(2, v.getBalance());  //두번째 ?는 잔액 
			ps.execute(); //실행

			sql = "select seq_ano.currval ano from dual"; // 증가한 현재값, dual은 가상태이블
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				ano = rs.getInt("ano");  //현재의 계좌번호를 리턴 위해 대입

		} catch (Exception e) {
			System.out.println("계좌생성 오류" + e.toString());
		}
		return ano; //현재 계좌번호 리턴
	}

	// 계좌정보조회
	public AccountVO read(int ano) throws Exception {//매개변수는 계좌번호
		AccountVO vo = new AccountVO();
		String sql = "select * from account where ano=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, ano); //조회를 위해 계좌번호를 입력받아서 ? 대입
		ResultSet rs = ps.executeQuery(); 
		if (rs.next()) { // 조회이므로 1행이라 if문 사용
			//db에서 데이터를 list에 저장
			vo.setAno(rs.getInt("ano"));  
			vo.setAname(rs.getString("aname"));
			vo.setBalance(rs.getInt("balance"));
		}
		return vo;// 데이터 리턴
	}
}
