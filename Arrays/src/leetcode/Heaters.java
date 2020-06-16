package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

// 475
public class Heaters {

    // this solution is correct but not so much efficient
	public static int findRadius(int[] houses, int[] heaters) {
        int minrad =1;
        List<Integer> l = Arrays.stream(houses)
        		.boxed()
        		.collect(Collectors.toList());
        Set<Integer> s = new HashSet<>(l);
        Set<Integer> hi = new HashSet<>();
        while(hi.size() != s.size()){
            hi.clear();
            
            for(int i: heaters){
                for(int j= i-minrad; j<= i+minrad; j++){
                    if(s.contains(j)){
                        hi.add(j);
                    }
                }
            }
            minrad ++;
        }
        return minrad -1;
    }

    public static int findRadius2(int[] houses, int[] heaters) {
        if(houses == null ) return 0;

        TreeSet<Integer> ts = new TreeSet<>();
        for(int heater: heaters) ts.add(heater);
        
        int max = 0;
        for(int house: houses){

            Integer leftheater = ts.floor(house);
            Integer rightheater = ts.ceiling(house);

            Integer left = 0;
            Integer right = 0;
            if(leftheater == null){
                left = Integer.MAX_VALUE;
            }else{
                left = house - leftheater;
            }

            if(rightheater == null){
                right = Integer.MAX_VALUE;
            }else{
                right = rightheater - house;
            }

            max = Math.max(max, Math.min(left, right));
        }

        return max;
    }

    public static void main(String[] args) {
        int [] houses = {1,2,3};
        int [] heaters = {2};
        System.out.println(findRadius2(houses, heaters));
    }
}
