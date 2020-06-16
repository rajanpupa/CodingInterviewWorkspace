package treeset;

import java.util.TreeSet;

public class TreeSetExample {

	public static void main(String[] args) {
		int[] arr = {1, 3, 2, 6, 4, 9, 8};
		
		TreeSet<Integer> s = new TreeSet<>();
		
		for(int i: arr) {
			s.add(i);
		}
		
		System.out.println(s.first());
		System.out.println(s.last());
		System.out.println(" Greater than 5 is " + s.ceiling(5));
		System.out.println(" Less than 5 is " + s.floor(5));
	}
}
