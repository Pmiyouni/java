package day09;

public class Peolple {

	private String name;
	private int age;
	
	 public Peolple() {// 첫번째 생성자
		 
	 }
	 
	 public Peolple(String name,int age ) { // 두번째 생성자
		 this.name = name;	
		 this.age = age;
	 }

	 public void setName(String name) {// 매개변수를 받음
			this.name = name; // 받은 매개변수 값을 현 클래스 필드 변수에 넣음
		}
		 
		public String getName() {//name을 돌려줌 
			return name;
			
					}

		public void setAge(int age) {
			this.age = age; // 자신의 sound에 매개변수 sound를 대입
			}

		public  int getAge() {// 돌려주기위해 리턴 매서드 작성 
			return age;
}
		
		public void print() {
			System.out.println("이름\t나이");
			System.out.println("================");
			System.out.println(this.name+"\t"+age+"\t");
		}
		
		
		public void ageUp() {
			age +=1;
		}
		public void ageUp1(int a) {
			age += a;
		}
		public int koreanAge() {
			return age-2;
		}
		
}