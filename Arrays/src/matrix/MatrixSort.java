package matrix;

public class MatrixSort {

	public static void main(String[] args) {
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
}
