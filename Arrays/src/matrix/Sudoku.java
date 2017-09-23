package matrix;

import java.util.HashSet;
import java.util.Set;

public class Sudoku {
	
	public static void main(String[] args) {
		char[][] grid={{'.', '.', '.', '1', '4', '.', '.', '2', '.'},
		          {'.', '.', '6', '.', '.', '.', '.', '.', '.'},
		          {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
		          {'.', '.', '1', '.', '.', '.', '.', '.', '.'},
		          {'.', '6', '7', '.', '.', '.', '.', '.', '9'},
		          {'.', '.', '.', '.', '.', '.', '8', '1', '.'},
		          {'.', '3', '.', '.', '.', '.', '.', '.', '6'},
		          {'.', '.', '.', '.', '.', '7', '.','.', '.'} ,
		          {'.', '.', '.', '5', '.', '.', '.', '7', '.'}};
		
		System.out.println(sudoku2(grid));
	}

	static boolean sudoku2(char[][] grid) {
		
	    Set<Character> domain = new HashSet<Character>(){
	        {
	            add('1');
	            add('2');
	            add('3');
	            add('4');
	            add('5');
	            add('6');
	            add('7');
	            add('8');
	            add('9');
	        }
	    };
	    
	    Set<Character> rs = new HashSet<>();
	    Set<Character> cs = new HashSet<>();
	    
	    for(int i=0; i<9; i++){
	        
	        rs.clear();
	        cs.clear();
	        for(int j=0; j<9; j++){
	            if(   ( domain.contains(grid[i][j]) && rs.contains(grid[i][j]) )
	               || ( domain.contains(grid[j][i]) && cs.contains(grid[j][i]) )
	              ){
	                return false;
	            }
	            else{
	                if ( domain.contains(grid[i][j]) ) rs.add(grid[i][j]);
	                if ( domain.contains(grid[j][i]) ) cs.add(grid[j][i]);
	            }
	            
	        }
	    }
	    
	    
	    for(int i=0; i<=6; i+=3){
	        for(int j=0; i<=6; j+=3){
	            rs.clear();
	            System.out.printf("running for %d, %d\n",i, j);
	            for(int k=i; k < (i+3); k++){
	                for(int l=j; l < (j+3); l++){
	                    if( rs.contains( grid[k][l] ) ) return false;
	                    else{
	                        if( domain.contains(grid[k][l]) ) rs.add(grid[k][l]);
	                    }
	                }
	            }
	        }
	    }
	    
	    return true;

	}
}
