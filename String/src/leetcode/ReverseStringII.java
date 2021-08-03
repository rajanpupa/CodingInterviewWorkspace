package leetcode;

public class ReverseStringII {
	public static void main(String[] args) {
		//System.out.println(new ReverseStringII().reverseStr("abcdefg", 2));// bacdfeg
		//System.out.println(new ReverseStringII().reverseStr("abcdefg", 3));// cbadefg
		System.out.println(new ReverseStringII().reverseStr("abcdefg", 8));// "gfedcba"
	}
	public String reverseStr(String s, int k) {
        if(s==null) return s;
        int len = s.length();
        char[] ca = s.toCharArray();
        if(len < k) return new StringBuilder(s).reverse().toString();
        
        // reverse the first k characters for every 2k characters
        int count = 0;
        int i=0;
        for(; i<len; i += 2*k){
            // reverse the first k chars
            int half = i + (k+1) /2;
            System.out.println("i=" + i + " , half = " + half);
            for(int j=i; j < half ; j++){
                int firstindex = j;
                int secondindex = i + k -j -1 +2*count*k;
                if(secondindex >= len) break;
                System.out.println(firstindex + ", " + secondindex);
                char tmp = ca[firstindex];
                ca[firstindex] = ca[secondindex];
                ca[secondindex] = tmp;
            }
            count ++;
        }
        // remaining, if there are less than 2k but greater or equal to k chars, then reverse first k chars
        // leave the others as original
        return new String(ca);
    }
}
