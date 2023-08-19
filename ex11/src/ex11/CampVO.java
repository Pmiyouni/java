package ex11;

public class CampVO {
	private String cno; //캠핑장번호
	private String cname; //캠핑장명
	private String juso;
	private String tel;
	
	public String getCno() {
		return cno;
	}
	public void setCno(String cno) {
		this.cno = cno;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getJuso() {
		return juso;
	}
	public void setJuso(String juso) {
		this.juso = juso;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	@Override
	public String toString() {
		return "CampVO [cno=" + cno + ", cname=" + cname + ", juso=" + juso + ", tel=" + tel + "]";
	}
	
	

}
