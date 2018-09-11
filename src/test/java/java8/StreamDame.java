package java8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import model.StreamVO;

public class StreamDame {
	
	public static void main(String[] args) {
		
		StreamVO s1 = new StreamVO(1,"张三","21","出票");
		StreamVO s2 = new StreamVO(2,"李四","22","退票");
		StreamVO s3 = new StreamVO(3,"王五","23","改签");
		StreamVO s4 = new StreamVO(4,"李刘","24","转签");
		StreamVO s5 = new StreamVO(5,"赵七","25","售后");
		
		List<StreamVO> list = new ArrayList<StreamVO>();
		list.add(s1);
		list.add(s2);
		list.add(s3);
		list.add(s4);
		list.add(s5);
		//stream
		long t2 = System.currentTimeMillis();
		list.stream().forEach(System.out::println);
		System.out.println("Stream遍历耗时:"+(System.currentTimeMillis() - t2)); 
		long t1 = System.currentTimeMillis();
		//迭代器遍历List
		Iterator<StreamVO> iterator = list.iterator();
		while (iterator.hasNext()) {
			StreamVO s = iterator.next();
			System.out.println(s);
		}
		System.out.println("迭代器遍历List耗时:"+(System.currentTimeMillis() - t1));
		
		
	}

}








