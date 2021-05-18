package test.study;

import java.util.Scanner;

import test.dao.MemoDao;
import test.dto.MemoDto;

public class MyMain01 {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("content: ");
		String content=scan.nextLine();
		System.out.println("regdate");
		String regdate=scan.nextLine();
		
		MemoDto dto=new MemoDto();
		dto.setContent(content);
		dto.setRegdate(regdate);
		
		MemoDao dao=MemoDao.getInstance();
		dao.insert(dto);
	}
}
