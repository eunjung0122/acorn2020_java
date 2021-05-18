package test.study;

import java.util.Scanner;

import test.dao.BirthDao;
import test.dao.MemoDao;
import test.dto.BirthDto;
import test.dto.MemoDto;

public class MyMain03 {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("번호 입력");
		int num=scan.nextInt();
		
		BirthDao dao=BirthDao.getInstance();
		BirthDto dto=dao.getData(num);
		if(dto==null) {
			System.out.println("정보 없음");
		}else {
			System.out.println(dto.getNum()+"|"+dto.getName()+"|"+dto.getBirthday()); 
		}
	}
}
