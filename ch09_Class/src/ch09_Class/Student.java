package ch09_Class;



/******************************************************
*
* 클래스명 | Student
* 	
* 내용       | 학생을 설계하기 위함
* 
* 작성일    | 2023.04.07
* 소속       | 개발1팀
* 직급       | 주임
* 성명       | 서지민
****************************************************/



public class Student {
	
	public String name;
	int age;
	
	private String phoneNumber;
	private String address;
	
	private String studentNumber;
	
	//각 과목별 점수
	double korScore;
	double engScore;
	double mathScore;
	
	double exp;
	
	
	//생성자도 오버로딩이 가능하다.
	public Student()
	{
		System.out.println("초기화가 필요합니다.");
	}
	
	public Student(String name)
	{
		this.name = name;
	}
	
	//이런식으로도 파라미터 초기화 여부에 따라서
	//생성자 또한 오버로딩이 가능
	public Student(String name, int age, String phoneNumber, String address) {
		
		//super();
		
		this.name = name;
		this.age = age;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.korScore = 0;
		this.engScore = 0;
		this.mathScore = 0;
		this.exp = 0;
		
		System.out.println("초기화 완료");
	}
	
	
	//보통은 밑으로 내려갈 수록 파라미터들이 하나씩
	//채워진다.
	//그래서 맨마지막 생성자는 모든 맴버변수들을 초기화
	//변수의 갯수만큼까지는 아니고 적절히 나누도록 하자
	public Student(String name, int age, String phoneNumber, String address, 
			String studentNumber, double korScore, double engScore,
			double mathScore, double exp) {
		
		//super();
		
		this.name = name;
		this.age = age;
		this.phoneNumber = phoneNumber;
		this.address = address;
		
		this.studentNumber = studentNumber;
		this.korScore = korScore;
		this.engScore = engScore;
		this.mathScore = mathScore;
		this.exp = exp;
		
		System.out.println("초기화 완료");
	}
	
	
	
	//상위 클래스에 설계된 함수를 다시 정의하여 개조하는 것이
	//오버라이딩
	
	//오버로딩은 중복선언이고
	//오버라이딩은 재정의
	@Override
	public String toString() {
		return "이름 = " + name;
	}

	
	
	
	//중요한 정보일 수록 직접접근하는 것이 아닌
	//함수를 통하여 필터링 해준다.
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		
		//번호 같은 경우도 그냥 변경하는 것이 아닌
		//유효성 체크도 하고 최종 반영하게할 수 있다.
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	public void setStudentNumber(String studentNumber)
	{
		this.studentNumber = studentNumber;
	}
	
	public String GetStudentNumber()
	{
		return studentNumber;
	}
	

	public double getKorScore() {
		return korScore;
	}

	public void setKorScore(double korScore) {
		this.korScore = korScore;
	}

	public double getEngScore() {
		return engScore;
	}

	public void setEngScore(double engScore) {
		this.engScore = engScore;
	}

	public double getMathScore() {
		return mathScore;
	}

	public void setMathScore(double mathScore) {
		this.mathScore = mathScore;
	}

	public double getExp() {
		return exp;
	}

	public void setExp(double exp) {
		this.exp = exp;
	}

	

}
