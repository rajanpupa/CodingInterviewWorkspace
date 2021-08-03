package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 1482. Minimum Number of Days to Make m Bouquets
/*
 * Given an integer array bloomDay, an integer m and an integer k.
We need to make m bouquets. To make a bouquet, you need to use k adjacent flowers from the garden.
The garden consists of n flowers, the ith flower will bloom in the bloomDay[i] and then can be used in exactly one bouquet.
Return the minimum number of days you need to wait to be able to make m bouquets from the garden. If it is impossible to make m bouquets return -1.
 */
public class Boutique {
	
	public static void main(String[] args) {
		//System.out.println(new Boutique().minDays(new int[] {1,10, 3, 10, 2}, 3, 1)); // days of bloom, num, count per boutique, // should be 3
		System.out.println(new Boutique().minDays(new int[] {1,10, 3, 10, 2}, 3, 2)); // days of bloom, num, count per boutique, // should be -1
	}
	
	public int minDays(int[] bloomDay, int m, int k) {
        Map<Integer, List<Integer>> map = new HashMap();
        for(int i=0; i<bloomDay.length; i++){
            List<Integer> l = map.getOrDefault(bloomDay[i], new ArrayList<>());
            l.add(i);
            map.put(bloomDay[i], l);
        }
        
        List<Integer> cumulative = new ArrayList<>();
        List<Integer> days = new ArrayList<>(map.keySet());
        Collections.sort(days);
        
        int count = 0;
        for(int i : days){
            
            cumulative.addAll(map.get(i));
            count = findAndRemoveConsecutive(cumulative, k);
            
            //System.out.printf(" %s -> %s \n", i, count);
            if(count >= m) return i;
        }
        return -1;
    }
    
    private int findAndRemoveConsecutive(List<Integer> l, int k){
        Collections.sort(l);
        int count = 0;
        List<Integer> del = new ArrayList<>();
        int left = 0, right = 0;
        
        while(left <= right && right < l.size()) {
        	
        	boolean adj = true;
        	for(int i = left; i<right && i<l.size()-k ; i++) {
        		if(l.get(i+1) -l.get(i) >1 ) {
        			adj = false;
        			break;
        		}
        	}
        	
        	if(adj) {
        		count++;
        		left += k;
        		right += k;
        	}
        }
        
        return count;
    }
}
