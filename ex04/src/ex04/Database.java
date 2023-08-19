package ex04;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
	 //데이터베이스 접속 위한 클래스
	// 데이터베이스를 위한 라이브러리를 불러와야 함
	public static Connection connect() {
		Connection con=null;
		 String driver = "oracle.jdbc.driver.OracleDriver";
		 String url = "jdbc:oracle:thin:@localhost:1521:xe";
		 String user = "java";
		 String password = "pass";
		 try {
			 Class.forName(driver);
			 con=DriverManager.getConnection(url,user,password);
			 System.out.println("접속 성공...");
		 }catch(Exception e) {
			 System.out.println("DB연결"+e.toString());
		 }//try 하다 오류가 생기면 보여줌
		return con; //리턴
	}
	
}
