package crackingthecodinginterview;

/* ## cracking the coding interview: ch1->1.5
 * There are three types of edits that can be performed on strings:
 * - insert a character,
 * - remove a character,
 * - replace a character
 * 
 * Given two strings, write a function to check if they are one edit (or zero edits) away.
 */

public class OneAway {
	
	public static void main(String[] args) {
		String [][] values= {
				{"pale", "ple"},
				{"pales", "pale"},
				{"pale", "bale"},
				{"pale", "bake"}
		};
		
		OneAway oneAway = new OneAway();
		
		for(int i=0; i<values.length; i++) {
			String [] touple = values[i];
			
			System.out.println(" => " + oneAway.isOneAway(touple[0], touple[1]));
		}
		
	}
	
	public boolean isOneAway(String str1, String str2) {
		if(str1 == null && str2 == null) return true;
		if(str1 == null || str2 == null) return false;
		
		System.out.print(String.format("Analyzing %s and %s ", str1, str2));
		
		// if the length diff is more than two, cannot be 
		if(Math.abs(str1.length() - str2.length()) > 1) return false;
		
		// if the length of both strings are same, need to check by replacing a character
		if(str1.length() == str2.length()) {
			int diff = findDiffChars(str1, str2);
			if(diff <=1) return true;
		}
		
		// if str1.len is less than str2.len need to check by deleting a character
		if(str1.length() < str2.length()) {
			return isEqualByDeletingACharacter(str1, str2);
		}else {
			return isEqualByDeletingACharacter(str2, str1);
		}
	
	}
	
	public int findDiffChars(String str1, String str2) {
		int diff = 0;
		for(int i = 0; i<str1.length(); i++) {
			if(str1.charAt(i) != str2.charAt(i)) {
				diff++;
			}
		}
		return diff;
	}
	
	// str2 has longer length
	public boolean isEqualByDeletingACharacter(String str1, String str2) {
		int del = 1;
		int i = 0, j = 0;
		
		while(i<str1.length() && j < str2.length()) {
			if(str1.charAt(i) != str2.charAt(j)) {
				del--;
				j++;
			}else {
				j++;
				i++;
			}	
		}
		return del >= 0;
	}

}
