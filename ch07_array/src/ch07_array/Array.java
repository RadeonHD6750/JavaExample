package ch07_array;

import java.util.Random;

/******************************************************
*
* 클래스명 | Array
* 	
* 내용       | 배열를 설명하기 위한 클래스
* 
* 작성일    | 2023.04.07
* 소속       | 개발1팀
* 직급       | 주임
* 성명       | 서지민
****************************************************/



public class Array {

	public static void main(String[] args) {
		
		
		/******************************************************
		* 배열
		* 
		* 동일 데이터 타입들의 집합
		* 
		* 데이터들을 다루기 위한 기본자료형
		* 
		* 사실상 대부분의 문제는 배열로써 해결됨. 반드시 숙지해야되는 개념
		****************************************************/
	

		//사실 String도 또한 char들의 배열이다.
		String name = "jimin";
		System.out.printf("String name is %s \n", name);
		
		//따라서 char 배열로 변환이 가능하다.
		//JAVA뿐 아니라 c#쪽 애들도 편의성을 위하여 String 객체를 사용
		char[] nameArray = name.toCharArray();
		
		System.out.print("char array name is ");
		for(int i = 0; i  < nameArray.length; i++)
		{
			System.out.print(nameArray[i]);
		}
		System.out.println();
		
		
		//배열을 사용해야 되는 이유
		//이렇게 타입은 동일한데 여러개를 한번에 제어해야될 때 사용
		String movie1 = "라이터를 켜라";
		String movie2 = "쉬리";
		String movie3 = "엽기적인 그녀";
		
		
		//명시적으로 배열크기를 직접 지정하여 생성할 수 있으나
		//String[] movie_list = new String[3];
		
		//보통 다루어야할 데이터 크기가 단번에 알기 어렵기에 
		//아래와 같이 취득한 데이터로 하여금 초기화하면서 생성한다.
		String[] movieList = {"라이터를 켜라", "쉬리", "엽기적인 그녀"};
		
		
		System.out.println("배열의 크기를 알고 싶을 때는 .length " + movieList.length);
		
		//배열이 아니었다면 이렇게 한번에 핸들링이 불가하다.
		//그래서 배열을 자주 사용한다.
		for(int i = 0; i < movieList.length; i++)
		{
			System.out.print(movieList[i] + ",  ");
		}
		System.out.println("\n\n");
		
		
		
		
		//주로 실무에서는 데이터들의 평균이나 최소/최대값을 찾고는 한다.
		//이럴 때도 배열로 해결한다.
		double[] scoreList = {45.25, 63.25, 45.25};
		
		double average = 0;
		
		//이 또한 따로 따로 선언했다면 엄청 힘들었을 것이다.
		for(int i = 0; i < scoreList.length; i++)
		{
			average = average + scoreList[i];
		}
		
		average = average / scoreList.length;
		
		
		System.out.printf("계산된 평균값 %f \n\n", average);
		
		
		
		
		
		//지금껏 테스트는 하고 싶은데 가짜 데이터를 만들어 오면서 
		//값을 뭐로 할지 일일이 생각하느라 불편했을 것이다.
		//컴퓨터에게 아무 숫자나 생각하게 하면 된다.
		
		Random rnd = new Random(); //랜덤 객체 생성
		
		//테스트 하고자 하기에 테스트하고 싶은
		//데이터 크기를 정해야 한다.
		int dataSize = 10;
		double[] randNumberList = new double[dataSize];
		
		System.out.println("랜덤값 생성중......");
		for(int i = 0; i < randNumberList.length; i++)
		{
			randNumberList[i] = rnd.nextInt(100) + 1;
		}
		
		
		System.out.println("랜덤값 생성 완료");
		for(int i = 0; i < randNumberList.length; i++)
		{
			System.out.print(randNumberList[i] + ", ");
		}
		System.out.println("\n\n");
		
		
		//일일이 배열값 확인하려고 매번 같은 로직을 작성하고 있으니
		//함수로 묶어보자
		System.out.println("이건 아까 그 영화 리스트");
		ShowStringArray(movieList);
		
		
		System.out.println("이건 랜덤생성한 숫자들 보려고한거");
		ShowDoubleArray(randNumberList);
		
		
		//생각해보니 평균계산하는 함수도 만들 수 있겠다.
		double randomNumberAverage = computeAverage(randNumberList);
		System.out.printf("랜덤숫자들의 평균값 %f \n\n", randomNumberAverage);
		
		
		
		
		
		//앞서 해본 예제들을 싹다 함수화하였다.
		
		//로직은 완성한 것 같은데 실제 데이터가 없어
		//이렇게 가짜로라도 만들어서 하는 것을 단위 테스트라고 한다.
		randNumberList = createDummyData(dataSize);
		ShowArray(randNumberList); //함수 오버로딩
		
		
		//본 예제에서는 평균을 구하는 로직을 만든 것 같은데
		//실제로 해보기에는 아직 모르겠고
		//그렇다고 일일이 손으로 하자니 힘들어서
		//랜덤숫자로 테스트를 진행 => 단위 테스트
		randomNumberAverage = computeAverage(randNumberList);
		System.out.printf("랜덤숫자들의 평균값 %f \n\n", randomNumberAverage);
		
		
		
		
		
		/******************************************************
		* 정렬
		* 
		* 실무에서 항상 사용하는 로직임으로 반드시 숙지하자.
		* 
		* 숫자 데이터의 경우 내장된 라이브러리를 사용하면 된다.
		* 그러나 숫자만 오는 경우는 거의 없다. 그래서 정렬 알고리즘 자체를 알고
		* 실무에서 사용해야 한다.
		****************************************************/
		
		//테스트를 해야되니 일단 데이터 파밍
		double[] sortingDummyData =  createDummyData(dataSize);
		
		System.out.println("정렬시킬 데이터들");
		ShowArray(sortingDummyData);
		
		//버블 정렬 알고리즘 단위 테스트
		sortingDummyData = BubbleSort(sortingDummyData);
		
		
		System.out.println("정렬시킨 데이터들");
		ShowArray(sortingDummyData);
		
		randomNumberAverage = computeAverage(sortingDummyData);
		System.out.printf("랜덤숫자들의 평균값 %f \n\n", randomNumberAverage);
		
		//제어문, 반복문, 함수, 함수 오버로딩, 배열 등등의 온갖 기술들의 사용으로
		//훨씬 코드가 간결해졌다.
		//특히 함수의 경우 한번 잘 만들면, 연금 마냥 두고두고 사용할 수 있다.
		
	
	}

