package leetcode;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LinkedListII {
	public ListNode detectCycle(ListNode head) {
        Set<ListNode> m = new HashSet<>();
        
        ListNode p = head;
        m.add(p);
        
        while(p.next != null){
            ListNode nxt = p.next;
            if(m.contains(nxt)) {
                System.out.println(nxt.val);
                return nxt;
            }else{
                System.out.println("adding " + nxt.val);
                m.add(nxt);
            }
            // don't forget this
            p = p.next;
        }
        
        return null;
    }
	
	public static void main(String[] args) {
		Integer[] arr1 = {1,2};
		
		Map<Integer, ListNode> m = ListNode.create(arr1, 0);
		
		ListNode ans = new LinkedListII().detectCycle(m.get(0));
		
		for(Map.Entry<Integer, ListNode> entry: m.entrySet()) {
			if(entry.getValue().equals(ans)) {
				System.out.println(entry.getKey());
				return;
			}
		}
	}
}
