package models;

public class HumanPlayer extends Player{
    public HumanPlayer(String name, Symbol symbol , PlayerType type) {
        super(name,symbol,type);
    }

    @Override
    public int playerTurn(Dice dice) {
        int diceValue = dice.roll();
        System.out.println(getName() + " rolled a " + diceValue);
        return diceValue;
    }


}
