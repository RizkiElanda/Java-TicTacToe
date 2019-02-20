import java.util.Scanner;

public class TTTConsoleNonOO2P {
   // Name-constants to represent the seeds and cell contents
   public static final int EMPTY = 0;
   public static final int CROSS = 1;
   public static final int NOUGHT = 2;
    public static final int EMPTY2 = 0;
   public static final int CROSS2 = 1;
   public static final int NOUGHT2 = 2;
 
   // Name-constants to represent the various states of the game
   public static final int PLAYING = 0;
   public static final int DRAW = 1;
   public static final int CROSS_WON = 2;
   public static final int NOUGHT_WON = 3;
   
   public static final int PLAYING2 = 0;
   public static final int DRAW2 = 2;
   public static final int CROSS_WON2 = 2;
   public static final int NOUGHT_WON2 = 3;
   
    
   // The game board and the game status
   public static final int ROWS = 3, COLS = 3; 
   public static final int ROWS2 = 4, COLS2 = 4; 
   public static int[][] board = new int[ROWS][COLS]; // game board in 2D array
   public static int[][] board2 = new int[ROWS2][COLS2];                                                   
   public static int currentState;  // the current state of the game
                                    // (PLAYING, DRAW, CROSS_WON, NOUGHT_WON)
   public static int currentPlayer; // the current player (CROSS or NOUGHT)
   public static int currntRow, currentCol; // current seed's row and column
   public static int currentState2;  // the current state of the game
                                    // (PLAYING, DRAW, CROSS_WON, NOUGHT_WON)
   public static int currentPlayer2; // the current player (CROSS or NOUGHT)
   public static int currntRow2, currentCol2; // current seed's row and column
   public int choice2;
   public int choice;
   public static int choice3;
   public static int rival;
   public static String nama;
   public static Scanner in = new Scanner(System.in); // the input Scanner
 
   /** The entry main method (the program starts here) */
   public static void main(String[] args) {
      // Initialize the game-board and current status
      Menu();
   }
       public static void Menu(){
        System.out.println("=============================");
        System.out.println("--WELCOME TO TICTACTOE GAME--");
        System.out.println("=============================");
        System.out.println("Input Player Name");
        nama = in.nextLine();
        System.out.println("=============================");
        System.out.println("Chosee your Rival");
        System.out.println("1.MiniComputer");
	System.out.println("2.Anonymous");
	System.out.print("Choice: ");
        rival = in.nextInt();
        
        if(rival == 1){
             System.out.println("=============================");
             System.out.println("GAME MiniComputer VS "+nama);
             System.out.println("=============================");
        }else if( rival == 2){
             System.out.println("=============================");
             System.out.println("GAME Anonymous VS "+nama);
             System.out.println("=============================");
        }else{
            System.out.println("Invalid Option");
        } 
        
        System.out.println("=============================");
        System.out.println("What would you like to do?");
        System.out.println("1.Start Game");
	System.out.println("2.Quit");
	System.out.print("Choice: ");
        int choice = in.nextInt();
        
        if(choice == 1){
            BoardChosee();
        }else if(choice == 2){
            System.exit(0);
        }else{
            System.out.println("Invalid Option");
        } 
       
   }
      
    public static void BoardChosee(){
        
        System.out.println("=============================");
        System.out.println("Chosee Board Type");
        System.out.println("1.Board 3X3");
	System.out.println("2.Board 4x4");
	System.out.print("Choice: ");
        int choice2 = in.nextInt();
        
          if(choice2 == 1){
            initGame();
        }else if(choice2 == 2){
            initGame2();
        }else{
            System.out.println("Invalid Option");
        } 
            
   }
 
   /** Initialize the game-board contents and the current states */
   public static void initGame() {
      for (int row = 0; row < ROWS; ++row) {
         for (int col = 0; col < COLS; ++col) {
            board[row][col] = EMPTY;  // all cells empty
         }
      }
      currentState = PLAYING; // ready to play
      currentPlayer = CROSS;  // cross plays first
      
      do {
         playerMove(currentPlayer); // update currentRow and currentCol
         updateGame(currentPlayer, currntRow, currentCol); // update currentState
         printBoard();
         // Print message if game-over
         if (currentState == CROSS_WON) {
            System.out.println("YOU THE WINNER");
         } else if (currentState == NOUGHT_WON) {
            System.out.println("SORRY..YOU LOSE");
         } else if (currentState == DRAW) {
            System.out.println("It's a Draw!");
         }
        
         // Switch player
         currentPlayer = (currentPlayer == CROSS) ? NOUGHT : CROSS;
      } while (currentState == PLAYING);
      
     
      
   }
   
