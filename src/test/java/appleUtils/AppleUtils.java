package appleUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java8.Apple;
import java8.Dish;

public class AppleUtils {

	
	/**
	 * 获取AppleList
	 */
	public static List<Apple> getAppleList(){
		List<Apple> apples = new ArrayList<Apple>();
		Apple a1 = new Apple("red",80);
		Apple a2 = new Apple("blue",100);
		Apple a3 = new Apple("red",150);
		Apple a4 = new Apple("blue",170);
		Apple a5 = new Apple("grren",20);
		Apple a6 = new Apple("yellow",180);
		Apple a7 = new Apple("purple",3000);
		apples.add(a1);
		apples.add(a2);
		apples.add(a3);
		apples.add(a4);
		apples.add(a5);
		apples.add(a6);
		apples.add(a7);
		return apples;
	}
	
	public static List<Dish> getDishList() {
		return Arrays.asList(new Dish("111", false, 100, Dish.Type.MEAT),
				new Dish("222", false, 200, Dish.Type.MEAT), new Dish("333", false, 560, Dish.Type.OTHER),
				new Dish("444", true, 450, Dish.Type.MEAT), new Dish("555", false, 900, Dish.Type.FISH),
				new Dish("666", true, 123, Dish.Type.MEAT), new Dish("777", false, 987, Dish.Type.OTHER),
				new Dish("888", false, 123, Dish.Type.MEAT), new Dish("999", true, 676, Dish.Type.FISH));
	}
	
	
	public static Apple getApple() {
		return new Apple("red",200);
	}
	
}
