import java.util.Arrays;

public class PrimeHashTable {
	
	int[] table;
	int itemsInTable = 0;
	int tableSize;
	
	PrimeHashTable(int size) {
		
		tableSize = getNextPrime(size);
		table = new int[size];
		Arrays.fill(table, -1);
		
	}
	
	
	public void insert(int element) { // double hashed
		
		itemsInTable++;
		int index = element % (tableSize);
		int step = 7 - element % 7;
		
		while (table[index] != -1) {
			index += step;
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
		int step = 7 - element % 7;
		
		for (int i = 0; i < tableSize; i++) {
			
			if(table[index] == element) {
				return true;
			} else if(table[index] == -1) {
				System.out.println("RETURNED FASLE: " + i);
				return false;
			}
			
			index += step;
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
	
	public boolean isPrime(int value) {
		
		if(value % 2 == 0) {
			return false;
		}
		
		for(int i = 3; i * i <= value; i += 2) {
			if(value % i == 0) {
				return false;
			}
		}
		
		return true;
	}
	
	public int getNextPrime(int value) {
		
		for(int i = value; true; i++) {
			
			if(isPrime(i)) {
				return i;
			}
		}
		
	}
	
	public void increaseTableSize(int minSize) {
		
		int newSize = getNextPrime(minSize);
		moveOldTable(newSize);
		
	}
	
	public void moveOldTable(int newSize) {
		
		int[] tempTable = removeEmptySpace(table);
		table = new int[newSize];
		tableSize = newSize;
		Arrays.fill(table, -1);
		insertArray(tempTable);
		
	}
	
	public int[] removeEmptySpace(int[] table) {
		
		int[] elementsList = new int[itemsInTable];
		itemsInTable = 0;
		int index = 0;
		
		for(int element: table) {
			if(element != -1) {
				elementsList[index] = element;
				index++;
			}
		}
		
		return elementsList;
	}
	
	public static void main(String[] args) {
		
		PrimeHashTable table = new PrimeHashTable(31);
		
		int[] elements = new int[30]; // if parameter is not prime, find for closest larger prime
		System.out.println("items in array " + table.itemsInTable);
		System.out.println("remaining: " + table.spacesLeft() + "\n");
		
		for (int i = 60; i < 90; i++) {
			//table.insert(i * i); // use this for insert function
			elements[i-60] = i * i; // use this for insertArray function 
		}

		table.insertArray(elements);
		table.display();
		
		System.out.println("\n");
		System.out.println("Is 7569 present: " + table.isElementPresent(7569));
		
		table.increaseTableSize(60);
		
		System.out.println("\nTable has been increased\n");
		
		table.display();
		
		System.out.println("\n\nitems in array " + table.itemsInTable);
		System.out.println("remaining: " + table.spacesLeft());
		
		System.out.println("\n");
		System.out.println("Is 7569 present: " + table.isElementPresent(7569));
	}
	
}


