package demo;

import java.lang.reflect.Constructor;

import org.junit.Test;

import model.reflectiveVo;

/**
 * 通过反射
 * 其中class代表的时类对 象，
 * Constructor－类的构造器对象，
 * Field－类的属性对象，
 * Method－类的方法对象
 * 
 * 
 * @author Administrator
 *
 */
public class reflectiveDemo {
	
	
	/*
	 * 获得字段信息的方法
	 * Field getField(String name) -- 获得命名的公共字段 
 	 * Field[] getFields() -- 获得类的所有公共字段 
	 * Field getDeclaredField(String name) -- 获得类声明的命名的字段 
	 * Field[] getDeclaredFields() -- 获得类声明的所有字段
	 */
	
	/*
	 * 获得方法信息的方法
	 * Method getMethod(String name, Class[] params) -- 使用特定的参数类型，获得命名的公共方法 
	 * Method[] getMethods() -- 获得类的所有公共方法 
	 * Method getDeclaredMethod(String name, Class[] params) -- 使用特写的参数类型，获得类声明的命名的方法 
	 * Method[] getDeclaredMethods() -- 获得类声明的所有方法 
	 */
	
	/*
	 * 
	 */
	
	
	/**
	 * 获取一个类的Class 共三种方式
	 * @throws ClassNotFoundException 
	 */
	@Test
	public void test1() throws ClassNotFoundException {
		/////////////第一种
		reflectiveVo stu1 = new reflectiveVo();//这一new 产生一个Student对象，一个Class对象。  
	    Class refClass1 = stu1.getClass();//获取Class对象  
	    System.out.println(refClass1.getName());  
		/////////////第二种
		Class refClass2 = reflectiveVo.class;
		System.out.println(refClass2.getName());
		/////////////第三种  比较常用的  这里需要捕获异常  
		/////////////注意此字符串必须是真实路径，就是带包名的类路径，包名.类名
		Class refClass3 = Class.forName("model.reflectiveVo"); 
		System.out.println(refClass3.getName());
	}
	
	/**
	 * 通过反射 获取 类的方法
	 * @throws Exception 
	 */
	@Test
	public void test2() throws Exception {
		//获取Class
		Class refClass = Class.forName("model.reflectiveVo");
		//获取构造方法  
		//getConstructors() 获取 所有公开的构造方法
		//getDeclaredConstructors();  获取 所有的构造方法
		Constructor[] conArray = refClass.getDeclaredConstructors();
		for(Constructor c : conArray) {
			System.out.println(c);
		}
		
		Constructor con = refClass.getDeclaredConstructor();  
		System.out.println(con);
		
		
	}
	
	/**
	 * 通过反射 获取 类的属性
	 */
	@Test
	public void test3() {
		
	}
}
















