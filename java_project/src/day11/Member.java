package day11;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Member {

	private Long id; 
	// 셋팅 되는 경우에는 long이 0이면 의미가 있는 값으로 문제가 있으므로
	// Long은 0이 아닌 null로 셋팅됨(Long는 클래스임)
	private String  email; // 기본값은 null (null과 " "는 다름)
	private String  pw;
	private String  name;
	private String  joinDate;
	
	
	public Member() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 hh:mm:ss");
		joinDate = dtf.format(LocalDateTime.now());
	}
	
	public Member(Long id, String email, String  pw, String  name) {
		this(); //기본생성자를 호출(날짜시간 받음)
		//this는 자기자신 객체
		//DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy년 mm월 dd일 hh:mm:ss");
		//joinDate = dtf.format(LocalDateTime.now());
		//위의 날짜시간이  문장이 중복이므로 기본생성자 호출
		this.id = id;
		this.email = email;
		this.pw = pw;
		this.name = name;
		
	}
	
	
//	public Member(Long id, String email, String  pw) {
//		this.id = id;
//		this.email = email;
//		this.pw = pw;
//		
//	}
//	public Member(Long id, String email, String  pw, String  name) {
//		this(id,email,pw);	// 3개 매개변수 생성자를 불러와서 받음
	     // 제일 첫줄에 위치하여야함 
//		this.name = name; //나머지 name 대입
//	}
	
	
	 public void setId(long id) {
		 this.id = id;
	 }
	 public Long getId() {
		 return id;
	 }
	 public void setPw(String pw) {
		 this.pw = pw;
	 }
	 public String getPw() {
		 return pw;
	 }
	 public void setName(String name) {
		 this.name = name;
	 }
	 public String getName() {
		 return name;
	 }
	 public void setEmail(String email) {
		 this.email = email;
	 }
	 public String getEmail() {
		 return email;
	 }

	 public void print() {
		 System.out.printf("%d\t %s\t %s\t %s\t %s\n",id,email,pw,name,joinDate);
	 }
	 // 매서드 안에는 생성자는 넣을 수 없음

} 
