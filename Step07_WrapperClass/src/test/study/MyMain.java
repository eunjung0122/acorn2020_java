package test.study;

public class MyMain {
	public static void main(String[] args) {
		int num1=10;
		Integer num2=10;
		
		int result1=num2+1;
		int result2=num1+num2;
		Integer result3=num1+num2;
		
		String strNum=num2.toString();
		
		String strNum2="999";
		int result4=Integer.parseInt(strNum2);
		
		double num3=10.1;
		Double num4=10.4;
		
		double result5=num3+20;
		double result6=num3+num4;
		Double result7=num3+num4;
		
		String strNum3=result7.toString();
		double result8=Double.parseDouble(strNum3);
		
	}
}
