package ch14_JavaThread;




/******************************************************
*
* 클래스명 | AccumulatorThread
* 	
* 내용       | 작업자 클래스
* 
* 작성일    | 2023.04.12
* 소속       | 개발1팀
* 직급       | 주임
* 성명       | 서지민
****************************************************/

public class AccumulatorThread extends Thread 
{
	String name;
	long startNum;
	long endNum;
	public long accumulator = 0;
	
	public AccumulatorThread(String name, long startNum, long endNum) {
		super();
		this.name = name;
		this.startNum = startNum;
		this.endNum = endNum;
	}
	
	@Override
	public void run() 
	{
		accumulator = 0;
		
		//System.out.println(name + " 계산시작");
		for(long i = startNum; i <= endNum; i++) 
		{
			//System.out.println(name + " 계산 중......" + accumulator);
			accumulator = accumulator + i;
		}
		//System.out.println(name + " 계산완료 start  " + startNum + " end  "+ endNum + "  = " + accumulator);
	}
	

}
