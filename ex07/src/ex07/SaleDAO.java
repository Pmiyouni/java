package ex07;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import ex07.SaleVO;

public class SaleDAO {
	Connection con = Database.connect();
	
	//상품별 판매 현황
	public List<SaleVO> sum_list(){
		List<SaleVO> array = new ArrayList<>();
		try {
			String sql = "SELECT pcode, pname, sum(qnt) sum_qnt,"
					+ "sum(qnt*sprice) sum_price FROM view_sale1"
					+ " group by PCODE, pname order by pcode";
			//뷰(view)dotj 상품코드와 상품명으로 그룹화하여 상품코드, 상품명, 수량 합계(sum_qnt),금액합계(sum_price)
			//추출하여 상품코드별 오름차순 정렬
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				SaleVO vo =new  SaleVO(); 
				vo.setPcode(rs.getInt("pcode"));
				vo.setPname(rs.getString("pname"));
				vo.setQnt(rs.getInt("sum_qnt")); // 수량 합계는 수량에 저장
				vo.setSprice(rs.getInt("sum_price"));// 금액 합계변수는 가격에 저장
				array.add(vo);
			}
		}catch(Exception e) {
			System.out.println("상품별 판매현황"+e.toString()); //오류시 처리
		}
		return array;
	}
	
	
	
	//상품별 판매 조회
	    public List<SaleVO> list(int pcode) throws Exception{
		List<SaleVO> array = new ArrayList<SaleVO>();
		String sql = "SELECT * FROM SALE where pcode =?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, pcode);
		ResultSet rs  = ps.executeQuery();
		while(rs.next()) {
			SaleVO vo = new SaleVO();
			vo.setScode(rs.getInt("scode"));
			vo.setPcode(rs.getInt("pcode"));
			vo.setQnt(rs.getInt("qnt"));
			vo.setSprice(rs.getInt("sprice"));
			vo.setSdate(rs.getTimestamp("sdate"));
			array.add(vo);
		}
		return array;
	}
	
	//판매등록
		public void insert(SaleVO vo) throws Exception {
			
				String sql ="insert into  sale(scode,pcode,qnt,sprice) values(code_seq.nextval,?,?,?)";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, vo.getPcode());
				ps.setInt(2, vo.getQnt());
				ps.setInt(3, vo.getSprice());
				ps.execute(); 
		}
}
