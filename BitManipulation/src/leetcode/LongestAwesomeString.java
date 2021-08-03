package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 5485
public class LongestAwesomeString {
	
	public static void main(String[] args) {
		//System.out.println( new LongestAwesomeString().longestAwesome("3242415")	);//5
		// "185801630663498" -> 5
		System.out.println( new LongestAwesomeString().longestAwesome("185801630663498")	);//5
	}
	int count = 1;
	public int longestAwesome(String s) {
        int res = 0, cur = 0, n = s.length(), seen[] = new int[1024];
        Arrays.fill(seen, n);
        seen[0] = -1;
        for (int i = 0; i < n; ++i) {
        	int shifti = s.charAt(i) - '0';
            cur ^= 1 << shifti;
            for (int a = 0; a < 10; ++a) {
            	int curXor = (cur ^ (1 << a));
            	
                res = Math.max(res, i - seen[curXor]);
            }
            res = Math.max(res, i - seen[cur]);
            seen[cur] = Math.min(seen[cur], i);
        }
        return res;
    }
}
