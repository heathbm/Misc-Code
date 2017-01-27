public class QuickSort {
	
	public static void quickSort(int[] array) {
		quickSort(array, 0, array.length - 1);
	}
	
	public static void quickSort(int[] array, int low, int high) {
		
		int mid = (low + high) / 2;
		int pivot = array[mid]; 
		int left = low;
		int right = high;
		
		while (left < right) {
			
			while (array[left] < pivot) {
				left++;
			}
			
			while (array[right] > pivot) {
				right--;
			}
			
			if (left <= right) {
				int temp = array[left];
				array[left] = array[right];
				array[right] = temp;
				left++;
				right--;
			}
		}
		
		if (low < right) {
			quickSort(array, low, right);
		}
		
		if (left < high) {
			quickSort(array, left, high);
		}
	}
	
	public static void main(String[] args) {
		
		int[] list = {345,5,68,8,4532,23,1,43,4,8,78,5,3,2,3,4,56,78,6};
		
		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] + ",");
		}
		
		quickSort(list);
		
		System.out.println("\n");
		
		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] + ",");
		}
		
	}
}
