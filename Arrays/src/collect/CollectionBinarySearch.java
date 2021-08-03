package collect;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionBinarySearch {
	
	public static void main(String[] args) {
		List<Integer> lst = Arrays.asList(4,6,7,8,9,10);
		
		int index = Collections.binarySearch(lst, 5);
		
		if( index < 0) {
			System.out.printf( "The element could be inserted in %s index\n", -index - 1 );
		} else {
			System.out.printf("Found at %s index\n", index);
		}
	}
}
