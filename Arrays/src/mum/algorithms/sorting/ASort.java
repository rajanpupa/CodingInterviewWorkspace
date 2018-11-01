package mum.algorithms.sorting;

abstract public class ASort {

	public static void printArray(int[] set) {
		System.out.print("[");
		if (set.length > 0) { 
			System.out.print(set[0]);	
		}
		for (int i = 1; i < set.length; i++) {
			System.out.print(", " + set[i]);
		}
		System.out.println("]");
	}
	
}
