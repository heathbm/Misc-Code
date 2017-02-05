import java.util.Arrays;
import java.util.Random;

public class MinHeap {
	public static void main(String[] args) {
		
		MinIntHeap minHeap = new MinIntHeap(20);
			
		Random random = new Random();
		for (int i = 0; i < 15; i++) {
			minHeap.add(random.nextInt(1000));
		}
		
		minHeap.display();
		System.out.println("");
		
		minHeap.heapSort();
		
		minHeap.display();
		
	}
}

class MinIntHeap {
	
	private int capacity, size = 0;
	
	int[] items;
	
	MinIntHeap(int newCapacity) {
		items = new int[newCapacity];
		capacity = newCapacity;
	}
	
	private int getLeftChildIndex(int parentIndex) {
		return 2 * parentIndex + 1;
	}
	
	private int getRightChildIndex(int parentIndex) {
		return 2 * parentIndex + 2;
	}
	
	private int getParnetIndex(int childIndex) {
		return (childIndex - 1) / 2;
	}
	
	private boolean hasLeftChild(int index) {
		return getLeftChildIndex(index) < size;
	}
	
	private boolean hasRightChild(int index) {
		return getRightChildIndex(index) < size;
	}
	
	private boolean hasParent(int index) {
		return getParnetIndex(index) >= 0;
	}
	
	private int leftChild(int index) {
		return items[getLeftChildIndex(index)];
	}
	
	private int rightChild(int index) {
		return items[getRightChildIndex(index)];
	}
	
	private int parent(int index) {
		return items[getParnetIndex(index)];
	}
	
	private void swap(int indexOne, int indexTwo) {
		int temp = items[indexOne];
		items[indexOne] = items[indexTwo];
		items[indexTwo] = temp;
	}
	
	private void ensureExtraCapcity() {
		if(size == capacity) {
			items = Arrays.copyOf(items, capacity * 2);
			capacity *= 2;
		}
	}
	
	public int peek() {
		if(size == 0) throw new IllegalStateException();
		return items[0];
	}
	
	public int poll() {
		if(size == 0) throw new IllegalStateException();
		int item = items[0];
		items[0] = items[size - 1];
		size--;
		heapifyDown();
		return item;
	}
	
	public int grab() {
		if(size == 0) throw new IllegalStateException();
		int item = items[0];
		items[0] = items[size - 1];
		heapifyDown();
		return item;
	}
	
	public void add(int item) {
		ensureExtraCapcity();
		items[size] = item;
		size++;
		heapifyUp();
	}
	
	private void heapifyUp() {
		int index = size - 1;
		while(hasParent(index) && parent(index) > items[index]) {
			swap(getParnetIndex(index), index);
			index = getParnetIndex(index);
		}
	}
	
	private void heapifyDown() {
		int index = 0;
		while(hasLeftChild(index)) {
			int smallerChildIndex = getLeftChildIndex(index);
			if(hasRightChild(index) && rightChild(index) < leftChild(index)) {
				smallerChildIndex = getRightChildIndex(index);
			}
			
			if(items[index] < items[smallerChildIndex]) {
				break;
			} else {
				swap(index, smallerChildIndex);
			}
			
			index = smallerChildIndex;
		}
	}
	
	 public void heapSort() {
		 int[] temp = new int[size];
		 int tempSize = size;
		 
		 for(int i = 0; size > 0; i++) {
			 temp[i] = poll();
		 }
		 
		 size = tempSize;
		 items = temp;
	 }

	public void display() {
		for (int i = 0; i < size; i++) {
			System.out.print(items[i] + ",");
		}
	}
}