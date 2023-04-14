package fileIO;

import java.io.*;
import java.util.Iterator;
import java.util.List;

import org.ini4j.Ini;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;



/******************************************************
*
* 클래스명 | FileIO
* 	
* 내용       | 각종 파일을 관리한다
* 
* 작성일    | 2023.04.11
* 소속       | 개발1팀
* 직급       | 주임
* 성명       | 서지민
****************************************************/



public class FileIO {
	
	//최초 읽어올 파일경로이며
	//절대로 수정되어서는 아니된다.
	private final String confFilePath = "./setting.conf";
	
	private Ini confFile;
	
	private boolean isConfFilePath = true;
	
	
	public FileIO()
	{
	
		File tmpFile = new File(confFilePath);
		
		isConfFilePath = true;
		
		try {
			confFile = new Ini(tmpFile);
			
		} 
		
		//행여 파일이 없는 경우를 대비
		catch (IOException e)
		{
			isConfFilePath = false;
			System.out.println(confFilePath + " 파일이 없습니다. 확인하세요"); //로그 남기고 종료
			return;
		}
		
	}
	
	public String getHostAdddress()
	{
		String hostAddress = "127.0.0.1";
		
		if(isConfFilePath)
		{
			hostAddress = confFile.get("Server", "host_address");
		}
		else
		{
			
		}
		
		System.out.println("confFilePath hostAddress = " + hostAddress);
		
		return hostAddress;
	}
	
	
	public int getPort()
	{
		int Port = 80;
		
		if(isConfFilePath)
		{
			String portStr = confFile.get("Server", "port");
			
			//숫자형식에 안맞게 입력된 경우 필터링
			try
			{
				Port = Integer.parseInt(portStr);
			}
			catch(Exception e)
			{
				Port = 80;
				System.out.println("포트번호가 잘못입력되어 있습니다."); //로그 남기고 종료
			}
			
		}
		else
		{
			
		}
		
		System.out.println("confFilePath Port = " + Port);
		
		return Port;
	}
	
	public String getCSVPath()
	{
		String CSVPath = getString("InitDataPath", "init_data");
		
		return CSVPath;
	
	}
	
	//다른 곳에 사용할 것을 염두하여 고의로 CSVReader만 추출
	public CSVReader getCSVReader(String path)
	{
		FileReader fileReader = null;
		
		try
		{
			fileReader = new FileReader(path);
		}
		catch(Exception e)
		{
			return null;
		}
		
		CSVReader csvReader = null;
		
		if(fileReader != null)
		{
			csvReader = new CSVReader(fileReader);
		}
		
		return csvReader;
	}
	
	public List<String[]> getCSVData(CSVReader csvReader)
	{
		List<String[]> readData = null;
		
		try
		{
			readData = csvReader.readAll();
		}
		catch (IOException | CsvException e)
		{
			return null;
		}
		
		return readData;
	}
	
	public CSVWriter getCSVWriter(String path)
	{
		FileWriter fileWriter = null;
		
		try
		{
			fileWriter = new FileWriter(path);
		}
		catch(Exception e)
		{
			System.out.println("파일을 생성할 수 없습니다.");
			return null;
		}
		
		CSVWriter csvWriter = new CSVWriter(fileWriter, 
				
				 //스타일 옵션
				 CSVWriter.DEFAULT_SEPARATOR,
			     CSVWriter.NO_QUOTE_CHARACTER,
			     CSVWriter.DEFAULT_ESCAPE_CHARACTER,
			     CSVWriter.DEFAULT_LINE_END
			     
				);
		
		return csvWriter;
	}
	
	public void writeCSV(List<String[]> data, CSVWriter csvWriter)
	{
		Iterator<String[]> it = data.iterator();
        try
        {
            while (it.hasNext())
            {
                String[] s = (String[]) it.next();
                csvWriter.writeNext(s);
                
                System.out.print("writeCSV data = ");
                
                for(String d : s)
                {
                	 System.out.print(d + "  ");
                }
                System.out.println();
            }
            
            csvWriter.close();
        } 
        catch(IOException e)
        {
        }
        finally 
        {
        }
  
	}
	
	//value 가져오는 로직이 계속 중복됨으로 함수화
	public String getString(String section, String key)
	{
		String value = "";
		
		if(isConfFilePath)
		{
			value = confFile.get(section, key);
		}
		else
		{
			
		}
		
		System.out.println("confFilePath   " + key + " = " + value);
		
		return value;
	}

}
