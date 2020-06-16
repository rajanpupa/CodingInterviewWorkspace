package leetcode;

import java.util.Arrays;

// return the third max int in an array.
// if not available return the max
// working solution::
public class ThirdMaxInt {
	public int thirdMax(int[] nums) {
        if(nums == null) return 0;
        int len = nums.length;
        
        Arrays.sort(nums);
        
        int max1 = nums[0];
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        
        int dcnt = 1;
        int last = nums[0];
        for(int j = 0; j<nums.length; j++){
            int i = nums[j];
            if(i == last) continue;
            if(i > max1 ){
                max3 = max2;
                max2 = max1;
                max1 = i;
            }else if(i > max2){
                max3 = max2;
                max2 = i;
            }else if(i > max3){
                max3 = i;
            }
            dcnt ++;
            last = i;
        }
        
        if(len > 2 && dcnt > 2){
            return max3;
        }else{
            return max1;
        }
    }
	
	public static void main(String[] args) {
		int[] arr1 = {1,2,-2147483648};
		
		System.out.println(new ThirdMaxInt().thirdMax(arr1));
	}
}
