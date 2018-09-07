package ict.sp.test.ch1;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.FileSystemResource;

public class Executor {
	static void load(Game g) {
		g.start();
		g.attack();
		g.jump();
		g.end();
	}
	
	public static void main(String[] args) {
		String path = "src/main/resources/ch1/ioc.xml";
		DefaultListableBeanFactory fac = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(fac);
		reader.loadBeanDefinitions(new FileSystemResource(path));
		
		ConsoleGame cg = (ConsoleGame)fac.getBean("cg");
		
		try {
			cg.on();
			cg.startGame();
		}catch(Exception e) {
			e.printStackTrace();
		}
		cg.off();
	
	}	
}
