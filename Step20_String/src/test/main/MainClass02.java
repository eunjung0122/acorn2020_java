package test.main;

public class MainClass02 {
	public static void main(String[] args) {
		String str="abcde김구라12345";
		//4번째 인덱스에 있는 문자 얻어오기
		str.charAt(4); //e
		//문자열 합치기
		String b=str.concat("ddfd");
		//문자열이 포함되어 있는지 알아보기
		boolean c=str.contains("123");
		//해당 문자열이 몇번째 인덱스에 있는지(없으면 -1)
		int d=str.indexOf("김구라");
		//문자열의 길이 얻어내기
		int e=str.length();
		
		//정규표현식으로 문자열 분리해서 String[]으로 얻어내기
		String line="김구라/해골/원숭이/주뎅이/덩어리";
		String[] result1=line.split("/");
	
		String line2="김구라     해골    원숭이    주뎅이   덩어리";
		String[] result2=line2.split("[ ]+");
		
		String line3="김구라abcd  ef해골  as  bd4원숭이  주뎅이  mdfks 덩어리";
		String[] result3=line3.split("[a-z0-9 ]+");
		
		String line4="김구라바보,해골바보,원숭이바보";
		String result4=line4.replaceAll("바보", "천재");
		
		String line5="abc   가나123 efg @!$ def 456";
		String result5=line5.replaceAll("[^A-Za-z0-9]", "");
		/*
		 * in javascript => /[^\w]/
		 * in java=> "[^\\w]"
		 * 
		 * in javascript => /a\\b/
		 * in java =>"a\\\\b"
		 * 
		 * -java에서 정규표현식을 작성할때 역슬래시를 하나 넣고싶으면 2개 넣기
		 */
		String result6=line5.replaceAll("[^\\w]", "");
		String result7=line5.replaceAll("[\\W]", "");
		
	}
}
