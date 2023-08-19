package ex11;

public class CampTypeVO extends TypeVO{
	private String cno;
	private int tno;
	
	public String getCno() {
		return cno;
	}
	public void setCno(String cno) {
		this.cno = cno;
	}
	public int getTno() {
		return tno;
	}
	public void setTno(int tno) {
		this.tno = tno;
	}
	@Override
	public String toString() {
		return "CampTypeVO [cno=" + cno + ", tno=" + tno + ", getTname()=" + getTname() + "]";
	}	
}
