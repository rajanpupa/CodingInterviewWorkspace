package leetcode;

import java.util.Stack;

public class FlattenDoublyLinkedList {
	
	public static void main(String[] args) {
		Integer[] arr = {1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12};
		
		Node head = Node.makeDoublyLinkedList(arr);
	}

	public Node flatten(Node head) {
        Stack<Node> stk = new Stack<>();
        Node last = head;
        
        if(head.child != null){
            stk.push(head.next);
            stk.push(head.child);
        }else{
            stk.push(head.next);
        }
        while(! stk.isEmpty()){
            Node n = stk.pop();
            
            if(n== null) continue;
            
            System.out.printf("last = %s, n = %s\n", last.val, n.val);
            
            last.next = n;
            n.prev = last;
            
            last = n;
            
            stk.push(n.next);
            stk.push(n.child);
        }
        return head;
    }
}
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
    
    public Node(int val) {
    	this.val = val;
    }
    
    public static Node makeDoublyLinkedList(Integer[] arr) {
    	
    	if(arr.length == 0) return null;
    	Node head = new Node(arr[0]);
    	
    	
    	
    	return null;
    }
};
