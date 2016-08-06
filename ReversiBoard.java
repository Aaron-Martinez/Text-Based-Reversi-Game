import java.util.Scanner;

/**
 * This class represents a Reversi (othello) game.
 * 
 * @author Aaron Martinez    <ajm21935@uga.edu>
 * @author Matt Butcher    <mab48671@uga.edu>
 *
 */
public class ReversiBoard implements Board {

    private char[][] gridDisplay;	//the grid that will be displayed to the user
    private Player p1;				
    private Player p2;
    private int rounds = 0;			//number of rounds (each player moving once) that has passed
    
    /**
     * Constructs an instance of the ReversiBoard that will be the object in which the game is played
     */
    public ReversiBoard() {
	//call methods to create human or computer players
    }
	
    /**
     * Returns the gridDisplay instance of a ReversiBoard object
     * @return gridDisplay
     * 				The board that gets printed out for users to see
     */
	public char[][] getGridDisplay() { 
		return gridDisplay;
	}
	
	/**
	 * Updates/sets the gridDisplay instance of ReversiBoard
	 * @param replacement
	 * 				A 2D char array that stores the values of each square to be printed out to the users
	 */
	public void setGridDisplay(char[][] replacement) { 
		gridDisplay = replacement;
	}
	
	/**
	 * Returns the p1 instance of a ReversiBoard object
	 * @return p1
	 * 				The 'X' player in the Reversi game
	 */
	public Player getP1() {
		return p1;
	}
	
	/**
	 * Returns the p2 instance of a ReversiBoard object
	 * @return p2
	 * 				The 'O' player in the Reversi game
	 */
	public Player getP2() {
		return p2;
	}
    
	/**
	 * Sets the myPiece instance of the player. Player 1's piece is 'X'
	 * @param player1
	 * 				The 'X' Player in the Reversi game
	 */
    public void setP1(Player player1) {
    	player1.setMyPiece('X');
    	p1 = player1;		
    }
    
    /**
	 * Sets the myPiece instance of the player. Player 2's piece is 'O'
	 * @param player1
	 * 				The 'O' Player in the Reversi game
	 */
    public void setP2(Player player2) {
    	player2.setMyPiece('O');
    	p2 = player2;    	
    }
    
    /**
     * Returns the rounds instance of a reversiBoard object
     * @return rounds
     * 				The number of rounds that have passed in the Reversi game
     */
    public int getRounds() {
    	return rounds;
    }
  
    /**
     * This method prints the game board out to the user so they can see. 
     */
    public void displayGrid() {
    	boolean firstCol = true;
    	System.out.println("  1 2 3 4 5 6 7 8");
    	
    	for (int m = 0; m < 8; m++) {

			firstCol = true;

			for (int n = 0; n < 8; n++) {

				if (firstCol) {
					System.out.print("" + (m + 1));
					firstCol = false;

				}// if

				System.out.print(" " + gridDisplay[m][n]);
			}//for n
			
    	System.out.println();
    	
    	}//for m
    	
    	System.out.println();
    	
    	//print the game board out
    }

    /**
     * Prints a welcome message to the user and creates a 2D char array that will be printed out to the user.
     */
    public void intro() {
	createGrid();
	System.out.println("Welcome to Reversi! Moves should be entered in \"[row] [column]\" format.\n");
	}   

    /**
     * Player1Turn and Player2Turn are both methods that run in a loop until the game is won by one player. If Player 1
     * has no moves, the turn is passed to player 2 by calling Player2Turn(). If both players have no moves, the game is
     * over and the winner is decided by counting each players pieces on the board and comparing them.
     */
    public void player1Turn() {
    	
    	legalMove(p1);
    	displayGrid();
    	boolean hasMoves = legalMove(p1);
    	if(hasMoves) {
			String move = p1.move();
			if(move.equals("null")) {
				player1Turn();
				return;
			}//if
			flip(move, p1);
    	}//if
    	else {
    		if(!legalMove(p2)) 
    			gameOver();
    		System.out.println("No moves available. Passed to \'O\' Player.\n");
    	}
    	System.out.println();
    }
    
