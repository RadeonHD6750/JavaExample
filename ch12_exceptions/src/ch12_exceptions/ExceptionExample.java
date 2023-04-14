package ch12_exceptions;

import java.text.ParseException;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

import ch10_person.Person;

/******************************************************
*
* 클래스명 | ExceptionExample
* 	
* 내용       | 예외처리 메인 클래스
* 
* 작성일    | 2023.04.11
* 소속       | 개발1팀
* 직급       | 주임
* 성명       | 서지민
****************************************************/


public class ExceptionExample {

	public static void main(String[] args) {
		
		
		/******************************************************
		* 예외처리
		* 
		* 설계단계에서부터 컴파일 단계까지도 발견되지 않는 오류
		* 
		* 대다수가 코딩실수이며, 몇몇이 치명적이긴 해도 금방 보수가 가능한 특징
		* 
		* 
		****************************************************/
		

		
		
		
		/******************************************************
		* 01. 인덱스 범위 초과한 예외처리
		* 
		* 사실 이정도는 코딩단계에서 예측하여 미리 선조치가 가능
		* 
		* 예측이 안될 때는 아예 ArrayList를 사용하면 된다.
		****************************************************/
	

		int[] testArrays = {1, 2, 3};
		
		int selectIndex = 100;
		
		try 
		{
			System.out.println(testArrays[selectIndex]);
		}
		catch(ArrayIndexOutOfBoundsException exception)
		{
			exception.printStackTrace();
			// 에러가 콘솔창에 출력되는 시점과
			// syso가 콘솔창에 출력되는 시점이 다르다.
			System.out.println("예외 발생!!!!!!!!");
			System.err.println("System.out이 아닌 err로 하면 옵션이 변경");
		}
		
		//이 정도의 수준에서는 이렇게 방어하는 것이 try-cath를
		//사용하는 것 보다 실행속도가 더 빠르다.
		if(0 < selectIndex && selectIndex < testArrays.length)
		{
			System.out.println("testArrays " + testArrays[selectIndex]);
		}
		else
		{
			System.out.println("인덱스 범위 초과 " + (selectIndex - testArrays.length));
		}
		System.out.println("\n===============================\n");
		
		
		
		/******************************************************
		* 02. 문자열을 숫자로 변환할 때 발생하는 예외처리
		* 
		* 거의 대부분은 사용자 입력실수이다. 따라서 보통은
		* 실수하여도 여러번의 기회를 부여해서 실수를 정정시키도록 한다.
		****************************************************/
	
		
		System.out.print("숫자를 입력하세요 >> ");
		Scanner scanner = new Scanner(System.in); 
		
		String inputUserDataStr = scanner.nextLine();
		
		//실패할 경우를 대비하여
		//최소한의 기본값은 있어야 한다.
		int inputUserDataInt = 10;
		
		try
		{
			inputUserDataInt = Integer.parseInt(inputUserDataStr);
		}
		catch(NumberFormatException e)
		{
			e.printStackTrace();
			
			System.out.println("숫자를 입력해주세요");

		}
		System.out.println("\n===============================\n");
		
		
		/******************************************************
		* 03. 객체가 null로 되어 있을 때 예외발생
		* 
		* 갑자기 사라지는 경우도 간혹 있으나 대다수는 애초에
		* 생성을 하지 못 한 경우이다.
		* 
		* 주로 사용자 클래스 배열 부분에서 선언은 되어 있고,
		* 생성을 안한 경우이다. 즉, 분양은 되고 입주가 안됨
		****************************************************/


		//주소를 할당한 것이지 객체를 생성한 것은 아니다.
		Person[] personList = new Person[inputUserDataInt];
		
		
		try
		{
			//생성안한 객체는 null임으로 접근하려 한다면 예외가 발생한다.
			System.out.println(personList[1].getName());
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
			
			System.out.println("객체를 생성해 주세요");
			
		}
		System.out.println("\n===============================\n");
		
		Random rnd = new Random(); //랜덤 객체 생성
		 
		
		
		//사용자 클래스 배열은 선언 이후 생성까지 해줘야 한다.
		//주로 나오는 실수이다.
		
		//앞서 크기를 입력 받는 부분에서
		//방어에 실패하게 되면 크기 지정이 안되어 있음으로 
		//선언 자체부터가 안된는 상황도 발생
		//고로 최소한의 기본값은 필요하다.
		for(Person p : personList)
		{
			 int nameNumber = rnd.nextInt(Integer.MAX_VALUE);
			 
			 String baseName = "Person" + nameNumber;
			 
			 p = new Person(baseName);
			 
			 System.out.println(p.getName());
		}
		
		System.out.println("\n===============================\n");
		
		
		
		
		/******************************************************
		* 04. 자원 미해제로 인한 누수
		* 
		* 사용 후 할당 해제를 해줘야 하는 것들이 있다.
		* 
		* 예외라기 보다 그냥 최적화 문제?
		****************************************************/
		
		
		//여기서는 Scanner를 사용하였다.
		//굳이 close를 안하여도 '당장' 문제는 없으나
		//수천 수만번씩 돌아가는 for문이라도 들어가 
		//있으면 메모리가 터질 수 있다.
		
		//예외처리라고 볼 수 있으나 사실상 일일이
		//close 해주기 귀찮을 때 주로 사용한다.
		
		String inputUserStr = "";
		try(Scanner scan = new Scanner(System.in))
		{
			System.out.print("아무거나 입력 >> ");
			
			inputUserStr = scan.nextLine();
			System.out.println("사용자 입력 = " + inputUserStr);
			
		}
		
		System.out.println("\n===============================\n");
		
		
		
	
		
		/******************************************************
		* 05. 사용자 정의 예외
		* 
		* 어지간한 것은 이미 제공되고 있는 예외 객체로 처리가 가능하다.
		* 특수하게 에러 메세지나 종류를 수정하고 싶을 때 사용한다.
		* 
		* 아래의 예시는 에러 코드 관리이다.
		****************************************************/
		
		
	
		boolean isName = false;
		
		try
		{
			isName = checkNameFormat(inputUserStr);
		} 
		catch (SystemErrorManagement e) 
		{
			e.printStackTrace();
			System.out.println("에러코드: " + e.getErrCode());
			System.out.println("에러메시지: " + e.getMessage());
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			e.getMessage();
		} 
		finally
		{
			// 예외가 발생하든 말든 실행할 명령어 입력
			// 일반적인 경우라면 굳이 finally에 쓸 이유가 없다.
			// 주로 try문에서 사용된 객체를 close할때 사용
			System.out.println("에러가 발생하든말든 실행됨");
			
			
			System.out.println("입력된 문자열 " + inputUserStr + "는 이름인가? " + isName);
		}
		
		scanner.close();
	}
	
	
	// 입력받은 이름을 콘솔에 출력하는 메소드
	// 만약 입력받은 이름이 숫자거나 empty면
	// 안됨!!!!
	public static boolean checkNameFormat(String name) throws SystemErrorManagement
	{
		String regex = "^.*[0-9].*$";
		
		boolean result = true;
		
		if(name.length() == 0) 
		{
			result = false;
			throw new SystemErrorManagement(SystemErrorManagement.USER_INPUT_EMPTY, "이름에 empty가 들어옴");
		}
		else if
		(
				Pattern.matches(regex, name)) {
			throw new SystemErrorManagement(SystemErrorManagement.USER_INPUT_NUMBER, "이름에 숫자가 포함되어 있음");
		}
		else 
		{
			System.out.println(name + " is OK");
		}
		
		return result;
	}
}
