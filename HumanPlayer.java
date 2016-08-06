import java.util.Scanner;

/**
 * This class represents a human player of the reversi game.
 * 
 * @author Aaron Martinez    <ajm21935@uga.edu>
 * @author Matt Butcher    <mab48671@uga.edu>
 *
 */
public class HumanPlayer extends Player {
	
    private int score; //The number of the players pieces on the board.

    /**
     * Constructs an object of the HumanPlayer class and sets its instance
     * variable score equal to 0.
     */
    public HumanPlayer(){
    	score = 0;
    }
   
    /**
     * Calls the prompt method
     * @return prompt()
     * 				A method that asks the human players for input.
     */
    @Override
    public String move() {
    	return prompt();
    }
    
    /**
     * Parses through the user input and sets the first two integers 
     * to the row and column variables respectively. Then it checks for additional input
     * and whether input is out of bounds.
     * 
     * @return "" + row + " " +column
     * 					This is a string that contains the row, a space, and
     * 					then the column.
     */
    public String prompt() {

		int row = 0;
		int column = 0;
	
		System.out.print("Enter your move, " + myPiece + " player: ");
	
		Scanner keyboard = new Scanner(System.in);
		String input = keyboard.nextLine();
		Scanner parseInput = new Scanner(input);
		
		if(parseInput.hasNextInt()) {
			row = parseInput.nextInt();
		    if(parseInput.hasNextInt()) {
		    	column = parseInput.nextInt();
		    	if(parseInput.hasNext()) {
				    System.out.println("Invalid input: Moves should be entered in [row] [column] format. Please try again\n");
				    return "null";
		    	}
				if(row < 1 || row > 8 || column < 1 || column > 8) {
				    System.out.println("Row/column entered is out of bounds. Please try again with only numbers 1-8\n");
				    return "null";
				}//if
				
		    }//if
	
		    else {
			System.out.println("Invalid input: Moves should be entered in [row] [column] format. Please try again\n");
			return "null";
		    }//else
	
		}//if
	
		else {
		    System.out.println("Invalid input: Moves should be entered in [row] [column] format. Please try again\n");
		    return "null";
		}//else

		return "" + row + " " +column;
		
    }//prompt

}
