package test.study;

import java.util.Random;
import java.util.Scanner;

import test.mypac.Bike;
import test.mypac.Rect;

public class MyMain {
	public static void main(String[] args) {
//		int[] nums= {10,20,30,40,50};
//		double[] nums2= {10.1,10.2,10.3,10.4,10.5};
//		boolean[] truth={true, false, true, true, false};
//		String[] names= {"김구라","해골","원숭이","주댕이","덩어리"};
//		
//		int result1=nums[0];
//		double result2=nums2[1];
//		boolean result3=truth[4];
//		String result4=names[3];
//		
//		int[] cloned=nums.clone();
//		int size=nums.length;
		
//		int[] nums= {0,0,0};
//		nums[0]=100;
//		nums[1]=200;
//		nums[2]=300;
//		
//		String[] names= {null,null,null};
//		names[0]="김구라";
//		names[1]="해골";
//		names[2]="원숭이";
//		
//		String[] names2=new String[3];
//		names2[0]="주댕이";
//		names2[1]="덩얼";
//		
//		Bike[] bikes=new Bike[3];
//		bikes[0]=new Bike();
//		bikes[1]=new Bike();
//		bikes[2]=new Bike();
//		for(int i=0; i<bikes.length; i++) {
//			Bike tmp=bikes[i];
//			tmp.ride();
//		}
		
//		//1. Rect 객체를 담을수 있는 방 3개짜리 배열객체를 생성해서 참조값을
//		// rects 라는 이름의 지역 변수에 담아 보세요.
//		Rect[] rects=new Rect[3]; 
//		//2. 배열에 Rect 객체 3개를 순서대로 담아 보세요.
//		rects[0]=new Rect(10,20);
//		rects[1]=new Rect(20,20);
//		rects[2]=new Rect(30,30);
//		//3. 반복문 for 문을 이용해서 각각 4각형의 면적을 콘솔창에 출력해 보세요.
//		for(int i=0; i<rects.length; i++) {
//			Rect tmp=rects[i];
//			int area=tmp.getArea();
//			System.out.println(area);
//		}
//		
//		/*
//		 *  1. Scanner 객체를 이용해서 문자열을 5번 입력 받는다.
//		 *     입력 받은 문자열은 차례대로 배열에 저장 되어야 한다.
//		 *     모두다 입력 받은후 for 문을 이용해서 배열에 저장된 
//		 *     모든 문자열을 콘솔창에 순서대로 출력하는 코드를 작성해 보세요.
//		 */
//		//Scanner 객체를 생성해서 참조값을 지역 변수에 담기
//		Scanner scan=new Scanner(System.in);
//		
//		//문자열(String) 5개를 담을수 있는 배열 객체 생성해서 참조값을 지역변수에 담기
//		String[] msgs=new String[5];
//		
//		//5번 문자열을 입력 받기 위해 for 문을 구성한다. 
//		for(int i=0; i<msgs.length; i++) {
//			System.out.print("문자 입력");
//			msgs[i]=scan.nextLine();
//			
//			
//		}
//		
//		for(int i=0; i<msgs.length; i++) {
//			String str=msgs[i];
//			System.out.println(str);
//		}
//			//i번째 방에 있는 String  객체의 참조값을 불러온다.
//			
//			//콘솔에 출력한다.
			
		/*   
		 *   hint 
		 *   
		 *   String[] items={"cherry", "apple", "banana", "melon", "7"};
		 *  
		 *   1. cherry, apple, banana, melon, 7
		 *      5개의 문자열 중에서 1개가 랜덤하게 출력되게 해 보세요.
		 *   
		 *   2. 5개의 문자열 중에서 3개가 한줄에 한번에 랜덤하게 출력되게 해 보세요.
		 *      예)  cherry | apple | cherry
		 *           7 | apple | melon
		 *           7 | 7 | 7
		 *      
		 */
		
		String[] items={"cherry", "apple", "banana", "melon", "7"};
		Random ran=new Random();
		int a=ran.nextInt(5);
		System.out.println(items[a]);
		
		int[] nums=new int[3];
		for(int i=0;i<3;i++) {
			int ranNum=ran.nextInt(5);
			nums[i]=ranNum;
		}
		int one=nums[0];
		int two=nums[1];
		int three=nums[2];
		
		System.out.println(items[one]+"|"+items[two]+"|"+items[three]);
	
		int[] points= {10,20,30,40,1000};
		if(nums[0]==nums[1] && nums[1]==nums[2]) {
			int point=points[nums[0]];
			System.out.println(point+"점");
		}else {
			System.out.println("0점");
		}
		
	}
}
