package mum.algorithms.arraymerge;

import java.util.Arrays;

public class MergeSortedArray {

	public static void main(String[] args) {
		MergeSortedArray msa = new MergeSortedArray();
		
		int [] arr1 = {1, 4, 5, 8, 17};
		int [] arr2 = {2, 4, 8, 11, 13, 21, 23, 25};
		
		int [] arr3 = msa.merge(arr1, arr2);
		
		Arrays.stream(arr3).forEach(x -> System.out.print(x + " "));
	}
	
	// two finger approach
	// point finger to the first elements of two arrays. 
	// whichever is smaller, put in third array, and increment the pointers
	public int[] merge(int [] arr1, int[] arr2){
		int [] ans = new int [arr1.length + arr2.length];
		
		int i=0; 
		
		int a1index = 0, a2index=0;
		
		while(i < ans.length){
			
			if( arr1[a1index] < arr2[a2index] ){
				ans[i++] = arr1[a1index++];
			}else{
				ans[i++] = arr2[a2index++];
			}
			
			if(a1index >= arr1.length || a2index >= arr2.length) break;
		}
		
		while(a1index < arr1.length) ans[i++] = arr1[a1index++];
		while(a2index < arr2.length) ans[i++] = arr2[a2index++];
		
		return ans;
	}
}
