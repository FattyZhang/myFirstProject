package java8;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import functionalInterface.AppleFunctionalInerface;
import java8.Apple;
import java8.AppleInterface;

//方法推导
public class MethodOverturn {

	public static void main(String[] args) {
		
		//类推导
		Supplier<String> supplierApple = String::new;
		
		//带参数的类 推导
		BiFunction<String,Integer,Apple> biFunction = Apple::new;

		//引用变量推导
		String abc = new String("abc"); 
		Function<Integer,Character> function = abc::charAt;
		Character apply = function.apply(2);
		System.out.println(apply);
		
		//自定义FunctionalInterface 推导
		AppleFunctionalInerface<String, Integer, String, AppleInterface> appleInterface = AppleInterface::new;
		AppleInterface apply2 = appleInterface.apply("red", 100, "Fushi");
		System.out.println(apply2);
		
		
	}
	
}
