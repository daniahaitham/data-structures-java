package comparingAlgos;
//

public class selectionSort {
	public static void selection(int[] dates) {
		for (int i = 0; i < dates.length - 1/2; i++) {//1- why /2: in each iteration i am placing the min and th emax so if i reached half of it the sec half is always sorted.
			int minIndex = i;
			
			///1- inisilizing the max as starting from the last elemnt of the array : arr.length-1 but whenever the i ( min ) is increasing ,the max shuold decrease with the smae value so -i
			int maxIndex =  dates.length- i - 1;
			
			//this loop is for hold an element and iterate over the rest ( all of them ) to check if they are less , if yes mark it as the min 
			for (int j = i + 1; j < dates.length-i; j++) {// -i : in each iteration of the outer i am done of an elemnt , so i dont have to reiterated on it ( the sorted part ) 
				if (dates[j] < dates[minIndex]) {
					minIndex = j;
					//note that if i found min i am not changing the i value but the min value that i assumed it is i but it will change
					
				} 
				
			}
			//this loop will do the same but from the other side.
			
			//strating from the last , back until the biggning of the unsorted part ( j > i )
			//  j strats from the last elemnt in the first out loop iterations but when the i increase j will avoid iterating on the sorted part to find the max in it  ( -i )
			// -1 : index 0  
		    for (int j = dates.length - i - 1; j >= i; j--) {
                if (dates[j] > dates[maxIndex]) {
                    maxIndex = j;
                }
            }

			if (i != minIndex) {
				int temp = dates[i];
				dates[i] = dates[minIndex];
				dates[minIndex] = temp;
				
				// RE UNDERSTAND THIS
				 if (maxIndex == i) {
					 // in each iteration i am aiming to put the min at the first of the unsorted andthe max at the end of it 
					 // if a case happened where the max on its right position 
					 // the swapping will moce it from its correct posotion 
					    // To handle this problem , maxIndex is updated to minIndex, which is the new position of the max.

	                  maxIndex = minIndex;
	              }
			}
			
			
			///-4
			 

			if (maxIndex != dates.length - 1-i ) { /// placing the max with its rth posistion.
				int temp = dates[dates.length - i - 1];
				dates[dates.length - i - 1] = dates[maxIndex];
				dates[maxIndex] = temp;
			}
		}
	}
}
