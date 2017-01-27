import java.time.Duration;
import java.time.Instant;

class Quicksort{
	
	public static void insertionSort(int array[]) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i-1;
            while ( (j > -1) && ( array [j] > key ) ) {
                array [j+1] = array [j];
                j--;
            }
            array[j+1] = key;
        }
    }
	
	public static void insertionSort(char array[]) {
        for (int i = 1; i < array.length; i++) {
            char key = array[i];
            int j = i-1;
            while ( (j > -1) && ( array [j] > key ) ) {
                array [j+1] = array [j];
                j--;
            }
            array[j+1] = key;
        }
	}
}

public class QSDemo {
	public static void main(String[] args) {
		
		int a[] = { 76,4,43,131,566,585,321,13,31,34,5,645,654};
		char b[] = { 'f', 'j', 'a', 'r', 'h', 'j', 'w', 'n', 'e', 't', 'z', 'b', 'o'};
		
		System.out.println("Original array: ");
		for(int 	i = 0; i < a.length; i++)
			System.out.print(a[i] + ",");
		
		System.out.println("\n");
		
		Instant startTime = Instant.now();

		Quicksort.insertionSort(a);
		
		Instant endTime = Instant.now();
		
		System.out.println("Sorted array: ");
		for(int i = 0; i < a.length; i++)
			System.out.println(a[i]);
		
		System.out.println("");
		System.out.println("Original array: ");
		for(int 	i = 0; i < b.length; i++)
			System.out.print(b[i] + ",");
		
		System.out.println("Time taken: " + Duration.between(endTime, startTime) + "\n");
				
		startTime = Instant.now();
		
		Quicksort.insertionSort(b);
		
		endTime = Instant.now();
		
		System.out.println("Sorted array: ");
		for(int i = 0; i < b.length; i++)
			System.out.println(b[i]);
		
		System.out.println("Time taken: " + Duration.between(endTime, startTime));
		
		}
}

