package ex11;

public class CampFacilVO extends FacilVO{ // 시설물 번호와 시설물명을 상속받기위해
	private String cno; // 캠핑장 번호
	private int fno; //시설물 번호
	
	public String getCno() {
		return cno;
	}
	public void setCno(String cno) {
		this.cno = cno;
	}
	public int getFno() {
		return fno;
	}
	public void setFno(int fno) {
		this.fno = fno;
	}
	
	@Override
	public String toString() {
		return "CampFacilVO [cno=" + cno + ", fno=" + fno + ", getFname()=" + getFname() + "]";
	}
}