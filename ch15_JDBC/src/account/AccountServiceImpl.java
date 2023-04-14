package account;

import java.sql.SQLException;
import java.util.HashMap;


public class AccountServiceImpl implements AccoutService {


	AccountDAO accountDAO;
	
	public AccountServiceImpl()
	{
		accountDAO = new AccountDAO();
	}

	
	
	@Override
	public HashMap<String, Object> SELECT_USER_LOGIN(String userId, String password) {

		HashMap<String, Object> loginResult = null;
		boolean isLogin = false;
		
		//01. 로그인 시도
		//DB에 해당 사용자가 있는 지 검사
		try {
			loginResult = accountDAO.SELECT_USER_LOGIN(userId, password);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		

		return loginResult;
	}

}
