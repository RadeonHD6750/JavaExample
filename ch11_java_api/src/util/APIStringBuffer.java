package util;

public class APIStringBuffer {
	
	public APIStringBuffer() {
		
	}
	
	public void showExample() 
	{
		// 문자열하면? String
		// String을 계속 수정하게 되면
		// 힙 메모리 영역에 매번 새로운
		// String 객체가 만들어지고,
		// 그로인해 가비지컬렉터가 할 일이 많아진다.
		// = 비효율적
		
		// 랜덤숫자 10자리를 더한다
		String strVal = "";
		for(int i = 0; i < 100000; i++) {
			// 0~9 랜덤 수
			int randInt = (int)(Math.random() * 10);
			strVal += randInt;
			if(i % 10000 == 0) {
				System.out.println(i + " ...");
			}
		}
		System.out.println(strVal.length());
		
		System.out.println("\n====================\n");
		
		// StringBuffer
		StringBuffer strBuff = new StringBuffer();
		
		System.out.println(strBuff);
		
		// 문자열 추가
		strBuff.append("안녕");
		System.out.println(strBuff);
		strBuff.append("하세요");
		System.out.println(strBuff);
		
		// StringBuffer가 가진 문자열을
		// String 으로 꺼내오기
		String str = strBuff.toString();
		System.out.println(str);
		
		// 보유중인 문자열 비우기
		//strBuff = new StringBuffer(); //이렇게 비우면 누수발생
		strBuff.delete(0, strBuff.capacity() - 1); //제공되는 함수 사용권장

		
		// StringBuffer로 문자열 변경을 해보면
		// String 보다 100배 이상 빠르다
		for(int i = 0; i < 10000000; i++) {
			int randInt = (int)(Math.random() * 10);
			strBuff.append(randInt);
			
			if(i % 1000000 == 0) {
				System.out.println(i + "...");
			}
		}
		
		System.out.println(strBuff.length());
		
		
		
		System.out.println("\n=======================\n");
		
		// StringBuilder
		StringBuilder strBuild = new StringBuilder();
		
		strBuild.append("안녕히");
		System.out.println(strBuild);
		strBuild.append("가세요");
		System.out.println(strBuild);
		
		String strB = strBuild.toString();
		System.out.println(strB);
		
		// 둘의 차이점
		// StringBuffer는 동기화 지원
		// StringBuilder는 동기화 미지원
		
		// 동기화를 지원한다란?
		// 멀티 쓰레드 환경에서 해당 객체가
		// 모든 쓰레드에서 안정적으로 
		// 사용 가능하도록 하는 것
		
		// 동기화 미지원 (StringBuilder)
		// 쓰레드 a, b, c에서 strBuild 를 사용한다면
		// 쓰레드 a에서 strBuild의 값을 바꿨을때
		// 쓰레드 b, c에서 이를 모른다.
		// 단일 쓰레드에서는 좋은 성능
		
		// 동기화 지원 (StringBuffer)
		// 쓰레드 a, b, c에서 strBuff 를 사용한다면
		// 쓰레드 a에서 strBuff의 값을 바꿨을때
		// 쓰레드 b, c에서 이를 안다.
		// 단일 쓰레드에서 느린 성능
		
	}

}
