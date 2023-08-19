package day10;

public class User {
	private String name;
	private String id;
	private String pw;
	
	public User() {
	 //this("홍길돌,"aaa","1234");
	}
	
	public User(String name, String id, String pw) {
		//this(); -> 생성자 위의 자기자신을 부름
		this.name = name;
		this.id = id;
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public void print() {
		System.out.printf("%s\t%s\t%s\n",name,id,pw);
	}
	

}
