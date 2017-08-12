package queues;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Queue has two main methods
 * add  -> add elements 
 * peek -> Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
 * pool -> Retrieves and removes the head of this queue, or returns null if this queue is empty.
 */
public class BasicQueue {

	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<>();
		
		q.add(10); // always return true if success, else throws exception
		q.add(50);
		q.add(20);
		q.offer(30); // adds the element if the size allows, else returns false
		
		System.out.println( "size = " + q.size() );
		System.out.println( "poll -> " + q.poll()); // removes element from head
		System.out.println( "remove -> " + q.remove()); // remove from head
		System.out.println( "size = " + q.size() );
	}
}
