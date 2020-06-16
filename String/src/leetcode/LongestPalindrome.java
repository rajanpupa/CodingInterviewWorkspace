package leetcode;

import java.util.HashMap;
import java.util.Map;

/*
 * 409. Longest Palindrome
 * Given a string which consists of lowercase or uppercase letters, 
 * find the length of the longest palindromes that can be built with those letters.
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 */
// working solution
public class LongestPalindrome {
	public int longestPalindrome(String s) {
		if(s == null) return 0;
		if(s.length() <2) return s.length();
		
        Map<Character, Integer> m = new HashMap<>();
        
		// count characters
        for(char c : s.toCharArray()){
            Integer count = m.get(c);
            if(count == null) {
            	m.put(c, 1);
            }else {
            	m.put(c, count+1);
            }
        }
        
        int len = 0;
        int oddcount = 0;
        
        for(Integer val : m.values()) {
        	if(val %2 ==0) {
			    // add all the even counts
        		len += val;
        	}else {
                if(val > 1){
				    // add all the odd count more than 1
                    len += val-1;
                }
				// count number of odd characters
                oddcount += 1;
        	}
        }
        
        if(oddcount > 0){
		    // add one if there are any odd counts in the string
            len += 1;
        }
		return len ;
    }
}
