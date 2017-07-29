package mum.algorithms.factoriall;

import java.util.HashMap;
import java.util.Map;

public class Factorial {
	
	public static void main(String[] args) {
		Factorial f = new Factorial();
		int ftl = f.factorialMemoized(5);
		System.out.println(ftl);
	}
	
	// simplest recursive method
	public int factorial(int n){
		if(n<=1) return 1;
		return n * factorial(n-1);
	}
	
	Map<Integer, Integer> map = new HashMap<>();
	public int factorialMemoized(int n){
		return factorialM(n);
	}

	private int factorialM(int n) {
		if(n<=1) return 1;
		if(map.get(n) != null) return map.get(n);
		else{
			Integer ans = n * factorialM(n-1);
			map.put(n, ans);
			return ans;
		}
	}
}
