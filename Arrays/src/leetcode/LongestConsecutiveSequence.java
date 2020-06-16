package leetcode;

import java.util.HashSet;
import java.util.Set;

// working solution
public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] nums) {
        if(nums == null) return 0;
        if(nums.length == 0) return 0;
        
        Set<Integer> s = new HashSet<>();
        
        for(int i: nums){
            s.add(i);
        }
        
        int longest = 1;
        for(int i : nums){
            // if i is middle number of a sequence
            if(s.contains(i-1)) continue;
            
            int locallong = 1;
            int j = i+1;
            while(s.contains(j)){
                locallong += 1;
                j += 1;
            }
            
            if(locallong > longest) longest = locallong;
            
        }
        return longest;
    }
}
