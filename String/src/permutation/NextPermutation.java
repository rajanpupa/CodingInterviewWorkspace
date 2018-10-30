package permutation;

import java.util.Arrays;

/**
 * Find the next lexographical permutation of numbers for the int array 
 *
 * [1,3, 2] -> [2, 1, 3]
 * [2,3,1]  -> [3,1,2]
 * [4,2,0,2,3,2,0] -> [4,2,0,3,0,2,2]
 */

public class NextPermutation {
	public static void main(String[] args) {
		//int[] nums = {4,2,0,2,3,2,0};
		int[] nums = {1,3,2};
		nextPermutation(nums);
		
		for(int i : nums) {
			System.out.printf("%d, ", i);
		}
	}
	
	public static void nextPermutation(int[] nums) {
        if(nums.length < 2) return ;
        
        int candidate = nums.length -1;
        // go from left to right, find the first index where the value decreases
        for(int i=nums.length-1; i>0; i--) {
        	if(nums[i-1] < nums[i]) {
        		candidate = i-1;
        		break;
        	}
        }
        
        // go from left to right towards the candidate, find the first number greater than num in candidate
        // exchange
        for(int i= nums.length -1; i>candidate; i--) {
        	if(nums[i] > nums[candidate]) {
        		int tmp = nums[i];
        		nums[i] = nums[candidate];
        		nums[candidate] = tmp;
        		break;
        	}
        }
        
        // reserve the numbers from [candidate+1, n], they already are in descending order, make it ascending
        int l = candidate+1, r = nums.length-1;
        
        while(l<r) {
        	int tmp = nums[l];
        	nums[l++] = nums[r];
        	nums[r--] = tmp;
        }
    }
}
/*
 Approach:
 
 Go from right to left, find a index (candidate) where the value is decreasing.
 
 Again, go from right to candidate, find the first value greater than the num at candidate.
 
 Exchange the values
 
 Not reverse the array [candidate +1, n-1], as they are already in descending order.
 
*/