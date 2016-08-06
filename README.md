# Text-Based-Reversi-Game

First Repository on Github

Aaron Martinez
Partner: Matthew Butcher

University of Georgia Undergraduate studying Computer Science and Mathematics


INSTRUCTIONS

** Running the program **
In order to run the program, use the following command from the command line after compiling:
java Reversi argument1 argument2.
- argument1 should be replaced with either humanplayer, randomcomputerplayer, or intelligentcomputerplayer
- argument2 should be replaced with either humanplayer, randomcomputerplayer, or intelligentcomputerplayer
- The player passed in as argument1 will use the X game piece. The player passed in as argument2 will use the O game piece.
- The arguments are not case sensitive. i.e hUmAnPLAyer is a valid argument.

** Playing the game **
Commands should be entered in the following format: 
[row] [col]
[row] represents how far down the cell is in the grid.
[col] represents how far right the cell is in the grid.
- [row] should be replaced with an integer between 1 and 8
- [col] should be replaced with an integer between 1 and 8

** End game conditions **
- All cells on the grid have been converted to a players piece
- Neither players can make a legal move

** Game Mechanics **
Players can only make moves that are deemed legal. A move is legal if the following conditions apply:
- The move is on an empty cell (represented by .)
- The move is within the boundaries of the grid.
- The move sandwiches the opponents pieces. Sandwiching requires that an immediately adjacent cell is held by the 
opponent and some cell further in that direction is held by you.
- The player who holds the most cells at the end of the game wins.
- The four cells with indices [4][4],[4][5],[5][4], and [5][5] are pre-filled with X,O,X, and O respectively.

** Notes on functionality implementation **
The arguments of the main method are used to decide the type(s) of players. Each type of player has its own dedicated class 
with unique method implementations. For example, the HumanPlayer class asks for user input, but the RandomComputerPlayer 
class has an algorithm that chooses a random move out of the possible legal moves. When neither player can make a legal move, 
the game ends and the scores are calculated to determine the winner.
