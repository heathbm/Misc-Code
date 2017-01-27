public class ShellSort {

	public static void main(String[] args) {
		
		int[] list = {54,9,14,2,7,10,22,65,11,78,44,26,9,0,6,4,36,99,43,2};
		
		System.out.println("ORIGINAL ARRAY:\n");
		
		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] + ",");
		}

		System.out.println("\n");
		long start = System.nanoTime();    
		
		int gap = (int) list.length / 2;

		while (gap != -1) {

			System.out.println("gap: " + gap);

			for (int i = 1; i < list.length; i++) {
				int j = i;
				while ((j != 0 && (j + gap) < list.length) && list[j + gap] < list[j - 1]) {

					int temp = list[j - 1];
					list[j - 1] = list[j + gap];
					list[j + gap] = temp;

					j--;
				}
			}
		
			if(gap == 0) {
				break;
			}
			gap = (int)(gap/2);
		
		}
		
		long elapsedTime = System.nanoTime() - start;
		
		System.out.println("\n\nSORTED:\n");
		
		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] + ",");
		}
		
		System.out.println("\n\nTime taken in nanoseconds: " + elapsedTime);
		
	}
	
}