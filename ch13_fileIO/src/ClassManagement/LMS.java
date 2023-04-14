package ClassManagement;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.opencsv.*;

import fileIO.FileIO;
import network.ServerManagement;


/******************************************************
*
* 클래스명 | LMS
* 	
* 내용       | 학생관리 메인 클래스
* 
* 작성일    | 2023.04.11
* 소속       | 개발1팀
* 직급       | 주임
* 성명       | 서지민
****************************************************/

public class LMS {

	public static void main(String[] args) {

		
		
		/******************************************************
		* 설정파일 ini 예제
		******************************************************/

		FileIO fileIO = new FileIO();
		
		//이런식으로 소스코드 수정없이 설정값을 불러오거나 수정할 수 있다.
		ServerManagement.hostAddress = fileIO.getHostAdddress();
		ServerManagement.port = fileIO.getPort();
		
		
		System.out.println("ServerManagement.hostAddress = " + ServerManagement.hostAddress);
		System.out.println("ServerManagement.port  = " + ServerManagement.port );
		
		System.out.println("\n\n ==== 설정파일 ini 예제 끝 ===== \n\n" );
		
		
		
		
		/******************************************************
		* 데이터 파일 CSV 예제
		******************************************************/
		
		System.out.println("\n\n ==== 데이터 파일 CSV 읽어오기 예제 ===== \n\n" );
		
		
		String testDataPath = fileIO.getCSVPath();
		System.out.println("테스트 파일 경로 "  + testDataPath );
		
		
		//한방에 몰아서 가져올 수 있으나 이렇게 나누어 두면,
		//다른 모듈에서 부분적으로 가져다 사용하기 좋다.	
		if(testDataPath != null)
		{
			
			//경로는 있는데 리더만 필요한 경우
			CSVReader csvReader = fileIO.getCSVReader(testDataPath);
			
			//리더는 있는데 데이터가 필요한 경우
			List<String[]> readData = fileIO.getCSVData(csvReader);
			
			for(String[] commaData : readData)
			{
				for(String data : commaData)
				{
					System.out.print(data + "   ");
				}
				
				System.out.println();
			}
			
			try {
				csvReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("데이터 파일이 없습니다.");
		}
		
		
		System.out.println("\n\n ==== 데이터 파일 CSV 뽑아내기 예제 ===== \n\n" );
		
		
		  List<String[]> csvDummyData = new ArrayList<String[]>();
		  
		  
		  Random rnd = new Random(); //랜덤 객체 생성
		  
		  int dataSize = 10;
		  
		  for(int i = 0; i < dataSize; i++)
		  {
			  Integer studentNumber = 1461045 + i;
			  String Name = "서지민" + 15 + i;
			  Integer age =  rnd.nextInt(20) + 20;
			  String phone = "01012345678";
			  String Address = "대전시 동구";
			  Integer kor = rnd.nextInt(100) + 1;
			  Integer math = rnd.nextInt(100) + 1;
			  Integer eng = rnd.nextInt(100) + 1;
			  Integer exp = rnd.nextInt(10000) + 1;
			  
			  String[] data = {studentNumber.toString(),
					  Name,
					  age.toString(),
					  phone,
					  Address,
					  kor.toString(),
					  math.toString(),
					  eng.toString(),
					  exp.toString()
					  }; 
			  
			  
			  csvDummyData.add(data);
		  }
		  
		  
		  int fileNumber = rnd.nextInt(Integer.MAX_VALUE);
		  
		  CSVWriter cscWriter = fileIO.getCSVWriter("./testWriteData" + fileNumber + ".csv");
		  
		  //데이터를 전부 저장할 때까지 다른 로직은 동작이 안되는 문제
		  //이는 서브 스레드로 해결
		  fileIO.writeCSV(csvDummyData, cscWriter);

		
		  try {
			cscWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("\n\n ==== 데이터 파일 CSV 예제 끝 ===== \n\n" );
		
	}

}
