package ex09;

import java.util.Date;

public class MessageVO extends UserVO{ // extends는 상속으로 부모매서드 그대로 사용
	private int mid; //일련번호
	private String sender; // 보낸이
	private String receiver; // 받은이
	private Date sdate; //전송날짜
	private String message; //메시지
	
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public Date getSdate() {
		return sdate;
	}
	public void setSdate(Date sdate) {
		this.sdate = sdate;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "MessageVO [mid=" + mid + ", sender=" + sender + ", receiver=" + receiver + ", sdate=" + sdate
				+ ", message=" + message + ", getUname()=" + getUname() + "]";
		// toString()에서 상속매서드(inherited methods)에서  getUname() 선택
	}
}
	
	