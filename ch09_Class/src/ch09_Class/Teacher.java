package ch09_Class;



/******************************************************
*
* 클래스명 | Teacher
* 	
* 내용       | 선생님을 설계하기 위함
* 
* 작성일    | 2023.04.07
* 소속       | 개발1팀
* 직급       | 주임
* 성명       | 서지민
****************************************************/




public class Teacher {
	
	
	//선생님도 똑같이
	//이름, 나이, 폰번호, 주소
	public String name;
	int age;
	
	private String phoneNumber;
	private String address;
	
	private String teacherNumber;
	private String teachingSubject; //담당과목
	
	//생성자도 오버로딩이 가능하다.
	public Teacher()
	{
		System.out.println("초기화가 필요합니다.");
	}
		
	public Teacher(String name)
	{
		this.name = name;
	}

	public Teacher(String name, int age, String phoneNumber, String address, String teacherNumber,
			String teachingSubject) {
		super();
		this.name = name;
		this.age = age;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.teacherNumber = teacherNumber;
		this.teachingSubject = teachingSubject;
	}

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
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTeacherNumber() {
		return teacherNumber;
	}

	public void setTeacherNumber(String teacherNumber) {
		this.teacherNumber = teacherNumber;
	}

	public String getTeachingSubject() {
		return teachingSubject;
	}

	public void setTeachingSubject(String teachingSubject) {
		this.teachingSubject = teachingSubject;
	}
	

}
