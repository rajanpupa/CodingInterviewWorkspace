package bit.negation;

import bit.util.BitDisplayHelper;

public class Invert {
	
	public static void main(String[] args) {
		Invert inv = new Invert();
		
		System.out.println( inv.invert(0) + " -> " + BitDisplayHelper.abc(inv.invert(0)) );
	}

	public int invert(int num){
		return ~num;
	}
}
