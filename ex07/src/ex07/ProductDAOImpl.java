package ex07;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO{ //implement는 시행하다
	Connection con = Database.connect(); //import java.util.List;
	
	@Override//재정의
	public void insert(ProductVO vo) throws Exception {//throws Exception은 시행할때 오류 체크
		String sql ="INSERT INTO PRODUCTS(PCODE,PNAME, PPRICE) VALUES(PCODE_SEQ.NEXTVAL,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, vo.getPname());
		ps.setInt(2, vo.getPprice());
		ps.execute();
		}

	@Override
	public void update(ProductVO vo) throws Exception {
		String sql ="update  products set pname=?,pprice=? where pcode=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, vo.getPname());
		ps.setInt(2, vo.getPprice());
		ps.setInt(3, vo.getPcode());		
		ps.execute();
		}


	@Override
	public void delete(int pcode) throws Exception {
		String sql ="delete from  products where pcode=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, pcode);		
		ps.execute();
	}

	@Override
	public ProductVO read(int pcode) throws Exception {
		ProductVO vo = new ProductVO();
		String sql="select * from products where pcode=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, pcode);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			vo.setPcode(rs.getInt("pcode"));
			vo.setPname(rs.getString("pname"));
			vo.setPprice(rs.getInt("pprice"));
		}
		return vo;
	}

	@Override
	public List<ProductVO> list() throws Exception {
		List<ProductVO> array = new ArrayList<>();
		String sql="select * from products order by pcode desc";
		PreparedStatement ps = con.prepareStatement(sql);		
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			ProductVO vo = new ProductVO();
			vo.setPcode(rs.getInt("pcode"));
			vo.setPname(rs.getString("pname"));
			vo.setPprice(rs.getInt("pprice"));
			array.add(vo);
		}
		return array;
	}



}
