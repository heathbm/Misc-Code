public class CountingSort {

	public static int[] countingSort(int[] list, int max) {
        
		int[] count = new int[max + 1]; // + 1 to cater for any 0's
        int[] sorted = new int[list.length];
        
        for (int i = 0; i < list.length; i++) {
			count[list[i]] += 1;
		}
        
        for (int i = 1; i < count.length; i++) { // Create a cumulative frequency distribution
			count[i] += count[i - 1];
		}
        
        for (int i = list.length - 1; i >= 0; i--) {
        	
			sorted[count[list[i]] - 1] = list[i];
			count[list[i]] -= 1;
		}
        
       
        return sorted;
    }
	
	public static int[] countingSort(int[] list) { // get max if not provided 
		
		int max = 0;
		
		for (int i = 0; i < list.length; i++) {
			if(list[i] > max) {
			max = list[i];
			}
		}
		
		return countingSort(list, max);
	}
	
	public static int[] countingSort2(int[] list, int max) {

		int[] count = new int[max + 1];
		int[] sorted = new int[list.length];

		for (int i = 0; i < list.length; i++) {
			count[list[i]] += 1;
		}
		
		int currentSortedIndex = 0;

		// for each number in numCounts
		for (int i = 0; i < count.length; i++) {
			int countNum = count[i];

			// for the number of times the item occurs
			for (int x = 0; x < countNum; x++) {

				sorted[currentSortedIndex] = i;
				currentSortedIndex++;
			}
		}

		return sorted;
	}
	
	public static int[] countingSort2(int[] list) { // get max if not provided 
		
		int max = 0;
		
		for (int i = 0; i < list.length; i++) {
			if(list[i] > max) {
			max = list[i];
			}
		}
		
		return countingSort2(list, max);
	}
	
	public static void main(String[] args) {
		
		int list[] = {54,9,14,2,7,10,22,65,11,78,44,26,9,0,6,4,36,99,43,2};
		
		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] + ",");
		}
		
		long start = System.nanoTime();
		
		int[] result = countingSort(list);
		
		long elapsedTime = System.nanoTime() - start;
		
		System.out.println("\n");
		
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + ",");
		}
		
		System.out.println("\n\nTime taken in nanoseconds: " + elapsedTime);
		
		System.out.println("\n---------------------------\n");
		
		int[] list2 = {54,9,14,2,7,10,22,65,11,78,44,26,9,0,6,4,36,99,43,2};
		
		for (int i = 0; i < list2.length; i++) {
			System.out.print(list2[i] + ",");
		}
		
		start = System.nanoTime();
		
		int[] result2 = countingSort2(list2);
		
		elapsedTime = System.nanoTime() - start;
		
		System.out.println("\n");
		
		for (int i = 0; i < result2.length; i++) {
			System.out.print(result2[i] + ",");
		}
		
		System.out.println("\n\nTime taken in nanoseconds: " + elapsedTime);
		
	}
	
}
