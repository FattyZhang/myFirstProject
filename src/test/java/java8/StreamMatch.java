package java8;

import java.util.List;

import model.StreamVO;

public class StreamMatch {

	public static void main(String[] args) {
		List<StreamVO> streamList = StreamMap.getStreamList();
		//所有元素都满足 返回true  --allMatch
		boolean allMatch = streamList.stream().allMatch(i -> i.getAge().equals("20"));
		System.out.println(allMatch);
		//只要有一个元素满足 就返回true --anyMatch
		boolean anyMatch = streamList.stream().anyMatch(i -> i.getId() > 3);
		System.out.println(anyMatch);
		//没有一个元素满足 就返回true --noneMatch
		boolean noneMatch = streamList.stream().noneMatch(i -> i.getId()<0);
		System.out.println(noneMatch);
	}
	
	
}
