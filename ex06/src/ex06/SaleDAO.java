package ex06;
import java.sql.*;
import java.util.*;

public class SaleDAO {
	Connection con = Database.connect();
	
	//판매정보목록
	public List<SaleVO> list(int pcode){
		List<SaleVO> array = new ArrayList<SaleVO>();
		try {
			String sql = "select * from sale where pcode = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, pcode);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				SaleVO vo = new SaleVO();
				vo.setQnt(rs.getInt("qnt"));
				vo.setSprice(rs.getInt("sprice"));
				vo.setSdate(rs.getTimestamp("sdate"));
				array.add(vo);
			}
		}catch(Exception e) {
			System.out.println("판매정보목록"+e.toString());
		}
		return array;
	}
	//판매정보등록
	public void sinsert(SaleVO vo) {
		try {
			String sql ="insert into  sale(scode,pcode,qnt,sprice) values(code_seq.nextval,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, vo.getPcode());
			ps.setInt(2, vo.getQnt());
			ps.setInt(3, vo.getSprice());
			ps.execute(); 
		}catch(Exception error) {
			System.out.println("판매정보등록"+error.toString());
		}
	}
}