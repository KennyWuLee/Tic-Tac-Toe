import java.util.ArrayList;
import java.util.Random;

public class AI {
	
	char winningSeq[][] = Board.winningSeq;
	Random rand = new Random();
	
	public AI() {

	}
	
	public int possibleWin(char player, char[] board) {
		for (int i = 0; i < winningSeq.length; i++) {
			int setFileds = 0;
			int freeLoc = -1;
			for (int j = 0; j < winningSeq[0].length; j++) {
				if(board[winningSeq[i][j]] == player)
					setFileds++;
				else if(board[winningSeq[i][j]] == '_')
					freeLoc = winningSeq[i][j];
			}
			if(setFileds == 2 && freeLoc != -1)
				return freeLoc;
		}
		return -1;
	}
	
	public int move(char player, char[] board) {
		char opponent = 'X';
		if(player == 'X')
			opponent = 'O';
		//check if we can win this move
		int canWin = possibleWin(player, board);
		if(canWin != -1)
			return canWin;
		//check if opponent can win next move
		canWin = possibleWin(opponent, board);
		if(canWin != -1)
			return canWin;
		//random field otherwise
		ArrayList<Integer> freeLoc = new ArrayList<Integer>();
		for (int i = 0; i < board.length; i++)
			if(board[i] == '_')
				freeLoc.add(i);
		return freeLoc.get(rand.nextInt(freeLoc.size()));
	}
}
