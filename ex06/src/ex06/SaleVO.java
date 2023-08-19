package ex06;
import java.util.Date;

	public class SaleVO extends ProductVO{ //상속
		private int scode; // 판매코드
		private int pcode; // 상품코드
		private int qnt;  // 수량
		private int sprice; //가격
		private Date sdate; // 판매일
		
		public int getScode() {
			return scode;
		}
		public void setScode(int scode) {
			this.scode = scode;
		}
		public int getPcode() {
			return pcode;
		}
		public void setPcode(int pcode) {
			this.pcode = pcode;
		}
		public int getQnt() {
			return qnt;
		}
		public void setQnt(int qnt) {
			this.qnt = qnt;
		}
		public int getSprice() {
			return sprice;
		}
		public void setSprice(int sprice) {
			this.sprice = sprice;
		}
		public Date getSdate() {
			return sdate;
		}
		public void setSdate(Date sdate) {
			this.sdate = sdate;
		}
		@Override
		public String toString() {
			return "SaleVO [scode=" + scode + ", pcode=" + pcode + ", qnt=" + qnt + ", sprice=" + sprice + ", sdate="
					+ sdate + "]";
		}
		}
