package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import fileIO.FileIO;


/******************************************************
*
* 클래스명 | DBconnection
* 	
* 내용       | DB 연결을 관리한다.
* 
* 작성일    | 2023.04.13
* 소속       | 개발1팀
* 직급       | 주임
* 성명       | 서지민
****************************************************/


public class DBconnection {
	
	//최초 읽어올 파일경로이며
	//절대로 수정되어서는 아니된다.
	private final String confFilePath = "./setting.conf";
	
	
	private FileIO fileIO;
	
	
	private static String DB_DRIVER_CLASS = "org.mariadb.jdbc.Driver";

	private static String DB_URL = "jdbc:mariadb://127.0.0.1:3306/";

	private static String DB_USERNAME = "root";

	private static String DB_PASSWORD = "jimin";
	
	private Connection connection;

	PreparedStatement pstmt = null;
	
	public DBconnection()
	{
		fileIO = new FileIO("./setting.conf");
		
		DB_DRIVER_CLASS = fileIO.getString("DB", "DB_DRIVER_CLASS");
		DB_URL = fileIO.getString("DB", "DB_URL");
		DB_USERNAME = fileIO.getString("DB", "DB_USERNAME");
		DB_PASSWORD = fileIO.getString("DB", "DB_PASSWORD");
		
		try
		{
			Class.forName(DB_DRIVER_CLASS);
		} 
		catch (ClassNotFoundException e) 
		{
			System.out.println("DB 드라이버 연결 실패");
		}
	}
	
	public boolean connectDB()
	{
		boolean isConnect = true;
		boolean canTryConnectDB = connectTestDB();
		
		if(canTryConnectDB)
		{
			try 
			{
				connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
			}
			catch (SQLException e) 
			{
				isConnect = false;
				System.out.println("DB 연결 실패");
			}
		}
		else
		{
			isConnect = false;
			System.out.println("DB 연결 실패");
		}
		
		return isConnect;
	}
	
	public boolean connectTestDB()
	{
		boolean result = true;
		
		Connection tryConnection = null;
		
		try {

			tryConnection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

			System.out.println("연결성공");

		} 
		catch (SQLException e)
		{
			System.out.println("DB 연결 실패");
			result = false;
		}
	
		try
		{
			if(tryConnection != null && !tryConnection.isClosed())
			{
				tryConnection.close();
			}
		}
		catch (SQLException e) 
		{
			result = false;
			System.out.println("DB 연결해제 실패");
		}
		
		
		return result;
	}
	
	public Connection getConnection()
	{
		return this.connection;
	}
	
	public void closeDB()
	{
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
