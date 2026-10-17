package comparingAlgos;
import java.util.Collections;
import java.util.Random;
import java.util.Arrays;

public class generatorForArr {

	static int size;
	static String type;

	// Constructor to initialize both size and type
	public generatorForArr(int size, String type) {
		this.size = size;
		this.type = type;
	}

	// methods are statics to make it easier to reach them from other classes
	// without making objects.
	static int[] SortedArr(int size) {

		 int[] arr = RandArr(size);
	        Arrays.sort(arr);
	        return arr;
	}
	

	static int[] RandArr(int size) {
		int[] arr = new int[size];
		Random random = new Random();
		for (int i = 0; i < size; i++) {
			arr[i] = random.nextInt(5);
			// this method generate any number from 0 to the given number
		}
		return arr;
	}

	
	static int[] ReverseArr(int size) {
	 int[] arr = RandArr(size);
     for (int i = 0; i < size / 2; i++) {
         int temp = arr[i];
         arr[i] = arr[size - i - 1];
         arr[size - i - 1] = temp;
     }
     return arr;

}
}
