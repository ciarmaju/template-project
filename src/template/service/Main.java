package template.service;

import java.text.ParseException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class Main {	
	public static void main(String[] args) throws ParseException {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Batch batch = (Batch) applicationContext.getBean("batch");
		batch.run();
	}
}