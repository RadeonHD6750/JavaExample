package ch14_JavaThread;



/******************************************************
*
* 클래스명 | SimpleThread
* 	
* 내용       | 간단한 스레드
* 
* 작성일    | 2023.04.12
* 소속       | 개발1팀
* 직급       | 주임
* 성명       | 서지민
****************************************************/

public class SimpleThread extends Thread
{
	String name;
	int num = 0;
	
	public SimpleThread(String name, int num)
	{
		this.name = name;
		this.num = num;
		
	}
	
	
	@Override
	public void run() 
	{
		int accumulator = 0;
		
		System.out.println(name + " 계산시작");
		for(int i = 0; i <= num; i++) 
		{
			System.out.println(name + " 계산 중......" + accumulator);
			accumulator = accumulator + i;
			
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(name + " 계산완료 시그마 " + num + " = " + accumulator);
	}
}