    /**
     * Player1Turn and Player2Turn are both methods that run in a loop until the game is won by one player. If Player 1
     * has no moves, the turn is passed to player 1 by calling Player1Turn(). If both players have no moves, the game is
     * over and the winner is decided by counting each players pieces on the board and comparing them.
     */
    public void player2Turn() {
   
		legalMove(p2);
    	displayGrid();
    	boolean hasMoves = legalMove(p2);
    	if(hasMoves) {
    		String move = p2.move();
    		if(move.equals("null")) {
    			player2Turn();
    			return;
    		}//if
			flip(move, p2);
    	}//if
    	else {
    		if(!legalMove(p1))
    			gameOver();
    		System.out.println("No moves available. Passed to \'X\' Player.\n");
    	}
    	System.out.println();
    }//player2Turn()

    /**
     * This method first calls the intro() method to set up the board display that will be printed to the user.
     * Then it uses an infinite loop that has each player taking turns moving until the game is over by calling 
     * player1Turn() and player2Turn()
     */
    public void run(){
    	intro();
    	while(true){
    	player1Turn();
    	player2Turn();
    	rounds++;
    	}
    }
    
    /**
     * This method sets up the 2D char array that will store the value of each square to be printed out to the user
     * of the program each round. It starts off as the starting position with 2 'X's and 2 'O's in the center of the
     * board, and assigns this to the instance variable gridDisplay.
     */
    public void createGrid() {
    	gridDisplay = new char[8][8];
    	for(int i = 0; i < 8; i++) {
    		for(int j = 0; j < 8; j++) {
    			gridDisplay[i][j] = '.';
    		}//for j
    	}//for i
    	    	
    	gridDisplay[3][3] = 'X';
    	gridDisplay[3][4] = 'O';
    	gridDisplay[4][3] = 'O';
    	gridDisplay[4][4] = 'X';
    	
    	legalMove(p1);
    	
    }//createGrid()
    
    /**
     * When neither player can make a move, this method is called and evaluates the winner by counting each player's
     * pieces on the board. If player 1 or player 2 has more pieces than the other, they are the winner. If it is a tie,
     * the game declares the game as a tie. In all situations the program is ended after this.
     */
    public void gameOver() {
    	int p1Score = 0;
    	int p2Score = 0;
    	
    	for(int i = 0; i < 8; i++) {
		    for(int j = 0; j < 8; j++) {
		    	if(gridDisplay[i][j] == p1.getMyPiece()) {
		    		p1Score++;
		    	}
		    	else if(gridDisplay[i][j] == p2.getMyPiece()) {
		    		p2Score++;
		    	}
		    }//for
    	}//for
    	System.out.println("Game over!");
    	System.out.println("Player \'X\' score: " + p1Score);
    	System.out.println("Player \'O\' score: " + p2Score);
    	if(p1Score > p2Score) {
    		System.out.println("Player \'X\' wins!");
    	}
    	else if(p1Score < p2Score) {
    		System.out.println("Player \'O\' wins!");
    	}
    	else if(p1Score == p2Score) {
    		System.out.println("Tie game!");
    	}
    	System.exit(0);
    }//gameOver()
    
    /**
     * When a player chooses their move, this method takes it in as a parameter and flips the correct
     * tiles based on the location of the parameter p pieces and opponents pieces.
     * @param s
     * 			The string representing the move the player wants to play in "[row] [col]" format
     * @param p
     * 			The player that is making the move so this method knows which pieces to flip
     */
    public void flip(String s, Player p) {
    	
    	Scanner move = new Scanner(s);
    	int row = move.nextInt() - 1;
    	int col = move.nextInt() - 1;
    	
    	if(gridDisplay[row][col] != '_') {
    		System.out.println("This move is not legal. The legal moves are marked with an \"_\".");
    		if(p.myPiece == 'X') {
    			player1Turn();
    			return;
    		}
    		else if(p.myPiece == 'O') {
    			player2Turn();	
    			return;
    		}  	
    	}
    	
    	boolean right = checkRight(row, col, p);
    	boolean left = checkLeft(row, col, p);
    	boolean up = checkUp(row, col, p);
    	boolean down = checkDown(row, col, p);
    	boolean upRight = checkUpRight(row, col, p);
    	boolean upLeft = checkUpLeft(row, col, p);
    	boolean downRight = checkDownRight(row, col, p);
    	boolean downLeft = checkDownLeft(row, col, p);
    	
    	if(right) {
    		for(int i = row, j = col + 1; gridDisplay[i][j] != p.getMyPiece(); j++) {
    			gridDisplay[i][j] = p.getMyPiece();
    		}
    	}
    		
    	if(left) {
    		for(int i = row, j = col - 1; gridDisplay[i][j] != p.getMyPiece(); j--) {
    			gridDisplay[i][j] = p.getMyPiece();
    		}
    	}
    		
    	if(up) {
    		for(int i = row - 1, j = col; gridDisplay[i][j] != p.getMyPiece(); i--) {
    			gridDisplay[i][j] = p.getMyPiece();
    		}
    	}
    		
    	if(down) {
    		for(int i = row + 1, j = col; gridDisplay[i][j] != p.getMyPiece(); i++) {
    			gridDisplay[i][j] = p.getMyPiece();
    		}
    	}
    		
		if(upLeft) {
			for(int i = row - 1, j = col - 1; gridDisplay[i][j] != p.getMyPiece(); i--, j--) {
    			gridDisplay[i][j] = p.getMyPiece();
    		}
		}
			
		if(downLeft) {
			for(int i = row + 1, j = col - 1; gridDisplay[i][j] != p.getMyPiece(); i++, j--) {
    			gridDisplay[i][j] = p.getMyPiece();
    		}
		}
			
		if(downRight) {
			for(int i = row + 1, j = col + 1; gridDisplay[i][j] != p.getMyPiece(); i++, j++) {
    			gridDisplay[i][j] = p.getMyPiece();
    		}
		}
    	
		if(upRight) {
			for(int i = row - 1, j = col + 1; gridDisplay[i][j] != p.getMyPiece(); i--, j++) {
    			gridDisplay[i][j] = p.getMyPiece();
    		}
		}
		
		gridDisplay[row][col] = p.getMyPiece();
    	
    }//flip()
    
