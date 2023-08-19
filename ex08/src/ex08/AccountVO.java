package ex08;

public class AccountVO { //계좌테이블 VO 생성
	private int ano;  //계좌번호 
	private String aname; //계좌주명
	private int balance;  // 잔액
	
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "AccountVO [ano=" + ano + ", aname=" + aname + ", balance=" + balance + "]";
	}
}
