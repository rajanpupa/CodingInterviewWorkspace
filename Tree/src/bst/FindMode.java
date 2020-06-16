package bst;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

// Easy: 501: Find mode in bst
public class FindMode {
	 public int[] findMode(Node root) {
	        if(root == null) return new int[]{};
	        Map<Integer, Integer> valcount = new HashMap<>();
	        
	        Queue<Node> q = new LinkedList<>();
	        q.add(root);
	        
	        int mode = 0;
	        while(! q.isEmpty()){
	            Node t = q.poll();
	            
	            if(t == null) continue;
	            Integer cnt = valcount.getOrDefault(t.val, 0);
	            if(cnt+1 > mode) mode = cnt+1;
	            valcount.put(t.val, cnt + 1);
	            
	            q.add(t.left);
	            q.add(t.right);
	        }
	        
	        int count = 0;
	        for(Map.Entry<Integer, Integer> e: valcount.entrySet()) {
	        	if(e.getValue() == mode) count++;
	        }
	        
	        int [] ans = new int[count];
	        int j = 0;
	        for(Map.Entry<Integer, Integer> e: valcount.entrySet()) {
	        	if(e.getValue() == mode) {
	        		ans[j++] = e.getKey();
	        	}
	        }
	        return ans;
	        
	    }
}
