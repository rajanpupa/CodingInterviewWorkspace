import java.util.ArrayList;
import java.util.List;
/*
 * 	Input: "x+5-3+x=6+x-2"
	Output: "x=2"
 */
public class Equation {
	
	public static void main(String[] args) {
		Equation s = new Equation();
		
		String ans = s.solveEquation("x+5-3+x=6+x-2");
		
		System.out.println(ans);
	}
	
	public boolean isNumeric(String s) {  
	    return s != null && s.matches("[-+]?\\d*\\.?\\d+");  
	}  
    public String solveEquation(String equation) {
        
    	String [] eq = equation.split("=");
    	
    	String left = eq[0];
    	String right = eq[1];
    	
    	List<String> ltokens = parse(left);
    	System.out.println("ltokens = " + ltokens);
    	
        int lnum = 0;
    	lnum = sumNums(ltokens, lnum);
    	
        System.out.println("lnum = " + lnum);
    	int lxcoef = 0;
    	lxcoef = sumXCoefs(ltokens, lxcoef);
    	System.out.println("lxcoef = " + lxcoef);
    	
    	
    	List<String> rtokens = parse(right);
        System.out.println("rtokens = " + rtokens);
    	int rnum = 0;
       
        
    	rnum = sumNums(rtokens, rnum);
        System.out.println("rnum = " + rnum);
        
    	int rxcoef = 0;
    	rxcoef = sumXCoefs(rtokens, rxcoef);
         System.out.println("rxcoef = " + rxcoef);
    	
    	int totalLeftXCoef = lxcoef - rxcoef;
    	int totalRightNum = rnum - lnum;
    	
    	String ans = "";
    	if(totalLeftXCoef != 0){
    		ans = "x=" + (totalRightNum / totalLeftXCoef) ;
    	}else if(totalRightNum != 0){
    		ans = "No solution";
    	}else{
            ans = "Infinite solutions";
        }
    	
    	return ans;
    }
	private int sumXCoefs(List<String> ltokens, int lxcoef) {
		for(String str: ltokens){
    		if(!isNumeric(str)){// ie its x
    			String replacedStr = str.replace("x", "")
    					.replace("+", "")
    					//.replace("-", "")
                    ;
    			if(replacedStr.isEmpty()){
                    replacedStr = "1";
                }if(replacedStr.equals("-")){
                    replacedStr += "1";
                }
    			lxcoef += Integer.parseInt(replacedStr);
    		}
    	}
		return lxcoef;
	}
	private int sumNums(List<String> ltokens, int lnum) {
		for(String str: ltokens){
    		if(isNumeric(str)){
    			lnum += Integer.parseInt(str);
    		}
    	}
		return lnum;
	}
    
    public List<String> parse(String side){
    	List<String> ans = new ArrayList<>();
    	
    	String temp = "";
    	for(int i=0; i<side.length(); i++){
    		char c = side.charAt(i );
    		if(c == '+' || c=='-'){
    			if(!temp.isEmpty()) ans.add(temp);
    			temp = c+ "";
    		}else{
    			temp += c;
    		}
    	}
    	
    	ans.add(temp);
    	
    	return ans;
    }
    
    
}