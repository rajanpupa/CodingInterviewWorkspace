package palindrome;

// find the longest palindromic string in s
// efficient solution: panindrome expand: efficient solution has memoization.
public class LongestPalindromicString {

	public static void main(String[] args) {
		//System.out.println(isPalindrome("aba"));
		System.out.println(longestPalindrome("cbbd"));
	}
	
	
	public static String longestPalindrome(String s) {
		for(int len = s.length(); len > 0; len --) {
			for(int i = 0; i <= s.length() - len; i++) {
				String substr = s.substring(i, i+len);
				if( isPalindrome(substr) ) {
					System.out.printf(" -- found -- \n");
					return substr;
				}
			}
		}
		return "";
    }
	
	private static boolean isPalindrome(String s) {
		System.out.println(s);
		
		for(int i=0; i<=s.length()/2; i++) {
			if( s.charAt(i) != s.charAt(s.length()-i-1) ) return false;
		}
		
		return true;
	}
	
	
}
