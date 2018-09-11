package java8;

import java.util.Arrays;
import java.util.List;

import model.StreamVO;

public class StreamReduce {
	
	public static void main(String[] args) {
		List<StreamVO> streamList = StreamMap.getStreamList();
		List<Integer> asList = Arrays.asList(1,2,3,4,5,8);
		
		//计算 初始值 参数 计算
		Integer reduce = asList.stream().reduce(0,Integer::max);
		System.out.println(reduce);
		Integer integer = asList.stream().reduce((i,j) -> i+j).get();
		Integer integer2 = asList.stream().reduce(Integer::max).get();
		System.out.println(integer);
		System.out.println(integer2);
	}

}
