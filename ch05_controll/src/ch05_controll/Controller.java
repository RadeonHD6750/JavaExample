package ch05_controll;

import java.util.Scanner;

/******************************************************
*
* 클래스명 | Controller
* 	
* 내용       | 각종 제어문을 설명하기 위한 예제 클래스
* 
* 작성일    | 2023.04.06
* 소속       | 개발1팀
* 직급       | 주임
* 성명       | 서지민
****************************************************/


public class Controller {

	public static void main(String[] args) {
		
		
		System.out.println("\n\n =========================조건문 예제========================\n");
		
		
		
		/******************************************************
		* 조건문
		* 
		* 각종 데이터로 하여금 조건을 판별하여 프로그램의 흐름을 제어
		****************************************************/
		
		
		
		System.out.print("전화번호를 입력하세요 >> ");
		Scanner scanner = new Scanner(System.in); 
		
		
		String phoneNumber = scanner.nextLine();
		
		boolean isPhoneNumberEmpty = phoneNumber.isEmpty();
		boolean isPhoneNumberLength11 = phoneNumber.length() == 11;
		
		//비어 있으면 안되기에 !로 반전시키기
		boolean isPhoneNumber = !isPhoneNumberEmpty && isPhoneNumberLength11;
		
		//한방에 잘 입력한 경우
		if(isPhoneNumber)
		{
			System.out.println("휴대전화 번호가 입력되었습니다.");
		}
		
		//상황대응하기
		//실무에서는 훨씬 더 다양하게 방어를 해야한다.
		else if(isPhoneNumberEmpty)
		{
			System.out.println("휴대전화 번호를 입력해주세요");
		}
		else if(0 < phoneNumber.length() && phoneNumber.length() < 11)
		{
			System.out.println("휴대전화 번호를 마저 입력해주세요");
		}
		else if(11 < phoneNumber.length())
		{
			System.out.println("휴대전화 번호를 너무 많이 입력했습니다.");
		}
		
		
		
		
		System.out.println("\n\n============사칙연산 계산기================\n\n");
		
		System.out.print("숫자를 입력하세요 >> ");
		String inputUserData1 = scanner.nextLine();
		
		System.out.print("숫자를 입력하세요 >> ");
		String inputUserData2 = scanner.nextLine();
		
		double dataDouble1 = Double.parseDouble(inputUserData1);
		double dataDouble2 = Double.parseDouble(inputUserData2);
		
		double result = 0;

		System.out.print("1더하기, 2빼기, 3곱하기, 4나누기 >> ");
		String userInputOperationStr = scanner.nextLine();
		int operation = Integer.parseInt(userInputOperationStr);
		
		String operationName = "";
		
		//잘못된 입력 1차 방어선
		if(operation <= 0 || 4 < operation)
		{
			System.out.println("잘못입력된 연산입니다. 강제로 더하겠습니다.");
			operation = 1;
		}
			
		
		switch(operation)
		{
			case 1:
				result = dataDouble1 + dataDouble2;
				operationName = " 더하기 ";
				break;
				
			case 2:
				result = dataDouble1 - dataDouble2;
				operationName = " 빼기 ";
				break;
				
			case 3:
				result = dataDouble1 * dataDouble2;
				operationName = " 곱하기 ";
				break;
				
			case 4:
				result = dataDouble1 / dataDouble2;
				operationName = " 나누기 ";
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
		
		
		System.out.println("\n\n =========================조건문 예제 끝========================\n");
		
		
		
		
		
		
		
		
		
		
		
		System.out.println("\n\n =========================반복문 예제========================\n");
		
		

		/******************************************************
		* 반목문
		* 
		* 뭔가 반복할 일이 있거나 재시도할 때 사용
		****************************************************/
		
		//숙달연습용 로직
		
		
		
		
		
		
		
		
		//실무용 로직
		
		
		
		
		
		
		
		//계산기 예제
		String isCalculator = "y";
		
		
		//고정 문자열에서 equals를 호출해야 null 예외가 발생하지 않는다.
		while("y".equals(isCalculator))
		{
			System.out.print("숫자를 입력하세요 >> ");
			inputUserData1 = scanner.nextLine();
			
			System.out.print("숫자를 입력하세요 >> ");
			inputUserData2 = scanner.nextLine();
			
			dataDouble1 = Double.parseDouble(inputUserData1);
			dataDouble2 = Double.parseDouble(inputUserData2);
			
			result = 0;

			System.out.print("1더하기, 2빼기, 3곱하기, 4나누기 >> ");
			userInputOperationStr = scanner.nextLine();
			operation = Integer.parseInt(userInputOperationStr);
			
			operationName = "";
			
			//잘못된 입력 1차 방어선
			if(operation <= 0 || 5 < operation)
			{
				System.out.println("잘못입력된 연산입니다. 강제로 더하겠습니다.");
				operation = 1;
			}
				
			
			switch(operation)
			{
				case 1:
					result = dataDouble1 + dataDouble2;
					operationName = " 더하기 ";
					break;
					
				case 2:
					result = dataDouble1 - dataDouble2;
					operationName = " 빼기 ";
					break;
					
				case 3:
					result = dataDouble1 * dataDouble2;
					operationName = " 곱하기 ";
					break;
					
				case 4:
					result = dataDouble1 / dataDouble2;
					operationName = " 나누기 ";
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
			isCalculator = scanner.nextLine();
			
		}
		System.out.println("\n\n===============================\n ");
		
		
		
		
		
		
		//전화번호 입력 예제
		//상태 초기화
		isPhoneNumber = false;
		
		
		while(!isPhoneNumber)
		{
			System.out.print("휴대전화 번호를 다시 입력해주세요 >> ");
			String retryPhoneNumber = scanner.nextLine();
			
			boolean retryisPhoneNumberEmpty = retryPhoneNumber.isEmpty();
			boolean retryisPhoneNumberLength11 = retryPhoneNumber.length() == 11;
			
			//비어 있으면 안되기에 !로 반전시키기
			isPhoneNumber = !retryisPhoneNumberEmpty && retryisPhoneNumberLength11;
			
			//상황대응하기
			//실무에서는 훨씬 더 다양하게 방어를 해야한다.
			if(retryisPhoneNumberEmpty)
			{
				System.out.println("휴대전화 번호를 입력해주세요");
			}
			else if(0 < retryPhoneNumber.length() && retryPhoneNumber.length() < 11)
			{
				System.out.println("휴대전화 번호를 마저 입력해주세요");
			}
			else if(11 < retryPhoneNumber.length())
			{
				System.out.println("휴대전화 번호를 너무 많이 입력했습니다.");
			}
			System.out.println("\n\n");
		}
		System.out.println("휴대전화 번호가 입력되었습니다.\n\n");
		
		
		
		
		
		
		System.out.println("for문을 이용한 반복시도 탐지하기");
		
		//상태 초기화
		isPhoneNumber = false;
		
		int retryLimit = 5;
		int retryCount = 0;
		
		for(int i = 0; i < retryLimit && !isPhoneNumber; i++)
		{
			System.out.print("휴대전화 번호를 다시 입력해주세요 >> ");
			String retryPhoneNumber = scanner.nextLine();
			
			boolean retryisPhoneNumberEmpty = retryPhoneNumber.isEmpty();
			boolean retryisPhoneNumberLength11 = retryPhoneNumber.length() == 11;
			
			//비어 있으면 안되기에 !로 반전시키기
			isPhoneNumber = !retryisPhoneNumberEmpty && retryisPhoneNumberLength11;
			
			//상황대응하기
			//실무에서는 훨씬 더 다양하게 방어를 해야한다.
			if(retryisPhoneNumberEmpty)
			{
				System.out.println("휴대전화 번호를 입력해주세요");
			}
			else if(0 < retryPhoneNumber.length() && retryPhoneNumber.length() < 11)
			{
				System.out.println("휴대전화 번호를 마저 입력해주세요");
			}
			else if(11 < retryPhoneNumber.length())
			{
				System.out.println("휴대전화 번호를 너무 많이 입력했습니다.");
			}
			
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
		
		
		scanner.close();
		
		
		System.out.println("\n\n =========================반복문 예제 끝========================\n");
	}

}
