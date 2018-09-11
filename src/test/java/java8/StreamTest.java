package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

public class StreamTest {
	
	@Test
	public void test() {
		
	}
	
	@Test
	public void test3() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4);
		Stream<Integer> stream = list.stream();
		stream.map(i -> i + 1).forEach(System.out::println);
	}
	
	@Test
	public void test2() {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}
		Stream<Integer> stream = list.stream(); 
		stream.map(i -> i+1).forEach(System.out::println);
	}
	
	
	@Test
	public void test1() {
		Stream<Integer> stream = Stream.of(1,2,3,4,5,6);
		stream.forEach(Integer -> System.out.println(Integer));
	}
	

}
