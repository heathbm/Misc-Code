public class Core {
	
	// void method
	public static <T> void methodName (T i) {
	System.out.println(i);
}
	
	//return method                         |this T is the return type
	public static <T extends Comparable<T>> T max(T a, T b, T c) {
		T m = a;
		
		if(b.compareTo(m) > 0)
			m = b;
		
		if(c.compareTo(m) > 0)
			m = c;
		
		return m;
	}
	
	public static void main(String[] args) {
		
		int i = 10;
		double d = 2.2;
		String str = "Hello";
		
		// method that return void 
		
		System.out.println("Void method\n");
		
		methodName(i);
		methodName(d);
		methodName(str);
		
		
		// method that return generic data
		
		System.out.println("\nReturn method");
		
		System.out.println(max(10, 20, 30));
		
		System.out.println(max("aaa", "bbb", "ccc"));
		
	}
}
