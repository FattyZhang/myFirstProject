package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class CollectorDemo {
	
	public static void main(String[] args) {
//		1.将流中的数据转成集合类型: toList、toSet、toMap、toCollection
//		2.将流中的数据(字符串)使用分隔符拼接在一起：joining
//		3.对流中的数据求最大值maxBy、最小值minBy、求和summingInt、求平均值averagingDouble
//		4.对流中的数据进行映射处理 mapping
//		5.对流中的数据分组：groupingBy、partitioningBy
//		6.对流中的数据累计计算：reducing
	}
	
	public static void test1() {
		//1.将流中的数据转成集合类型: toList、toSet、toMap、toCollection
		
		//toList    		toList()		无参			返回List集合
		//toSet				toSet()			无参		
		//toMap 			toMap(function<T,R> key,function<T,R> value)		传入两个function			返回一个map
		//					toMap(function<T,R>,function<T,R> key,BinaryOperator<T> value,BinaryOperator<T,T> value)
							//传入两个function和一个BinaryOperator 如果key重复 根据BinaryOperator 取值
		//toCollection		toCollection(Supplier<T>)
		ArrayList<Integer> collect = Stream.of(1, 3, 4).collect(Collectors.toCollection(ArrayList::new));
		System.out.println(collect);
	}
	
	public static List<Apple> getList() {
		Apple a1 = new Apple("aaaa1", 10);
		Apple a2 = new Apple("aaaa2", 20);
		Apple a3 = new Apple("aaaa3", 30);
		Apple a4 = new Apple("aaaa2", 60);
		Apple a5 = new Apple("aaaa5", 60);
		List<Apple> asList = Arrays.asList(a1,a2,a3,a4,a5);
		return asList;
	}
	
	@Test
	public void test2() {
		//2.将流中的数据(字符串)使用分隔符拼接在一起：joining
		String collect = getList().stream().map(Apple::getColour).collect(Collectors.joining("-"));
		System.out.println(collect);
		String collect2 = getList().stream().map(Apple::getColour).collect(Collectors.collectingAndThen(Collectors.joining(","),a -> a+"111"));
		System.out.println(collect2);
	}

	@Test
	public void test3() {
		//3.对流中的数据求最大值maxBy、最小值minBy、求和summingInt、求平均值averagingDouble
		Integer collect = getList().stream().map(Apple::getWeight).collect(Collectors.collectingAndThen(Collectors.minBy((a, b) -> a - b), Optional::get));
		System.out.println(collect);
		Integer collect1 = getList().stream().map(Apple::getWeight).max((a,b) -> a-b).get();
		System.out.println(collect1);
		Integer collect2 = getList().stream().map(Apple::getWeight).collect(Collectors.summingInt(a -> a+1));
		System.out.println(collect2);
		Double collect3 = getList().stream().map(Apple::getWeight).collect(Collectors.averagingInt(a -> a));
		System.out.println(collect3);
	}
	
	@Test
	public void test4() {
		//4.对流中的数据进行映射处理 mapping
		String collect = getList().stream().map(Apple::getColour).collect(Collectors.mapping(a -> a.toString().length()+"",Collectors.joining("-")));
		System.out.println(collect);
		String collect2 = getList().stream().map(a ->a.getWeight()).collect(Collectors.mapping(x -> x.toString(), Collectors.joining("-")));
		System.out.println(collect2);
		
	}
	
	@Test
	public void test5() {
		//5.对流中的数据分组：groupingBy、partitioningBy
		// 参考 CollectorsAction
		
	}
	
	@Test
	public void test6() {
		//6.对流中的数据累计计算：reducing
		//参看 StreamReduce
	}
}




