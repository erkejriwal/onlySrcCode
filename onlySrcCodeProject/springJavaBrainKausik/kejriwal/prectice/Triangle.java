package kejriwal.prectice;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Triangle implements ApplicationContextAware, BeanNameAware, InitializingBean, DisposableBean, Shape{
	
	/*private List<Point> points;

	public List<Point> getPoints() {
		return points;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
	}
	
	public void draw(){
		
		for (Point point : getPoints()) {
			
			System.out.println("drawing triangle " + point.getX()+","+point.getY());
		}
	}*/
	
	private Point pointA;
	private Point pointB;
	private Point pointC;
	
	private ApplicationContext context;
	private String beanName;
	
	public Triangle( ){
		System.out.println("default constructor Triangle() called");
	}
	
	public Triangle(Point pointA,Point pointB,Point pointC ){
		this.pointA = pointA;
		this.pointB = pointB;
		this.pointC = pointC;
		System.out.println("constructor Triangle() called which set all three variables pointA, pointB, pointC");
	}
	
	
	public Point getPointA() {
		return pointA;
	}
	public void setPointA(Point pointA) {
		this.pointA = pointA;
		System.out.println("setter of pointA called");

	}
	public Point getPointB() {
		return pointB;
	}
	public void setPointB(Point pointB) {
		this.pointB = pointB;
		System.out.println("setter of pointB called");
	}
	public Point getPointC() {
		return pointC;
	}
	public void setPointC(Point pointC) {
		this.pointC = pointC;
		System.out.println("setter of pointC called");

	}
	
	public void draw(){
		System.out.println("drawing triangle point A" + getPointA().getX()+","+getPointA().getY());
		System.out.println("drawing triangle point B" + getPointB().getX()+","+getPointB().getY());
		System.out.println("drawing triangle point C" + getPointC().getX()+","+getPointC().getY());
	//	System.out.println(context);
	//	System.out.println(beanName);


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

	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("from DisposableBean  interface destroy() method bean"+beanName+" has been distroyed");
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("InitializingBean interface afterPropertiesSet() method bean"+ beanName+" initialization has been done, setters has been called");
		
	}
	
	
	public void myInit() {
		System.out.println("myInit() method of bean"+ beanName+" initialization from spring init method configuration");
	}
	
	public void myDestroy(){
		System.out.println("myDestroy() method bean"+ beanName+" distroy from spring distroy method configuration");
	}
	/*
	private String type1;
	private int height;
	public int getHeight() {
		return height;
	}
	public Triangle(String Type1){
		this.type1=Type1;
	}
	public Triangle(String Type1, int height){
		this.type1=Type1;
		this.height=height;
	}
	public Triangle(int height){
		this.height=height;
	}
	
	public String getType1() {
		return type1;
	}
	public void setType1(String type1) {
		this.type1 = type1;
	}
	*/
}
