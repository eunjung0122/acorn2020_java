package test.study;

import java.util.List;
import java.util.Scanner;

import test.dao.MemoDao;
import test.dto.MemoDto;

public class MyMain04 {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("삭제할 번호: ");
		int num=scan.nextInt();
		
		MemoDao dao=MemoDao.getInstance();
		dao.delete(num);
		
		List<MemoDto> list=dao.getList();
		
		for(MemoDto tmp:list) {
			System.out.println(tmp.getNum()+"|"+tmp.getContent()+"|"+tmp.getRegdate());
		}
	}
}
