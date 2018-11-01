package mum.algorithms.sorting;

/*
 * If the array is already sorted, complexity = O(N)
 */
public class BubbleSortAdvanced  extends ASort{
	
	public static void main(String[] args) {
		//int[] arr = {435,1,3,2,6,13,9, 1, 6, 2, 234, 22,  221, 200,0};
		int[] arr = {1,2,3,4,5,6,7};
		sort(arr);
		printArray(arr);
	}
	
	public static void sort(int[] arr){
		int temp=0;
		boolean sorted = false;
		for(int i=0; i<arr.length-1 && !sorted; i++){
			System.out.printf("solving %d, num=%d \n", i, arr[i]);
			sorted = true;
			for(int j=i+1; j<arr.length; j++){
				if(arr[i] > arr[i+1]) {
					sorted = false;
				}
				if(arr[i] > arr[j]){
					System.out.printf(" swapping %d and %d\n", arr[i], arr[j]);
					temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
					
				}
			}
			// by the first j iteration, the smallest number has reached its position
			printArray(arr);
		}
	}
	
	
}
