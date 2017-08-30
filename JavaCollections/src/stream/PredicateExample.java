package stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateExample {

	public static void main(String[] args) {
		List<Integer> i = Arrays.asList(4,3,2,5,6,7,8,10,9);
		
		Predicate<Integer> p = a-> a%5!=0;
		
		// filter out the numbers divisible by 5;
		i = i.stream().filter(p).collect(Collectors.toList());
		
		System.out.println(i);
	}
}
