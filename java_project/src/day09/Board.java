package day09;

public class Board {

	private String title;
	private int cnt;
	private boolean open;
	
	public Board(String title, int cnt, boolean open) {
		this.title = title;
		this.cnt = cnt;
		this.open = open;
	}
	public String getTitle() {
		return title;
	}
	public int getCnt() {
		return cnt;
	}
	public boolean getOpen() {
		return open;
	}
		
	public void setTitle(String title) {
		this.title = title;
	}	
	public void setCnt(int b) {
		cnt = b;
	}	
	public void setOpen(boolean c) {
		open = c;
	}	
		
	public void cntUp() {
		cnt++;
		}	
	public int cntUp1(int k) {
		 return cnt += k;
		}
	public void print() {
	System.out.printf("%s   %d   %b\n",title,cnt,open);	
	}	
		
		
		
	}
	
	

