package ex11;

public class TypeVO {
	private int tno;
	private String tname;
	
	public int getTno() {
		return tno;
	}
	public void setTno(int tno) {
		this.tno = tno;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	@Override
	public String toString() {
		return "TypeVO [tno=" + tno + ", tname=" + tname + "]";
	}
}
