package queues;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueExample {

	public static void main(String[] args) {
		Comparator<String> comp = new StringLengthComparator();
		
		// if comparator is passed, uses the comparator
		// else uses default alphabetical comparison
		Queue<String> queue = new PriorityQueue<>();//comp );
		
		queue.add("short");
		queue.add("z");
        queue.add("very long indeed");
        queue.add("medium");
        
        while ( queue.size() != 0 ){
            System.out.println( queue.remove() );
        }
	}
	
	public static class StringLengthComparator implements Comparator<String>{

		@Override
		public int compare(String o1, String o2) {
			return o1.length()-o2.length();
		}
		
	}
}
