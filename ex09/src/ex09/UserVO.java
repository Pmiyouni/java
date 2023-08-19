package ex09;

public class UserVO { // 사용자 값 객체(VO는 실어나르는 의미)
	private String id; //아이디
	private String uname; //이름
	private int point; //포인트
	private String phone; //전화번호
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "UserVO [id=" + id + ", uname=" + uname + ", point=" + point + ", phone=" + phone + "]";
	}
}
