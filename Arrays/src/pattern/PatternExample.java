package pattern;

import java.util.HashMap;
import java.util.Map;

public class PatternExample {

	public static void main(String[] args) {
		System.out.println(Math.pow(2, 7));
		//checkWordPattern();
		Integer i = 128;
		Integer j = 128;
		
		System.out.println( i != j );
		System.out.println( i.intValue() != j.intValue() );
	}

	private static void checkWordPattern() {
		String pattern = "ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccdd";
		String str = "s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s t t";
		
		System.out.println(wordPattern(pattern, str));
	}

	public static boolean wordPattern(String pattern, String str) {

		char[] ap = pattern.toCharArray();
		String[] as = str.split(" ");

		if (ap.length != as.length) {
			System.out.printf("len not equal %d %d \n", ap.length, as.length);
			return false;
		}
		if (ap.length < 2) {
			System.out.printf("len less than 2");
			return true;
		}

		Map<Character, Integer> mp = new HashMap<>();
		Map<String, Integer> ms = new HashMap<>();

		// mp.put(ap[0], 0);
		// sp.put(as[0], 0);

		for (int i = 0; i < ap.length; i++) {
			Integer pi = mp.get(ap[i]);
			Integer si = ms.get(as[i]);
			
			if(pi == null && si == null) continue;
			else if(pi == null ^ si == null) return false;
			else if ( ! pi.equals(si) ) {
				System.out.printf("returning false. i=%d, pi=%d si=%s \n", i, pi, si);
				return false;
			}

			mp.put(ap[i], i);
			ms.put(as[i], i);
		}

		return true;

	}
}
