package leetcode;

import java.util.HashMap;
import java.util.Map;

public class PrisonCellAfterNDays {
	
	public static void main(String[] args) {
		
				print(prisonAfterNDays(new int[] {0,1,0,1,1,0,0,1}, 7)); // 0, 0, 1, 1, 0, 0, 0, 0
				
				print(prisonAfterNDays(new int[] {1,0,0,1,0,0,1,0}, 1000000000)); // 0,0,1,1,1,1,1,0
				
	}
	
	public static int[] prisonAfterNDays(int[] cells, int N) {
        if(N == 0) return cells;
        Map<Integer, Integer> m = new HashMap<>(); // state, day
        Map<Integer, int[]> m2 = new HashMap<>();// day, state
        
        int[] copy2 = cells.clone();
        int day = 0;
        while(day < N){
            Integer k = key(copy2);
            if(m.get(k) != null){
                int dayRemaining = N - day;
                int found = m.get(k);// of the this state
                dayRemaining %= (day-found); // actual remaining days
                return m2.get(found + dayRemaining);
            }else{
                m.put(k, day);
                m2.put(day, copy2);
            }
            
            copy2 = transform(copy2);
            day ++;
            
        }
        return copy2;
    }
    
    private static int[] transform(int[] arr){
        int[] arr2 = new int[arr.length];
        for(int i=1; i<7; i++){
            if( arr[i-1] == arr[i+1]){
                arr2[i] = 1;
            }
        }
        arr2[0] = 0;
        arr2[7] = 0;
        
        return arr2;
    }
    
    private static Integer key(int[] arr){
        int ans = 0;
        for(int i=0; i< arr.length; i++){
            if(arr[i] ==1 ){
                ans += Math.pow(2, i);
            }
        }
        
        return ans;
    }

    private static void print(int[] arr){
        System.out.print('[');
        
        for(int i: arr){
            System.out.printf("%s,", i);
        }
        System.out.print("]\n");
    }
}
