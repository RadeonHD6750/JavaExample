package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import account.AccountServiceImpl;
import account.AccoutService;


/******************************************************
*
* 클래스명 | DBManager
* 	
* 내용       | DB의 모든 것을 관리한다. mybatis를 얼추 구현한셈
*                 각종 트랜젝션을 관리
* 
* 작성일    | 2023.04.13
* 소속       | 개발1팀
* 직급       | 주임
* 성명       | 서지민
****************************************************/


public class DBManager {
	
	AccountServiceImpl accountService;
	
	public DBManager()
	{
		accountService = new AccountServiceImpl();
	}
	
	//로그인 트랜잭션
	public HashMap<String, Object> loginTransaction(String userId, String password)
	{
		HashMap<String, Object> result = accountService.SELECT_USER_LOGIN(userId, password);
	
		return result;
	}
}
