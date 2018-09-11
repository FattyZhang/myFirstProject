package java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import model.StreamVO;

public class StreamInAction {
	public static void main(String[] args) {
		StreamVO s1 = new StreamVO("张三","退票");
		StreamVO s2 = new StreamVO("李四","改签");
		StreamVO s3 = new StreamVO("王五","改签");
		StreamVO s4 = new StreamVO("赵六","转签");
		
		List<Transaction> transactionList = Arrays.asList(
				new Transaction(s1,2011,1000),
				new Transaction(s2,2012,2000),
				new Transaction(s3,2011,55500),
				new Transaction(s4,2012,4000),
				new Transaction(s4,2012,7000),
				new Transaction(s4,2012,4000)
				);
		
//		List<Transaction> collect = transactionList.stream()
//				.filter(Transaction -> Transaction.getYear() == 2011)
//				.sorted(Comparator.comparing(Transaction::getValue))
//				.collect(Collectors.toList());
//		System.out.println(collect);
//		List<String> collect2 = transactionList.stream().map(t -> t.getS().getJob()).distinct().collect(Collectors.toList());
//		System.out.println(collect2);
		
//		List<StreamVO> collect = transactionList.stream()
//				.map(Transaction::getS)
//				.filter(t -> t.getJob().equals("改签"))
//				.distinct()
//				.sorted(Comparator.comparing(StreamVO::getName))
//				.collect(Collectors.toList());
//		System.out.println(collect);
		
//		String reduce = transactionList.stream().map(t -> t.getS().getJob()).distinct().sorted().reduce("",(job1,job2) -> job1+","+job2);
//		System.out.println(reduce.substring(1, reduce.length()));
		
//		boolean anyMatch = transactionList.stream().map(Transaction::getS).anyMatch(t -> t.getJob().equals("退票"));
		
//		List<String> collect = transactionList.stream().map(Transaction::getS).map(t -> t.getJob()).collect(Collectors.toList());
//		System.out.println(collect);
		
//		transactionList.stream().filter(t -> t.getS().getJob().equals("改签"))
//		.map(Transaction::getValue).sorted(Comparator.reverseOrder()).forEach(System.out::println);
		
//		Integer integer = transactionList.stream().map(Transaction::getValue).reduce(Integer::max).get();
//		System.out.println(integer);
		
		
	}
//transactionList	Transaction
	
}










