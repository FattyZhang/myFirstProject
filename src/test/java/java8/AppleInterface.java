package java8;

public class AppleInterface {

	
	private String colour;
	
	private int weight;
	
	private String nane;

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

	public String getNane() {
		return nane;
	}

	public void setNane(String nane) {
		this.nane = nane;
	}

	@Override
	public String toString() {
		return "AppleInterface [colour=" + colour + ", weight=" + weight + ", nane=" + nane + "]";
	}

	public AppleInterface() {
		super();
	}

	public AppleInterface(String colour, int weight, String nane) {
		super();
		this.colour = colour;
		this.weight = weight;
		this.nane = nane;
	}
	
	
}
