package leetcode;

import java.util.HashMap;
import java.util.Map;

public class ListNode {
     public int val;
     public ListNode next;
     public ListNode(int x) {
         val = x;
         next = null;
     }
     
     public static Map<Integer, ListNode> create(Integer [] arr, Integer cyclicPosition) {
    	 
    	 Map<Integer, ListNode> m = new HashMap<>();
    	 Integer index = 0;
    	 
    	 for(Integer i: arr) {
    		 ListNode n = new ListNode(i);
    		 
    		 if(index > 0) {
    			 m.get(index-1).next = n;
    		 }
    		 
    		 m.put(index++, n);
    		 
    	 }
    	 
    	 if(cyclicPosition >= 0) {
    		 m.get(index-1).next = m.get(cyclicPosition);
    	 }
    	 
    	 
    	 return m;
     }
 }
