package leetcode;

/**
 * The below class has better solution.
 * This solution is bad because it gets weird solutions.
 * @author Raj
 *
 */
public class ValidPalindrome {
	
	public boolean validPalindrome(String s) {
        int l = 0, r = s.length()-1;
        return getMinCount(s) <= 1;
    }
    private int getMinCount(String s){
    	System.out.println(s);
        if(s.length() <= 1) return 0;
        if(s.length() == 2) return s.charAt(0) == s.charAt(1) ? 0 : 1;
        
        int l = 0, r = s.length()-1;
        int count = 0;
        while(l < r){
            if(s.charAt(l) != s.charAt(r)){
                count += Math.min( getMinCount(s.substring(l+1, r+1)), getMinCount(s.substring(l, r) ));
            }
            l++;
            r--;
        }
        return count;
    }
    
    public static void main(String[] args) {
    	String s = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga";
    	String s2 = "abcdefabcbafedcba";
		//System.out.println(new ValidPalindrome().validPalindrome(s));
		System.out.println(new Solution().validPalindrome(s));
	}
}

/**
 * This is efficient solution.
 * Instead of trying to optimize the loop, and fit all the conditions 
 * Run the loop twice, one time incrementing left to right on inequality, and on from right to left on inequality.
 * 
 * @author Raj
 *
 */
class Solution{
	public boolean validPalindrome(String s) {
        return isValid(s) || isValid(new StringBuilder(s).reverse().toString());
    }                           
            
    private boolean isValid(String s){
        int l = 0, r = s.length()-1;
        int count = 0;
        while(l <= r){
            if(s.charAt(l) != s.charAt(r)){
                l++;
                count ++;
                continue;
            }
            l++;
            r--;
        }
        return count <= 1;
    }
}
