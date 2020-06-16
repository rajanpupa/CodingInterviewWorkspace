package leetcode;

public class AddString {
	public static void main(String[] args) {
		System.out.println(new AddString().addStrings("1", "0"));
		System.out.println(new AddString().addStrings("2", "8"));
		System.out.println(new AddString().addStrings("98", "9"));
	}
	private String eqStr(String num1, String num2){
        int len1 = num1.length();
        int len2 = num2.length();
        
        StringBuilder z = new StringBuilder();
        for(int i=0; i<len1-len2; i++){
            z.append("0");
        }
        num2 = z.toString() + num2;
        return num2;
    }
    public String addStrings(String num1, String num2) {
        if(num1 == null ) return num2;
        if(num2 == null ) return num1;
        
        int len1 = num1.length();
        int len2 = num2.length();
        
        if(len1 > len2){
            num2 = this.eqStr(num1, num2);
        }else if(len2 > len1){
            num1 = this.eqStr(num2, num1);
        }
     
        StringBuilder sb = new StringBuilder();
        
        int carry = 0;
        
        // num1 and num2 are same length
        for(int i = num1.length()-1; i>= 0; i-- ) {
        	
        	char c1 = num1.charAt(i);
        	char c2 = num2.charAt(i);
        	
        	int n1 = c1-'0';
        	int n2 = c2-'0';
        	
        	int s = (n1 + n2 + carry) % 10;
        	carry = (n1 + n2 + carry) / 10;
        	
        	sb.append(s);
        	
        }
        
        if(carry > 0) {
        	sb.append(carry);
        }
        
        return sb.reverse().toString();
    }
}
