package leetcode.matrix;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NumBoomerants {
	public static void main(String[] args) {
		int[][] points = {
				{0,0},
				{1,0},
				{2,0} // 2
		};
		
		int [][] points2 = {
			{0,0},{1,0},{-1,0},{0,1},{0,-1} // 20
		};
		
		System.out.println(
				new NumBoomerants().numberOfBoomerangs(points2)
		);
	}
	
	// wrong
	public int numberOfBoomerangs(int[][] points) {
		int count = 0;
        Set<Double> s = new HashSet<>();
        
        for(int i=0; i<points.length; i++){
            int x1 = points[i][0];
            int y1 = points[i][1];
            
            for(int j=i+1; j<points.length; j++){
                if(i==j) continue;
                int x2 = points[j][0];
                int y2 = points[j][1];
                double d = Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1,2));
                if(s.contains(d)){
                	System.out.printf("%d, %d \n", i, j);
                    count++;
                }else{
                    s.add(d);
                }
            }
        }
        return 2*count;
	}
	int[][] points;
	// correct answer but not so much optimized
	public int numberOfBoomerangs2(int[][] points) {
        int count = 0;
        this.points = points;
        
        for(int i=0; i<points.length; i++){
            
            int[] point1 = points[i];
            for(int j=0; j< points.length; j++){
            	
            	if(j == i) continue;
                
                int[] point2 = points[j];
                double dist1 = dist(i, j);
                for(int k=0; k<points.length; k++){
                	
                	if(k==i) continue;
                	if(k==j) continue;
                    
                    int[] point3 = points[k];
                    // if 3 is same distance as 1-2, count
                    
                    if( dist1 == dist(i, k)){
                    	System.out.printf("%d, %d, %d \n", i, j, k);
                        count ++;
                    }
                }
            }
            
        }
        
        return count;
    }
    
    Map<String, Double> distmap = new HashMap<>();
    private double dist(int i, int j){
    	int[] point1 = this.points[i];
    	int[] point2 = this.points[j];
    	
    	int k = i<j?i:j;
    	int l = i<j?j:i;
    	
    	String key = k + "-" + l;
    	
    	if(distmap.containsKey(key)) {
    		return distmap.get(key);
    	}
    	
    	//System.out.printf(" comparing %s and %s\n", atos(point1), atos(point2));
        Double distance = Math.sqrt( Math.pow(point1[0] - point2[0], 2)
                          + Math.pow(point1[1] - point2[1], 2)
                        );
        
        distmap.put(key, distance);
        return distance;
    }
    
    private String atos(int[] point) {
    	return String.format("{%s, %s}", point[0], point[1]);
    }
}
