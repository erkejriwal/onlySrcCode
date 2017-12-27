package onlySrcCode.onlySrcCodeProject.springJavaBrainKausik.kejriwal.prectice;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Point implements ApplicationContextAware, BeanNameAware{

	private int x;
	private int y;
	
	private ApplicationContext context;
	private String beanName;
	
	public Point(){
		System.out.println("default constructor Point() called");
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	@Override
	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
		// TODO Auto-generated method stub
		this.context = context;
	}

	@Override
	public void setBeanName(String beanName) {
		// TODO Auto-generated method stub
		this.beanName = beanName;
		
	}
	public void draw(){
		System.out.println(context);
		System.out.println(beanName);
	}
	
}
