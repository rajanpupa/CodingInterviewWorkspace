package mum.algorithms.powerset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PowersetHelper {
	
	public static void main(String[] args) {
		PowersetHelper psh = new PowersetHelper();
		
		List<Set<String>> powerSet = psh.powerset(Arrays.asList("a","b","c"));
		
		System.out.println(powerSet);
	}

	public List<Set<String>> powerset(List<String> list){
		List<Set<String>> ans = new ArrayList<>();
		
		// add empty set
		ans.add(new HashSet<String>());
		
		// for each element in the list
		for(String str : list){
			List<Set<String>> newlist = new ArrayList<>();
			
			// get the existing element in the final list
			// make a new copy of it, and add the str element to it
			// add it to the newlist
			for(Set<String> existingSet : ans){
				Set<String> newset = new HashSet<>();
				newset.addAll(existingSet);
				newset.add(str);
				
				newlist.add(newset);
			}
			
			// add all the new sets created from above loop into the ans list
			ans.addAll(newlist);
			
		}
		
		return ans;
	}
}
