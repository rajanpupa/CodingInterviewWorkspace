package leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

// 55. Jump game
// working
public class JumpGame {
	
	public static boolean canJump(int[] nums) {
        if(nums == null || nums.length < 2) return true;
        if(nums[0] == 0) return false;
        
        int n = nums.length-1;
        
        Map<Integer, Integer> cango = new LinkedHashMap<>(); // index -> element
        cango.put(0, nums[0]);
        
        while(cango.size() > 0){
            Map.Entry<Integer, Integer> e = cango.entrySet().iterator().next();
            
            Integer index = e.getKey();
            Integer element = e.getValue();
            
            cango.remove(index);
            
            int sum = index + element;
            if(sum >= n) return true;
            
            int maxsum = sum;
            int nextindex = index;
            
            for(int i=index + 1; i<= index + element; i++){
                int tsum = i + nums[i];
                if(tsum > maxsum) {
                	maxsum = tsum;
                	nextindex = i;
                }
                //if(tsum >= n) return true;
            }
            
            if(nextindex > index) {
            	cango.put(nextindex, nums[nextindex]);
            }else {
            	return false;
            }
            
        }
        
        return false;
        
    }

	public static void main(String[] args) {
		int[] nums1 = {2,3,1,1,4}; // true
		int[] nums2 = {3,2,1,0,4}; // false
		int[] nums3 = {1,1,1,0}; // true
		int[] nums4 = {1,2,3}; // true
		int[] nums5 = {3,0,8,2,0,0,1}; // true
		
		
		System.out.println(canJump(nums5));
	}
}
