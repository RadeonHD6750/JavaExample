package ch09_Functions;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/******************************************************
*
* 클래스명 | Util
* 	
* 내용       | 각종 개발 편의기능들을 묶어놓은 클래스
*                 다른 기능을 하고는 상관없이 아무때나 쓰기 위하여
*                 함수들은 static으로 선언해둔다.
* 
* 작성일    | 2023.04.07
* 소속       | 개발1팀
* 직급       | 주임
* 성명       | 서지민
****************************************************/

public class Util {
	
	
	public static void addArrayUserData(Scanner scanner, ArrayList<Double> dataArrayList)
	{
		int dataSize = inputUserData(scanner, "입력할 데이터 크기 >> ", 0);
		
		for(int i = 0; i < dataSize; i++)
		{
			double inputUserDouble = inputUserData(scanner, "숫자를 입력하세요 >> ", 0.0);
			
			
			//이렇게 그 때 그 때 동적으로 데이터를 저장할 수 있다.
			//그래서 배열은 고정값을 많이 하고 대다수는 ArrayList를 많이 사용한다.
			dataArrayList.add(inputUserDouble);
		}
		
		System.out.println("addArrayUserData data");
		ShowArrayList(dataArrayList, 0.0);

	}
	
	
	//함수 오버로딩을 하기 위하여
	//가짜  파라미터를 만들어 두었다.
	public static int inputUserData(Scanner scanner, String comment,  int dummy)
	{
		System.out.print(comment);
		String inputUserDataStr = scanner.nextLine();
		
		int result = Integer.parseInt(inputUserDataStr);
		
		return result;
	}
	
	//함수 오버로딩을 하기 위하여
	//가짜  파라미터를 만들어 두었다.
	public static double inputUserData(Scanner scanner,  String comment, double dummy)
	{
		System.out.print(comment);
		String inputUserDataStr = scanner.nextLine();
		
		double result = Integer.parseInt(inputUserDataStr);
		
		return result;
	}
	
	public static void ShowArrayList(ArrayList<Double> ArrayList, double dummy)
	{
		for(int i = 0; i < ArrayList.size(); i++)
		{
			System.out.print(ArrayList.get(i) + ", ");
		}
		System.out.println("\n\n");
	}
	
	public static void ShowArrayList(ArrayList<String> ArrayList, String dummy)
	{
		for(int i = 0; i < ArrayList.size(); i++)
		{
			System.out.print(ArrayList.get(i) + ", ");
		}
		System.out.println("\n\n");
	}

	public static double computeAverage(ArrayList<Double> ArrayList)
	{
		double average = 0;
		
		//이 또한 따로 따로 선언했다면 엄청 힘들었을 것이다.
		for(int i = 0; i < ArrayList.size(); i++)
		{
			average = average + ArrayList.get(i);
		}
		
		average = average / ArrayList.size();
		
		return average;
	}
	
	public static void BubbleSort(ArrayList<Double> ArrayList)
	{
		for (int k = 0; k < ArrayList.size(); k++) 
		{
			for (int i = 0; i < ArrayList.size() - 1 - k; i++) 
			{
				// i > i+1 하면 오름차순
				// i < i+1 하면 내림차순
				if (ArrayList.get(i) > ArrayList.get(i + 1)) 
				{
					//여기서 자리를 바꿔야함
					double tmp = ArrayList.get(i); //원본 대피 시키고
					ArrayList.set(i, ArrayList.get(i + 1)); //그 자리에 값 넣고
					ArrayList.set(i + 1, tmp); //대피시켰던 값을 빠진 애 한테 넣기
				}
			}
		}

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
}
