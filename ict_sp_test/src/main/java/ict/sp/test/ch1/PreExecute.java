package ict.sp.test.ch1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ict.sp.test.ch2.Company;

public class PreExecute {
	public static void main(String[] args) {
		ApplicationContext ac;
		ac = new ClassPathXmlApplicationContext("ch1/ioc.xml");
		
		ConsoleGame cg = (ConsoleGame)ac.getBean("cg");
		cg.test();
	}
}
//Controller <- 얘 빼고 나머지는 동일하게 동작함 
//Service
//Repository
//Component
//Named 현재는 이걸로 하고 있다고 함(이걸로 통합하자고 하고 있다고 함)