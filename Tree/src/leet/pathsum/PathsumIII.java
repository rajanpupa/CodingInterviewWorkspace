package leet.pathsum;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import leet.Node;
// 437
// right solution
public class PathsumIII {
	public static void main(String[] args) {
		Integer[] arrtree1 = {10,5,-3,3,2,null,11,3,-2,null,1};// 8, 3
		Integer[] arrtree2 = {1,2}; // 4, 0
		// not working for this scenario
		Integer[] arrtree3 = {0,1,1}; // 1, 4
		
		Integer[] arr = arrtree3;
		Node root = Node.construct(arr);
		//System.out.println(new PathsumIII().pathSum(root, 4)); // 0
		System.out.println(new PathsumIII().pathSum(root, 1));// 4
	}
	
	List<Integer> curpath = new ArrayList<>();
	int count = 0;
	
	public int pathSum(Node root, int sum) {
        if(root == null) return 0;
        
        this.backtrack(root, sum);
        return count;
    }

	private void backtrack(Node root, int sum) {
		if(root == null) return;
		if(root.val == sum) count++;

		// check sum from this path to up, if it equals sum
		int lsum = root.val;
		for(int i = curpath.size()-1; i>=0; i--) {
			lsum += curpath.get(i);
			if(lsum == sum) count++;
		}
		// add this node to the visited
		curpath.add(root.val);
		
		backtrack(root.left, sum);
		backtrack(root.right, sum);
		
		// deleted this node from the visited
		curpath.remove(curpath.size()-1);
	}
	
	
}

class WrongSolution{
	public int pathSum(Node root, int sum) {
        if(root == null) return 0;
        List<Integer> set = new ArrayList<>();
        set.add(sum);
        //set.add(sum-root.val);
        return this.pathsum(root, set);
    }
    
    private int pathsum(Node root, List<Integer> sumstofind){
        if(root == null) return 0;
        if(sumstofind.size() < 1) return 0;
        if(root.left == null && root.right == null) {
        	if(!sumstofind.contains(root.val)) {
        		return 0;
        	}else {
        		return sumstofind.stream()
        				.filter(a -> a == root.val)
        				.collect(Collectors.toList()).size();
        	}
        }
        
        int count = 0;
        
        if(sumstofind.contains(root.val)) {
        	count ++;
        }
        else {
            List<Integer> additional = new ArrayList();
        	for(Integer i: sumstofind) {
        		Integer extra = i - root.val;
        		//if( !sumstofind.contains(extra) ) {
        			additional.add(extra);
        	//	}
        	}
        	sumstofind.addAll(additional);
            
            //sumstofind.add(extra);
            count += this.pathsum(root.left, sumstofind);
            count += this.pathsum(root.right, sumstofind);
            
            for(Integer i: additional) {
        		sumstofind.remove(i);
        	}
        }
        return count;
        
    }
}
