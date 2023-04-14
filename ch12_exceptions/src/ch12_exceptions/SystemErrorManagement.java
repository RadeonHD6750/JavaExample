package ch12_exceptions;

public class SystemErrorManagement extends Exception 
{
	
	// API_0001 : 사용자가 문자열을 입력하지 않음(empty)
	public static final String USER_INPUT_EMPTY = "USER_INPUT_EMPTY";
	
	// API_0002 : 사용자가 숫자를 입력함
	public static final String USER_INPUT_NUMBER = "USER_INPUT_NUMBER";
	
	
	private String errCode = "";
	
	
	public SystemErrorManagement() {
		super();
	}

	public SystemErrorManagement(String errMsg) {
		super(errMsg);
	}
	
	public SystemErrorManagement(Exception e) {
		super(e);
	}
	
	public SystemErrorManagement(String errCode, String errMsg)
	{
		super(errMsg);
		this.errCode = errCode;
	}
	
	public String getErrCode() {
		return errCode;
	}

}
