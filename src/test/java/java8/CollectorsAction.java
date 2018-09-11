package java8;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import java8.Dish.Type;

public class CollectorsAction {
	
	private static final List<Dish> menu = Arrays.asList(
			new Dish("111",false,100,Dish.Type.MEAT),
			new Dish("222",false,200,Dish.Type.MEAT),
			new Dish("333",false,560,Dish.Type.OTHER),
			new Dish("444",true,450,Dish.Type.MEAT),
			new Dish("555",false,900,Dish.Type.FISH),
			new Dish("666",true,123,Dish.Type.MEAT),
			new Dish("777",false,987,Dish.Type.OTHER),
			new Dish("888",false,123,Dish.Type.MEAT),
			new Dish("999",true,676,Dish.Type.FISH)
			);

	public static void main(String[] args) {
		testAveragingDouble_Int_Long();
		testCollectingAndThen();
		testCounting();
		testGroupingBy_Counting();
	}
	
	private static void testAveragingDouble_Int_Long() {
		System.out.println("testAveragingDouble_Int_Long");
		//计算list集合中calories的平均值averagingDouble ofNullable():创建Optional对象 不管有没有值       ifPresent:有值执行 没有值不执行
		Optional.ofNullable(menu.stream().collect(Collectors.averagingDouble(Dish::getCalories))).ifPresent(System.out::println);
		Optional.ofNullable(menu.stream().collect(Collectors.averagingInt(Dish::getCalories))).ifPresent(System.out::println);
		Optional.ofNullable(menu.stream().collect(Collectors.averagingLong(Dish::getCalories))).ifPresent(System.out::println);
	}
	
	private static void testCollectingAndThen() {
		System.out.println("testCollectingAndThen.");
		Optional.ofNullable(menu.stream().collect(Collectors.collectingAndThen(Collectors.averagingInt(Dish::getCalories),a -> "平均的卡路里为:"+a)))
			.ifPresent(System.out::println);;
	}
	
	private static void testCounting() {
		System.out.println("testCounting");
		Optional.ofNullable(menu.stream().collect(Collectors.collectingAndThen(Collectors.counting(),a -> "size:"+a))).ifPresent(System.out::println);;
	}
	
	private static void testGroupingBy_Counting() {
		System.out.println("testGroupingBy_Counting");
		//每个类型的个数
		Optional.ofNullable(menu.stream().collect(Collectors.groupingBy(Dish::getType,Collectors.counting()))).ifPresent(System.out::println);;
		//每个类型的平均值
		Optional.ofNullable(menu.stream().collect(Collectors.groupingBy(Dish::getType,Collectors.averagingInt(Dish::getCalories)))).ifPresent(System.out::println);;
		//统计
		IntSummaryStatistics collect = menu.stream().collect(Collectors.summarizingInt(Dish::getCalories));
		System.out.println(collect);
	}
	
	
}












