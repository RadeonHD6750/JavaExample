package util;

import java.text.DecimalFormat;

public class APIFormat {
	
	public APIFormat()
	{
		
	}
	
	public void showExample()
	{
		// 숫자 형식 DecimalFormat
		
		// 자리수에 맞춰 숫자 앞에 0 붙이기
		// 1이면 001, 11이면 011, 111이면 111
		DecimalFormat deciFormat = new DecimalFormat("000");
		int anyNum = 13;
		String strNum = deciFormat.format(anyNum);
		System.out.println(strNum);
		
		System.out.println("\n=======================\n");
		
		// 자리수에 맞춰 소수 뒤에 0붙이기
		// 0.1이면 0.100, 0.11이면 0.110, 0.111이면 0.111
		deciFormat = new DecimalFormat("0.000");
		double anyDouble = 0.13;
		strNum = deciFormat.format(anyDouble);
		System.out.println(strNum);
		
		System.out.println("\n==========================\n");
		
		// 000은 없는 자리에 0을 붙임. 그게 싫다면 #. 자리가 비어도 빈 채로 놔둠 
		// 소수 넷째자리에서 반올림
		double pi = Math.PI;
		deciFormat = new DecimalFormat("#.###");
		strNum = deciFormat.format(pi);
		System.out.println(strNum);
		
		double hi = Double.parseDouble(strNum);
		System.out.println(hi);
		
		
		System.out.println("\n======================\n");
		
		// 천 단위마다 , 붙이기 [웹 사이트 화면에 있는 숫자에 콤마를 적용하는건 자바스크립트에서 할일]
		int money = 12000000;
		deciFormat = new DecimalFormat("#,###");
		strNum = deciFormat.format(money);
		System.out.println(strNum);
	}

}
