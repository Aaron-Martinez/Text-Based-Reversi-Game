/**
 * This interface contains methods that board games should implement.
 * 
 * @author Aaron Martinez    <ajm21935@uga.edu>
 * @author Matt Butcher    <mab48671@uga.edu>
 *
 */
public interface Board {
    
	/**
	 * displays the board out to the user
	 */
    public void displayGrid(); 
    
    /**
     * creates the board that will be displayed to the user
     */
    public void createGrid(); 
    
    /**
     * checks to see what moves are legal for the player p
     * @param p
     * 		A player object.
     * @return
     * 		returns either true or false depending on whether a move
     * 		can be made or not.
     */
    public boolean legalMove(Player p); 
    
    /**
     * checks for game ending conditions and shows who won the game
     */
    public void gameOver(); 
    
}//Board