package leetcode;

/*
You are a professional robber planning to rob houses along a street. 
Each house has a certain amount of money stashed. All houses at this place are arranged in a circle.
That means the first house is the neighbor of the last one. 
Meanwhile, adjacent houses have security system connected and 
it will automatically contact the police if two adjacent houses were broken into on the same night.
Given a list of non-negative integers representing the amount of money of each house, 
determine the maximum amount of money you can rob tonight without alerting the police.

Example 1:
Input: [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
             because they are adjacent houses.
Example 2:
Input: [1,2,3,1]
Output: 4

Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.
*/
// dynamic programming
public class MaxRob {
	
	/**
	 * This solution is correct but not efficient.
	 * This is a Dynamic programming problem and has to be solved that way.
	 * 
	 */
	public int rob(int[] nums) {
        if(nums == null) return 0;
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        
        int len = nums.length;
        
        int max = 0;
        for(int i=0; i<len; i++){
            int tmp = maxrob(nums, i+2, i==0 ? len-2 : len-1, nums[i]);
            if(tmp > max) max = tmp;
        }
        return max;
        
    }
    
	// exhaustive search in one direction
    private int maxrob(int[] nums, int start, int end, int sum){
        if(start > end) return sum;
        
        int max = sum;
        for(int i = start; i <= end; i++){
            int tmp = maxrob(nums, i+2, end, sum + nums[i]);
            if(tmp > max) max = tmp;
        }
        return max;
    }
    
    /**
     * This is using the dynamic programming technique<br/>
     * 
     */
    public int rob_dynamic_programming(int[] nums) {
        if(nums == null) return 0;
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        
        int len = nums.length;
        int max = 0;

        int[] dp1 = new int[len-1];
        int[] dp2 = new int[len-1];
        
        int[] reverse = nums.clone();
        
        // reverse
        for(int i=0; i<len; i++){
            reverse[i] = nums[len-i-1];
        }
        
        dp1[0] = nums[0];
        dp2[0] = reverse[0];
        
        // start dynamic programming
        dp1[1] = Math.max(nums[0], nums[1]);
        dp2[1] = Math.max(reverse[0], reverse[1]);
        
        for(int i=2; i<len-1; i++){
            dp1[i] = Math.max(nums[i]+dp1[i-2], dp1[i-1]);
            dp2[i] = Math.max(reverse[i]+dp2[i-2], dp2[i-1]);
        }
        
        return Math.max(dp1[len-2], dp2[len-2]);
        
    }
    
    public static void main(String[] args) {
		int [] input = {1,3,1,3,100};
		int [] input2 = {1,2,3,1};
		int [] input4 = {1,2,1,1};
		int [] input3 = {
				114,117,207,117,235,82,90,67,143,146,53,108,200,
				91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,
				235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,
				202,144,240
		};// 4077
		
		//int [] clone = input3.clone();
		System.out.println(new MaxRob().rob(input4));
	}
}
