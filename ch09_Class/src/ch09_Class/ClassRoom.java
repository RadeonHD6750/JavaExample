package ch09_Class;

import java.util.ArrayList;
import java.util.List;



/******************************************************
*
* 클래스명 | ClassRoom
* 	
* 내용       | 학습반을 설계하기 위함
* 
* 작성일    | 2023.04.07
* 소속       | 개발1팀
* 직급       | 주임
* 성명       | 서지민
****************************************************/

public class ClassRoom {
	
	
	Teacher mainTeacher;
	ArrayList<Student> studentList;
	
	public ClassRoom()
	{
		studentList = new ArrayList<Student>();
	}
	
	public ClassRoom(Teacher mainTeacher)
	{
		this.mainTeacher = mainTeacher;
	}
	
	/******************************************************
	* 수업하기
	****************************************************/
	
	
	
	/******************************************************
	* 학생관리
	* 
	* 실무 로직
	* 
	* Create
	* Read
	* Update
	* Delete
	* 
	* 현업에서 데이터를 다룬다는 것은 거진 위 네가지 항목을 
	* 구현하는 것이다.
	* 
	* 보통 데이터베이스 언어인 SQL의 구분을 인용하여 명명한다.
	****************************************************/
	
	//학생 추가
	public void insertStudent(Student student)
	{
		studentList.add(student);
	}
	
	//학생목록 조회
	public List<Student> selectAllStudent(Student student)
	{
		return studentList;
	}
	
	//특정 학생 조회
	public Student selectStudentElement(Student student)
	{
		String targetStudentNumber = student.GetStudentNumber();
		
		
		for(int i = 0; i < studentList.size(); i++)
		{
			
			Student temp = studentList.get(i);
			
			
			//학생을 찾았다.
			if(temp.GetStudentNumber().equals( targetStudentNumber))
			{
				return temp;
			}
		}
		
		return null;
	}
	
	//특정 학생 개인정보 수정
	public void updateStudent(Student student)
	{
		String targetStudentNumber = student.GetStudentNumber();
		
		
		for(int i = 0; i < studentList.size(); i++)
		{
			
			Student temp = studentList.get(i);
			
			
			//학생을 찾았다.
			if(temp.GetStudentNumber().equals( targetStudentNumber))
			{
				studentList.set(i, student);
				
				break;
			}
		}
	}
	
	//학생 재적
	public void deleteStudent(Student student)
	{
		studentList.remove(student);
	}
	
	//학습반 만료
	public void clearStudent()
	{
		studentList.clear();
	}


}
