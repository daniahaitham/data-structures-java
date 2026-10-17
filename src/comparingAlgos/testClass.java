package comparingAlgos;

public class testClass {

	public static void main(String[] args) {

		
// i created those arrays because i need to test each size with all types
		
		int[] sizes = { 10000, 100000 }; // add 1000000 for a bigger run (selection sort then takes minutes: it is O(n^2))
		
		String[] types = { "sorted", "random", "reversed" };

		
		
		for (int size : sizes) {
			for (String type : types) {
				System.out.println(" size: " + size + ", Type: " + type);
				int[] requiredArr = choosingArr(size, type);
				int[] forMerge = requiredArr.clone();      // each algorithm sorts its own copy
				int[] forSelection = requiredArr.clone();
			//	printArr(requiredArr);
				// merge sort
				long start = System.currentTimeMillis();
				mergeSort.mergeSort(forMerge);
			//	printArr(requiredArr);
				long end = System.currentTimeMillis();
				long mergeTime = (end - start);
				System.out.println("Merge Sort Time: " + mergeTime + " millseconds");

				// Sort using Enhanced Selection Sort
				long start2 = System.currentTimeMillis();
				selectionSort.selection(forSelection);
				long end2 = System.currentTimeMillis();
				long selectionTime = (end2 - start2);
				System.out.println("Enhanced Selection Sort Time: " + selectionTime + " millseconds");

				System.out.println();
			}
		}
	
	}
	
	
		
	public static void printArr(int[] array) {
		for (int x : array) {
			System.out.print(x + "| ");
		}
		System.out.println();
	}

	public static int[] choosingArr(int size, String type) {
		switch (type) {
		case "sorted":
			return generatorForArr.SortedArr(size);
		case "random":
			return generatorForArr.RandArr(size);
		case "reversed":
			return generatorForArr.ReverseArr(size);
		default:
			// Handle invalid types here
			return null;
		}
	}
	

}
