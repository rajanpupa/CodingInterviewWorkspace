package linkedlist;

import java.util.LinkedList;

/*
 * add: 		adds element at the end of list, also at specified index
 * addFirst: 	adds element at the beginning of the list
 * addLast: 	
 * clear: 		remove all elements
 * contains: 	returns true if the element is present in the list
 * element: 	return but not remove, the head element of list
 * poll():
 * pollFirst():
 * pollLast():
 * pop()
 * push()
 */
public class LinkedListExample {

	public static void main(String[] args) {
		LinkedList<Integer> l = new LinkedList();
		
		l.add(1);
		l.add(2);
		
		l.add(3);
		
		l.forEach(System.out::println);;
		System.out.println("-------------------------");
		
		l.add(1,4);
		l.forEach(System.out::println);;
		System.out.println("-------------------------");
		
		l.remove(1);
		l.forEach(System.out::println);;
		System.out.println("-------------------------");
		
		System.out.println("the index of 4 is " + l.indexOf(4));
		
	}
}
