import java.util.Scanner;

public abstract class Player {

    protected int score;
    protected char myPiece;
    protected char opponentsPiece;

    public void move(int row, int col) {
	//some stuff

    }//move    

    public void setMyPiece(char piece) {
    	myPiece = piece;
    	opponentsPiece = ' ';
    	if(myPiece == 'X')
    		opponentsPiece = 'O';
    	else
    		opponentsPiece = 'X';
    }
    
    public void legalMove() {
    	//check if a move is legal
    	boolean legalMove = true;
    	int moves = 0;
		for(int i = 0; i < 8; i++) {
		    for(int j = 0; j < 8; j++) {
		    	checkRight(i, j);
		    	checkLeft(i, j);
		    	checkUp(i, j);
		    	checkDown(i, j);
		    	checkUpLeft(i, j);
		    	checkDownLeft(i, j);
		    	checkDownRight(i, j);
		    	checkDownLeft(i, j);		    	
		    }//for j
		}//for i
    }//legalMove()
 
    public boolean checkRight(int row, int col) {
    	
    /*	
    	if (col>6)
    		return false;
    	
    	if (myPiece == 'X')
    	if(game.getGridDisplay()[row][col+1]=={			//opponents piece)
			for(int m=col+2; m<=8; m++){
				if(gridDisplay[row][m] == '.') return false;
				if(gridDisplay[row][m] == myPiece ) return true;
				if(gridDisplay[row][m] == opponentsPiece ) continue;
			}
    	}
    	*/
    	return true;
    }//checkRight
    
    public boolean checkLeft(int row, int col){
    	
    }
    
    public boolean checkUp(int row, int col){
    	
    }
    
    public boolean checkDown(int row, int col){
    	
    }
    
	public boolean checkUpLeft(int row, int col){
		
	}	
	
	public boolean checkDownLeft(int row, int col){
		
	}
	
	public boolean checkDownRight(int row, int col){
		
	}
	
	public boolean checkUpRight(int row, int col){
		
	}   
    
    
    
    
    
    
    
    

}