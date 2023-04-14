package ch08_collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

/******************************************************
*
* 클래스명 | Collections
* 	
* 내용       | 자바 컬렉션들을 설명하기 위한 클래스
* 
* 작성일    | 2023.04.07
* 소속       | 개발1팀
* 직급       | 주임
* 성명       | 서지민
****************************************************/

public class Collections {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in); 
		
		
		/******************************************************
		* 컬렉션
		* 
		* 배열 다음으로 아니 어쩌면 배열 보다 더 많이 실무에서 사용
		* 
		* 특히 HashMap
		****************************************************/
		
		
		
		/******************************************************
		* ArrayList
		* 배열 보다 사용성이 좋은 업그레이드 버전
		* 인데 속도는 살짝 느림
		****************************************************/

		int dataSize = 10;
		
		//기존 배열은 고정길이라서 
		//항상 사용할 데이터의 크기부터 파악을 했어야 했다.
		double[] datalist = new double[dataSize];
		
		
		//자바에서 제공하는 컬렉션 중 하나인 ArrayList를 사용하면
		//가변길이로 사용할 수 있다. 즉, 길이를 정해 놓고 시작할 필요 없다.
		ArrayList<Double> dataArrayList = new ArrayList<Double>();
		
		
		addArrayUserData(scanner, dataArrayList);

		System.out.println("addArrayUserData end");
		ShowArrayList(dataArrayList, 0.0);
		
		
		
		//마찬가지로 함수를 사용하여 ArrayList 또한 평균과 정렬작업을 할 수 있다.
		
		System.out.println("addArrayUserData 정렬");
		BubbleSort(dataArrayList);
		ShowArrayList(dataArrayList, 0.0);
		
		//평균 구하기
		double average = computeAverage(dataArrayList);
		System.out.printf("addArrayUserData 평균값 %f \n\n", average);
		
		
		
		
		
		
		/******************************************************
		* HashMap
		* 마치 백과사전처럼 잡다한 데이터를 수용할 때 사용
		* 
		* 현업에서 가장 많이 사용하는 자료구조로써 추후 JSON이라는 것과 찰떡
		****************************************************/
		
		//서로 다른 데이터 타입을 묶을 수 있다.
		HashMap<String, Object> student = new HashMap<String,Object>();
		
		student.put("name", "서지민");
		student.put("phoneNumber", "01012345678");
		student.put("age", 20);
		student.put("army", true);
		
		
		HashMap<String, Object> student2 = new HashMap<String,Object>();
		
		student.put("name", "서지민2");
		student.put("phoneNumber", "01087456123");
		student.put("age", 22);
		student.put("army", true);
		
		
		//같은 HashMap끼리도 담을 수 있다.
		HashMap<Integer, Object> classes = new HashMap<Integer,Object>();
		classes.put(0, student);
		classes.put(1, student2);
		
		
		//따라서 리스트로도 넣을 수 있다.
		HashMap<String, Object> classes2 = new HashMap<String, Object>();
		
		ArrayList<HashMap<String, Object>> studentList = new ArrayList<HashMap<String, Object>>();
		studentList.add(student);
		studentList.add(student2);
		
		classes2.put("classesName", "7월반");
		classes2.put("studentList", studentList);
		
		
		
		//어떤식으로 효율적으로 설계할지는 발주처 요구사항에 따라 다르기에
		//많은 연습과 경험이 필요하다.
		
		
		
		
		
		scanner.close();
	}
	
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
