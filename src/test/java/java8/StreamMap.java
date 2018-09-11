package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import model.StreamVO;

public class StreamMap {
	
	public static void main(String[] args) {
		List<StreamVO> list= getStreamList();
		//自然排序
		List<String> collect = list.stream().map(m -> m.getAge()).sorted().collect(Collectors.toList());
		System.out.println(collect);
		//倒叙排序
		List<String> collect1 = list.stream().map(m -> m.getAge()).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println(collect1);
		
		String[] strArr = new String[] {"hello","world"};
		List<String[]> collect2 = Arrays.asList(strArr).stream().map(i -> i.split("")).collect(Collectors.toList());
		collect2.stream().flatMap(Arrays::stream).distinct().forEach(System.out::println);
		
		
		
	}
	
	
	public static List<StreamVO> getStreamList() {
		StreamVO s1 = new StreamVO(1,"张三","20","出票");
		StreamVO s2 = new StreamVO(2,"李四","20","退票");
		StreamVO s3 = new StreamVO(3,"王五","20","改签");
		StreamVO s4 = new StreamVO(4,"李刘","20","转签");
		StreamVO s5 = new StreamVO(-1,"赵七","-1","售后");
		List<StreamVO> list = new ArrayList<StreamVO>();
		list.add(s1);
		list.add(s2);
		list.add(s3);
		list.add(s4);
		list.add(s5);
		return list;
	}
	
}