	//가짜 데이터를 만들어 준다.
	public static double[] createDummyData(int dataSize)
	{
		Random rnd = new Random(); //랜덤 객체 생성
		
		double[] randNumberList = new double[dataSize];
		
		System.out.printf("랜덤값 %d개 생성중......\n", dataSize);
		for(int i = 0; i < randNumberList.length; i++)
		{
			randNumberList[i] = rnd.nextInt(100) + 1;
		}
		
		return randNumberList;
	}
	
	public static double computeAverage(double[] array)
	{
		double average = 0;
		
		//이 또한 따로 따로 선언했다면 엄청 힘들었을 것이다.
		for(int i = 0; i < array.length; i++)
		{
			average = average + array[i];
		}
		
		average = average / array.length;
		
		return average;
	}
	
	
	public static void ShowStringArray(String[] array)
	{
		for(int i = 0; i < array.length; i++)
		{
			System.out.print(array[i] + ", ");
		}
		System.out.println("\n\n");
	}
	
	public static void ShowDoubleArray(double[] array)
	{
		for(int i = 0; i < array.length; i++)
		{
			System.out.print(array[i] + ", ");
		}
		System.out.println("\n\n");
	}
	
	
	//로직은 똑같은데 데이터 타입만 다른 경우
	//같은 메소드명으로 하여도 가능하다.
	//이를 함수 "오버로딩"이라 한다.
	public static void ShowArray(double[] array)
	{
		for(int i = 0; i < array.length; i++)
		{
			System.out.print(array[i] + ", ");
		}
		System.out.println("\n\n");
	}
	public static void ShowArray(String[] array)
	{
		for(int i = 0; i < array.length; i++)
		{
			System.out.print(array[i] + ", ");
		}
		System.out.println("\n\n");
	}
	
	//버블정렬 알고리즘
	//여러 알고리즘이 있으나 여기서는 버블정렬만 소개
	//사유는 가장 간단해서
	public static double[] BubbleSort(double[] array)
	{
		for (int k = 0; k < array.length; k++) 
		{
			for (int i = 0; i < array.length - 1 - k; i++) 
			{
				// i > i+1 하면 오름차순
				// i < i+1 하면 내림차순
				if (array[i] > array[i + 1]) 
				{
					//여기서 자리를 바꿔야함
					double tmp = array[i]; //원본 대피 시키고
					array[i] = array[i + 1]; //그 자리에 값 넣고
					array[i + 1] = tmp; //대피시켰던 값을 빠진 애 한테 넣기
				}
			}
		}
		
		return array;
	}

}
