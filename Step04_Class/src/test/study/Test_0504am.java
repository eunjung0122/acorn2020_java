package test.study;

import test.mypac.Box;
import test.mypac.Car;
import test.mypac.Marine;
import test.mypac.Member;
import test.mypac.MyUtil;
import test.mypac.Rect;
import test.mypac.YourUtil;

public class Test_0504am {
	public static void main(String[] args) {
		//Car 클래스를 이용해서 객체 생성하고 참조값을 지역 변수에 담기
		Car c1=new Car();
		//Car 객체의 메소드 호출하기
		c1.drive();
		//Car 객체의 필드에 값 대입하기
		c1.name="티구안";
				
		//1. Car 클래스를 이용해서 객체를 생성하고 참조값을 car2 라는 이름의 지역변수에 담아보세요.
		Car car2=new Car();
		//2. 메소드를 호출해 보세요.
		car2.drive();
		//3. name 이라는 필드에 차 이름을 담아 보세요.
		car2.name="폭스바겐";
		
		//MyUtil 클래스의 static 메소드 호출하기
		MyUtil.send();
		//MyUtil 클래스의 static 필드에 값 대입하기 
		MyUtil.version="21";

		//Car 객체를 생성해서 drive() 메소드 호출하기
		new Car().drive();
		
		//Car 객체를 생성해서 참조값을 car1 이라는 지역변수에 담기 
		Car car1=new Car();
		//car1 안에 들어 있는 참조값을 이용해서 drive() 메소드 호출하기 
		car1.drive();

		
		// MyUtil 클래스의 send() 라는 static 메소드 호출하기 
		MyUtil.send();
		// YourUtil 클래스의 up() 이라는 static 메소드 호출하기 
		YourUtil.up();
		
		
		/*
		 *  1, 김구라, 노량진 
		 *  
		 *  이라는 int, String, String type 의 값을 
		 *  
		 *  객체의 필드에 저장하는 프로그래밍을 해 보세요. 
		 *  
		 *  단 객체를 생성할 클래스의 이름은  Member 로 작성하세요.
		 */
		Member mem1=new Member();
		mem1.num=1;
		mem1.name="김구라";
		mem1.addr="노량진";
		// 2, 해골, 행신동 도 새로운 Member 객체를  생성해서 담아 보세요.
		Member mem2=new Member();
		mem2.num=2;
		mem2.name="해골";
		mem2.addr="노량진";
		
		//Member 객체의 메소드 호출하기
		mem1.showInfo();
		mem2.showInfo();
		
		
		//Rect 객체 생성해서 참조값을 r1 이라는 지역 변수에 담기 
		Rect r1=new Rect();
		//Rect 객체의 필드에 값 대입하기
		r1.width=100;
		r1.height=20;
		//Rect 객체의 메소드를 호출해서 리턴되는 int 값을 a 라는 지역변수에 담기 
		int a=r1.getArea();
		
		
		//new Box().
		System.out.println("main 메소드가 시작 되었습니다.");
		Member d=Box.mem; // null
		Rect b=Box.rect; // null
		
		Car c=Box.car; //참조값이 들어 있다. 
		c.drive(); // 메소드 호출가능!
		
		//아래와 같이 사용할수도 있다. 
		Box.car.drive();
		
		//d.showInfo(); // a 가 null 이므로 NullPointerException 발생
		//b.getArea();  // b 가 null 이므로 NullPointerException 발생

		
		/*
		 *  Marine 객체를 생성해서 참조값을 m1 이라는 지역 변수에 담아 보세요.
		 */
		Marine m1=new Marine();
		m1.move();
		m1.attack();
		m1.showEnergy();
		System.out.println("--m1--");
		
		Marine m2=new Marine();
		m2.move();
		m2.attack();
		m2.showEnergy();
		System.out.println("--m2--");
		//Marine 의 공격력을 올려보자 (모든 Marine 객체의 공격력에 영향을 미친다)
		new Marine().attackPower += 20;
		m1.attack();
		m2.attack();
		
		//m1 의 에너지 감소 시키기 (m2 의 에너지에는 영향을 주지 않는다)
		m1.energy -= 10;
		m1.showEnergy();
		m2.showEnergy();
	}
}
