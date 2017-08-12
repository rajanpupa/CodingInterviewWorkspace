package stack;

import java.util.Stack;

/*
 * empty(): returns true if the stack is empty
 * peek():
 * pop():
 * push(E item):
 * search(Object o): returns 1 based position if object is in the stack
 */
public class BasicStack {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		
		System.out.print("stack = " + stack + ", top item = " + stack.peek()); // 3
		System.out.println(", adding 4");
		stack.push(4);
		
		System.out.println("empty()? = " + stack.empty()); // false;
		
		
		System.out.print("stack = " + stack + " , ");
		System.out.print("peek() = " + stack.peek() + ", ");
		System.out.print("search(2) = " + stack.search(2));
		System.out.println(", pop() = " + stack.pop());
	}
}
