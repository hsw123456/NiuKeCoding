package cn.itcast.oa.test;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringTest {
	
	private ApplicationContext ctx = null;
	
	{
		ctx= new ClassPathXmlApplicationContext("applicationContext.xml");
		
	}
	
	@Test
	public void testBean(){
		
		ActionTest actionTest = ctx.getBean(ActionTest.class);
		actionTest.say();
		
	}
	
	@Test
	public void testSessionFactory(){
		SessionFactory sessionFactory = ctx.getBean(SessionFactory.class);
		System.out.println(sessionFactory);
	}
	
	@Test
	public void testTransaction(){
		
		TestService testService = ctx.getBean(TestService.class);
		testService.saveUsers();
		
	}

}
