package ex06;

import java.sql.*;
import java.util.*;

import javax.naming.spi.DirStateFactory.Result;

public class ProductDAO {
	Connection con =Database.connect();
	// 상품 수정
	 public void update(ProductVO vo) {
		 try {
			 String sql = "update products set pname=?,pprice=? where pcode =?";
			 PreparedStatement ps = con.prepareStatement(sql);
			 ps.setString(1,vo.getPname());
			 ps.setInt(2,vo.getPprice());
			 ps.setInt(3, vo.getPcode());
			 ps.execute();		 
		 } catch(Exception e) {
			 System.out.println("상품수정"+e.toString());
		 }
	 }
	
	// 상품삭제
	public void delete(int pcode) throws Exception {
		String sql = "delete from Products where pcode =?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, pcode);
		ps.execute();
	}
	
	//상품 조회
		public ProductVO read(int pcode) {
			ProductVO vo = new ProductVO();
			try {
				String sql = "select * from products where pcode=?";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, pcode);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					vo.setPcode(rs.getInt("pcode"));
					vo.setPname(rs.getString("pname"));
					vo.setPprice(rs.getInt("pprice"));
				}
			}catch(Exception e) {
				System.out.println("상품조회"+e.toString());
			}
			return vo; //select 결과를 리턴
		}
	
	//상품등록
	public void insert(ProductVO vo) {
		try {
			String sql ="insert into  products(pcode,pname,pprice) values(pcode_seq.nextval, ?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, vo.getPname());
			ps.setInt(2, vo.getPprice());
			ps.execute(); //select가 아닐 경우 execute() select이면 ResultSet로 executeQuery()
		}catch(Exception error) {
			System.out.println("상품등록"+error.toString());
			
		}
		
	}
	
	//상품목록
	public List<ProductVO> list(){
		List<ProductVO> array = new ArrayList<>();
		try {
			String sql ="select * from products order by pcode desc";
			PreparedStatement ps = con.prepareStatement(sql);
			//쿼리문(질의문)을 String 형태의 sql 변수를 만들어 넣어줌, sql문 저장
			ResultSet rs = ps.executeQuery();
			//쿼리 실행 결과를 갯수 상관없이 rs에 넣어줌
			while(rs.next()) { //rs 결과의 데이터가 다음 데이터가 있을때 반복
				ProductVO vo = new ProductVO();
				vo.setPcode(rs.getInt("pcode"));
				vo.setPname(rs.getString("pname"));
				vo.setPprice(rs.getInt("pprice"));
				array.add(vo);				
			}			
		}catch(Exception error) {
			System.out.println("상품목록"+error.toString());
		}
		 return array;  // select 일때만 리턴값이 있음
	 	}
	}
