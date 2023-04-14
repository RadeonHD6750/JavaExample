package ch15_JDBC;

import java.util.HashMap;

import db.DBManager;
import db.DBconnection;

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
