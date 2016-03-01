public class ReversiBoard implements Board {

    private char[][] gridDisplay;
    private int movesLeft;
    Player p1;
    Player p2;
    
    public ReversiBoard() {
	//call methods to create human or computer players
    }
	
	public char[][] getGridDisplay() {
		return gridDisplay;
	}
    
    public void setP1(Player player1) {
	p1 = player1;
	p1.setMyPiece('X');
    }
    
    public void setP2(Player player2) {
    	p2 = player2;
	p2.setMyPiece('O');
    }
  
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

    public void intro() {
	createGrid();
	System.out.println("Welcome to Reversi! Moves should be entered in \"[row] [column]\" format.\n");
	}   

    public void player1Turn(Player p1) {
    	
    	if(p1 instanceof HumanPlayer) {
    		HumanPlayer humanP1 = new HumanPlayer();
    		humanP1.setMyPiece('X');
    		humanP1.legalMove(); 
        	displayGrid();
    		humanP1.prompt();
    	}//if
    	else if(p1 instanceof RandomComputerPlayer) {
    		RandomComputerPlayer randomP1 = new RandomComputerPlayer();
    		randomP1.setMyPiece('X');
    		randomP1.legalMove();
        	displayGrid();
    		randomP1.randomChoice();
    	}//if
    	else if(p1 instanceof IntelligentComputerPlayer) {
    		IntelligentComputerPlayer intelligentP1 = new IntelligentComputerPlayer();
    		intelligentP1.setMyPiece('X');
    		intelligentP1.legalMove();
        	displayGrid();
    		intelligentP1.smartChoice();
    	}
    }
    
    public void player2Turn(Player p2) {
   
    	if(p2 instanceof HumanPlayer) {
    		HumanPlayer humanP2 = new HumanPlayer();
    		humanP2.setMyPiece('O');
    		humanP2.legalMove();
        	displayGrid();
    		humanP2.prompt();
    	}//if
    	else if(p2 instanceof RandomComputerPlayer)  {
    		RandomComputerPlayer randomP2 = new RandomComputerPlayer();
    		randomP2.setMyPiece('O');
    		randomP2.legalMove();
        	displayGrid();
    		randomP2.randomChoice();
    	}//if
    	else {
    		IntelligentComputerPlayer intelligentP2 = new IntelligentComputerPlayer();
    		intelligentP2.setMyPiece('O');
    		intelligentP2.legalMove();
        	displayGrid();
    		intelligentP2.smartChoice();
    	}//else
    		   	
    }//player2Turn()

    public void run(){
    	intro();
    	while(true){
    	player1Turn(this.p1);
    	player2Turn(this.p2);
    	
    	}
    }
    
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
    	
    }//createGrid()
    
    public static void main(String[] args) {
    
    	ReversiBoard game = new ReversiBoard();

    	if(args.length != 2) {
    		System.out.println("Incorrect input. Read instructions.txt");
    		System.exit(0);
    	}
    	
    	switch (args[0].toLowerCase()) {
    	
    	case "human": 
    		Player humanPlayer1 = new HumanPlayer();
    		humanPlayer1.setMyPiece('X');
    		game.setP1(humanPlayer1);
    		break;
    		
    	case "randomcomputerplayer":
    		Player randomComputerPlayer1 = new RandomComputerPlayer();
    		randomComputerPlayer1.setMyPiece('X');
    		game.setP1(randomComputerPlayer1);
    		break;
    		
    	case "intelligentcomputerplayer": 
    		Player intelligentComputerPlayer1 = new IntelligentComputerPlayer();
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
			Player randomComputerPlayer2 = new RandomComputerPlayer();
			randomComputerPlayer2.setMyPiece('O');
			game.setP2(randomComputerPlayer2);
			break;

		case "intelligentcomputerplayer":
			Player intelligentComputerPlayer2 = new IntelligentComputerPlayer();
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