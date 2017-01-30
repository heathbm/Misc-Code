public class ShellSort {
	
	public static void shellSort(int[] list) {
		
		int temp, i, j, k;
		int gap = (int) list.length / 2;

		while (gap != 0) { // iterate with all gaps sizes until gap reaches 0

			for (i = 0; i < list.length; i += gap) { // iterate with current gap size
	
				j = i;
				while((j - gap) >= 0 && list[j - gap] > list[j]) {
					
					temp = list[j];
					list[j] = list[j - gap];
					list[j - gap] = temp;

					j -= gap;
					
				}

			}
		
			gap = (int)(gap/2);
		
		}
	}

	public static void main(String[] args) {
		
		int[] list = {54,9,14,2,7,10,22,65,11,78,44,26,9,0,6,4,36,99,43,2};
		
		System.out.println("ORIGINAL ARRAY:\n");
		
		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] + ",");
		}
		
		long start = System.nanoTime();  
		
		shellSort(list);
		
		long elapsedTime = System.nanoTime() - start;
		
		System.out.println("\n\nTime taken in nanoseconds: " + elapsedTime);
		
		System.out.println("\nSORTED:\n");
		
		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] + ",");
		}
		
	}
	
}