    public static void initGame2() {
        
      for (int row2 = 0; row2 < ROWS2; ++row2) {
         for (int col2 = 0; col2 < COLS2; ++col2) {
            board2[row2][col2] = EMPTY2;  // all cells empty
         }
      }
      currentState2 = PLAYING2; // ready to play
      currentPlayer2 = CROSS2;  // cross plays first
      
      do {
         playerMove2(currentPlayer2); // update currentRow and currentCol
         updateGame2(currentPlayer2, currntRow2, currentCol2); // update currentState
         printBoard2();
         // Print message if game-over
         if (currentState2 == CROSS_WON2) {
            System.out.println ("YOU THE WINNER");
         } else if (currentState2 == NOUGHT_WON2) {
            System.out.println("SORRY..YOU LOSE");
         } else if (currentState2 == DRAW2) {
            System.out.println("It's a Draw");
         }
         // Switch player
         currentPlayer2 = (currentPlayer2 == CROSS2) ? NOUGHT2 : CROSS2;
      } while (currentState2 == PLAYING2); // repeat if not game-
      
       
   }
 
   /** Player with the "theSeed" makes one move, with input validation.
       Update global variables "currentRow" and "currentCol". */
   public static void playerMove(int theSeed) {
      boolean validInput = false;  // for input validation
      do {
         if (theSeed == CROSS) {
            System.out.print("Player["+nama+"] enter your move (row[1-3] column[1-3]): ");
         } else {
             if (rival ==1){
            System.out.print("Player [MiniComputer] enter your move (row[1-3] column[1-3]): ");
            }else if (rival ==2){
             System.out.print("Player [Anonymous] enter your move (row[1-3] column[1-3]): ");
            }
         }
         int row = in.nextInt() - 1;  // array index starts at 0 instead of 1
         int col = in.nextInt() - 1;
         if (row >= 0 && row < ROWS && col >= 0 && col < COLS && board[row][col] == EMPTY) {
            currntRow = row;
            currentCol = col;
            board[currntRow][currentCol] = theSeed;  // update game-board content
            validInput = true;  // input okay, exit loop
         } else {
            System.out.println("This move at (" + (row + 1) + "," + (col + 1)
                  + ") is not valid. Try again...");
         }
      } while (!validInput);  // repeat until input is valid
   }
   
   public static void playerMove2(int theSeed2) {
      boolean validInput2 = false;  // for input validation
      do {
         if (theSeed2 == CROSS2) {
            System.out.print("Player["+nama+"] enter your move (row[1-4] column[1-4]): ");
         } else {
            if (rival ==1){
            System.out.print("Player [MiniComputer] enter your move (row[1-4] column[1-4]): ");
            }else if (rival ==2){
             System.out.print("Player [Anonymous] enter your move (row[1-4] column[1-4]): ");
            }
         }
         int row2 = in.nextInt() - 1;  // array index starts at 0 instead of 1
         int col2 = in.nextInt() - 1;
         if (row2 >= 0 && row2 < ROWS2 && col2 >= 0 && col2 < COLS2 && board2[row2][col2] == EMPTY2) {
            currntRow2 = row2;
            currentCol2 = col2;
            board2[currntRow2][currentCol2] = theSeed2;  // update game-board content
            validInput2 = true;  // input okay, exit loop
         } else {
            System.out.println("This move at (" + (row2 + 1) + "," + (col2 + 1)
                  + ") is not valid. Try again...");
         }
      } while (!validInput2);  // repeat until input is valid
   }
 
   /** Update the "currentState" after the player with "theSeed" has placed on
       (currentRow, currentCol). */
   public static void updateGame(int theSeed, int currentRow, int currentCol) {
      if (hasWon(theSeed, currentRow, currentCol)) {  // check if winning move
         currentState = (theSeed == CROSS) ? CROSS_WON : NOUGHT_WON;
      } else if (isDraw()) {  // check for draw
         currentState = DRAW;
      }
      // Otherwise, no change to currentState (still PLAYING).
   }
   
   public static void updateGame2(int theSeed2, int currentRow2, int currentCol2) {
      if (hasWon2(theSeed2, currentRow2, currentCol2)) {  // check if winning move
         currentState2 = (theSeed2 == CROSS2) ? CROSS_WON2 : NOUGHT_WON2;
      } else if (isDraw2()) {  // check for draw
         currentState2 = DRAW2;
      }
      // Otherwise, no change to currentState (still PLAYING).
   }
 
