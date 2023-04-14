package ch14_JavaThread;



/******************************************************
*
* 클래스명 | JavaThread
* 	
* 내용       | 스레드 예제들
* 
* 작성일    | 2023.04.12
* 소속       | 개발1팀
* 직급       | 주임
* 성명       | 서지민
****************************************************/



public class JavaThread {

	public static void main(String[] args) 
	{
		SimpleThread exThread = new SimpleThread("서지민", 10);
		exThread.start();
		
		
		SimpleThread exThread2 = new SimpleThread("서지민2", 10);
		exThread2.start();
		
		System.out.println("main 함수는 이미 끝났음");
		
		
		try {
			exThread.join();
			exThread2.join();
		} 
		catch (InterruptedException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("\n\n====================================================\n\n");
		
		
		
		
		/******************************************************
		*  분할정복 예제
		*  
		*  여러 종류의 작업이 아닌 특정 무거운 작업을 각개격파해야될 때 사용한다.
		*  
		*  본 예제는 시그마 계산으로 교환법칙이 성립해야 사용가능한 작업
		****************************************************/
		
		System.out.println("\n과학/수학 분야에서 주로 사용되는 분할정복 예제\n");
		
		
		
		String name = "Main Thead";
		long num = 2000000000L;
		long accumulator = 0;
		
		System.out.println(name + " 계산시작");
		
		long MainStartMillis = System.currentTimeMillis();
		for(int i = 0; i <= num; i++) 
		{
			//System.out.println(name + " 계산 중......" + accumulator);
			accumulator = accumulator + i;
		}
		long MainEndMillis = System.currentTimeMillis();
		
		System.out.println(name + " 계산완료  "+ num + "  = " + accumulator);
		System.out.println(name + " 계산 소요시간  "+ (MainEndMillis - MainStartMillis));
		

		System.out.println( "\n멀티 쓰레드 연산 시작 \n");
		
		
		//작업분배 계산
		//여기서는 작업자들의 능력이 동일하기에 동일하게 분배
		//현업에서는 주로 네트워크 분산이될텐데 각자 작업자들의 능력이 다르니
		//잘 쪼개서 할당해야 한다. ==> 스케쥴링
		int workerSize = 10;
		long jobSize = num / workerSize;
		long endNum = 0;
		accumulator = 0;
		AccumulatorThread[] workerList = new AccumulatorThread[workerSize];
		
		for(int i = 0; i < workerSize; i++)
		{
			String threadName = "name-" + i;
			
			long startNum = endNum;
			endNum = (i + 1) * jobSize;
			
			//작업 할당
			workerList[i] = new AccumulatorThread(threadName, startNum, endNum);
		}
		
		//작업시작
		System.out.println(workerSize + "명의 작업자들 계산시작");
		MainStartMillis = System.currentTimeMillis();
		for(int i = 0; i < workerSize; i++)
		{
			workerList[i].start();
		}
		
		//작업완료 대기
		//여기 이 과정에서 멀티쓰레드의 단점이 드러난다.
		//이 때 시간이 가장 오래 소요된다.
		for(int i = 0; i < workerSize; i++)
		{
			try {
				workerList[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//최종 작업물 취합
		for(int i = 0; i < workerSize; i++)
		{
			accumulator = accumulator + workerList[i].accumulator;
		}
		MainEndMillis = System.currentTimeMillis();
		
		System.out.println(workerSize + "명의 작업자들 계산완료  "+ num + "  = " + accumulator);
		System.out.println(workerSize + "명의 작업자들 계산 소요시간  "+ (MainEndMillis - MainStartMillis));
		
		
		//작업자수를 조절해보면 알겠지만, 늘린다고 능사가 아니니
		//적당히~ 쪼개야 한다.
	}

}
