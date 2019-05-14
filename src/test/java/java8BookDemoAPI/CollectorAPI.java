package java8BookDemoAPI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.alibaba.druid.sql.ast.statement.SQLColumnDefinition.Identity;

import appleUtils.AppleUtils;
import java8.Apple;
import java8.Dish;
import java8.Dish.Type;

public class CollectorAPI {
	
	public static void main(String[] args) {
		/**
		 * Collector主要有三点
		 * 1.收集器,统计
		 * 2.分组
		 * 3.分割
		 * 
		 */
		//appleList.stream().collect(Collectors.);
		List<Apple> appleList = AppleUtils.getAppleList();
		
		
		//---------------收集器 start--------------------
		//toList/toSet 返回:一个集合<T>
		List<Apple> toList = appleList.stream().collect(Collectors.toList());
		Set<Apple> toSet = appleList.stream().collect(Collectors.toSet());
		//toMap<Function<T,R> -key- ,Function<T,R> -Value- >
		//入参:  第一个参数: Map的key  --> <Function<T,K>
		//		第二个参数: Map的Value  --> <Function<T,U>
		Map<String, Apple> toMap1 = appleList.stream().collect(Collectors.toMap(Apple::getColour, Function.identity()));
		//		第三个参数: 在流中的数据key值相同的情况下返回你需要得到的value --> BinaryOperator<U>
		Map<String, Apple> toMap2 = appleList.stream().collect(Collectors.toMap(Apple::getColour, Function.identity(),(a1,a2) -> a2));
		//		第四个参数: 指定其他的映射实现 --> Supplier<M>
		LinkedHashMap<String,Apple> toMap3 = appleList.stream().collect(Collectors.toMap(Apple::getColour, Function.identity(),(a1,a2) -> a2,LinkedHashMap::new));
		//toCollection<Supplier>  将结果收集到其它类型的集合中
		LinkedHashSet<Apple> toCollection = appleList.stream().collect(Collectors.toCollection(LinkedHashSet::new));
		// collectingAndThen<Collectors,Function<R,RR>>
		//入参:Collectors<T,A,R> Function<R,RR>  返回:function的R	注:转换函数返回的类型,包裹另一个转换器,对其结果应用转换函数
		String collectingAndThen = appleList.stream().collect(Collectors.collectingAndThen(Collectors.averagingInt(Apple::getWeight), a -> "在加工->"+a));
		//---------------收集器 end--------------------
		
		
		
		List<Dish> menu = AppleUtils.getDishList();
		// averagingInt/averagingDouble/averagingLong<Function<T,?R>>
		//	入参:Function<T,?R>	返回:取传入属性的平均值返回	注:一种聚合函数,取属性的平均值按照相应的类型返回
		Double collect = appleList.stream().collect(Collectors.averagingInt(Apple::getWeight));
		Map<Type, Long> collect3 = menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.counting()));
		// 统计
		IntSummaryStatistics collect2 = menu.stream().collect(Collectors.summarizingInt(Dish::getCalories));
		System.out.println(collect2);
		
		
		
	}

}
