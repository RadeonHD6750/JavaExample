package ch03_operator;


/******************************************************
*
* 클래스명 | Operator
* 	
* 내용       | 연산자를 설명하기 위한 예제 클래스
* 
* 작성일    | 2023.04.06
* 소속       | 개발1팀
* 직급       | 주임
* 성명       | 서지민
****************************************************/

public class Operator {

	public static void main(String[] args) {
		
		/******************************************************
		* 산술연산자
		* 
		* 일상생활에서도 흔히 사용
		* 
		* 나눗셈의 경우 형변환이 필요할 수 있으니 유의
		****************************************************/
		
		System.out.println("\n\n =========================산술연산 예제========================\n");
		
		int data1 = 2;
		int data2 = 3;
		
		int add = data1 + data2;
		int sub = data1 - data2;
		int mul = data1 * data2;
		int div = data1 / data2;

		System.out.println("data1(" + data1 + ") + data2(" + data2 + ") = " + add);
		System.out.println("data1(" + data1 + ") - data2(" + data2 + ") = " + sub);
		System.out.println("data1(" + data1 + ") * data2(" + data2 + ") = " + mul);
		System.out.println("data1(" + data1 + ") / data2(" + data2 + ") = " + div + " <== 뭔가 이상함");
		
		//강제 형변환
		double divForceToDouble = (double) data1 / data2;
		
		
		//정수끼리의 연산이어도 나눗셈은 실수형으로 변환해줘야 한다.
		System.out.println("data1(" + data1 + ") / data2(" + data2 + ") = " + divForceToDouble + " <== 자료형 설계의 중요성");
		
		
		System.out.println("\n\n 형변환으로 인한 부하는 둘째치고");
		System.out.println("데이터 손실을 방지하기 위하여");
		System.out.println("처음부터 자료형 설계를 잘 하여야 한다. \n");
		double dataDouble1 = 2;
		double dataDouble2 = 3;
		
		double addDouble = dataDouble1 + dataDouble2;
		double subDouble = dataDouble1 - dataDouble2;
		double mulDouble = dataDouble1 * dataDouble2;
		double divDouble = dataDouble1 / dataDouble2;
		
		System.out.println("dataDouble1(" + dataDouble1 + ") + dataDouble2(" + dataDouble2 + ") = " + addDouble);
		System.out.println("dataDouble1(" + dataDouble1 + ") - dataDouble2(" + dataDouble2 + ") = " + subDouble);
		System.out.println("dataDouble1(" + dataDouble1 + ") * dataDouble2(" + dataDouble2 + ") = " + mulDouble);
		System.out.println("dataDouble1(" + dataDouble1 + ") / dataDouble2(" + dataDouble2 + ") = " + divDouble);
		
		
		int oddNumber = 7;
		int evenNumber = 2;
		
		int oddModNumber = 7 % 2;
		int evenModNumber = 2 % 2;
		
		System.out.println("임의의 자연수 " + oddNumber + "를 2로 나눈 나머지값은 " + oddModNumber);
		
		
		System.out.println("\n\n =========================산술연산 예제 끝========================\n");
		
		
		
		/******************************************************
		* 논리연산자
		* 
		* 일상생활 보다는 제품 기능 구현시 사용
		* 
		****************************************************/
		
	
		System.out.println("\n\n =========================논리연산 예제========================\n");
		
		//같은값인지 비교하기
		boolean oddNumberCompare = oddModNumber == 0;
		System.out.println("임의의 자연수 " + oddNumber + "는 짝수인가? " + oddNumberCompare);
		
		
		//크기비교
		int health = 40;
		boolean isAlive = health > 0;
		System.out.println("체력이 " + health + " 남아있다. 살아있는가? " + isAlive);
		
		
		//AND 연산을 이용한 휴대폰 번호 유효성 검사
		//회원가입시에 주로 사용한다.
		String phoneNumber = "01012345678";
		
		
		boolean isPhoneNumberEmpty = phoneNumber.isEmpty();
		System.out.println(phoneNumber +  " 해당 번호는  비어있는가? " + isPhoneNumberEmpty);
		
		boolean isPhoneNumberLength11 = phoneNumber.length() == 11;
		System.out.println(phoneNumber +  " 해당 번호의 길이가 11자인가? " + isPhoneNumberEmpty);
		
		//비어 있으면 안되기에 !로 반전시키기
		boolean isPhoneNumber = !isPhoneNumberEmpty && isPhoneNumberLength11;
		System.out.println(phoneNumber +  " 고로 해당 번호는 휴대폰 번호인가? " + isPhoneNumber);
		
		
		
		//범위연산
		int age =29;
		boolean is20 = 20 <= age && age <= 29;
		System.out.println(age +  " 해당 나이는 20대인가? " + is20);
		
		
		
		//삼항 조건연산
		//실무에서는 가독성이 안좋고 유지보수가 어렵기에 사장되는 추세
		String ageStr = (20 <= age && age <= 29) ? "20대 입니다." : "20대가 아닙니다.";
		System.out.println(ageStr);
		
		
		
				
		System.out.println("\n\n =========================논리연산 예제 끝========================\n");
	}

}
