package ex08;

import java.util.Date;

public class DetailVO { //거래내역 VO 생성
	private int dno;   // 거래번호
	private int ano;   // 계좌번호
	private int amount;   //금액
	private String type;  // 구분
	private Date ddate;  //거래일
	
	public int getDno() {
		return dno;
	}
	public void setDno(int dno) {
		this.dno = dno;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getDdate() {
		return ddate;
	}
	public void setDdate(Date ddate) {
		this.ddate = ddate;
	}
	@Override
	public String toString() {
		return "DetailVO [dno=" + dno + ", ano=" + ano + ", amount=" + amount + ", type=" + type + ", ddate=" + ddate
				+ "]";
	}
}
