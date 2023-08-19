package day11;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.text.DateFormatter;

public class Account {
	private String name;
	private String account;
	private int balance;
	private String joindate;
	private static  int num=100; // static(정적)는 공유 데이터로  다른 개체에도 연결됨
	
	
	
	public Account() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 hh:mm:ss");
		joindate = dtf.format(LocalDateTime.now());
	}
	
	public void deposit(int inmoney) { //입금금액 받음
		balance += inmoney;  //입금 (balance 에 증가)
	}
	
	public Boolean withdraW(int outmoney) {
		if(balance >= outmoney) { // 잔액부족인지 물어봄
			balance -= outmoney;  // 출금
			return true; // 출금하면 true 리턴
		} else {
			return false; // 실패하면 false 리턴
		}
		
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = (num++) + " " +account;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public void print() {
		System.out.printf("%s\t %s\t %d\t %s\n",name,account,balance,joindate);
	}
	
	
	
	
}
// 객체마다 필드명이 동일헤도 각각 고유의 필드가 독립되어있음
// 계좌생성일때 각 객체가 생길떼마다 계속 새로 셋팅, 연관이 없음
// 하지만 static(정적)는 공유 데이터로  다른 개체에도 연결되어 값이 같이 바뀜