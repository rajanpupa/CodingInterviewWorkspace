package stack;

import java.util.ArrayList;
import java.util.List;

/*
 * push the min also everytime a new element is being added which is less than min
 * when popping, check if being popped elem is = min, then pop once again and assign to min
 */
public class StackWithMin {
	
	public static void main(String[] args) {
		StackWithMin swm = new StackWithMin();
		
		swm.push(5);
		swm.push(4);
		swm.push(10);
		swm.push(1);
		
		System.out.println("min = " + swm.min());
		
		swm.pop();
		System.out.println("min = " + swm.min());
	}

	List<Integer> lst = new ArrayList<>();
	int min = Integer.MAX_VALUE;
	
	public void push (int i){
		if(i<min){
			lst.add(min);
			lst.add(i);
			min = i;
		}else{
			lst.add(i);
		}
	}
	
	public int pop(){
		int i = lst.remove(lst.size()-1);
		if(i<=min){
			min = lst.remove(lst.size()-1);
		}
		return i;
	}
	
	public int peek(){
		return lst.get(lst.size()-1);
	}
	
	public int min(){
		return min;
	}
}
