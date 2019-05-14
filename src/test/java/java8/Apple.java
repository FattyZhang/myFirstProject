package java8;

public class Apple {

	private String colour;
	
	private int weight;

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Apple(String colour, int weight) {
		super();
		this.colour = colour;
		this.weight = weight;
	}
	
	public Apple() {
		super();
	}
	
	public static boolean isColour(Apple apple,String colour) {
		return colour.equals(apple.getColour());
	}
	
	public static boolean isWeight(Apple apple) {
		return 150 > apple.getWeight();
	}

	@Override
	public String toString() {
		return "Apple [colour=" + colour + ", weight=" + weight + "]";
	}
	
}


