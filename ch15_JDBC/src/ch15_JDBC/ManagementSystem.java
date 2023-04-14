package ch15_JDBC;

import java.util.HashMap;

import db.DBManager;
import db.DBconnection;


/******************************************************
*
* 클래스명 | ManagementSystem
* 	
* 내용       | DB 관리 시스템 메인
* 
* 작성일    | 2023.04.12
* 소속       | 개발1팀
* 직급       | 주임
* 성명       | 서지민
****************************************************/

public class ManagementSystem {

	public static void main(String[] args) {

		DBconnection dbConnection = new DBconnection();
		
		System.out.println("MariaDB 연결 테스트 = " + dbConnection.connectTestDB());
		
	
		DBManager dbManager = new DBManager();
		
		//01. 사용자 입력을 받아서
		String userId = "km29a1";
		String password = "jimin";
		
		
		//02. DB에 물어본다.
		HashMap<String, Object> loginResult =  dbManager.loginTransaction(userId, password);
		
		System.out.printf("%s  %s  로그인한 사람 %s \n\n", userId, password, loginResult.get("name"));
		
	}
	

}
