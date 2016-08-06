import java.util.Random;

/**
 * This class represents a computer player of the reversi game that chooses random moves.
 * 
 * @author Aaron Martinez    <ajm21935@uga.edu>
 * @author Matt Butcher    <mab48671@uga.edu>
 *
 */
public class RandomComputerPlayer extends ComputerPlayer {

	private ReversiBoard board; //An instance of the ReversiBoard class.
	
	
	/**
	 * Constructs a new RandomComputerPlayer object and sets ReversiBoard game
	 * equal to its instance variable board.
	 * @param game
	 * 				An instance of the ReversiBoard class. 
	 */
    public RandomComputerPlayer(ReversiBoard game) {
    	board = game;
    }

    /**
     * Returns the return value of the randomChoice method (defined in this class).
     * @return randomChoice()
     * 					A method that returns a random legal move
     */
    public String move() {
    	return(randomChoice());
    }
    
    /**
     * Runs through the legal moves and selects a random one.
     * @return move
     * 			A string containing the indices of the random choice.
     */
    public String randomChoice() {
	
    	delay();
    	String move = "";
    	Random r = new Random();
    	int numMoves = 0;
    	int count = 0;
    	
    	for(int m = 0; m < 8; m++) {
		    for(int n = 0; n < 8; n++) {
		    	if(board.getGridDisplay()[m][n] == '_') {
		    		numMoves++;		    		
		    	}		    		
		    }  
    	}//for
    	
    	String[] choices = new String[numMoves];
    	
    	for(int m = 0; m < 8; m++) {
		    for(int n = 0; n < 8; n++) {
		    	if(board.getGridDisplay()[m][n] == '_') {
		    		choices[count] = "" + (m + 1) + " " + (n + 1);
		    		count++;
		    	}//if		    		
		    }//for
    	}//for
    	
    	int randomMove = r.nextInt(numMoves);
    	move = choices[randomMove];
    	return move;
    	
    }//randomChoice()

}//RandomComputerPlayer

//ALGORITHM: 	
//look through moves gridDisplay[row][col]
//make a String array of all "" + row + " " + col ""; that work
//generate a random number between 1 and array.length
//move = random number - 1