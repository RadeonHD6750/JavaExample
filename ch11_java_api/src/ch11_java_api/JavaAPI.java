package ch11_java_api;

import java.text.ParseException;

import util.APIDate;
import util.APIFormat;
import util.APIJSON;
import util.APIMath;
import util.APIPattern;
import util.APIStringBuffer;


/******************************************************
*
* 클래스명 | JavaAPI
* 	
* 내용       | 각종 JAVA에서 제공하고 있는 것들
* 
* 작성일    | 2023.04.12
* 소속       | 개발1팀
* 직급       | 주임
* 성명       | 서지민
****************************************************/



public class JavaAPI {

	public static void main(String[] args) {

		
		APIMath mathExample = new APIMath();
		mathExample.showExample();
		
		System.out.println("PI " + mathExample.PI());
		
		
		APIFormat formatExample = new APIFormat();
		formatExample.showExample();
		
		
		APIPattern patternExample = new APIPattern();
		patternExample.showExample();
		
		
		APIStringBuffer stringBufferExample = new APIStringBuffer();
		stringBufferExample.showExample();
		
		
		APIJSON jsonExample = new APIJSON();
		try {
			jsonExample.showExample();
		} catch (org.json.simple.parser.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("\n\n=======================================\n\n");
		
		APIDate dateExample = new APIDate();
		
		try 
		{
			dateExample.showExample();
		} 
		catch (ParseException e) 
		{
			e.printStackTrace();
		}
		

	}

}
