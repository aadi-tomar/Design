import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GameBoard {
    int boardSize;
    char [][] board;
    Queue< Player> nextTurn;
    Scanner input;
    public GameBoard(int boardSize, Player[] players){
        this.boardSize = boardSize;
        this.board = new char [2*boardSize - 1][2*boardSize - 1];
        initializeBoard(board);
        nextTurn = new LinkedList<>();
        nextTurn.add(players[0]);
        nextTurn.add(players[1]);
        input = new Scanner(System.in);
    }

    private void initializeBoard( char [][] board){
        for(int i=0; i< board.length; i++){
            for(int j=0; j< board[0].length;j++){
                if( i%2 ==0 && j%2!=0){
                    board[i][j] = '|';
                }
                else if(i%2!=0 && j%2==0){
                    board[i][j] = '-';
                }
                else if( i%2 !=0 && j%2!=0){
                    board[i][j] = '+';
                }
            }
        }
    }

    private void printBoard(){
        for(int i=0; i< board.length;i++){
            for(int j=0; j< board[0].length;j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public void startGame(){
        int count = 0;
        while(true){
            count++;
            if(count == (boardSize* boardSize) + 1){
                System.out.println("Match has drawn");
                break;
            }
            Player p = nextTurn.remove();
            int pos = getUserInput(p);
            int row = 2 * (pos % boardSize ==0 ? pos/boardSize -1 : pos/boardSize);
            int col = 2 * ((pos %boardSize == 0 ? boardSize : pos% boardSize)-1);
            board[row][col] = p.getPlayerSymbol();
            System.out.println("Board after the move");
            printBoard();
            if(checkGameState(p, row, col)){
                break;
            }
            nextTurn.add(p);
        }
    }

    private boolean checkGameState( Player p, int row, int col){
        String winString = "";
        for(int i=0; i< boardSize; i++)
            winString+=String.valueOf(p.getPlayerSymbol());

        String rowString ="";
        String colString = "";
        String diagonalString = "";
        String revDiagonal = "";

        for(int i=0; i<board.length;i+=2){
            rowString += board[row][i];
            colString += board[i][col];
            if(row == col){
                diagonalString += board[i][i];
            }
            if(row+col == board.length - 1){
                revDiagonal += board[board.length - i - 1][i];
            }
        }

        if(winString.equals(rowString) || winString.equals(colString) || winString.equals(diagonalString) || winString.equals(revDiagonal)){
            System.out.println(p.getPlayerName() + " has won the game ");
            return true;
        }
        return false;


    }

    private int getUserInput(Player p){
        System.out.println(p.getPlayerName() + " should enter a number between 1 -" + boardSize*boardSize);
        int val = input.nextInt();

        while(!validateInput(val)){
            printBoard();
            System.out.println("You've entered wrong number. Please enter again");
            val = input.nextInt();
        }
        return  val;
    }

    private boolean validateInput(int val){
        if( val <1 && val > boardSize* boardSize)
            return false;

        int row = 2 * (val % boardSize ==0 ? val/boardSize -1 : val/boardSize);
        int col = 2 * ((val %boardSize == 0 ? boardSize : val% boardSize)-1);
        if( board[row][col] !=0)
            return false;
        return true;
    }
}
