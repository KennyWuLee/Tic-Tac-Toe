import java.util.Arrays;

public class Board {
	
	private char board[] = { '_', '_', '_', '_', '_', '_', '_', '_', '_'};
	static char winningSeq[][] = {
			{0, 1, 2},
			{3, 4, 5},
			{6, 7, 8},
			{0, 3, 6},
			{1, 4, 7},
			{2, 5, 8},
			{0, 4, 8},
			{2, 4, 6}
	};
	
	public Board() {
		
	}
	
	public boolean isEmpty(int i) {
		return i >= 0 && i  < 9 && board[i] == '_';
	}
	
	public void clearBoard() {
		for (int i = 0; i < board.length; i++) {
			board[i] = '_';
		}
	}
	
	public char[] getBoard() {
		return Arrays.copyOf(board, board.length);
	}
	
	public void set(char player, int location) {
		if(isEmpty(location))	
			board[location] = player;
 	}
	
	public void print() {
		for(int i=0; i<9;) {
			for(int j=0; j<3; j++,i++)
				System.out.print(board[i]+" ");
			System.out.println();
		}
	}
	
	public boolean isOver() {
		return isFull() || isWinner('X') || isWinner('O');
	}
	
	public boolean isFull() {
		for (int i = 0; i < board.length; i++)
			if(board[i] == '_')
				return false;
		return true;
	}
	
	public boolean isWinner(char player) {
		for (int i = 0; i < winningSeq.length; i++) {
			boolean won = true;
			for (int j = 0; j < winningSeq[0].length; j++)
				won = won && (board[winningSeq[i][j]] == player);
			if(won)
				return true;
		}
		return false;
	}
	
}
