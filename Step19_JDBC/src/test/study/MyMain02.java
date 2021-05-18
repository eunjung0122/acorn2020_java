package test.study;

import java.util.List;

import test.dao.MemoDao;
import test.dto.MemoDto;

public class MyMain02 {
	public static void main(String[] args) {
		MemoDao dao=MemoDao.getInstance();
		List<MemoDto> list=dao.getList();
		for(MemoDto tmp:list) {
			System.out.println(tmp.getNum()+"|"+tmp.getContent()+"|"+tmp.getRegdate());
		}
		
	}
}
