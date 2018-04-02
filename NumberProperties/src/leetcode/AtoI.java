package leetcode;

/**
 * https://leetcode.com/problems/string-to-integer-atoi/description/
 * @author Rajan
 * 
 * "123" => 123
 * "+123" => 123
 * "-123" => -123
 * 
 * "" => 0
 * "+" => 0
 * "9929929292929" => Integer.MAX_VALUE
 * if(less than integer min value) return Integer.MIN_VALUE
 * 
 * "-123a456" => -123
 *
 */
public class AtoI {
	
	public static void main(String[] args) {
		
	}
	    public int myAtoi(String str) {
	        if(str == null) return 0;
	        str = str.trim();
	        if(str.isEmpty()) return 0;
	        
	        int sign = 1;
	        if(str.charAt(0) == '-'){
	            str = str.substring(1, str.length());
	            sign = -1;
	        }else if(str.charAt(0) == '+'){
	            str = str.substring(1, str.length());
	        }
	        
	        if(str.isEmpty()) return 0;
	        
	        long val = 0l;
	        
	        for(int i=0; i< str.length(); i++){
	            char c = str.charAt(i);
	            if(c >= '0' && c <= '9'){
	                val *= 10;
	                val += c - '0';
	            }else{
	                //System.out.println("breaking on " + c);
	                break;
	            }
	            if(val > Integer.MAX_VALUE) break;
	        }
	        
	        if(sign < 0){
	            //System.out.println(val);
	            if(sign * val < Integer.MIN_VALUE) return Integer.MIN_VALUE;
	            else return (int) (sign * val);
	        }else{
	            //System.out.println("-"+val);
	            if(val > Integer.MAX_VALUE) return Integer.MAX_VALUE;
	            else return (int)(val);
	        }
	        
	    }

}
