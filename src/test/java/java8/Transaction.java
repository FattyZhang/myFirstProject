package java8;

import model.StreamVO;

public class Transaction {

	private final StreamVO s;
	
	private final int year;
	
	private final int value;
	

	public Transaction(StreamVO s, int year, int value) {
		super();
		this.s = s;
		this.year = year;
		this.value = value;
	}

	public StreamVO getS() {
		return s;
	}

	public int getYear() {
		return year;
	}

	public int getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "Transaction [s=" + s + ", year=" + year + ", value=" + value + "]";
	}
	
	
	
}
