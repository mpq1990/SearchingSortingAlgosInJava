
public class App {
	
	public static void main(String[] args) {
		int[] array = {1, 3,5,6 ,7 ,67,777};
		int index = binarySearch(7775, array);
		System.out.println(index);
	}
	
	private static int binarySearch(int key, int[] array){
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
}
