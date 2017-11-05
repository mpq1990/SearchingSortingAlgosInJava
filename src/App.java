
public class App {
	
	public static void main(String[] args) {
		int[] array = {1, 3,5,6 ,7 ,67,777};
		int[] unsortedArray = {33, 2, 431, 23423, 3242,12,1,43};
		int[] unsortedArrayTwo = {33, 2, 431, 23423, 3242,12,1,43};
		int[] unsortedArrayThree = {33, 2, 431, 23423, 3242,12,1,43,5,5,5,5,5,5,5,65};
		int[] unsortedArrayFour = {33, 2, 431, 23423, 3242,12,1,43,5,5,5,5,5,5,5,65,55,44,33,2343};
		
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
		
		mergeSort(unsortedArrayThree, 0, unsortedArrayThree.length - 1);
		printArray(unsortedArrayThree);
		
		quickSort(unsortedArrayFour, 0, unsortedArrayFour.length - 1);
		printArray(unsortedArrayFour);
		
	}
	
	/**
	 * Binary Search
	 * @param key
	 * @param array
	 * @return
	 */

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
	
	/**
	 * just some recursion .. fur Fun ;)
	 * @param n
	 */
	public static void reduceByOne(int n){
		if( n != 0) {
			reduceByOne(n - 1);
		}
		System.out.println(n);
	}
	
	/**
	 * recursive linear search
	 * @param a
	 * @param i
	 * @param x
	 * @return
	 */
	
	public static int recursiveLinearSearch(int[] a ,  int i, int x) {
		if (i > a.length - 1){
			return -1;
		} else if (a[i] == x){
			return i;
		} else {
			return recursiveLinearSearch(a, i+1, x);
		}
	}
	
	/**
	 * Recuirsive Binary serach
	 * @param arr
	 * @param p
	 * @param r
	 * @param x
	 * @return
	 */
	
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
	
	/**
	 * 
	 * Selection sort
	 * @param unsortedArray
	 * @return
	 */
	
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
	
	/**
	 * insertion sort
	 * @param unsortedArray
	 * @return
	 */
	
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
	
	/**
	 * start merge sort
	 * @param inputArray
	 * @param start
	 * @param end
	 */
	
	public static void mergeSort(int inputArray[], int start, int end){
		if(end <= start){
			return;
		}
		int mid = (start + end) / 2;
		mergeSort(inputArray, start, mid);
		mergeSort(inputArray, mid + 1, end);
		merge(inputArray, start, mid, end);
	}
	
	public static void merge(int inputArray[], int start, int mid, int end){
		int tempArray[] = new int[end - start + 1];
		
		int leftSlot = start;
		int rightSlot = mid + 1;
		
		int  k = 0;
		
		while (leftSlot <= mid && rightSlot <= end){
			if(inputArray[leftSlot] < inputArray[rightSlot]){
				tempArray[k] = inputArray[leftSlot];
				leftSlot++;
			} else{
				tempArray[k] = inputArray[rightSlot];
				rightSlot++;
			}
			k++;
		}
		
		// above loop completed and right and left side have been sorted
		if(leftSlot <= mid){ // consider the right side done being sorted... left must be stored..
			while(leftSlot <= mid){
				tempArray[k] = inputArray[leftSlot];
				leftSlot++;
				k++;
			}
		} else if(rightSlot <= end) { // left side has been sorted and right must be stored
			while(rightSlot <= end){
				tempArray[k] = inputArray[rightSlot];
				rightSlot++;
				k++;
			}
		}
		
		//copy over the temp array into the appropraite slot
		for(int i =0; i < tempArray.length; i++ ){
			inputArray[start + i] = tempArray[i];
		}
		
	}
	
	/**
	 * 
	 * @param array
	 * @param start
	 * @param end
	 */

	public static void quickSort(int[] array, int start, int end){
		if(start < end){
			int q = partition(array, start, end);
			quickSort(array, start, q - 1);
			quickSort(array, q + 1, end);
		}	
	}
	
	public static int partition(int[] array, int start, int end){
		int pivot = array[end];
		int i = start - 1;
		
		for(int j = start; j <= end - 1; j++){
			if(array[j] <= pivot){
				i = i + 1;
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
		
		int temp = array[i + 1];
		array[i + 1] = pivot;
		array[end] = temp;
		return  i + 1;
	}
	
	
	/**
	 * print the array
	 * @param array
	 */
	public static void printArray(int[] array){
		for(int i = 0 ; i < array.length; i++){
			System.out.print(array[i] + ",");
		}
		System.out.println();
	}
}
