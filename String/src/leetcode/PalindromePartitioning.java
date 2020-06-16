package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// 131: Palindrome Partitioning

//Given a string s, partition s such that every substring of the partition is a palindrome.
//Return all possible palindrome partitioning of s.
// E.g. Input = "aab"
// 		Output = [
//					[a,a,b],
// 					[aa, b]
// 				]

public class PalindromePartitioning {
	
	public static void main(String[] args) {
		//System.out.println(partition("aabb"));
		//System.out.println(partition("aka"));
		//System.out.println(partition("bbb"));
		System.out.println(partition2("abbab")); // should have 4 lists
	}

	// not proper solution
	public static List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        if(s == null || s.isEmpty()) return ans;
        
        int n = s.length();
        List<List<String>> slst = partition(s.substring(1));
        
        if(slst.isEmpty()) {
        	List<String> tlist = new ArrayList<String>() ;
        	tlist.add(s);
        	ans.add(tlist);
        	return ans;
        }
        
        List<List<String>> temp = new ArrayList<>();
        for(List<String> l : slst){
            List<String> tl = new ArrayList<>(l);
            tl.add(0, "" + s.charAt(0));
            temp.add(tl);
            
            if(!tl.isEmpty() && isp( s.charAt(0) + l.get(0))){
                List<String> tlb = new ArrayList<>(l);
                String newp = s.charAt(0) + tl.get(0);
                tlb.remove(0);
                tlb.add(0, newp);
                temp.add(tlb);
            }
        }
        ans.addAll(temp);
        if(isp(s)){
            if(!ans.contains(Arrays.asList(s))){
                ans.add(Arrays.asList(s));
            }
        }
        
        ans = ans.stream()
            .filter( a-> {
                int size = 0;
                for(String ns: a) {
                	size += ns.length();
                }
                return size == n;
            }).collect(Collectors.toList());
        
        return ans;
    }
    
	// efficient backtracking
	static List<List<String>>  llist = new ArrayList<>();
	public static List<List<String>> partition2(String s){
		if(s == null || s.length() < 0) return Arrays.asList();
		
		backtrack(s, 0, 0, new ArrayList<>());
		
		return llist;
	}
	// efficient backtracking solution
    private static void backtrack(String s, int i, int j, List<String> list) {
    	if(j >= s.length()) {
    		llist.add(new ArrayList(list));
    		return;
    	}
    	
    	for(int k=i; k < s.length(); k++) {
    		for(int l=j; l>=k && l<s.length() ; l++) {
    			String sub = s.substring(k, l+1);
    			
    			if(isp(sub)) {
    				//System.out.println(sub);
    				list.add(sub);
    				backtrack(s, l+1, l+1, list);
    				list.remove(sub);
    			}
    		}
    	}
		
	}

	static boolean isp(String s){
        if(s.length() == 1) return true;
        
        int n = s.length();
        for(int i=0 ; i<n ; i++){
            if(s.charAt(i) != s.charAt(n-i-1)) return false;
        }
        return true;
    }
}
