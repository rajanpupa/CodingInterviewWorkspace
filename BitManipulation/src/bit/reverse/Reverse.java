package bit.reverse;

import bit.util.BitDisplayHelper;
import bit.util.DefaultExample;

public class Reverse {
	public static void main(String[] args) {
		String input = "11111111111111111111111111111101";
		
		System.out.println(
				BitDisplayHelper.abc(
						reverseBits(DefaultExample.to32IntFromBinary(input))
				)
		);
		
	}

	public static int reverseBits(int n) {
        int ans = 0;
        int mask = 1;
        for(int i=0; i<16; i++){
            int shift = 31 - 2*i;
            int nmask = n&mask;
            int shifted = nmask << shift;
            ans |= shifted;
            mask = mask<<1;
        }
        System.out.println(BitDisplayHelper.abc(ans));
        for(int i=16; i<31; i++){
            int shift = 2*i -31;
            int nmask = n&mask; // ith bit
            int shifted = nmask >>> shift;
            
            
            ans |= shifted;
            
            mask = mask<<1;
        }
        return ans;
        
    }
}
