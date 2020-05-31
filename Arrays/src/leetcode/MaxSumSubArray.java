package leetcode;

/*
 Given an integer array nums, find the contiguous subarray (containing at least one number) 
 which has the largest sum and return its sum.
Example:
Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.

Follow up:
If you have figured out the O(n) solution, 
try coding another solution using the divide and conquer approach, which is more subtle.
 */
public class MaxSumSubArray {
	// simple solution
	// for every number in the left, start excluding every number from the right and keep calculating sum
	// if the ssum > max, update max
	public int maxSubArray(int[] nums) {
		int maxSoFar = Integer.MIN_VALUE;
		int  maxHere= 0;
		
		for(int i: nums) {
			maxHere += i;
			if(maxSoFar < maxHere) {
				maxSoFar = maxHere;
			}
			if(maxHere < 0) {
				maxHere = 0;
			}
		}
		
		return maxSoFar;
	}

	public static void main(String[] args) {
		int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		
		System.out.println(new MaxSumSubArray().maxSubArray(arr)); // 6
	}
}
