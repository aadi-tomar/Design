import java.util.List;
import java.util.Map;
import java.util.Queue;

public class GameBoard {

    private Dice dice;
    private Queue< Player > nextTurn;
    private  List< Jumper > snakes;
    private List< Jumper > ladders;
    private Map< String, Integer> playersCurrPosition;
    int boardSize;

    public GameBoard(Dice dice, Queue< Player> nextTurn , List<Jumper> snakes , List< Jumper> ladders , Map< String, Integer> playersCurrPosition, int boardSize){

        this.dice = dice;
        this.nextTurn = nextTurn;
        this.snakes = snakes;
        this.ladders = ladders;
        this.playersCurrPosition = playersCurrPosition;
        this.boardSize = boardSize;

    }


    void startGame(){
        while(nextTurn.size() > 1) {
            Player player = nextTurn.remove();
            int currPosition = playersCurrPosition.get(player.getPlayerName());

            int diceValue = dice.rollDice();
            int nextCell = currPosition + diceValue;

            // for the finish Condition
            if (nextCell > boardSize)
                nextTurn.add(player);
            else if (nextCell == boardSize) {
                System.out.println(player.getPlayerName() + " has won the game");

            } else {
                int[] nextPosition = new int[1];
                boolean[] isLadder = new boolean[1];
                nextPosition[0] = nextCell;
                snakes.forEach(v -> {
                    if (v.startPoint == nextCell) {
                        nextPosition[0] = v.endPoint;
                    }
                });
                if (nextPosition[0] != nextCell) {
                    System.out.println(player.getPlayerName() + " is bitten by snake at " + nextCell);
                }

                ladders.forEach(v -> {
                    if (v.startPoint == nextCell) {
                        nextPosition[0] = v.endPoint;
                        isLadder[0] = true;
                    }
                });
                if (nextPosition[0] != nextCell && isLadder[0] == true) {
                    System.out.println(player.getPlayerName() + " climbed ladder at " + nextCell);
                }
                if (nextPosition[0] == boardSize) {
                    System.out.println(player.getPlayerName() + " has won the game");
                } else {
                    playersCurrPosition.put(player.getPlayerName(), nextPosition[0]);
                    System.out.println(player.getPlayerName() + " is at position " + nextPosition[0]);
                    nextTurn.add(player);
                }


            }
        }


    }



}
