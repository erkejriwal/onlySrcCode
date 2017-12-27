package onlySrcCode.onlySrcCodeProject.springJavaBrainKausik.kejriwal.prectice;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.cglib.core.Local;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class Circle implements Shape{
	public Point center;
	
	@Autowired
	public MessageSource messageSource;
	
	
	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public Point getCenter() {
		return center;
	}
	
	//	@Required
	//	@Autowired
	//	@Qualifier("circleRelated")
	//@Resource(name="pointC")
	@Resource
	public void setCenter(Point center) {
		this.center = center;
		System.out.println("circle setter called ");
	}



	@Override
	public void draw() {
		System.out.println("circle center is: x = "+getCenter().getX()+" y = "+getCenter().getY());
		System.out.println(messageSource.getMessage("a", null, "default Message from circle", null));

		System.out.println(messageSource.getMessage("circle.center", null, "default Message from circle", null));
		System.out.println(messageSource.getMessage("circle.center", new Object[]{getCenter().getX(),getCenter().getY()}, "default Message from circle", null));
		System.out.println(messageSource.getMessage("circle.center", new Object[]{getCenter().getX(),"second point"}, "default Message from circle", null));
		System.out.println(messageSource.getMessage("circle.center", new Object[]{getCenter().getX(),getCenter().getY()}, "default Message from circle", null));

	}
	
	@PostConstruct
	public void initializationMethod(){
		System.out.println("circle center initializationMethod() ");
	}
	
	@PreDestroy
	public void destroyMethod(){
		System.out.println("circle center destroyMethod() ");
	}
}