    /**
     * This method returns whether or not a player (passed in as a parameter) has any legal
     * moves on the current board configuration. If he/she does, this method returns true. If 
     * not, this method returns false. This method also updates the gridDisplay instance to
     * show an '_' underscore wherever there is a legal move.
     * 
     * @param p
     * 			Either player 1 or player 2 in the game
     * 
     * @return hasMoves
     * 			If any of the squares are legal moves for player p, hasMoves is true
     */
    public boolean legalMove(Player p) {

    	boolean hasMoves = false;
    	for(int m = 0; m < 8; m++) {
		    for(int n = 0; n < 8; n++) {
		    	if(gridDisplay[m][n] == '_')
		    		gridDisplay[m][n] = '.';
		    }
    	}
    	
		for(int i = 0; i < 8; i++) {
		    for(int j = 0; j < 8; j++) {
		    	if (gridDisplay[i][j] == '.' && 
		    	(checkRight(i, j, p) ||
		    	checkLeft(i, j, p) ||
		    	checkUp(i, j, p) ||
		    	checkDown(i, j, p) ||
		    	checkUpLeft(i, j, p) ||
		    	checkDownLeft(i, j, p) ||
		    	checkDownRight(i, j, p) ||
		    	checkUpRight(i, j, p))) {
		    	gridDisplay[i][j] = '_';
		    	hasMoves = true;
		    	}
		    }//for j
		}//for i
		return hasMoves;
    }//legalMove()
 
    /**
     * This method checks whether or not placing a piece at the given spot sandwiches opponents pieces in the 
     * right direction.
     * 
     * @param row
     * 				The row index of the move chosen
     * @param col
     * 				The col index of the move chosen
     * @param p
     * 				Either player 1 or player 2
     * @return true or false
     * 				Returns true if this move sandwiches opponents pieces in the right direction. False otherwise
     */
    public boolean checkRight(int row, int col, Player p) {
    	
    	if (col>5)
    		return false;
    	
    	if(gridDisplay[row][col+1]== p.getOpponentsPiece()){	
			for(int m=col+2; m<=7; m++){
				if(gridDisplay[row][m] == '.' || gridDisplay[row][m] == '_') return false;
				if(gridDisplay[row][m] == p.getMyPiece() ) return true;
				if(gridDisplay[row][m] == p.getOpponentsPiece() ) continue;
			}
    	}
    	return false;
    }//checkRight
    
    /**
     * This method checks whether or not placing a piece at the given spot sandwiches opponents pieces in the 
     * left direction.
     * 
     * @param row
     * 				The row index of the move chosen
     * @param col
     * 				The col index of the move chosen
     * @param p
     * 				Either player 1 or player 2
     * @return true or false
     * 				Returns true if this move sandwiches opponents pieces in the left direction. False otherwise
     */
    public boolean checkLeft(int row, int col, Player p){
    	if (col<2)
    		return false;
    	
    	if(gridDisplay[row][col-1]==p.getOpponentsPiece()){
			for(int m=col-2; m>=0; m--){
				if(gridDisplay[row][m] == '.' || gridDisplay[row][m] == '_') return false;
				if(gridDisplay[row][m] == p.getMyPiece() ) return true;
				if(gridDisplay[row][m] == p.getOpponentsPiece() ) continue;
			}
    	}
    	
    	return false;
    }
    
