package assignment1;

/*
 *  SortedLinkedList.java
 * 
 * 
 */

public class SortedLinkedList {
	private NodeType head;
	private NodeType currentPos;
	
	public SortedLinkedList() {
		
	}
	
	public int getLength() {
		int l = 1;
		currentPos = head;
		
		if (currentPos == null) {
			return 0;
		}

		while (this.getNextItem() != null) {
			l++;
		}
		
		return l;
	}
	
	public void insertItem( ItemType item) {
		NodeType newHead = new NodeType();
		newHead.info = item;
		
		if (head != null) {
			newHead.next = head;	
		}
		head = newHead;	
	}
	
	public void deleteItem(ItemType item) {
		
		int index = this.searchItem(item);
		
		if (index == -1) {
			//System.out.println("The item is not present in the list");
			return;
		}
		
		currentPos = head;
		
		head = null;
		
		if (currentPos.info.getValue() != item.getValue()) {
			this.insertItem(currentPos.info);
		}
		
		while (this.getNextItem() != null) {
			
			if (currentPos.info.getValue() != item.getValue()) {
				this.insertItem(currentPos.info);
			}		
		}

		
	}
	
	public int searchItem(ItemType item) {
		currentPos = head;
		
		if (currentPos == null) {	
			return -1;
		}

		int index = 0;
		boolean present = false;
		
		if (currentPos.info.getValue() == item.getValue()) {
			return 0;
		}
		
		while (this.getNextItem() != null) {
			index++;
			if (currentPos.info.getValue() == item.getValue()) {
				present = true;
				break;
			}
		}
		
		if (present) {
			return index;
		} else {
			return -1;
		}	
	}
	
	public void print() {
		currentPos = head;
		
		if (currentPos == null) {
			return;
		}
		
		System.out.print(currentPos.info.getValue());
		System.out.print(" ");

		while (this.getNextItem() != null) {
			System.out.print(currentPos.info.getValue());
			System.out.print(" ");
		}
	}
	
	public ItemType getNextItem() {
		if (currentPos == null) {
			if (head == null) {
				return null;
			} else {
				currentPos = head;
			}
		}
		
		ItemType i = currentPos.info;
		
		if (currentPos.next != null) { //if at the end of list
			currentPos = currentPos.next;
		} else {
			return null;
		}
		
		return i;
	}
	
	public void resetList() {
		// Initialize the currentPos to null
		this.currentPos = null;
	}
	
}
