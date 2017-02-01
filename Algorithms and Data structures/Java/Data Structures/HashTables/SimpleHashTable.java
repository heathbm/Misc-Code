import java.util.Arrays;

public class SimpleHashTable {
	
	int[] table;
	int itemsInTable = 0;
	int tableSize;
	
	SimpleHashTable(int size) {
		
		tableSize = size;
		table = new int[size];
		Arrays.fill(table, -1);
		
	}
	
	
	public void insert(int element) {
		
		itemsInTable++;
		int index = element % (tableSize);
		
		while (table[index] != -1) {
			index += 1;
			index %= (tableSize);
		} 
		
		table[index] = element;
		
		
	}
	
	public void insertArray(int[] elements) {
		
		for (int i = 0; i < elements.length; i++) {
		
			insert(elements[i]);
			
		}
		
	}
	
	public boolean isElementPresent(int element) {
		
		int index = element % (tableSize);
		
		for (int i = 0; i < tableSize; i++) {
			
			if(table[index] == element) {
				return true;
			} 
			
			index += 3;
			index %= (tableSize);
			
		} 
		
		return false;
	
	}
	
	public void display() {
		
		for (int i = 0; i < table.length; i++) {
			System.out.print(table[i] + ",");
		}
		
	}
	
	public boolean isFull() {
		return (tableSize == itemsInTable);
	}
	
	public int spacesLeft() {
		return (tableSize - itemsInTable);
	}
	
	public static void main(String[] args) {
		
		SimpleHashTable table = new SimpleHashTable(30);
		
		int[] elements = new int[30]; // parameter is size of the hash table
		
		for (int i = 60; i < 90; i++) {
			//table.insert(i * i); // use this for insert function
			elements[i-60] = i * i; // use this for insertArray function 
		}

		table.insertArray(elements);
		table.display();
		
		System.out.println("\n");
		System.out.println("Is 7569 present: " + table.isElementPresent(7569));
		
		System.out.println();
		System.out.println("Is table full: " + table.isFull());
		
		System.out.println();
		System.out.println("Spaces remain in table: " + table.spacesLeft());
	}
	
}


