// a generic interface example

//a generic containment interface. This interface implies that an implementing class contains one or more values 
interface Containment<T> {
	//the contains() method tests if a specific item is contained within an object that implies containment
	
	boolean contains(T o) ;
}

//implement Containment using an array to hold the values 
class MyClass<T> implements Containment<T> { // a generic class is needed to implement a generic interface unless the interface states its type
	T[] arrayRef;
	
	MyClass(T[] o) {
		arrayRef = o;
	}
	
	// implement contains()
	public boolean contains(T o) {
		for(T x : arrayRef)
			if(x.equals(o)) return true;
		return false;
	}
}


public class GenIFDemo {
	public static void main(String[] args) {
		
		Integer x[] = { 1, 2, 3 };
		
		MyClass<Integer> ob = new MyClass<Integer>(x);
		
		if(ob.contains(2))
			System.out.println("2 is in ob");
		else 
			System.out.println("2 is NOT in ob");
		
		if(ob.contains(5))
			System.out.println("5 is in ob");
		else
			System.out.println("5 is NOT in ob");
		
		// the following is illegal because ob is an integer Containment and 9.25 is a Double value
		//    if(ob.contains(9.25)) // illegal!
		//    System.out.println("9.25 is in ob");
	}
}
