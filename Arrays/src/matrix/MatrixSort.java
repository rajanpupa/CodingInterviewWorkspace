package matrix;

public class MatrixSort {

	public static void main(String[] args) {
		//test1();
		
		int[][] mat = {
				{1,2,3},
				{4,6,5},
				{9,8,7},
				{10, 22, 44, 66}
			};
		int[] r = {1};
		int[] c = {1};
		
		int [][] del = constructSubmatrix(mat, r,c);
		
		System.out.println(del);
	}

	private static void test1() {
		int[][] mat = {
						{1,2,3},
						{4,6,5},
						{9,8,7},
						{10, 22, 44, 66}
					};
		
		System.out.println( " rows = " + mat.length);//
		System.out.println(" cols = " + mat[0].length);
		
		System.out.println("(0,0) => " + mat[0][0]);
		
		for(int row = 0; row < mat.length; row++){
			for(int col = 0; col < mat[row].length; col++){
				System.out.printf("%d \t", mat[row][col]);
			}
			System.out.println();
		}
	}
	
	static int[][] constructSubmatrix(int[][] matrix, int[] rowsToDelete, int[] columnsToDelete) {
	    if(matrix == null ) return matrix;
	    
	    int rows = matrix.length;
	    int cols = matrix[0].length;
	    
	    int newrows = rows - rowsToDelete.length;
	    int newcols = cols - columnsToDelete.length;
	    
	    if(newrows == 0 || newcols==0) return new int[0][0];
	    
	    int[] rtdset = new int[rows];
	    for(int i : rowsToDelete) rtdset[i]=1;
	    
	    int[] ctdset = new int[cols];
	    for(int i: columnsToDelete) ctdset[i]=1;
	    
	    int[][] ans= new int[newrows][newcols];
	    
	    int rtemp=0;
	    for(int row = 0; row < rows; row++){
	        
	        int ctemp=0;
	        
	        if(rtdset[row]!=1){
		        for(int col = 0; col <cols; col++){
		            if(ctdset[col]!=1){
		                ans[rtemp][ctemp++] = matrix[row][col];
		            }
		        }
		        rtemp++;
	        }
	    }
	    
	    return ans;
	}
}
