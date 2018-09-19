package myFirstProject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class PatternTest {
	
	@Test
	public void test() {
		String str = "123Java456Java789Java000";
		Pattern pattern = Pattern.compile("Java");
		System.out.println(pattern.pattern());//返回此模式的正则表达式即Java
		
		String[] result = str.split("Java");
		for(String s : result)
		    System.out.println(s);
	}
	
	@Test
	public void test1() {
		Pattern pattern = Pattern.compile("Java");
		String test1 = "Java";
		String test2 = "Java1234";
		String test3 = "1234Java";
		Matcher matcher = pattern.matcher(test1);
		System.out.println(matcher.matches());//返回true
		matcher = pattern.matcher(test2);
		System.out.println(matcher.matches());//返回false

		matcher = pattern.matcher(test1);
		System.out.println(matcher.find());//返回true
		
		matcher = pattern.matcher(test2);
		System.out.println(matcher.find());//返回true
		
		matcher = pattern.matcher(test3);
		System.out.println(matcher.find(2));//返回true
		
		matcher = pattern.matcher(test3);
		System.out.println(matcher.find(5));//返回false
	}

}
