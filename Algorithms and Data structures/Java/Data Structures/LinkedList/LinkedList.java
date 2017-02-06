public class LinkedList {
	
	public static void main(String[] args) {
		
		 List linkedList = new List();
		 
		 linkedList.addAtStart(1);
		 linkedList.addAtStart(2);
		 linkedList.addAtStart(3);
		 linkedList.addAtStart(4);
		 linkedList.addAtStart(5);
		 
		 System.out.println("Added 5 values");
		 linkedList.display();
		 System.out.println("\n");
		 
		 linkedList.addAtEnd(10);
		 linkedList.addAtEnd(11);
		 linkedList.addAtEnd(12);
		 linkedList.addAtEnd(13);
		 linkedList.addAtEnd(14);
		 linkedList.addAtEnd(15);
		 
		 System.out.println("Added 5 more values");
		 linkedList.display();
		 System.out.println("\n");
		 
		 System.out.println("Deleted index 10");
		 linkedList.deleteIndex(10);
		 linkedList.display();
		 
		 System.out.println("\n");
		 System.out.println("Is index 9 present: " + linkedList.findIndex(9));
		 
		 System.out.println();
		 System.out.println("Is data value 14 present: " + linkedList.findData(14));
		 
		 System.out.println();
		 System.out.println("Deleted value 14: " + linkedList.deleteData(14) + "\n");
		 
		 System.out.println("Displaying the dataSet");
		 linkedList.display();
	}
	
}

class Node {
	public int data;
	public Node nextNode;
	
	Node(int newData) {
		nextNode = null;
		data = newData;
	}
}

class List {
	
	Node root;
	public int size = 0;
	
	List() {
		root = null;
	}
	
	public int getSize() {
		return size;
	}
	
	public void addAtStart(int newData) {
		Node tempNode = new Node(newData);
		
		if (root == null) {
			root = tempNode;
		} else {

			tempNode.nextNode = root;
			root = tempNode;
		}
		
		size++;
	}
	
	public void addAtEnd(int newData) {
		Node tempNode = new Node(newData);
		
		if (root == null) {
			root = tempNode;
		} else {

			Node parentNode = root;
			for (int i = 0; i < size - 1; i++) {
				parentNode = parentNode.nextNode;
			}

			parentNode.nextNode = tempNode;
		}
		
		size++;
	}
	
	public boolean deleteIndex(int index) {
		
		if(index > size) {
			return false;
		} else if (index == 0) {
			root = root.nextNode;
			size--;
			return true;
		}
		
		Node parentNode = null;
		Node currentNode = root;
		for (int i = 0; i < index; i++) {
			parentNode = currentNode;
			currentNode = parentNode.nextNode;
		}
		
		if(index == size) {
			parentNode.nextNode = null;
		} else {
			parentNode.nextNode = currentNode.nextNode;
		}
		
		size--;
		return true;
	}
	
		public boolean deleteData(int data) {
		
		Node parentNode = null;
		Node currentNode = root;
		int i;
		for (i = 0; i < size; i++) {
			if(currentNode.data == data) {
				break;
			}
			parentNode = currentNode;
			currentNode = parentNode.nextNode;
		}
		
		if(currentNode == root) {
			root = root.nextNode;
			size--;
			return true;
		}
		
		if(currentNode.data != data) {
			return false;
		}
		
		parentNode.nextNode = currentNode.nextNode;
		
		size--;
		return true;
	}
	
	public boolean findData(int data) {
		Node currentNode = root;
		for (int i = 0; i < size; i++) {
			if(data == currentNode.data) {
				return true;
			}
			currentNode = currentNode.nextNode;
		}
		return false;
	}
	
	public boolean findIndex(int index) {
		if(index <= size) {
			return true;
		}
		return false;
	}
	
	public void display() {
		Node currentNode = root;
		for (int i = 0; i < size; i++) {
			System.out.print(currentNode.data + ",");
			currentNode = currentNode.nextNode;
		}
	}
	
}

