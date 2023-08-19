package ex03;

public class SaleVO {
	private int code; //상품코드
	private String name; //상품명
	private int price; //단가
	private int qnt;  //수량
	private int sum;  //금액
	
	public SaleVO() { //기본생성자
		
	}

	public SaleVO(int code, String name, int price, int qnt) {
		// 매개변수 있는 생성자 생성
		super();
		this.code = code;
		this.name = name;
		this.price = price;
		this.qnt = qnt;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQnt() {
		return qnt;
	}

	public void setQnt(int qnt) {
		this.qnt = qnt;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	@Override
	public String toString() {
		return "SaleVO [code=" + code + ", name=" + name + ", price=" + price + ", qnt=" + qnt + ", sum=" + sum + "]";
	}
	
	public void print_land() { // 가로 출력
		System.out.printf("%d\t%s\t%d\t%d\t%,d\n",code,name,price,qnt,sum);
	}
}
