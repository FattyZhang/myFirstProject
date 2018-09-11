package java8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class CreateStream {
	//Collection
	
	public static void main(String[] args) {
//		System.out.println("==============Collection");
//		createStreamFromCollection().forEach(System.out::println);
//		System.out.println("==============Values");
//		createStreamFromValus().forEach(System.out::println);
//		System.out.println("==============Arrays");
//		createStreamFromArrays().forEach(System.out::println);
//		System.out.println("==============Files");
//		createStreamFronFile();
//		System.out.println("==============Iterator");
//		createStreamFromIterator().forEach(System.out::println);
//		System.out.println("==============generate");
//		careateStreamFromGenerate().forEach(System.out::println);
//		System.out.println("==============generate_自定义");
//		createAStreamFromGenerate().forEach(System.out::println);
	}
	
	//创建Stream--Collection
	private static Stream<String> createStreamFromCollection(){
		List<String> list = Arrays.asList("张三","李四","王五","赵六","张七","冯八");
		return list.stream();
	}
	//创建Stream--Values
	private static Stream<String> createStreamFromValus(){
		return Stream.of("张三","李四","王五","赵六","张七","冯八"); 
	}
	//创建Stream--Arrays
	private static Stream<String> createStreamFromArrays(){
		return Arrays.stream(new String[] {"张三","李四","王五","赵六","张七","冯八"});
	}
	//创建Stream--File
	private static Stream<String> createStreamFronFile(){
		Path path =  Paths.get("D:\\eclipseProject\\myFirstProject\\src\\test\\java\\java8\\StreamTest.java");
		try(Stream<String> lines = Files.lines(path)){
			lines.limit(10).forEach(System.out::println);
			return lines;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	//创建Stream--Iterator
	private static Stream<Integer> createStreamFromIterator(){
		Stream<Integer> stream = Stream.iterate(2, n -> n+2).limit(100);
		return stream;
	}
	//创建Stream--Generate
	private static Stream<Double> careateStreamFromGenerate(){
		Stream<Double> stream = Stream.generate(Math::random).limit(10);
		return stream;
	}
	
	//创建自定义对象Stream--Generate
	private static Stream<A> createAStreamFromGenerate(){
		return Stream.generate(new ASupplier()).limit(10);
	}
	
	static class  A{
		private int id ;
		private String name;
		
		public A(int id, String name) {
			super();
			this.id = id;
			this.name = name;
		}

		@Override
		public String toString() {
			return "A [id=" + id + ", name=" + name + "]";
		}
		
	}

	static class ASupplier implements Supplier<A>{

		private int index = 0;
		private Random random = new  Random(System.currentTimeMillis());
		@Override
		public A get() {
			index = random.nextInt(100);
			return new A(index ,index+"");
		}
	}
	
	
}













