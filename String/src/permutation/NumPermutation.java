package permutation;

import java.util.ArrayList;
import java.util.List;

public class NumPermutation {

	public static void main(String[] args) {
		
		//permut(12345);
		//permut2(12345);
		
		int a = 130;
		
		byte b = (byte)(a);
		
		System.out.println(b);
		
	}
	
	
	
	private static void permut2(int i) {
		StringBuilder s = new StringBuilder(i+"");
		
		if(s.length()<=1) {
			System.out.println(s);
		}
		
		List<StringBuilder> childPer = permut2(new StringBuilder(s));
		
		for(StringBuilder sb: childPer){
			System.out.println(sb);
		}
		
	}
	
	private static List<StringBuilder> permut2(StringBuilder stb){
		StringBuilder s = new StringBuilder(stb);
		
		if(s.length()<=1) {
			List<StringBuilder> ans = new ArrayList<>();
			ans.add(stb);
			return ans;
		}
		
		char c = s.charAt(0);
		List<StringBuilder> childPer = permut2(new StringBuilder(s.substring(1)));
		
		int size = childPer.size();
		for(int k=0; k<size; k++){
			
			StringBuilder sb2 = childPer.remove(0);
			// insert 0th index char at every possible place
			for(int j=0; j<=sb2.length(); j++){
				StringBuilder sb1 = new StringBuilder(sb2);
				sb1.insert(j, c);
				childPer.add(sb1);
			}
		}
		
		return childPer;
	}



	private static void permut(int i) {
		List<List<Integer>> lst = new ArrayList<>();
		lst.add(new ArrayList<>());
		
		//System.out.println(lst.size());
		
		while(i>0){
			int rem = i%10;
			List<List<Integer>> tmp = new ArrayList<>();
			
			for(List l : lst){
				List<Integer> nl = new ArrayList<>();
				for(int j=0; j<=l.size(); j++){
					nl = new ArrayList<>();
					nl.addAll(l);
					nl.add(j, rem);
					tmp.add(nl);
				}
			}
			List<Integer> empty = new ArrayList<>();
			if(lst.contains(empty)) lst.remove(empty);
			lst.addAll(tmp);
			
			i/=10;
		}
		
		
		for(List<Integer> l : lst){
			if(l.size() == 5){
				for(Integer il : l){
					System.out.print(il);
				}
				System.out.println();
			}
		}
		
	}
}
