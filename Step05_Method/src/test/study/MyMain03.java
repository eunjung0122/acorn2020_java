package test.study;

import test.mypac.Car;
import test.mypac.Messenger;
import test.mypac.MyObject;
import test.mypac.Radio;
import test.mypac.Speaker;

public class MyMain03 {
	public static void main(String[] args) {
		MyObject obj1=new MyObject();
//		obj1.walk();
//		obj1.getNumber();
//		obj1.getGreeting();
//		
//		int a=obj1.getNumber();
//		String b=obj1.getGreeting();
		
//		Car a=obj1.getCar();
//		Car b=obj1.getCar();
//		Car c=obj1.getCar();
//		
//		a.drive();
//		b.drive();
//		c.drive();
		
//		obj1.setNum(10);
//		obj1.setName("xxx");
//		obj1.useCar(new Car());
//		
//		int a=20;
//		String b="김구라";
//		Car c=new Car();
//		
//		obj1.setNum(a);
//		obj1.setName(b);
//		obj1.useCar(c);
		
//		String name="김구라";
//		Car c1=new Car();
//		
//		obj1.useSome(name, c1);
//		
//		Radio r=new Radio();
//		Speaker s=new Speaker();
//		obj1.doSome(r, s);
		
		Messenger.sendMessage("xxx");
		String a=Messenger.getMessage();
		Messenger.useCar(new Car());
	
	}
}
