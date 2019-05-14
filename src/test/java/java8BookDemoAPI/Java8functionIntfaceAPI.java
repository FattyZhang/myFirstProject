package java8BookDemoAPI;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import java.util.function.UnaryOperator;

import appleUtils.AppleUtils;
import java8.Apple;

//java8 常用的API 汇总
public class Java8functionIntfaceAPI {

	//java8核心让方法参数化行动起来
	//如果它里面有一个抽象方法剩下的是defer或者是static 哪它就是functionInterface
	public static void main(String[] args) {
		//******************常用函数入口******************
		//1. Function<T,R> 传入一个T返回一个R
		Function<Apple,String> function = T -> {
			String R = "苹果的颜色:"+T.getColour();
			return R;
		};
		
		//2. Consumer<T> 接收T对象不返回值		--> consumer 消费者
		Consumer<String> consumer = s -> {
			System.out.println(s);
		};
		
		//3. Predicate<T> 接收T对象 返回一个boolean  和Function<T,boolean> 功能相识   --> 断言 
		Predicate<String> predicate = s -> s.equals("Predicate");
		
		//4. Supplier<T> 没有入参 返回T对象 ;  工厂生成T对象   -->供应者
		Supplier<Apple> supplier = Apple::new;
		Supplier<Apple> supplier2 = () -> {
			return new Apple("red",100);
		};
		
		//5. BinaryOperator<T> 传入2个T对象返回一个T对象   Operator-->经营者
		BinaryOperator<Apple> binartOperator = (n,o) -> {
			return n.getWeight()>o.getWeight() ? n:o;
		}; 
		binartOperator.apply(new Apple("red",100),new Apple("bule",200));
		
		//6. UnaryOperator<T> 传入一个T 返回一个T
		UnaryOperator<Apple> unartOperator = t -> {
			t.setColour("red");
			return t;
		}; 
		unartOperator.apply(new Apple("bule",100));
		
		//BiFunction<T,U,R>  传入T,U返回一个R 
		BiFunction<String,Integer,String> biFun  = (s,i) -> s+i;
		String apply = biFun.apply("1234", 50);
		System.out.println("apply:"+apply);
		
		//IntFunction<R> 传入int返回R
		IntFunction<String> intFunction = i -> "123"+i;
		String apply2 = intFunction.apply(4);
		System.out.println("apply2:"+apply2);
		
		//ToIntFunction<T> 传入T返回Int
		ToIntFunction<Apple> toIntFunction = Apple::getWeight;
		int applyAsInt = toIntFunction.applyAsInt(new Apple("red",100));
		System.out.println("applyAsInt:"+applyAsInt);
		
	}
	
	
	
}