    /**
     * This method checks whether or not placing a piece at the given spot sandwiches opponents pieces in the 
     * up direction.
     * 
     * @param row
     * 				The row index of the move chosen
     * @param col
     * 				The col index of the move chosen
     * @param p
     * 				Either player 1 or player 2
     * @return true or false
     * 				Returns true if this move sandwiches opponents pieces in the up direction. False otherwise
     */
    public boolean checkUp(int row, int col, Player p){
    	if (row<2)
    		return false;
    	
    	if(gridDisplay[row-1][col]==p.getOpponentsPiece()){
			for(int m=row-2; m>=0; m--){
				if(gridDisplay[m][col] == '.' || gridDisplay[m][col] == '_') return false;
				if(gridDisplay[m][col] == p.getMyPiece() ) return true;
				if(gridDisplay[m][col] == p.getOpponentsPiece() ) continue;
			}
    	}
    	
    	return false;
    }
    
    /**
     * This method checks whether or not placing a piece at the given spot sandwiches opponents pieces in the 
     * down direction.
     * 
     * @param row
     * 				The row index of the move chosen
     * @param col
     * 				The col index of the move chosen
     * @param p
     * 				Either player 1 or player 2
     * @return true or false
     * 				Returns true if this move sandwiches opponents pieces in the down direction. False otherwise
     */
    public boolean checkDown(int row, int col, Player p){
    	if (row>5)
    		return false;
    	
    	if(gridDisplay[row+1][col]==p.getOpponentsPiece()){
			for(int m=row+2; m<=7; m++){
				if(gridDisplay[m][col] == '.' || gridDisplay[m][col] == '_') return false;
				if(gridDisplay[m][col] == p.getMyPiece() ) return true;
				if(gridDisplay[m][col] == p.getOpponentsPiece() ) continue;
			}
    	}
    	
    	return false;
    }
    
    /**
     * This method checks whether or not placing a piece at the given spot sandwiches opponents pieces in the 
     * up-left direction.
     * 
     * @param row
     * 				The row index of the move chosen
     * @param col
     * 				The col index of the move chosen
     * @param p
     * 				Either player 1 or player 2
     * @return true or false
     * 				Returns true if this move sandwiches opponents pieces in the up-left direction. False otherwise
     */
	public boolean checkUpLeft(int row, int col, Player p){
    	if (row<2 || col<2)
    		return false;
    	
    	if(gridDisplay[row-1][col-1]==p.getOpponentsPiece()){
    		for(int m = row - 2, n = col - 2; m >=0 && n>= 0; m--, n--) {
			
					if(gridDisplay[m][n] == '.' || gridDisplay[m][n] == '_') return false;
					if(gridDisplay[m][n] == p.getMyPiece() ) return true;
					if(gridDisplay[m][n] == p.getOpponentsPiece() ) continue;
			}
    	}
    	return false;
	}	
	
	 /**
     * This method checks whether or not placing a piece at the given spot sandwiches opponents pieces in the 
     * down-left direction.
     * 
     * @param row
     * 				The row index of the move chosen
     * @param col
     * 				The col index of the move chosen
     * @param p
     * 				Either player 1 or player 2
     * @return true or false
     * 				Returns true if this move sandwiches opponents pieces in the down-left direction. False otherwise
     */
	public boolean checkDownLeft(int row, int col, Player p){
    	if (row>5 || col<2)
    		return false;
    	
    	if(gridDisplay[row+1][col-1]==p.getOpponentsPiece()){
    		
    		for(int m = row + 2, n = col - 2; m <= 7 && n >= 0; m++, n--) {
					if(gridDisplay[m][n] == '.' || gridDisplay[m][n] == '_') return false;
					if(gridDisplay[m][n] == p.getMyPiece() ) return true;
					if(gridDisplay[m][n] == p.getOpponentsPiece() ) continue;
			}
    	}
    	return false;
	}
	
