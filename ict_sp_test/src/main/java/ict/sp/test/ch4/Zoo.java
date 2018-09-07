package ict.sp.test.ch4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Zoo {
	private Animal tiger;
	
	public Zoo(Animal tiger) {
		this.tiger = tiger;
	}
	
	public void doSome() {
		tiger.attack();
		tiger.howl();
		tiger.sleep();
	}
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("ch4/ioc.xml");
		
		Zoo z = (Zoo) ac.getBean("zoo");
		z.doSome();
	}
}
