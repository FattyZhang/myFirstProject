package java8;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class FunctionAction {
			//java  Function常用函数入口
			//1. Consumer	Consumer< T >	接收T对象，不返回值
			//2. Predicate	Predicate< T >	接收T对象并返回boolean
			//3. Function	Function< T, R >	接收T对象，返回R对象
			//4. Supplier	Supplier< T >	提供 T 对象,例如工厂生成 T 对象,没有入参
			//5. UnaryOperator	UnaryOperator<T>	接收 T 对象,返回 T 对象.
			//6. BinaryOperator	BinaryOperator<T>	接收两个T对象,返回一个T对象
	
	public static void main(String[] args) {
		testConsumer();
		testPredicate();
		testFunction();
		testSupplier();
		testUnaryOperator();
		testBinaryOperator();
	}
	
	public static void testConsumer() {
		Consumer<Apple>  c = r -> {
			System.out.println(r.getColour());
			System.out.println(r.getWeight());
		};
		Apple a = new Apple("绿色", 123);
		//接收T对象，不返回值
		c.accept(a);
	}
	
	public static void testPredicate() {
		Predicate<Apple> p = a -> {
			if(a.getWeight() == 11) {
				return false;
			}else {
				return true;
			}
		};
		//接收T对象并返回boolean
		Apple t = new Apple("紫色",12);
		System.out.println(p.test(t));
	}
	
	public static void testFunction() {
		//接收T 返回 R
		Apple a = new Apple("蓝色", 50);
		Function<Apple,String > f = r -> {
			String colour = r.getColour();
			int weight = r.getWeight();
			return colour+"-"+weight;
		};
		String apply = f.apply(a);
		System.out.println(apply);
	}
	
	public static void testSupplier() {
		//提供 T 对象,例如工厂生成 T 对象,没有入参
		Supplier<Apple> s = () -> {
			return new Apple("红色",12);
		};
		Apple apple = s.get();
		System.out.println(apple.getWeight()+"-"+apple.getColour());
	}
	
	public static void testUnaryOperator() {
		// 给一个T 返回一个 T
		UnaryOperator<Apple> u = a -> {
			String colour = a.getColour();
			a.setColour(colour+" plus");
			return a;
		};
		Apple a = new Apple("土豪金",123);
		Apple apply = u.apply(a);
		System.out.println(apply.getColour());
	}
	
	public static void testBinaryOperator() {
		// 给两个T 返回一个T
		BinaryOperator<Apple> b = (n,o) -> {
			int weight = n.getWeight();
			int weight2 = o.getWeight();
			return weight > weight2 ? n : o;
		};
		Apple n = new Apple("银色", 90);
		Apple o = new Apple("灰色", 80);
		Apple apply = b.apply(n, o);
		System.out.println(apply.getWeight());
	}
}






