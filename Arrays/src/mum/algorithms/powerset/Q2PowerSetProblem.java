package mum.algorithms.powerset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
4. Power Set Algorithm. Given a set X, the power set of X, denoted P(X), is the set of all subsets of X. 
Below, you are given an algorithm for computing the power set of a given set. 
This algorithm is used in the brute-force solution to the SubsetSum Problem, discussed in the first lecture. 
Implement this algorithm in a Java method:

List powerSet(List X)
Use the following pseudo-code to guide development of your code
Algorithm: PowerSet(X)
	Input: A list X of elements
	Output: A list P consisting of all subsets of X – elements of P are Sets
	P ? new list
	S ? new Set //S is the empty set
	P.add(S) //P is now the set { S }
	T ? new Set
	while (!X.isEmpty() ) do
		f ? X.removeFirst()
		for each x in P do
			T ? x U {f} // T is the set containing f & all elements of x
			P.add(T)
	return P
 */

public class Q2PowerSetProblem {
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>( Arrays.asList(new Integer[]{1,2,3,4}) );
		
		List<Set<Integer>> powerset= powerSet(list);
		
		
		System.out.println(powerset);
		System.out.println("size = " + powerset.size());
	}

	public static List<Set<Integer>> powerSet(List<Integer> list){
		List<Set<Integer>> p = new ArrayList<Set<Integer>>();
		Set s = new HashSet<Integer>();
		p.add(s);
		Set t = new HashSet<Integer>();
		Integer f;
		Set x;
		System.out.println(p);
		while(!list.isEmpty()){
			f = list.remove(0);
			
			int size = p.size();
			for(int i=0; i<size; i++){
				x=p.get(i);
				t=new HashSet<Integer>(x);
				t.add(f);
				p.add(t);
			}
			System.out.println(p);
		}
		
		return p;
	}
}
