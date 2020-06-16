package leetcode;

import java.util.Arrays;

// 455
public class AssignCookies_455 {
	public static void main(String[] args) {
		int[] boys = {10,9,8,7};
		int[] coo = {5,6,7,8};
		
		System.out.println(findContentChildren(boys, coo));
	}
	// working solutions
	public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        
        int gi = 0;
        int si = 0;
        int count = 0;
        
        while(si < s.length){
            boolean found = false;
            while(gi < g.length && !found){
                if(g[gi] <= s[si]){
                    found = true;
                    count ++;
                    gi++;
                }else {
                	break;
                }
            }
            si++;
        }
        
        return count;
    }
}
