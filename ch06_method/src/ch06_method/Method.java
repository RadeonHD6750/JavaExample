package ch06_method;

import java.util.Scanner;

/******************************************************
*
* 클래스명 | Metohd
* 	
* 내용       | 함수(=메소드)를 설명하기 위한 클래스
* 
* 작성일    | 2023.04.07
* 소속       | 개발1팀
* 직급       | 주임
* 성명       | 서지민
****************************************************/

public class Method {

	public static void main(String[] args) {
		
		/******************************************************
		* 함수(=Method)
		* 
		* 자주 쓰는 기능을들 묶어놓고 두고두고 먹을 수 있다.
		****************************************************/
		
		Scanner scanner = new Scanner(System.in); 
		
		
		
		//사칙연산 예제
		String isCalculator = "y";
		
		while("y".equals(isCalculator))
		{
			isCalculator = Calculator(scanner);
		}
		
		System.out.println("\n\n=====================번호입력 예제================\n");
		
		//전화번호 입력 예제
		boolean isPhoneNumber = false;
		
		int retryLimit = 5;
		int retryCount = 0;
		
		for(int i = 0; i < retryLimit && !isPhoneNumber; i++)
		{
			isPhoneNumber = PhoneNumberInput(scanner);
			
			retryCount = i + 1;
		
			System.out.printf("총 시도 횟수 %d,  남은 횟수 %d  \n\n", retryCount,  retryLimit - retryCount);
		}
		
		if(retryCount > 0 && isPhoneNumber)
		{
			System.out.println("휴대전화 번호가 입력되었습니다.");
		}
		else
		{
			System.out.println("입력을 너무 많이 시도하고 있습니다. 해킹시도 의심");
		}
		
		
		//재귀함수 예제
		
		scanner.close();

	}
	
	//계산기 예제
	
	//메인로직
	 public static String Calculator(Scanner scanner)
	{
		System.out.print("숫자를 입력하세요 >> ");
		String inputUserData1 = scanner.nextLine();
		
		System.out.print("숫자를 입력하세요 >> ");
		String inputUserData2 = scanner.nextLine();
		
		double dataDouble1 = Double.parseDouble(inputUserData1);
		double dataDouble2 = Double.parseDouble(inputUserData2);
		
		double result = 0;

		System.out.print("1더하기, 2빼기, 3곱하기, 4나누기, 5팩토리얼 >> ");
		String userInputOperationStr = scanner.nextLine();
		int operation = Integer.parseInt(userInputOperationStr);
		
		String operationName = "";
		
		//잘못된 입력 1차 방어선
		if(operation <= 0 || 5 < operation)
		{
			System.out.println("잘못입력된 연산입니다. 강제로 더하겠습니다.");
			operation = 1;
		}
			
		
		//정의된 함수안에서 또 함수를 호출하는 것도 가능하다.
		//이것을 극대화하여 활용한 것이 재귀함수라고 따로 있음
		switch(operation)
		{
			case 1:
				result = ADD(dataDouble1, dataDouble2);
				operationName = " 더하기 ";
				break;
				
			case 2:
				result = SUB(dataDouble1, dataDouble2);
				operationName = " 빼기 ";
				break;
				
			case 3:
				result = MUL(dataDouble1, dataDouble2);
				operationName = " 곱하기 ";
				break;
				
			case 4:
				result = DIV(dataDouble1, dataDouble2);
				operationName = " 나누기 ";
				break;
				
			//팩토리얼 구하기 추가
			//이런식으로 메인로직에서 다른 서브함수들을 호출함으로써
			//기능 추가 등의 유지보수가 용이하다.
			case 5:
				result = Factorial((int) dataDouble1);
				operationName = " 팩토리얼 ";
				break;
				
			//잘못된 입력 2차 방어선, 지정된 값 이외에 예외처리
			//그러나 dafault 구문이 있다면 컴퓨터는 헤시 테이블을 생성하지 않아 속도는 저하됨.
			//고로 앞단에서 if문 등으로 충분히 방어해야함
			default:
				System.out.println("잘못입력된 연산입니다. 강제로 더하겠습니다.");
				result = dataDouble1 + dataDouble2;
				operationName = " 더하기 ";
				
		}
		
		System.out.printf("\n %.03f " + operationName + " %.03f  는  %.03f \n", dataDouble1, dataDouble2, result );
		
		System.out.print("계속하겠습니까? y, n >> ");
		String isCalculator = scanner.nextLine();
		
		System.out.println("\n");
		
		return isCalculator;
	}
	 
	 
	//지원함수 or 서브함수
	public static double ADD(double a, double b)
	{
		return a + b;
	}
	
	public static double SUB(double a, double b)
	{
		return a - b;
	}
	 
	public static double MUL(double a, double b)
	{
		return a * b;
	}
	 
	public static double DIV(double a, double b)
	{
		return a / b;
	}
	 
	 
	 
	 
	 
	 
	//전화번호 예제
	public static boolean PhoneNumberInput(Scanner scanner)
	{
		
		System.out.print("휴대전화 번호를 입력해주세요 >> ");
		String retryPhoneNumber = scanner.nextLine();
		
		boolean retryisPhoneNumberEmpty = retryPhoneNumber.isEmpty();
		boolean retryisPhoneNumberLength11 = retryPhoneNumber.length() == 11;
		
		//비어 있으면 안되기에 !로 반전시키기
		boolean isPhoneNumber = !retryisPhoneNumberEmpty && retryisPhoneNumberLength11;
		
		//상황대응하기
		//실무에서는 훨씬 더 다양하게 방어를 해야한다.
		if(retryisPhoneNumberEmpty)
		{
			System.out.println("\n휴대전화 번호를 입력해주세요");
		}
		else if(0 < retryPhoneNumber.length() && retryPhoneNumber.length() < 11)
		{
			System.out.println("\n휴대전화 번호를 마저 입력해주세요");
		}
		else if(11 < retryPhoneNumber.length())
		{
			System.out.println("\n휴대전화 번호를 너무 많이 입력했습니다.");
		}
		System.out.println("\n\n");
		
		return isPhoneNumber;
	}
	
	
	/******************************************************
	* 재귀함수 예제
	* 
	* 자기 자신을 호출하여 처리는 기법
	* 
	* 함수 호출을 함에 있어 오버헤드가 소요되고 탈출로직이 필요하고
	* 결정적으로 메모리가 누수되어 터질 수 있기에 특수기능이 아닌 이상
	* 실무에서는 그닥 사용하는 기법은 아니다.
	****************************************************/
	
	
	//팩토리얼 구하기
	public static long Factorial(int num) {
		if(num == 1) {
			return 1;
		}
		return num * Factorial(num-1);
	}

}
