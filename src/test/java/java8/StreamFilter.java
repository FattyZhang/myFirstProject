package java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFilter {
//Stream Filter api
	
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,7,1,8,9);
		
		// filter
		List<Integer> collect = list.stream().filter(i -> i%2 == 0).collect(Collectors.toList());
		System.out.println(collect);
		// skip 过滤前n位的元素
		List<Integer> collect2 = list.stream().skip(5).collect(Collectors.toList());
		System.out.println(collect2);
		// limit 只要前n位的元素
		List<Integer> collect3 = list.stream().limit(5).collect(Collectors.toList());
		System.out.println(collect3);
		// distinct 去除重复
		List<Integer> collect4 = list.stream().distinct().collect(Collectors.toList());
		System.out.println(collect4);
	}
}










