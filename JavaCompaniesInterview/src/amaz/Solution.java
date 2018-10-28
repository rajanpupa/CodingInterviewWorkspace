package amaz;

import java.util.Arrays;

// Sum of two numbers
// find how many pairs exists in a that sums up to target k
public class Solution {
	
	public static void main(String[] args) {
		int[] a = {6,6,3,9,3,5,1};
		long k = 12;
		
		int[] a1 = {1,3,46,1,3,9};
		long k1 = 47;
		
		System.out.println(numberOfPairs(a1, k1));
	}
	
	static int numberOfPairs(int[] a, long k){
		int count = 0;
		
		Arrays.sort(a);
		
		int lo = 0;
		int hi = a.length-1;
		
		while(lo < hi){
			if(a[lo] + a[hi] == k){
				count++;
				while(lo<hi && a[lo] == a[lo+1]) lo++;
				while(lo<hi && a[hi] == a[hi-1]) hi--;
				lo++;
			}else if(a[lo] + a[hi] < k){
				lo++;
			}else{
				hi--;
			}
		}
		
		return count;
	}

}
