package ex01;

public class Student {
	//필드
	private String sno; //private는 외부에서 수정 불가능하게 함
	private String sname; 
	private String address; 
	private String dept = "컴정과"; //데이터가 모두 동일하면 기본값 설정
	
	// 생성자는 객체(object)를 생성
	// 기본 생성자는 생략 가능
	
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno; 
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	@Override
	public String toString() { //자바빈 source ->toString
		return "Student [sno=" + sno + ", sname=" + sname + ", address=" + address + ", dept=" + dept + "]";
	}

	
	//생성자
	public Student() {// 기본생성자가 하나이면 생략이 가능하지만 
		//생성자가 여러개이면 기본생성자 반드시 작성해주어야 함
		
	}
	
	public Student(String sno, String sname, String address) {
		super(); //상위 생성자, 현재는 생략 가능
		this.sno = sno;
		this.sname = sname;
		this.address = address;
	}
	
	
	
	
	
	
	
}
