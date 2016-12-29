//demonstrate a simple ageenric method
public class GenericMethodDemo {
	
	// determine if the contents of two arrays are the same 
	static <T extends Comparable<T>, V extends T> boolean
	arraysEqual(T[] x, V[] y) {
		// If array lengths differ, the arrays differ.
		if(x.length != y.length) return false;
		
		for(int i = 0; i < x.length; i++) 
			if(!x[i].equals(y[i])) return false; // arrays differ
			
			return true;
		
			
	}
	
	
	public static void main(String args[]) {
		
		Integer nums[] = { 1, 2, 3, 4, 5 };
		Integer nums2[] = { 1, 2, 3, 4, 5 };
		Integer nums3[] = { 1, 2, 8 , 4, 5 };
		Integer nums4[] = { 1, 2, 3, 4, 7 };

		if(arraysEqual(nums, nums))
			System.out.println("nums equal nums");
		
		if(arraysEqual(nums, nums2))
			System.out.println("nums equals nums2");
		
		if(arraysEqual(nums, nums3))
			System.out.println("nums equals nums3");
		
		if(arraysEqual(nums, nums4))
			System.out.println("nums equals nums4");
		
		// create an array of doubles
		Double dvals[] = { 1.1, 2.2, 3.3, 4.4, 5.5 };
		
		//this wont work because nums and dval are not of the same type
		
		//if(arraysEqual(nums, dvals))
			//System.out.println("nums equals dval");
	}
}
