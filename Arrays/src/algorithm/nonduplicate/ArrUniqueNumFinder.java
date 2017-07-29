package algorithm.nonduplicate;

/**
 * In a sorted array, all the elements have duplicated except one.
 * Find the unique element in O(log n) complexity and O(1) space complexity
 */

public class ArrUniqueNumFinder {
	
	public static void main(String[] args) {
		int[] arr = {1,1,2,2,3,3,4,5,5,6,6};
		ArrUniqueNumFinder unf = new ArrUniqueNumFinder();
		
		System.out.println("Single element = " + unf.findUnique(arr));
	}

	public int findUnique(int[] nums){
		if(nums.length%2 == 0) return -9999;// can't be even
		
		int lo = 0;
		int hi = nums.length/2;
		
		while(lo<hi){
			int m = (lo + hi)/2;
			
			if(nums[2*m] == nums[2*m +1]){
				System.out.printf("if %d == %d\n", nums[2*m] , nums[2*m +1]);
				lo = m+1;
			}else if(nums[2*m] == nums[2*m-1]){
				System.out.printf("else %d == %d\n", nums[2*m] , nums[2*m -1]);
				// unique number is in the first half
				hi = m;
			}else{
				System.out.printf("else returning == %d\n", nums[2*m] );
				return nums[2*m];
			}
		}
		return nums[hi];
	}
}
