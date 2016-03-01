import java.util.Scanner;
public class HumanPlayer extends Player {
	
    private int score = 0;

    public HumanPlayer(){

    }

    
	
    
    
    public void prompt() {

	int row;
	int column;

	System.out.println("Enter your move, " + myPiece + " player: ");

	Scanner keyboard = new Scanner(System.in);
	String input = keyboard.nextLine();
	Scanner parseInput = new Scanner(input);
	
	if(parseInput.hasNextInt()) {
		row = parseInput.nextInt();
	    if(parseInput.hasNextInt()) {
	    	column = parseInput.nextInt();
		if(row < 1 || row > 8 || column < 1 || column > 8) {
		    System.out.println("Row/column entered is out of bounds. Please try again with only numbers 1-8");
		    prompt();
		}
		move(row, column);
	    }//if

	    else {
		System.out.println("Invalid input: Moves should be entered in [row] [column] format. Please try again");
		prompt();
	    }//else

	}//if

	else {
	    System.out.println("Invalid input: Moves should be entered in [row] [column] format. Please try again");
	    prompt();
	}//else

    }//prompt

}
