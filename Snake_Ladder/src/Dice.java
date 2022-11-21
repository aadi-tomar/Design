public class Dice {

    private int numberOfDice;

    public Dice(int numberOfDice){
        this.numberOfDice = numberOfDice;
    }

    public int rollDice(){
        int num = (int)(Math.random()*(6* numberOfDice - 1* numberOfDice)) + 1;

        return num;
    }
}
