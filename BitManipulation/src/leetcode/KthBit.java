package leetcode;

import java.util.HashMap;
import java.util.Map;

public class KthBit {
	
	public static void main(String[] args) {
		System.out.println(new KthBit().findKthBit(3, 1));
	}
	
	Map<Integer, String> m  = new HashMap<>();
    
    public char findKthBit(int n, int k) {
        m.put(1, "0");
        m.put(2, "011");
        m.put(3, "0111001");
        m.put(4, "011100110110001");
        
//        if(n <=  4) {
//            return m.get(n).charAt(k);
//        }
        
        calc(n);
        
        String str = m.get(n);
        System.out.println(str);
        return str.charAt(k-1);
    }
    
    void calc(int n){
        if(!m.containsKey(n)){
            calc(n-1);
        }else {
        	return;
        }
        
        String s = m.get(n-1) + "1" + reverse(invert(new StringBuilder(m.get(n-1)))).toString();
        m.put(n, s);
    }
    
    StringBuilder reverse(StringBuilder s){
        return s.reverse();
    }
    
    StringBuilder invert(StringBuilder s){
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '0'){
                s.setCharAt(i, '1');
            }else{
                s.setCharAt(i, '0');
            }
        }
        
        return s;
    }
}
