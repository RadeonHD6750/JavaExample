package ch04_standardIO;

import java.util.Scanner;

/******************************************************
*
* 클래스명 | StandardIO
* 	
* 내용       | 표준입출력을 설명하기 위한 예제 클래스
* 
* 작성일    | 2023.04.06
* 소속       | 개발1팀
* 직급       | 주임
* 성명       | 서지민
****************************************************/


public class StandardIO {

	public static void main(String[] args) {
		
		
		/******************************************************
		* 출력
		* 
		* 처리결과 확인
		****************************************************/
		
		System.out.println("\n\n =========================출력 예제========================\n");
		System.out.println("이미 많이 사용한 System.out.println");
		
		
		double dataDouble1 = 2;
		double dataDouble2 = 3;
		
		double addDouble = dataDouble1 + dataDouble2;
		double subDouble = dataDouble1 - dataDouble2;
		double mulDouble = dataDouble1 * dataDouble2;
		double divDouble = dataDouble1 / dataDouble2;
		
		System.out.println("dataDouble1(" + dataDouble1 + ") + dataDouble2(" + dataDouble2 + ") = " + addDouble);
		
		
		System.out.printf("출력 형식 지정1 dataDouble1(%f) + dataDouble2(%f) = %.03f \n", dataDouble1, dataDouble2, addDouble);
		System.out.printf("출력 형식 지정2 dataDouble1(%.03f) + dataDouble2(%.03f) = %.03f \n", dataDouble1, dataDouble2, addDouble);
		
		System.out.println("\n\n =========================출력 예제 끝========================\n");
		
		/******************************************************
		* 입력
		* 
		* 데이터 입력
		****************************************************/
		
		System.out.println("\n\n =========================입력 예제========================\n");
		
		Scanner scanner = new Scanner(System.in); 
		
		System.out.print("숫자를 입력하세요 >> ");
		
		//항상 입력은 문자열로 들어옴
		String inputUserData = scanner.nextLine();
		
		//이럴 때 어쩔 수 없이 문자열로 들어오는 데이터를 형변환
		int userNumber = Integer.parseInt(inputUserData);
		
		
		boolean oddNumberCompare = userNumber > 0 && userNumber % 2 == 0;
		System.out.printf("입력한 숫자 %d는 짝수인가? " + oddNumberCompare + "\n\n\n", userNumber);
		
		
		System.out.print("숫자를 입력하세요 >> ");
		String inputUserData1 = scanner.nextLine();
		
		System.out.print("숫자를 입력하세요 >> ");
		String inputUserData2 = scanner.nextLine();
		
		//변수의 재사용
		dataDouble1 = Double.parseDouble(inputUserData1);
		dataDouble2 = Double.parseDouble(inputUserData2);
		
		//변수의 재사용
		addDouble = dataDouble1 + dataDouble2;
		subDouble = dataDouble1 - dataDouble2;
		mulDouble = dataDouble1 * dataDouble2;
		divDouble = dataDouble1 / dataDouble2;
		double modDouble = dataDouble1 % dataDouble2;
		
		System.out.printf("더하기(%.03f)  빼기(%.03f)  곱하기(%.03f)  나누기(%.03f)  나머지(%.03f) \n"
				, addDouble, subDouble, mulDouble, divDouble, modDouble);
		
		
		
		
		
		System.out.print("전화번호를 입력하세요 >> ");
		String phoneNumber = scanner.nextLine();
		
		
		boolean isPhoneNumberEmpty = phoneNumber.isEmpty();
		System.out.println(phoneNumber +  " 해당 번호는  비어있는가? " + isPhoneNumberEmpty);
		
		boolean isPhoneNumberLength11 = phoneNumber.length() == 11;
		System.out.println(phoneNumber +  " 해당 번호의 길이가 11자인가? " + isPhoneNumberLength11);
		
		//비어 있으면 안되기에 !로 반전시키기
		boolean isPhoneNumber = !isPhoneNumberEmpty && isPhoneNumberLength11;
		System.out.println(phoneNumber +  " 고로 해당 번호는 휴대폰 번호인가? " + isPhoneNumber);
		

		//문단속하기
		scanner.close();
		
		System.out.println("\n\n =========================입력 예제 끝========================\n");
	}

}
