package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexGroupReplaceExample {

	public static void main(String[] args) {
		String st1 = "123def";
		String pat = "*def";
		
		pat = pat.replace("*", ".*");
		pat = pat.replace("?", ".?");
		
		boolean isMatch = st1.matches(pat);
		
		System.out.println("matches is " + isMatch);
	}
	
	public static void replace(){
		String str = " The lady cleans sth leanierly.";
		String regex = "\\w*(lea)\\w*";
		
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(str);
		
		while(m.find()){
			System.out.println("group = " + m.group());
			String output = m.replaceFirst("<replaced>");
			System.out.println(output);
		}
	}
}
