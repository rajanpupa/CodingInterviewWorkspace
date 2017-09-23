package purmutation;

/*
 * Given two strings, ab and cd
 * print all the purmutations such that 
 * b does not come before a, 
 * and d does not come before c
 */

public class CharPurmutAmazon {

	public static void main(String[] args) {
		String ab = "ab";
		String cd = "cde";
		
		CharPurmutAmazon cp = new CharPurmutAmazon();
		
		cp.purmut(ab, cd, cd.length());
	}
	
	public void purmut(String ab, String cd, int ind) {
		if(ab == null ) return;
		else if(ab.equals("")){
			System.out.println(cd);
			return;
		}else if(ab.length()==1){
			for(int i=0; i<=ind; i++){
				StringBuilder sb = new StringBuilder(cd);
				sb.insert(i, ab);
				System.out.println(sb.toString());
			}
			return;
		}
		
		for(int i=0; i<=ind; i++){
			StringBuilder sb = new StringBuilder(cd);
			sb.insert(i, ab.substring(ab.length()-1));
			purmut(ab.substring(0, ab.length()-1), sb.toString(), i);
		}
		
	}
	
	
	
}
