package java8BookDemoAPI;

import java.util.Optional;

import java8.Apple;

public class OptionalAPI {
	public static void main(String[] args) {
		
		//==================构造Optional<T> start=====================
		//1. Optional.empty() 无入参	返回:空的 Optional<T>   
		Optional<Apple> empty = Optional.empty();
		
		//2. Optional.of(T) 入参:T 返回:你传入泛型的 Optional<T>
		Optional<Apple> of = Optional.of(new Apple("red",100));
		
		//3. Optional.ofNullable(T) 入参:T  返回: [传入为null 则空的 Optional<T>] [不为null 你传入泛型的 Optional<T>] 
		Optional<Apple> of1 = Optional.ofNullable(null);
		//==================构造Optional<T> end=====================
		
		
		//==================Optional<T>的方法 start=====================
		//1. get() 不解释 !
		Apple apple = of.get();
		
		//2. orElse(Object o)  入参:Object()  返回:Option[有值返回自身的值] [没有值返回你传入的值]
		Apple orElse = of.orElse(new Apple("123",200));

		//3. orElseGet(Supplier()) 入参:Supplier()  返回:Option[有值返回自身的值] [没有值返回你传入的值]
		Apple orElseGet1 = of.orElseGet(Apple::new);
		Apple orElseGet = of.orElseGet(() -> new Apple("123",200));
		
		//4. orElseThrow(exceptionSupplier)  入参:一个异常exceptionSupplier()  返回:Option[有值返回自身的值] [没有值抛出你的传入的异常]
		Apple orElseThrow = of.orElseThrow(RuntimeException::new);
		Apple orElseThrow1 = of.orElseThrow(() -> new RuntimeException("出现了异常.."));
		
		//5. filter(predicate<T>) 入参:predicate<T> 返回:Optional<T> 	 注:经过断言返回过滤后的值
		Optional<Apple> filter = of.filter(a -> a.getWeight() == 200);
		
		//6. map(Function<T,R>) 入参:Function<T,R> 返回:Optional<T> 	 注:把function返回的值封装成optional返回
		Optional<Integer> map = of.map(Apple::getWeight);
		
		//7. flatMap<T,Optional<T>>  入参:Function<T,Optional> 返回:Optional<T>  注: 扁平化处理function中 返回的类型必须是Optional 方便继续map操作
		Optional<String> flatMap = of.flatMap(a -> Optional.ofNullable(a.getColour()));
		Optional<Integer> map2 = of.flatMap(a -> Optional.ofNullable(a.getColour())).map(String::length);

		//8. isPresent()  入参:无	返回boolean	注:判断当前optional是否为null 
		boolean present = of.isPresent();
		
		//9. ifPresent()  入参:传入consumer<T>	返回:无	注:把当前optional传入进行操作,无返回 ,如果传入的参数为null 不报异常
		of1.ifPresent(System.out::println);
		
		//==================Optional<T>的方法 end=====================
	}
}












