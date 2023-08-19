package ex09;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {//db연결
	public static Connection connect() {
		 //Connection이 타입입. connect()는 매서드
		Connection con = null; //리턴값 지정
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			  con = DriverManager.getConnection(
					  "jdbc:oracle:thin:@localhost:1521:xe",
						"java",
						"pass");
			  //  System.out.println("접속 성공");
			}catch(Exception e) {
				System.out.println("DB 연결"+e.toString());
			}
		return con;  // Connection 타입의 con 변수 값 리턴
	}
}