	 /**
     * This method checks whether or not placing a piece at the given spot sandwiches opponents pieces in the 
     * down-right direction.
     * 
     * @param row
     * 				The row index of the move chosen
     * @param col
     * 				The col index of the move chosen
     * @param p
     * 				Either player 1 or player 2
     * @return true or false
     * 				Returns true if this move sandwiches opponents pieces in the down-right direction. False otherwise
     */
	public boolean checkDownRight(int row, int col, Player p){
    	if (row>5 || col>5)
    		return false;
    	
    	if(gridDisplay[row+1][col+1]==p.getOpponentsPiece()){
    		for(int m = row + 2, n = col + 2; m <= 7 && n <= 7; m++, n++) {
					if(gridDisplay[m][n] == '.' || gridDisplay[m][n] == '_') return false;
					if(gridDisplay[m][n] == p.getMyPiece() ) return true;
					if(gridDisplay[m][n] == p.getOpponentsPiece() ) continue;
			}
    	}
    	return false;
	}
	
	 /**
     * This method checks whether or not placing a piece at the given spot sandwiches opponents pieces in the 
     * up-right direction.
     * 
     * @param row
     * 				The row index of the move chosen
     * @param col
     * 				The col index of the move chosen
     * @param p
     * 				Either player 1 or player 2
     * @return true or false
     * 				Returns true if this move sandwiches opponents pieces in the up-right direction. False otherwise
     */
	public boolean checkUpRight(int row, int col, Player p){
    	if (row<2 || col>5)
    		return false;
    	
    	if(gridDisplay[row-1][col+1]==p.getOpponentsPiece()){
    		for(int m = row - 2, n = col + 2; m >=0 && n <= 7; m--, n++) {
					if(gridDisplay[m][n] == '.' || gridDisplay[m][n] == '_') return false;
					if(gridDisplay[m][n] == p.getMyPiece() ) return true;
					if(gridDisplay[m][n] == p.getOpponentsPiece() ) continue;
			}
    	}
    	return false;
	}  
    
    /**
     * The arguments of main are evaluated to decide what type of players will play the game. An argument of
     * "human" represents a human player, "randomcomputerplayer" represents a computer player that chooses
     * random moves, and "intelligentcomputerplayer" represents a computer player that uses an algorithm to make
     * a smart move. The first argument will be player one, and the second argument is player two. Invalid arguments
     * are dealt with by ending the program and referring the user to the INSTRUCTIONS.txt to learn the correct
     * syntax for input. The ReversiBoard instance called game is created and the game starts with the two players
     * specified in the arguments.
     * 
     * @param args
     * 				The types of players that will be playing the game
     */
    public static void main(String[] args) {
    
    	ReversiBoard game = new ReversiBoard();

    	if(args.length != 2) {
    		System.out.println("Incorrect input. Read instructions.txt");
    		System.exit(0);
    	}
    	
    	switch (args[0].toLowerCase()) {
    	
    	case "human": 
    		Player humanPlayer1 = new HumanPlayer();
    		game.setP1(humanPlayer1);
    		break;
    		
    	case "randomcomputerplayer":
    		Player randomComputerPlayer1 = new RandomComputerPlayer(game);
    		randomComputerPlayer1.setMyPiece('X');
    		game.setP1(randomComputerPlayer1);
    		break;
    		
    	case "intelligentcomputerplayer": 
    		Player intelligentComputerPlayer1 = new IntelligentComputerPlayer(game);
    		intelligentComputerPlayer1.setMyPiece('X');
    		game.setP1(intelligentComputerPlayer1);
    		break;
    		
    	default:
    		System.out.println("Incorrect input. Read instructions.txt");
    		System.exit(0);
    	}//switch
    	
    	
		switch (args[1].toLowerCase()) {

		case "human":
			Player humanPlayer2 = new HumanPlayer();
			humanPlayer2.setMyPiece('O');
			game.setP2(humanPlayer2);
			break;

		case "randomcomputerplayer":
			Player randomComputerPlayer2 = new RandomComputerPlayer(game);
			randomComputerPlayer2.setMyPiece('O');
			game.setP2(randomComputerPlayer2);
			break;

		case "intelligentcomputerplayer":
			Player intelligentComputerPlayer2 = new IntelligentComputerPlayer(game);
			intelligentComputerPlayer2.setMyPiece('O');
			game.setP2(intelligentComputerPlayer2);
			break;

		default:
			System.out.println("Incorrect input. Read instructions.txt");
			System.exit(0);
		}//switch
    	
    	game.run();
    	
    	
    }//main
    
}//ReversiBoard