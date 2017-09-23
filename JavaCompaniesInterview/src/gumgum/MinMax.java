package gumgum;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MinMax {
	static long[] maxMin(String[] operations, int[] x){
		int len = operations.length;
		
		LinkedList<Integer> min = new LinkedList<>();
		LinkedList<Integer> max = new LinkedList<>();
		min.add(x[0]);
		max.add(x[0]);
		
		List<Long> ll = new ArrayList<>();
		
		for(int i=0; i<len; i++){
			int next = x[i];
			if("push".equals(operations[i])){
				if(next < min.getLast()){
					min.addLast(next);
				}else if(next > max.getLast()){
					max.addLast(next);
				}
			}else{// pop
				if(next == min.getLast()){
					min.removeLast();
				}else if(next == max.getLast()){
					max.remove();
				}
			}
			
			ll.add( Long.valueOf(min.getLast()) * Long.valueOf(max.getLast()) );
			
		}
		long[] la = new long[ll.size()];
		
		for(int i=0;i<ll.size(); i++)la[i] = ll.get(i);
		
		return la;
	}
}
