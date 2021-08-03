package find;

/*
 * Given two sorted arrays, find the nth element if the arrays were combined together
 */

public class KthElementInSortedArrays {
	
	public static void main(String[] args) {
		KthElementInSortedArrays kth = new KthElementInSortedArrays();
		int[] arr1 = {1,5, 7, 8};
		int[] arr2 = {2, 3, 6, 10};
		System.out.println(kth.findKth(arr1, arr2, 3));// 6
	}

	public int findKth(int[] nums1, int[] nums2, int k) {
		return helper(nums1, nums2, 0, 0, k);
	}

	private int helper(int[] nums1, int[] nums2, int start1,  int start2, int k) {
		if(start1 >= nums1.length) return nums2[start2+k-1];
		if(start2 >= nums2.length) return nums1[start1+k-1];
		
		if(k==1)return Math.min(nums1[start1],nums2[start2]);
		
		int mid1 = 99999, mid2 = 99999;
		
		if(start1 + k/2 -1 < nums1.length) mid1 = start1 + k/2 - 1;
		if(start2 + k/2 -1 < nums2.length) mid2 = start2 + k/2 - 1;
		
		if(mid1 <= mid2 ) {
			return helper(nums1, nums2, start1+k/2, start2, k-k/2);
		}else {
			return helper(nums1, nums2, start1, start2+k/2, k-k/2);
		}
		
	}
}
