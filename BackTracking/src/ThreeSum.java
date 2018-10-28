import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ThreeSum {
	
	public static void main(String[] args) {
		ThreeSum s = new ThreeSum();
		
		//System.out.println(s.threeSum(new int[]{-3,-4,-2,0,2,2,-2,1,-1,2,3,-1,-5,-4,-5,1}));
		
		System.out.println(s.hashThreeSum(new int[]{-1, 0, -1, 1, 2, 3}));
	}
	
	public List<List<Integer>> hashThreeSum(int[] nums){
		Arrays.sort(nums);
		List<List<Integer>> ll = new ArrayList<>();
		for(int i=0; i<nums.length-2;i++){
			if(i==0 || (i>0 && nums[i] != nums[i-1])){
				int lo = i+1;
				int hi = nums.length-1;
				
				ll.addAll( twoSum(nums, 0-nums[i] , lo, hi) );
					 
			}
			
		}
		
		return ll;
	}
	
	public List<List<Integer>> twoSum(int[] nums, int sum, int start, int end){
        Map<Integer, Integer> map = new HashMap<>();// value, index
        List<List<Integer>> lst = new ArrayList<>();
        
        for(int i=start; i<=end; i++){
            if( map.containsKey(sum-nums[i]) ){// sum present
                lst.add(Arrays.asList(nums[i], sum-nums[i], -sum));
                map.put(nums[i], i);
                while(i < end && nums[i] == nums[i+1]) i++;
            }else{
                map.put(nums[i], i);
            }
        }
        return lst;
    }
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
       // ans.add( new ArrayList<Integer>() );
        
        for(int i=0; i<nums.length-2; i++){
           
            int lo = i+1;
            int high = nums.length - 1;
            
            while(lo < high){
                if( nums[i] + nums[lo] + nums[high] == 0 ){
                    ans.add( Arrays.asList(nums[i], nums[lo], nums[high]) );
                    
                    while( lo  <= high && nums[lo] == nums[lo+1] ) lo++;
                    while( high >= lo && nums[high] == nums[high -1] ) high--;
                }
                if(nums[i] + nums[lo] + nums[high] > 0) high--;
                else lo++;
            }
        }
        
        return ans;
    }
}
