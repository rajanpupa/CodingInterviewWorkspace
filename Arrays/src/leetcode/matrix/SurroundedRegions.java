package leetcode.matrix;

public class SurroundedRegions {
	
	public static void main(String[] args) {
		char[][] board1 = {
				{'X','X','X','X'},
				{'X','O','O','X'},
				{'X','X','O','X'},
				{'X','O','X','X'}
		};
		
		char[][] board2 = {
				{'O','X','X','O', 'X'},
				{'X','O','O','X', 'O'},
				{'X','O','X','O', 'X'},
				{'O','X','O','O', 'O'},
				{'X','X','O','X', 'O'}
		};
		
		char[][] board = board2;
		System.out.println("---------------before------------------");
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[0].length; j++) {
				System.out.printf("%s\t", board[i][j]);
			}
			System.out.println();
		}
		
		new SurroundedRegions().solve(board);
		System.out.println("------------After--------------");
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[0].length; j++) {
				System.out.printf("%s\t", board[i][j]);
			}
			System.out.println();
		}
	}
	
	public void solve(char[][] board) {
		if(board == null) return;
		if(board.length <= 0) return;
		
		for (int i = 1; i < board.length - 1; i++) {
			for (int j = 1; j < board[0].length - 1; j++) {
				if(!check(board, i, j)) {
					board[i][j] = 'X';
				}
			}
		}
		
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[0].length; j++) {
				char c = board[i][j];
				
				//if(c == '1') board[i][j] = 'X';
				if(c == '2') board[i][j] = 'X';
				if(c == '3') board[i][j] = 'O';
			}
		}
	}

	private boolean check(char[][] board, int i, int j) {
		if(board[i][j] == 'X') return false;
		
		if(this.eval(board, i, j)) {
			return true;
		}
		if(this.eval(board, i+1, j)){
			return true;
		}
		if(this.eval(board, i-1, j)){
			return true;
		}
		if(this.eval(board, i, j+1)){
			return true;
		}
		if(this.eval(board, i, j-1)){
			return true;
		}
		
		return false;
	}
	// call check if not already visited
	// returns true or false if already visited
	private boolean eval(char[][] board, int i,int j) {
		if(i==4 && j==4) {
			System.out.println('a');
		}
		if(!isValidIndex(board, i, j)) return false;
		
		if (isborder(board, i, j)) {
			if (board[i][j] == 'O') return true;
			return false;
		}
		
		char c = board[i][j];
		if(c == 'X') return false;
		
		if(c == 'O') {
			board[i][j] = '1';
			
			boolean result = this.check(board, i, j);
			if(result) {
				board[i][j] = '3';
			}else {
				board[i][j] = '2';
			}
			return result;
		}
		
		if(c == '1') return false; // under evaluation
		if(c == '2') return false; // found negative oed
		if(c == '3') return true;  // found positive oed

		return false;
	}
	
	private boolean isValidIndex(char[][] board, int i, int j) {
		if (i >= board.length || j >= board[0].length)
			return false;
		if (i < 0 || j < 0)
			return false;
		
		return true;
	}

	private boolean isborder(char[][] board, int i, int j) {
		return i==0 || j==0 || i== board.length || j==board.length;
	}
}
