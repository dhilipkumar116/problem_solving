package arrays;

public class NQueens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] board = new int[4][4];
		if(Nqueen(board,board.length,0)) {
			for(int i=0;i<board.length;i++) {
				for(int j=0;j<board.length;j++) {
					System.out.print(board[i][j]+" ");
				}
				System.out.println();
			}
		}

	}
	
	
	public static boolean Nqueen(int[][] board,int size,int row) {
		if(row==board.length) {
			return true;
		}
		
		for(int col=0;col<board.length;col++) {
			if(isValidPlace(board,row,col)) {
				board[row][col]=1;
				if(Nqueen(board,size,row+1)) return true;
				board[row][col]=0;
			}
			
		}
		
		return false;
	}
	
	public static boolean isValidPlace(int[][] board,int newRow,int newCol) {
		
		
		for(int i=0;i<board.length;i++) {
			if(board[i][newCol]==1) {
				return false;
			}
		}
		for(int i=newRow,j=newCol;i>=0&&j>=0;i--,j--) {
			if(board[i][j]==1) {
				return false;
			}
		}
		for(int i=newRow,j=newCol;i>=0&&j<board.length;i--,j++) {
			if(board[i][j]==1) {
				return false;
			}
		}
		
		return true;
	}

}
