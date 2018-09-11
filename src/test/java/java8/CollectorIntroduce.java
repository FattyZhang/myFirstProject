package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class CollectorIntroduce {
	
	public static void main(String[] args) {
		List<Apple> list = Arrays.asList(
				new Apple("蓝色",100),
				new Apple("蓝色",1234),
				new Apple("红色",100),
				new Apple("绿色",100),
				new Apple("紫色",100),
				new Apple("橙色",100),
				new Apple("橙色",123),
				new Apple("橙色",234)
				);
		
		List<Apple> collect = list.stream().filter(a -> !a.getClass().equals("橙色")).collect(Collectors.toList());
		Optional.ofNullable(collect).ifPresent(System.out::println );
		long t1 = System.currentTimeMillis();
		Map<String, List<Apple>> groupByNormal = groupByNormal(list);
		System.out.println(System.currentTimeMillis()-t1);
		System.out.println(groupByNormal);
		long t2 =System.currentTimeMillis();
		Map<String, List<Apple>> groupByFunction = groupByFunction(list);
		System.out.println(System.currentTimeMillis()-t2);
		System.out.println(groupByFunction);
		
		long t3 =System.currentTimeMillis();
		Map<String, List<Apple>> groupByCollector = groupByCollector(list);
		System.out.println(System.currentTimeMillis()-t3);
		System.out.println(groupByCollector);
	}
	
	private static Map<String,List<Apple>> groupByNormal(List<Apple> appleList){
		Map<String,List<Apple>> map = new HashMap<>();
		for(Apple a: appleList) {
			List<Apple> list = map.get(a.getColour());
			if(list == null) {
				list = new ArrayList<>();
				map.put(a.getColour(), list);
			}
			list.add(a);
		}
		return map;
	}
	
	private static Map<String,List<Apple>> groupByFunction(List<Apple> appleList){
		Map<String,List<Apple>> map = new HashMap<>();
		appleList.stream().forEach(a -> {
			//Optional.ofNullable()  获取当前颜色的List 不为空 直接add 为空执行orElseGet() 传入一个对象 如果为null返回对象本身不为null 运行 函数且返回
			List<Apple> orElseGet = Optional.ofNullable(map.get(a.getColour())).orElseGet(() -> {
				List<Apple> list = new ArrayList<>();
				map.put(a.getColour(), list);
				return list;
			});
			orElseGet.add(a);
		});
		return map;
	}
	
	private static Map<String,List<Apple>> groupByCollector(List<Apple> appleList){
		return appleList.stream().collect(Collectors.groupingBy(Apple::getColour));
	}
	
	
	
	
	
	
}





