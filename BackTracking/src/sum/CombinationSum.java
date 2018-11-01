package sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given an array of integers and a large integer target,
 * Find all the combinations of the integers in the candidate, which sums up to target.
 * 
 * The numbers are allowed to be repeated.
 */

/**
 * Solved using backtracking algorithm 
 *
 */
public class CombinationSum {
	
	public static void main(String[] args) {
		int[] candidates = { 0, 1, 2, 5, 6};
		CombinationSum cs = new CombinationSum();
		System.out.println(cs.combinationSum(candidates, 7));
	}
	

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        
        Set<List<Integer>> s = new HashSet<>();
        
        backtrack(candidates, target, s, new ArrayList<Integer>());
        return new ArrayList<List<Integer>> (s);
    }
    
    private void backtrack(int[] candidates, int target, Set<List<Integer>> s, List<Integer> list){
        if(target < 0) {
        	//System.out.printf("target = %d returning \n", target);
        	return;
        }
        if(target == 0){
            List<Integer> l = new ArrayList<Integer>();
            l.addAll(list);
            Collections.sort(l);
            s.add( l );
            return;
        }
         if(target < candidates[0]){
            //System.out.printf("%d less than %d \n",target, candidates[0]);
            return;
        }
        for(int i: candidates){
        	if(i==0) continue;
            if(!list.isEmpty() && list.get(list.size()-1) > i ) continue;
            list.add(i);
            backtrack(candidates, target - i, s, list);
            list.remove(list.size()-1);
        }
    }
}
