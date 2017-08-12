package regex;

/*
 * aa*b,  input aaabb return true, aabbc return false
 * a?b, input aab return true, 2nd input example -  abb return false;
 * 
 */
public class RegexMatchAlgo {

	public static void main(String[] args) {
		//System.out.println(match("aa*b", "aabbc"));
		System.out.println(match("a?b", "abb"));
	}
	
	public static boolean match(String pat, String input){
		int i = 0;
		
		int pi=0;
		int ii = 0;
		char pchar=0 ;
		while(pi<pat.length() && ii < input.length()){
			char pc = pat.charAt(pi);
			char ic = input.charAt(ii);
			
			if(pc !='*' && pc != '?'){
				if(pc == ic) {
					pchar = pc;
					pi++;
					ii++;
				}else{
					return false;
				}
			}else{
				if(pc == '*'){
					while(input.charAt(ii) == pchar)ii++;
					pi++;
					return pat.substring(pi).equals(input.substring(ii));
				}else {
					// ?
					if(input.charAt(ii++) != pchar) return false;
					pi++;
					return pat.substring(pi).equals(input.substring(ii));
				}
			}
		}
		return true;
	}
	
}
