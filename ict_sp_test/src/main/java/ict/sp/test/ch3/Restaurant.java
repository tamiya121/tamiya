package ict.sp.test.ch3;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
@Service
public class Restaurant {
	@Autowired
	List<Food> foods;
	
	
	
	@Autowired
	@Qualifier("pasta")
	private Food food1;
	@Autowired
	@Qualifier("pizza")
	private Food food2;
	
	public List<Food> getFoods(){
		return foods;
	}
	
	public Food getPasta() {
		return food1;
	}
	
	public Food getPizza() {
		return food2;
	}
	
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("ch3/ioc.xml");
		
		Restaurant r = (Restaurant)ac.getBean("restaurant");
		
		
		
		for(Food f : r.getFoods()) {
			f.buy();
			f.sell();
		}
	}
}