   /** Return true if it is a draw (no more empty cell) */
   // TODO: Shall declare draw if no player can "possibly" win
   public static boolean isDraw() {
      for (int row = 0; row < ROWS; ++row) {
         for (int col = 0; col < COLS; ++col) {
            if (board[row][col] == EMPTY) {
               return false;  // an empty cell found, not draw, exit
            }
         }
      }
      return true;  // no empty cell, it's a draw
   }
   
   public static boolean isDraw2() {
      for (int row2 = 0; row2 < ROWS2; ++row2) {
         for (int col2 = 0; col2 < COLS2; ++col2) {
            if (board2[row2][col2] == EMPTY2) {
               return false;  // an empty cell found, not draw, exit
            }
         }
      }
      return true;  // no empty cell, it's a draw
   }
 
   /** Return true if the player with "theSeed" has won after placing at
       (currentRow, currentCol) */
   public static boolean hasWon(int theSeed, int currentRow, int currentCol) {
      return (board[currentRow][0] == theSeed         // 3-in-the-row
                   && board[currentRow][1] == theSeed
                   && board[currentRow][2] == theSeed
              || board[0][currentCol] == theSeed      // 3-in-the-column
                   && board[1][currentCol] == theSeed
                   && board[2][currentCol] == theSeed
              || currentRow == currentCol            // 3-in-the-diagonal
                   && board[0][0] == theSeed
                   && board[1][1] == theSeed
                   && board[2][2] == theSeed
              || currentRow + currentCol == 2  // 3-in-the-opposite-diagonal
                   && board[0][2] == theSeed
                   && board[1][1] == theSeed
                   && board[2][0] == theSeed);
   }
 
   
   public static boolean hasWon2(int theSeed2, int currentRow2, int currentCol2) {
      return (board2[currentRow2][0] == theSeed2         // 3-in-the-row
                   && board2[currentRow2][1] == theSeed2
                   && board2[currentRow2][2] == theSeed2
                   && board2[currentRow2][3] == theSeed2
              || board2[0][currentCol2] == theSeed2      // 3-in-the-column
                   && board2[1][currentCol2] == theSeed2
                   && board2[2][currentCol2] == theSeed2
                   && board2[3][currentCol2] == theSeed2
              || currentRow2 == currentCol2            // 3-in-the-diagonal
                   && board2[0][0] == theSeed2
                   && board2[1][1] == theSeed2
                   && board2[2][2] == theSeed2
                   && board2[3][3] == theSeed2
              || currentRow2 + currentCol2 == 2  // 3-in-the-opposite-diagonal
                   && board2[0][2] == theSeed2
                   && board2[1][1] == theSeed2
                   && board2[2][0] == theSeed2
                   && board2[3][0] == theSeed2);
   }
   /** Print the game board */
   public static void printBoard() {
      for (int row = 0; row < ROWS; ++row) {
         for (int col = 0; col < COLS; ++col) {
            printCell(board[row][col]); // print each of the cells
            if (col != COLS - 1) {
               System.out.print("|");   // print vertical partition
            }
         }
         System.out.println();
         if (row != ROWS - 1) {
            System.out.println("-----------"); // print horizontal partition
         }
      }
      System.out.println();
   }
   
   public static void printBoard2() {
      for (int row2 = 0; row2 < ROWS2; ++row2) {
         for (int col2 = 0; col2 < COLS2; ++col2) {
            printCell2(board2[row2][col2]); // print each of the cells
            if (col2 != COLS2 - 1) {
               System.out.print("|");   // print vertical partition
            }
         }
         System.out.println();
         if (row2 != ROWS2 - 1) {
            System.out.println("---------------"); // print horizontal partition
         }
      }
      System.out.println();
   }
 
   /** Print a cell with the specified "content" */
   public static void printCell(int content) {
      switch (content) {
         case EMPTY:  System.out.print("   "); break;
         case NOUGHT: System.out.print(" O "); break;
         case CROSS:  System.out.print(" X "); break;
      }
   }
   
    public static void printCell2(int content2) {
      switch (content2) {
         case EMPTY2:  System.out.print("   "); break;
         case NOUGHT2: System.out.print(" O "); break;
         case CROSS2:  System.out.print(" X "); break;
      }
   }
}