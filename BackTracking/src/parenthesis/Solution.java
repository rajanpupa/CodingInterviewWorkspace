package parenthesis;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given an integer n, generate all the valid opening and closing parenthesis combination.
 */
/**
 * Using the backtracking algorithm to solve this.
 * 
 * Basically the opening parenthesis (OP) always comes first before the closing parenthesis(CP).
 * 
 * Increase the OP and then search for all the possible solutions from that state (in depth)
 * Then increase the CP ans search the same. Whenever a solution is found, add it to the set.
 *
 */

public class Solution {
	
	public static void main(String[] args) {
		Solution s = new Solution();
		
		System.out.println(s.generateParenthesis(1));
	}

	public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        Set<String> s = new HashSet<>();
        backtrack(0, 0, n, sb, s);
        return new ArrayList<String> (s);
    }
    
    private void backtrack(int l, int r, int n, StringBuilder sb, Set<String> s){
        if(l == 0 && r == 0 && n==1) {
            s.add("()");
            return;
        }
        
        if( l > n || r > n ) return;
        if( r > l ) return;
        
        if( l == r && l == n ){
            s.add(sb.toString());
            return;
        }
        
        backtrack(l+1, r, n, sb.append("("), s);
        sb.deleteCharAt(sb.length()-1);
        backtrack(l, r+1, n, sb.append(")"),s);
        sb.deleteCharAt(sb.length()-1);
        
    }
}
