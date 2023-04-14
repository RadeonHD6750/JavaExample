package account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import db.DBconnection;
import fileIO.FileIO;

public class AccountDAO {
	
	FileIO fileIo;
	
	public AccountDAO()
	{
		fileIo = new FileIO("./mapper/Person.res");
	}
	
	
	public HashMap<String, Object> SELECT_USER_LOGIN(String userId, String password) throws SQLException
	{
		HashMap<String, Object> result_map = new HashMap<String, Object>();
		
		String sql = fileIo.getString("Login", "SELECT_USER_LOGIN");
		
		DBconnection connection = new DBconnection();
		
		boolean isConnect = connection.connectDB();
		
		if(isConnect)
		{
			Connection executeConn = connection.getConnection();
			PreparedStatement ps = executeConn.prepareStatement(sql);
			
			ps.setString(1, userId);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			
			while (rs.next()) 
			{
				String rsUserId = rs.getString("user_id");
				String rsName = rs.getString("name");
				
				result_map.put("userId", rsUserId);
				result_map.put("name", rsName);
			}
		}
		else
		{
		}
		connection.closeDB();
		
		
		
		return result_map;
	}

}
