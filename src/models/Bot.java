package models;

public class Bot extends Player{
    Bot(String name, Symbol symbol , PlayerType type) {
        super(name,symbol,type);
    }

    @Override
    public int playerTurn(Dice dice) {
        return 0;
    }


}
