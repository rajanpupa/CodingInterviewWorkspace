package leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

// VVI calculator
// 
public class CalcII {
	List<Character> signs = Arrays.asList('+', '-', '*', '/');

    public Integer calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        
        int num = 0;
        char op = '+';
        // parse
        for(char c: (s + '+').toCharArray()){
            if(c == ' ') continue;
            if(Character.isDigit(c)) {
            	num = num * 10 + c-'0';
            }
            else {
            	if(op == '+') {
            		stack.push(num);
            	}else if(op == '-') {
            		stack.push(-num);
            	}else if(op == '*') {
            		stack.push(stack.pop() * num);
            	}else if(op == '/') {
            		stack.push(stack.pop() / num);
            	}
            	num = 0;
            	op = c;
            }
        }
        
        Integer result = 0;
        while(!stack.isEmpty()) {
        	result += stack.pop();
        }
		return result;
    }
    
    private boolean isNum(String s){
        try {
        	Integer.valueOf(s);
        	return true;
        }catch(NumberFormatException e) {
        	return false;
        }
    }

    public static void main(String[] args) {
		System.out.println(new CalcII().calculate("3+2*2")); // 7
		System.out.println(new CalcII().calculate("3+5 / 2")); // 5
	}
}

