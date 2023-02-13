package assignment1;

/*
 *  ItemType.java
 * 
 * 
 */

public class ItemType {
	private int value;
	
	public int compareTo(ItemType item) {
		if (item.getValue() > this.value) {
			return -1;
		} else if (item.getValue() < this.value)  {
			return 1;
		} else {
			return 0;
		}
	}
	
	public int getValue() {
		return this.value;
	}
	
	public void initialize(int num) {
		this.value = num;
	}
	
	ItemType() {
		
	}
	
	ItemType(int num) {
		this.initialize(num);
	}
	
}
