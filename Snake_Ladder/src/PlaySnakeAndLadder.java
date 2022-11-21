import java.util.*;

public class PlaySnakeAndLadder {


    public static void main(String[] args) {
        Dice dice = new Dice(1);
        Player p1 = new Player("Aadi", 1);
        Player p2 = new Player("Swati", 2);

        Queue< Player> allPlayers = new LinkedList<>();
        allPlayers.add(p1);
        allPlayers.add(p2);

        Jumper snake1 = new Jumper(32, 10);
        Jumper snake2 = new Jumper(65 , 23);
        Jumper snake3 = new Jumper(99, 9);

        List< Jumper> snakes = new ArrayList<>();
        snakes.add(snake1);
        snakes.add(snake2);
        snakes.add(snake3);

        Jumper ladder1 = new Jumper(15, 56);
        Jumper ladder2 = new Jumper(43, 85);
        List< Jumper> ladders = new ArrayList<>();
        ladders.add(ladder1);
        ladders.add(ladder2);

        Map< String, Integer > playersCurrPosition = new HashMap<>();
        playersCurrPosition.put("Aadi", 0);
        playersCurrPosition.put("Swati", 0);

        GameBoard gb = new GameBoard( dice, allPlayers, snakes, ladders, playersCurrPosition , 100 );
        gb.startGame();

    }
}
