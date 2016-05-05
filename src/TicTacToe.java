import java.io.IOException;
import java.util.Hashtable;
import java.util.Scanner;

public class TicTacToe {
	
	Scanner scan = new Scanner(System.in);
	Board board = new Board();
	AI ai = new AI();
	Hashtable<Character, Boolean> isAI = new Hashtable<Character, Boolean>();
	
	public TicTacToe() {
		
	}
	
	public void game() throws InterruptedException, IOException {
		board.clearBoard();
		output();
		char turn = 'X';
		while(! board.isOver()) {
			if(isAI.get(turn)) {
				Thread.sleep(1000);
				int move = ai.move(turn, board.getBoard());
				board.set(turn, move);
			} else {
				int selection = getInput(turn);
				board.set(turn, selection);
			}
			output();
			turn = (turn=='X')?'O':'X';
		}
		if(board.isWinner('X'))
			System.out.println("X won !");
		else if(board.isWinner('O'))
			System.out.println("O won !");
		else
			System.out.println("draw !");
		Thread.sleep(2000);
	}
	
	public void start() throws InterruptedException, IOException {
		int games = askHowManyGames();
		isAI.put('X', askIfAI('X'));
		isAI.put('O', askIfAI('O'));
		for (int i = 0; i < games; i++)
			game();
	}
	
	public int askHowManyGames() {
		System.out.print("How many games? ");
		int games = scan.nextInt();
		scan.nextLine();
		return games;
	}
	
	public int getInput(char player) {
		int selection = -1;
		while(! board.isEmpty(selection)) {
			System.out.print("Enter position for " + player + ": ");
			selection = scan.nextInt();
			scan.nextLine();
		}
		return selection;
	}
	
	public boolean askIfAI(char player) {
		char selection = '-';
		while(selection != 'y' && selection != 'n') {
			System.out.print("Is " + player + " AI?(y/n)");
			selection = scan.nextLine().charAt(0);
		}
		if(selection == 'y')
			return true;
		return false;
	}
	
	public void output() throws InterruptedException, IOException {
        //new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		board.print();
	}

	public static void main(String[] args) {
		try {
			TicTacToe t = new TicTacToe();
			t.start();
		} catch (Exception e) {
			System.out.println("Error!");
			e.printStackTrace();
		}
	}

}
