public class Bubble {
	public static void main(String args[]){
		
		int nums[] = { 99, -10, 100123, 18, -978, 5623, 463, -9, 287, 49};
		
		//display original array
		System.out.print("Original array is:");
		for(int i = 0; i < nums.length; i++)
			System.out.println(" " + nums[i]);
		System.out.println();
				
		int swaps = -1;
		
		//This is bubble sort
		while(swaps != 0) {
			
			swaps =  0;
			
			for(int j = 0; j < nums.length - 1; j++) {
			
				System.out.println("at: " + j + " Is " + nums[j] + " > " + nums[j+1]  + 
						" at: " + (j+1) + " " + (nums[j]>nums[j+1]));
				
				if(nums[j] > nums[j+1]) { // compare adjacent pairs
					swaps += 1;
					int temp = nums[j+1];
					nums[j+1] = nums[j];
					nums[j] = temp;
				}
				
			}
		}
		
		//display sorted array
		System.out.println("Sorted array is:");
		for(int i = 0; i < nums.length; i++)
			System.out.println(" " + nums[i]);
		System.out.println();
	}
}
