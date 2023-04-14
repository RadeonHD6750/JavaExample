package ch10_person;

public class Person {
	
	private String name;
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

	private int age;
	private String phoneNumber;
	private String address;
	
	public Person(String name)
	{
		this.name = name;
	}
	
	public Person(String name, int age, String phoneNumber, String address) {
		super();
		this.name = name;
		this.age = age;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	@Override
	public String toString() {
		return "이름 = " + name;
	}


}
