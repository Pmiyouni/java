package day11;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class User {
	
	private String name;
	private String id;
	private String pw;
	private String joinDate;
	
	
	
	//생성자 
	public User() {//기본생성자는 미리 셋팅되어져야 하는 것 사용
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-mm-dd hh:mm:ss");
		joinDate =dtf.format(LocalDateTime.now());
		// 클래스에서 만들므로 set 매서드 필요없음, 단 필요하면 get매서드는 가져올때 사용 가능
	}
	
	public User(String name,String id,String pw) {
		//바로 생성하기 위해 매개변수 사용
		//생성자 매개변수 받은 값을 셋팅해서 사용하기 위해
		// (유의)매개변수 타입 정하기
		this();   // 기본생성자를 부름, 매개변수 개수 동일하게 해야함 무조건 다른 생성자를 사용할때는 첫 줄에 위치
		this.name = name;
		this.id = id;
		this.pw = pw;
		//this.joinDated = joinDate;  // 이건 생성자 없을때 main에서 받아서 사용
	
	}
	
	
	//매서드 set/ get
	public void setName(String name) { //객체.setName("안녕")
		this.name = name;
	}
	public String getName() { //객체.getName()
		return name;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getId() {
		return id;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	public String getPw() {
		return pw;
	}
	
	//print 매서드
	public void print() {
		System.out.printf("%s\t%s\t%s\t%s\n",name,id,pw,joinDate);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
