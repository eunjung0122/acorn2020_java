package test.study;

import java.util.Random;

public class MyMain01 {
	public static void main(String[] args) {
		/*
		 * 랜덤한 무작위 숫자를 얻어내고 싶다면
		 * Random 객체를 활용해야한다
		 * 따라서 new Random() 해서 객체를 생성후
		 * 객체의 메소드를 이용하여 무작위 숫자를 얻어내보자
		 */
		Random ran=new Random();
		Boolean isRun=ran.nextBoolean();
		System.out.println(isRun);
		//int 범위 안에서 랜덤한 정수 얻어내기
		int num1=ran.nextInt();
		//0~4 사이에서 랜덤한 정수
		int num2=ran.nextInt(5);
		//10~20사이의 랜덤한 정수
		int num3=ran.nextInt(11)+10;
		//75~100사이의 랜덤한 정수
		int num4=ran.nextInt(26)+75;
		//-15~15 사이의 랜덤한 정수
		int num5=ran.nextInt(31)-15;
	}
}
