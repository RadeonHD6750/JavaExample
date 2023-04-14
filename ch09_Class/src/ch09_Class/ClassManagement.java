package ch09_Class;


/******************************************************
*
* 클래스명 | ClassManagement
* 	
* 내용       | 학습반 관리 시스템 메인
* 
* 작성일    | 2023.04.07
* 소속       | 개발1팀
* 직급       | 주임
* 성명       | 서지민
****************************************************/

//메인클래스는 보통 제품명으로 한다.
public class ClassManagement {

	public static void main(String[] args) {

		/******************************************************
		* 객체지향 프로그래밍을 실현 시켜주는 핵심기능
		* 
		* 클래스 : 해당 모듈의 설계도
		* 
		* 오늘날 대다수 프로그램들이 클래스로 구현되는 만큼
		* 현업에서의 중요성은 말할 것도 없고 반드시 이해해야될 개념
		****************************************************/
		
		//Student.java에 명시된 클래스라는 설계도를 가지고 찍어낸
		//student1 객체
		Student student0 = new Student();
		
		
		Student student1 = new Student("홍길동1111"); //초기화 안해줌
		
		
		System.out.println("student0 " + student0);
		
		//student2 객체
		Student student2 = new Student("서지민", 20, "01012345678",
				"대전시 동구", "2002949", 78, 86, 76, 0
				
				); //초기화 진행
		
		
		System.out.println("객체 수정 전");
		System.out.println("student1 " + student1);
		System.out.println("student2 " + student2);
		
		//핵심개념
		//클래스라는 설계도를 변경하지  않는 이상
		//특정 객체를 수정한다고 해서 다른 객체가 변하지 않는다.
		student1.setName("홍길동");
		
		System.out.println("객체 수정 후");
		System.out.println("student1 " + student1);
		System.out.println("student2 " + student2);
		
		
		
		//학습반을 꾸려야 하니 선생님도 배정해준다.
		Teacher javaTeacher = new Teacher(
				"서지민2", 29, "01012345678", "대전시 대덕구", 
				"062610", "JAVA"
				);
		
		
		//본격적으로 학습반을 만든다.
		ClassRoom javaClassRoom = new ClassRoom(javaTeacher);
		
		
		//학생들을 해당 학습반에 등록시킨다.
		javaClassRoom.insertStudent(student0);
		javaClassRoom.insertStudent(student1);
		javaClassRoom.insertStudent(student2);
	}

}
