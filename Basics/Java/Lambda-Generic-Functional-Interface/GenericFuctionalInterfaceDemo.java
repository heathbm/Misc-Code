//use a generic fuctional interface

// a generic functional interface with two parameters that returns a boolean result
interface SomeTest <T> {
	boolean test(T n, T m);
}

public class GenericFuctionalInterfaceDemo {
	public static void main(String[] args) {
		
		//this lambda expression determines if one integer is a factor of another
		SomeTest<Integer> isFactor = (n, d) -> (n % d) == 0;
		
		if(isFactor.test(10,2))
			System.out.println("2 is a factor of 10");
		System.out.println();
		
		// the next lambda expression determines if one Double is a factor of another
		SomeTest<Double> isFactorD = (n, d) -> (n % d) == 0;
		
		if(isFactorD.test(212.0, 4.0))
			System.out.println("4.0 is a factor of 212.0");
		System.out.println();
		
		// this lambda determines if one string is part of another 
		SomeTest<String> isIn = (a, b) -> a.indexOf(b) != -1;
		
		String str = "Generic Functional Interface";
		
		System.out.println("Testing string: " + str);
		
		if(isIn.test(str, "face"))
			System.out.println("'face' is found.");
		else
			System.out.println("'face' is not found.");
	}
}
