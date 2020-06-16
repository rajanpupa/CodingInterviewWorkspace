package leetcode;

// 434
public class NumberOfSegments {
	public int countSegments(String s) {
        if(s == null) return 0;
        
        int scount = 0;
        
        boolean waschar = false;
        
        for(char c : s.toCharArray()){
            
            if(! Character.isWhitespace(c)) {
            	waschar = true;
            }else {
            	if(waschar) {
            		scount ++;
            		waschar = false;
            	}
            }
            
        }
        
        if(waschar) {
        	scount ++;
        }
        
        return scount;
    }
	
	public static void main(String[] args) {
		System.out.println(new NumberOfSegments().countSegments("Hello, my name is John"));
	}
}
