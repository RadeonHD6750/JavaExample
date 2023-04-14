package account;

import java.sql.SQLException;
import java.util.HashMap;

public interface AccoutService {
	
	HashMap<String, Object> SELECT_USER_LOGIN(String userId, String password) throws SQLException;
}
