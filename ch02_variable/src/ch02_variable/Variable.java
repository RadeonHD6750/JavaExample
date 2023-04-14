package ch02_variable;


/******************************************************
 *
 * 클래스명 | Variable
 * 	
 * 내용       | 변수를 설명하기 위한 예제 클래스
 * 
 * 작성일    | 2023.04.06
 * 소속       | 개발1팀
 * 직급       | 주임
 * 성명       | 서지민
 ****************************************************/

public class Variable {

	public static void main(String[] args)
	{
		
		
		/******************************************************
		* 변수
		* 
		* 데이터를 다루기 위하여 필수적으로 만들어야 하는 것
		* 
		* 디버깅이라도 최대한 변수로 따로 빼놓아야 한다.
		****************************************************/
		
		System.out.println("=================변수 예제==============\n");
		
		//int 인원수처럼 딱딱 떨어진다. (정수)
		int personNumber = 10;
		System.out.println("personNumber = " + personNumber);
		
		
		//double 거리처럼 소수점이 들어간다. (실수)
		double distance = 50.5; //meters
		System.out.println("distance = " + distance);
		
		
		//char 문자 한개를 담는다.
		char alphabet = 'a';
		System.out.println("alphabet = " + alphabet);
		
		
		//char 보다는 문장을 담을 수 있는 String을 주로 사용한다.
		String comment = "안녕하세요.";
		System.out.println("comment = " + comment);
		
		
		//한글자라도 문장으로 취급하여 담을 수도 있다.
		String alphabetStr = "a";
		System.out.println("alphabetStr = " + alphabetStr);
		
		
		//논리연산의 결과를 담을 수 있다.
		boolean compare = 10 > 5;
		System.out.println("isWorking = " + compare);
		
		
		//이렇게 한번에 선언할 수도 있다.
		int kor = 80, eng = 70, math = 80;
		
		
		//요렇게 반드시 변수가 있어야 데이터들을 다룰 수 있다.
		double avg = (kor + eng + math) / 3;
		System.out.println("avg = " + avg);
		
		
		
		System.out.println("\n=================변수 예제 끝==============\n\n\n");
		
		
		/******************************************************
		* 형변환
		* 
		* 데이터가 담긴 그릇을 개조해야될 때 사용
		****************************************************/
		
		System.out.println("=================형변환 예제==============\n");
		
		
		//자동 형변환
		//int로 시작했으나 끝은 double로써 자동으로 변환된 경우
		double avgAuto = (kor + eng + math) / 3; 
		System.out.println("avgAuto = " + avg);
		
		
		
		//수동 형변환 (가능시에만)
		//소수점을 제거하는 용도로써 사용하기도함
		int avgDeletePoint = (int) avgAuto;
		System.out.println("avgDeletePoint = " + avgDeletePoint + " <= 소수점 제거됨");
		
		
		
		
		//주로 쓰는 활용방법
		
		//01. 문자열을 숫자로 변환
		//데이터들이 어쩔 수 없이 문자열로 오는 경우
		String strNumber = "45.34";
		System.out.println("변환전 strNumber = " + strNumber);
		
		
		
		//이렇게 변환을 해야 다른 double들끼리 연산이 가능
		double doubleNumber =  Double.parseDouble(strNumber);
		System.out.println("변환후 doubleNumber = " + doubleNumber);
		
		
		System.out.println("\n=================형변환 예제 종료==============\n\n\n");
		
	}

}
