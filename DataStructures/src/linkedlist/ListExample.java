package linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListExample {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		
		Arrays.asList(arr).contains(4);
		
		List<String> lst = new ArrayList<>();
		
		lst.addAll(Arrays.asList("abc", "apple", "banana", "orange", "pineapple"));
		System.out.println(lst);
		lst.remove(new String("apple"));
		System.out.println(lst);
	}
}
