public class SelectionSort {
	
	public static void selectionSort(int[] list) {	
		
		for (int i = 0; i < list.length; i++) {
			
			int min = i;
			
			for (int j = i; j < list.length; j++) {
				
				if(list[min] > list[j]) {
					min = j;
				}
				
			}
			
			if(min != i) {
				int temp = list[min];
				list[min] = list[i];
				list[i] = temp;
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		
		int list[] = {54,9,14,2,7,10,22,65,11,78,44,26,9,0,6,4,36,99,43,2};
		
		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] + ",");
		}
		
		long start = System.nanoTime();
		
		selectionSort(list);
		
		long elapsedTime = System.nanoTime() - start;
		
		System.out.println("\n");
		
		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] + ",");
		}
		
		System.out.println("\n\nTime taken in nanoseconds: " + elapsedTime);
		
	}
	
}
