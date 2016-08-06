import java.util.Scanner;

/**
 * This class represents a Player of the reversi game.
 * 
 * @author Aaron Martinez    <ajm21935@uga.edu>
 * @author Matt Butcher    <mab48671@uga.edu>
 *
 */
public abstract class Player {

    protected int score; //The total number of game pieces on the board
    protected char myPiece; //An X or O depending on the player
    protected char opponentsPiece; //The opposite of myPiece    

    /**
     * The purpose of this method is to be overridden by each type
     * of player in a different manner.
     * @return String
     * 				This string contains the indices of the move
     * 				that the player wishes to do.
     */
    public abstract String move();
	    
	/**
	 * Sets the instance variable myPiece to the value passed in as the
	 * parameter.
	 * @param piece
	 * 			Either an O or X depending on the player using the method.
	 */
    public void setMyPiece(char piece) {
    	myPiece = piece;
    	opponentsPiece = ' ';
    	if(myPiece == 'X')
    		opponentsPiece = 'O';
    	else
    		opponentsPiece = 'X';
    }
    
    /**
     * Returns the instance variable myPiece of the player using the method.
     * @return myPiece
     * 			An instance variable that is either a O or X.
     */
    public char getMyPiece() {
    	return myPiece;
    }
    
    /**
     * Returns the instance variable opponentsPiece of the player using the method.
     * @return opponentsPiece
     * 			An instance variable that is either a O or X.
     */
    public char getOpponentsPiece() {
    	return opponentsPiece;
    }
    
    /**
     * Retrieves the value of the instance variable score.
     * @return score
     * 			The number of a player's game pieces on the board.
     */
    public int getScore() {
    	return score;
    }
    
    /**
     * Sets the value of the instance variable score.
     * @param score
     * 			The number of a player's game pieces on the board.
     */
    public void setScore(int score) {
    	this.score = score;
    }

}