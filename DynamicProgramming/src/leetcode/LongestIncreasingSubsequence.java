package leetcode;
// 130: 
public class LongestIncreasingSubsequence {
	
	public int lengthOfLIS(int[] nums) {
        if(nums == null) return 0;
        
        int p1 = 0;
        int p2 = 0;
        
        int maxlen = 0;
        
        for(int i=0; i<nums.length; i++){
            int len = 0;
            for(int j=i+1; j<nums.length; j++){
                if(nums[i] < nums[j] && nums[j] > nums[j-1]){
                    len++;
                }else{
                    if(maxlen < len) maxlen = len;
                    break;
                }
                
            }
        }
        return maxlen;
    }
	
	public static void main(String[] args) {
		System.out.println("hello");
	}
}
