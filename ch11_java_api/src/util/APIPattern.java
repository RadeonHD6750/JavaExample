package util;

import java.util.regex.Pattern;

public class APIPattern {
	
	
	public APIPattern()
	{
		
	}
	
	public void showExample()
	{
		// 정규표현식 (Regular Expression)
		// 특정한 규칙을 가진 문자열의 집합을
		// 표현하기 위해 쓰는 형식
		
		// 전화번호, 주민등록번호, 이메일 등과 같이
		// 정해진 형식에 대해 정규표현식과
		// Pattern을 이용하여 검증할 수 있다.
		
		// 숫자만 존재하는지 검증
		String regex = "^[0-9]+$";
		String example = "12342";
		
		boolean result = Pattern.matches(regex, example);
		System.out.println(example + "의 검증 " + regex 
				+ " 결과 = " + result);
		
		// String 클래스의 matches 에 이미 Pattern 라이브러리의 matches 가 들어가있다!!
		System.out.println(example.matches(regex));
		
		
		// 숫자만 존재하는지 검증 2
		regex = "\\d+";
		example = "243534";
		result = Pattern.matches(regex, example);
		System.out.println(example + "의 검증 " + regex 
				+ " 결과 = " + result);
		
		System.out.println("\n=========================\n");
		
		// 알파벳만 존재하는지 검증
		regex = "[a-zA-Z]+";
		example = "Jeong Chanung";
		result = Pattern.matches(regex, example);
		System.out.println(example + "의 검증 " + regex 
				+ " 결과 = " + result);
		
		// 알파벳만 존재하는지 검증(띄어쓰기 포함)
		regex = "[a-zA-Z\\s]+";
		example = "Jeong Chanung";
		result = Pattern.matches(regex, example);
		System.out.println(example + "의 검증 " + regex 
				+ " 결과 = " + result);
		
		System.out.println("\n==========================\n");
		
		// 한글로만 존재하는지 검증
		regex = "[가-힣]+";
		example = "찬웅";
		result = Pattern.matches(regex, example);
		System.out.println(example + "의 검증 " + regex 
				+ " 결과 = " + result);
		
		System.out.println("\n==========================\n");
		
		// 비밀번호 패턴
		// 영어와 숫자로만 구성
		regex = "[a-zA-Z0-9]+";
		// 영어와 숫자로만 구성 2
		regex = "\\w+";
		example = "akow283";
		result = Pattern.matches(regex, example);
		System.out.println(example + "의 검증 " + regex 
				+ " 결과 = " + result);
		
		// 영어와 숫자 + 특수문자
		regex = "[\\w!@#$%^&*=-_+()]+";
		example = "akow283!";
		result = Pattern.matches(regex, example);
		System.out.println(example + "의 검증 " + regex 
				+ " 결과 = " + result);
		
		// 숫자, 영어 소문자, 영어 대문자, 특수문자
		// 각각 1개 이상 포함된 8~20자리 문자
		regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*\\)\\(_\\-\\+=\\{\\}\\[\\]<>.,/?\\|]).{8,20}$";
		example = "nextIt1234!";
		result = Pattern.matches(regex, example);
		System.out.println(example + "의 검증 " + regex 
				+ " 결과 = " + result);
		
		// 한번에 하기 어려우면 단계별로 적용하기
		regex = "^.{8,20}$";
		example = "nextIt1234";
		result = Pattern.matches(regex, example);
		if(result) {
			System.out.println("자리수 검증 통과");
			// 소문자가 최소 한개 이상?
			regex = "^.*[a-z].*$";
			result = Pattern.matches(regex, example);
			if(result) {
				System.out.println("소문자가 1개 이상");
				regex = "^.*[A-Z].*$";
				result = Pattern.matches(regex, example);
				
				if(result) {
					System.out.println("대문자가 1개 이상");
					regex = "^.*[0-9].*$";
					result = Pattern.matches(regex, example);
					
					if(result) {
						System.out.println("숫자가 1개 이상");
						regex = "^.*[!@#$%^&*\\)\\(_\\-\\+=\\{\\}\\[\\]<>.,/?\\|].*$";
						result = Pattern.matches(regex, example);
						
						if(result) {
							System.out.println("특수문자가 1개 이상");
						}else {
							System.out.println("특수문자가 0개");
						}
					}else {
						System.out.println("숫자가 0개");
					}
				}else {
					System.out.println("대문자가 0개");
				}
			}else {
				System.out.println("소문자가 0개");
			}
		}else {
			System.out.println("8~20자리가 아닙니다.");
		}
		
		System.out.println("\n============================\n");
		
		// 6자리 숫자 비밀번호 중 3자리 이상 반복 금지
		regex = "^.*(\\d)\\1\\1.*$";
		example = "122234";
		result = Pattern.matches(regex, example);
		System.out.println(example + "의 검증 " + regex 
				+ " 결과 = " + result);
		
		// 숫자가 6자리 인지 확인
		regex = "[\\d]{6}";
		example = "122234";
		result = Pattern.matches(regex, example);
		System.out.println(example + "의 검증 " + regex 
				+ " 결과 = " + result);
		
		// 이메일 형식 확인
		regex = "^[\\w]+@[\\w]+\\.[a-z]+$";
		example = "akow283@gmail.com";
		result = Pattern.matches(regex, example);
		System.out.println(example + "의 검증 " + regex 
				+ " 결과 = " + result);
		
		// 연락처 형식 확인
		regex = "^[0-9]{2,3}-[\\d]{3,4}-[\\d]{4}$";
		example = "010-7398-7332";
		result = Pattern.matches(regex, example);
		System.out.println(example + "의 검증 " + regex 
				+ " 결과 = " + result);
	}

}
