package find;

public class Steps {
	
	public static void main(String[] args) {
		System.out.println(new Steps().heightChecker(new int[] {1,1,4,2,1,3}));
	}

	public int heightChecker(int[] heights) {
        int steps = 0;
        
        for(int i=0; i< heights.length; i++){
            
            int min = i;
            boolean found = false;
            for(int j=i+1; j<heights.length; j++){
                if(heights[j] < heights[min]){
                    min = j;
                    found = true;
                }
            }
            
            if(found){
                steps++;
                int temp = heights[min];
                System.arraycopy(heights, i, heights, i+1, min-i);
                heights[i] = temp;
            }
        }
        
        return steps;
    }
}
