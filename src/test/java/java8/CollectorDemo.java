package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorDemo {
	
	public static void main(String[] args) {
//		1.将流中的数据转成集合类型: toList、toSet、toMap、toCollection
//		2.将流中的数据(字符串)使用分隔符拼接在一起：joining
//		3.对流中的数据求最大值maxBy、最小值minBy、求和summingInt、求平均值averagingDouble
//		4.对流中的数据进行映射处理 mapping
//		5.对流中的数据分组：groupingBy、partitioningBy
//		6.对流中的数据累计计算：reducing
		test2();
	}
	
	public static void test1() {
		//toList    		toList()		无参			返回List集合
		//toSet				toSet()			无参		
		//toMap 			toMap(function<T,R> key,function<T,R> value)		传入两个function			返回一个map
		//					toMap(function<T,R>,function<T,R> key,BinaryOperator<T> value,BinaryOperator<T,T> value)
							//传入两个function和一个BinaryOperator 如果key重复 根据BinaryOperator 取值
		//toCollection		toCollection(Supplier<T>)
		ArrayList<Integer> collect = Stream.of(1, 3, 4).collect(Collectors.toCollection(ArrayList::new));
		System.out.println(collect);
	}
	
	public static void test2() {
		Apple a1 = new Apple("aaaa", 1111);
		Apple a2 = new Apple("aaaa", 2222);
		Apple a3 = new Apple("aaaa", 3333);
		Apple a4 = new Apple("aaaa", 4444);
		Apple a5 = new Apple("aaaa", 5555);
		List<Apple> asList = Arrays.asList(a1,a2,a3,a4,a5);
		String collect = asList.stream().map(Apple::getColour).collect(Collectors.joining(" "));
		System.out.println(collect);
	}

}




