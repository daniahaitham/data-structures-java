package comparingAlgos;


public class mergeSort {

	static void mergeSort(int[] dates) {

		// this part is just for diving reaching having one elemnt per aaray
		/// then the recuirsion will start comparing and mering

		if (dates.length < 2) {
			return;
			// we will reach it inn the final step of dividing
		
		}

		int mid = dates.length / 2;

		int[] leftTemp = new int [mid];
		int[] rightTemp = new int[dates.length - mid];

		// i want the temp arrays becouse now i will start merging , i will lose data if
		// i merged directly ,
		for (int i = 0; i < mid; i++) {
			leftTemp[i] = dates[i];
			// this line will copy the reference of the obj so both will refare to the same obj 
		}
		
	

		for (int j = mid; j < dates.length; j++) {// j here is just aniterator for the mid
			rightTemp[j - mid] = dates[j];
			// how i will reach the indixes of the temp using the mids ?
			// example : mid =5 ; the temp [0] will be ( mid - mid ) = ( j-mid ) ( j = 0 )
			// in sec iterat : mid =5 ; j = 5+1 ; arr[ 1] = 6-1 so i can reach 1
		}
		
		
		
		//THIS WHOULD GIVE THE SAME RESULT 
//		for ( int i =0 ; i<dates.length-mid;i++) {
//			rightTemp[i] = dates[i+mid];
//		}

		mergeSort(leftTemp);// this is the first half
		mergeSort(rightTemp);// second half

		// merging
		mergingProcess(dates, leftTemp, rightTemp);
	}

	public static void mergingProcess(int[] dates, int[] leftTemp, int[] rightTemp) {
		int i = 0, j = 0, k = 0; // iterators for leftTemp, rightTemp, and arr respectively
		// k is an iterator om my origenal array

		while (i < leftTemp.length && j < rightTemp.length) {// to ensure that we reach all elemnts

			// one of them will be true and the other will be false
			if (leftTemp[i] <= rightTemp[j]) {
				dates[k] = leftTemp[i];
				i++;
				k++;
			} else {
				dates[k] = rightTemp[j];
				j++;
				k++;
			}

			// i can put the k++ here becouse it will always do +1
		}
		// now when one of the above is true thier will remain an elemnt not compied to
		// its correct place , SO :
		// Copy remaining elements from the leftTemp array
		// also one of them will be excuted

		while (i < leftTemp.length) {
			// if i is i ++ in the pervios loops this will not be intered ?
			dates[k] = leftTemp[i];
			i++;
			k++;
		}

		while (j < rightTemp.length) {
			// if j is j ++ in the pervios loops this will not be intered ?

			dates[k] = rightTemp[j];
			j++;
			k++;
		}
	}

}
