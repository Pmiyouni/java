package ex02;

public class ScoreVO {//성적관리를 위한 자바빈
	private String no;
	private String name;
	private int kor;
	private int eng;
	private int mat;
	private int tot;
	private double avg;
	private String grade;
	
	
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	public int getTot() {
		return tot;
	}
	public void setTot(int tot) {
		this.tot = tot;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
		
	@Override
	public String toString() { // 사용하지 않아도 존재하는 것은 관계없음
		return "ScoreVO [no=" + no + ", name=" + name + ", kor=" + kor + ", eng=" + eng + ", mat=" + mat + ", tot="
				+ tot + ", avg=" + avg + ", grade=" + grade + "]";
	}
	public ScoreVO() { //기본생성자
		
	}
	public ScoreVO(String no, String name, int kor, int eng, int mat) {//매개변수 있는 생성자
		super();//상위 생성자 즉 기본생성자를 의미함, 생략 가능함
		this.no = no;
		this.name = name; 
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}
	
	public void print_land() {//가로 출력
		System.out.printf("%s\t%s\t%d\t%d\t%d\t%d\t%.2f\t%s\n",
				no,name,kor,eng,mat,tot,avg,grade);
		}
	public void print_port() {
		System.out.println("학번  "+no);
		System.out.println("이름  "+name);
		System.out.println("국어  "+kor);
		System.out.println("영어  "+eng);
		System.out.println("수학  "+mat);
		System.out.println("총점  "+tot);
		System.out.printf("평균  %.2f\n",avg);
		System.out.println("학점  "+grade);
	}
	
	
	

}
