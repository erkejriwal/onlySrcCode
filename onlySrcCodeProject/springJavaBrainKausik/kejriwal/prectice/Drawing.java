package onlySrcCode.onlySrcCodeProject.springJavaBrainKausik.kejriwal.prectice;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

@SuppressWarnings("deprecation")
public class Drawing {
 
	public static void main(String[] args) throws Exception {
		//in application context spring.xml should be src folder 
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		context.registerShutdownHook();
		//	Triangle triangle = (Triangle) context.getBean("triangle-alias");
		
		//in BeanFactory spring.xml should be project folder 

		//BeanFactory beanFactory = new XmlBeanFactory(new FileSystemResource("spring.xml"));
		//Triangle triangle = (Triangle) beanFactory.getBean("triangle");
		
		//Triangle triangle = new Triangle();
//		System.out.println(context);
		
//		Triangle triangle = (Triangle) context.getBean("triangle2");
//		triangle.draw();
		Shape shape = (Shape) context.getBean("shape");
		shape.draw();
		
//		Point point = (Point) context.getBean("pointA");
//		point.draw();
		
		System.out.println(context.getMessage("a", null, "default Message", null));
	}

}
