package leetcode;

/*
 Given an array nums, write a function to move all 0's to the end of it while maintaining the relative 
 order of the non-zero elements.

Example:
Input: [0,1,0,3,12]
Output: [1,3,12,0,0]

You must do this in-place without making a copy of the array.
Minimize the total number of operations.
 */
public class MoveZeros {
	public void moveZeroes(int[] nums) {

		int zp = 0;
		int nzp = 0;

		while (zp < nums.length) {
			while (zp < nums.length && nums[zp] != 0) {
				zp++;
			}
			nzp = zp+1;
			while (nzp < nums.length && nums[nzp] == 0) {
				nzp++;
			}
			if (zp < nums.length && nzp < nums.length && zp < nzp) {
				// swap
				int tmp = nums[zp];
				nums[zp] = nums[nzp];
				nums[nzp] = tmp;
			}
			zp++;
			nzp++;
		}
	}
	
	public static void main(String[] args) {
		int[] arr1 = {0,1,0,3,12};
		int[] arr2 = {1,0, 1};
		
		new MoveZeros().moveZeroes(arr2);
		
		for(int i: arr2) {
			System.out.printf(" %d, " , i);
		}
		
	}
}
