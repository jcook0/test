package assignment1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 *  LinkedListDriver.java
 * 
 * 
 */

public class LinkedListDriver {
	
    public static Scanner input = new Scanner(System.in);
    public static SortedLinkedList linkedList = new SortedLinkedList();

	public void mergeList() {
		
	}
	
	public static void deleteAltNodes() {
		int l = linkedList.getLength()/2;
		
		while (l>0) {
			try {
				linkedList.resetList();
				linkedList.getNextItem();
				linkedList.deleteItem(linkedList.getNextItem());
			} catch(Exception e) {
				
			}
			l--;
		}
	}
	
	public static void intersection() {
		System.out.println("Enter the length of the new list: ");
		int l = input.nextInt();

		ArrayList<Integer> intersectionArr = new ArrayList<Integer>();
		
		if (l > 0) {
			System.out.println("Enter the numbers: ");
			
			SortedLinkedList newList = new SortedLinkedList();

			
			while (input.hasNext()) { // add numbers
				int v = input.nextInt();
				if (newList.searchItem(new ItemType(v)) == -1) {
					newList.insertItem(new ItemType(v));
					
					if (linkedList.searchItem(new ItemType(v)) != 1) {
						intersectionArr.add(v);
					}
				}
			}
			
			System.out.print("list 1: ");
			linkedList.print();
			System.out.println();
			
			System.out.print("list 2: ");
			newList.print();
			System.out.println();
			
			System.out.print("Intersection: " + intersectionArr.toString());
			System.out.println();
		}
		
	}
	
	public static void processCommand(String cmd) {
		char char1 = cmd.charAt(0);
		
		switch (char1) {
			case 'i': //insert value
				
				System.out.println("Enter a number to insert: ");
				int insertInt = input.nextInt();
				
				int index2 = linkedList.searchItem(new ItemType(insertInt));
				
				if (index2 == -1) {
					System.out.println("The item is not present in the list");
					break;
				} else {
					System.out.print("Original list: ");
					linkedList.print();
					System.out.println();
				}
				
				linkedList.insertItem(new ItemType(insertInt));
				
				System.out.print("New list: ");
				linkedList.print();
				System.out.println();
				
				break;
			case 'd': //delete value
				System.out.println("Enter a number to delete: ");
				int deleteInt = input.nextInt();
				

				
				int index3 = linkedList.searchItem(new ItemType(deleteInt));
				
				if (index3 == -1) {
					System.out.println("The item is not present in the list");
					break;
				} else {
					System.out.print("Original list: ");
					linkedList.print();
					System.out.println();
				}
				
				linkedList.deleteItem(new ItemType(deleteInt));
				
				System.out.print("New list: ");
				linkedList.print();
				System.out.println();
				
				break;
			case 's': //search value
				
				System.out.println("Enter a number to search: ");
				int searchInt = input.nextInt();
				
				System.out.print("Original list: ");
				linkedList.print();
				System.out.println("");
				
				int index = linkedList.searchItem(new ItemType(searchInt));
				
				if (index == -1) {
					System.out.println("The item is not present in the list");
				} else {
					System.out.println("The item is at index "+ index);
				}
				
				break;
			case 'n': 
				
				if (linkedList.getLength() == 0) {
					System.out.print("The list is empty");
				} else {
					ItemType it = linkedList.getNextItem();
					if (it != null) {
						System.out.println(it.getValue());
					} else {
						System.out.println("The end of the list has been reached.");
					}
				}

				break;
			case 'r': //reset 
				linkedList.resetList();
				System.out.println("Iterator is reset.");
				break;
			case 'a': //delete alt nodes
				
				System.out.print("Original list: ");
				linkedList.print();
				System.out.println("");
				
				deleteAltNodes();
				
				System.out.print("New list: ");
				linkedList.print();
				System.out.println();
				
				break;
			case 'm': //merge lists
				
				break;
			case 't': //find intersection
				
				intersection();
				
				break;
			case 'p': //print
				
				if (linkedList.getLength() == 0) {
					System.out.print("The list is empty");
				} else {
					System.out.print("The list is: ");
					linkedList.print();
					System.out.println();
				}
				
				break;
			case 'l': //length
				System.out.println("The length of the list is " + linkedList.getLength());		
				break;
			case 'q': //quit
				System.exit(0);
				break;
		}
	}
	
	public static void main(String args[]) {
		
	    String fileName = null;
		
	    if(args.length < 1) {
	        System.err.println("Error, usage: java ClassName file.txt");
	        fileName = "input.txt";
	    } else {
	    	//fileName = args[0];
	    	System.exit(1);
	    }
	    
	   
	    try {
			Scanner reader = new Scanner(new FileInputStream(fileName));
			
			while (reader.hasNext()) {
				int v = reader.nextInt();
				if (linkedList.searchItem(new ItemType(v)) == -1) {
					linkedList.insertItem(new ItemType(v));
				}
			}
			
			reader.close();

		} catch (FileNotFoundException e) {
			System.err.println("Error, The file "+fileName+" could not be found.");
			e.printStackTrace();
			System.exit(1);
		}
	    
	    while (true) {
	    	System.out.println("Enter a command: ");
	    	String cmd = input.next();
	    	
	    	if (cmd.equals("q")) {
	    		break;
	    	}
	    	
	    	processCommand(cmd);	
	    }
	    
	    input.close();
	}
	
}
