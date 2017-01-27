//a block lambda that finds the smallest positive factors of an int

interface NumericFunc {
	int func(int n);
}

public class BlockLambdaDemo {
	public static void main(String[] args) {
		
		// this block lambda returns the smallest positive factor of a value 
		NumericFunc smallestF = (n) -> {
		
		int result = 1;
		
		// get an absolute value of n
		System.out.println(n);
		n = n < 0 ? -n : n;  // this is pointless here
		System.out.println(n);
		
		for(int i = 2; i < n/i; i++) 
			if((n % i) == 0) {
			   result  = i;
			   break;
			}
		
		return result;
		};
		
		System.out.println("Smallest factor of 12 is " + smallestF.func(12));
		System.out.println("Smallest factor of 11 is " + smallestF.func(11));
	}
}
