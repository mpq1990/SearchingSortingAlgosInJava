
public class App {
	
	public static void main(String[] args) {
		int[] array = {1, 3,5,6 ,7 ,67,777};
		int[] unsortedArray = {33, 2, 431, 23423, 3242,12,1,43};
		int[] unsortedArrayTwo = {33, 2, 431, 23423, 3242,12,1,43};
		int index = binarySearch(7775, array);
		System.out.println(index);
		
//		reduceByOne(10);
		
		index = recursiveLinearSearch(array, 0, 67);
		System.out.println(index);
		
		index = recursiveBinarySearch(array, 0, array.length - 1, 44);
		System.out.println(index);
		
		int[] sorted = selectionsort(unsortedArray);
		printArray(sorted);
		int[] sortedArrayTwo = insertionSort(unsortedArrayTwo);
		printArray(sortedArrayTwo);
	}
	
	private static int binarySearch(int key, int[] array) {
		int p = 0;
		int r = array.length - 1;
		int q = 0;
		while(p <= r){
			q = (int) Math.floor((p + r) / 2);
			if(key == array[q]){
				return q;
			} else if(array[q] > key){
				r = q - 1;
			} else {
				p = q + 1;
			}
		}
		return -1;
	}
	
	public static void reduceByOne(int n){
		if( n != 0) {
			reduceByOne(n - 1);
		}
		System.out.println(n);
	}
	
	public static int recursiveLinearSearch(int[] a ,  int i, int x) {
		if (i > a.length - 1){
			return -1;
		} else if (a[i] == x){
			return i;
		} else {
			return recursiveLinearSearch(a, i+1, x);
		}
	}
	
	public static int recursiveBinarySearch(int[] arr, int p, int r, int x){
		if(p > r) {
			return -1;
		} else {
			int q = (int) Math.floor((p+r)/2);
			if(arr[q] == x){
				return q;
			} else if(arr[q] > x){
				return recursiveBinarySearch(arr, p, q - 1, x);
			} else {
				return recursiveBinarySearch(arr, q + 1, r, x);
			}
		}
	}
	
	public static int [] selectionsort(int [] unsortedArray){
		int [] sortedArray = unsortedArray;
		
		for (int i = 0; i < unsortedArray.length; i++) {
			int min = i;
			
			for(int j = i + 1; j < unsortedArray.length; j++) {
				if(unsortedArray[j] < unsortedArray[min]){
					min = j;
				}
			}
			int temp = unsortedArray[i];
			unsortedArray[i] = unsortedArray[min];
			unsortedArray[min] = temp;
		}
		
		return sortedArray;
	}
	
	public static int [] insertionSort(int [] unsortedArray){
		int [] sortedArray = unsortedArray;
		
		for(int i = 1; i < unsortedArray.length; i++) {
			int j = i;
			while(j > 0 && unsortedArray[j - 1] > unsortedArray[j]){
				int temp = unsortedArray[j];
				unsortedArray[j] = unsortedArray[j - 1];
				unsortedArray[j - 1] = temp;
				j--;
			}
		}
		
		return sortedArray;
	}
	
	public static void printArray(int[] array){
		for(int i = 0 ; i < array.length; i++){
			System.out.print(array[i] + ",");
		}
		System.out.println();
	}
}
