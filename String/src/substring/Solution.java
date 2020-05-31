package substring;

public class Solution {
	public int numDistinct(String s, String t) {
		int dp[][] = new int[s.length() + 1][t.length() + 1];

		for (int i = 0; i <= s.length(); i++) {
			dp[i][0] = 1; // As empty string is subsequence of every string
		}

		for (int i = 1; i <= s.length(); i++) {
			for (int j = 1; j <= t.length(); j++) {
				if (s.charAt(i - 1) == t.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
					// i-1 is the count of subsequence existing without adding the current char
					// i-1,j-1 subsequence when taking both chars in string and reducing the length
				} else {
					dp[i][j] = dp[i - 1][j];
					// without adding current char and reducing the size
				}
			}
		}
		return dp[s.length()][t.length()];
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		String str = "cateat";
		String t = "cat";
		System.out.println( s.numDistinct(str, t) );
	}
}