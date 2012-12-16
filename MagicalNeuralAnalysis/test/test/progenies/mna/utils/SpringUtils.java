package test.progenies.mna.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringUtils
{
	
	public static final ApplicationContext createContext()
	{
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("/configuration/spring*.xml");
		return context;
	}

	public static void closeContext(ApplicationContext context) {
		((ClassPathXmlApplicationContext)context).close();
		
	}

}
