package leetcode;

// 115. Distinct Subsequences
/*
 Given a string S and a string T, count the number of distinct subsequences of S which equals T.
A subsequence of a string is a new string which is formed from the original string by deleting some 
(can be none) of the characters without disturbing the relative positions of the remaining characters.
(ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
It's guaranteed the answer fits on a 32-bit signed integer.

Input: S = "rabbbit", T = "rabbit"
Output: 3
 */
public class DistinctSubsequence {
	
	public int numDistinct(String s, String t) {
        if(s == null || t == null) return 0;
        if(t.length() > s.length()) return 0;
        
        int [][] mat = new int[s.length()+1][t.length()+1];
        
        for(int i=0; i<=s.length(); i++){
            for(int j = 0; j<=t.length(); j++){
                
                if(j==0 ){
                    mat[i][j] = 1;
                }else if(i==0){
                    mat[i][j] = 0;
                }else{
                    if(s.charAt(i-1) == t.charAt(j-1)){
                        mat[i][j] = mat[i-1][j-1] + mat[i-1][j];
                    }else{
                        mat[i][j] = mat[i-1][j];
                    }
                }
            }
        }
        
        return mat[s.length()][t.length()];
    }
	
	public static void main(String[] args) {
		System.out.println(
				new DistinctSubsequence().numDistinct("rabbbit", "rabbit")
		);
	}
}
