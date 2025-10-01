package models;

import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private GameStatus status;
    private int nextPlayerIndex;
    private Dice dice;
    private Player winner;

    private Game (Builder builder){
        this.board = new Board(builder.dimension);
        this.players = builder.players;
        this.dice = new Dice(builder.diceSides);
        this.status = GameStatus.IN_PROGRESS;
        this.nextPlayerIndex = 0;
        this.winner = null;

    }

    public Board getBoard() {
        return board;
    }

    public List<Player> getPlayers() {
        return players;
    }



    public GameStatus getStatus() {
        return status;
    }


    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public Dice getDice() {
        return dice;
    }

    public Player getWinner() {
        return winner;
    }

    public void playerTurn() {
        Player currentPlayer = players.get(nextPlayerIndex);
        System.out.println("Current Player: " + currentPlayer.getName());

        int diceRoll = currentPlayer.playerTurn(dice);
        int oldPosition = currentPlayer.getCurrentPosition();
        int newPosition = oldPosition + diceRoll;
        int totalCells = board.getSize() * board.getSize();

        if (newPosition > totalCells) {
            System.out.println("Roll exceeds board limit. Player stays at position: " + oldPosition);
            nextPlayerIndex = (nextPlayerIndex + 1) % players.size();
            return;
        }

        // Move and handle obstacles
        Cell targetCell = board.getGrid().get(newPosition - 1);

        if (targetCell.getObstacle() != null) {
            if (targetCell.getObstacle().getType() == ObstacleType.SNAKE) {
                int snakeEnd = targetCell.getObstacle().getEnd();
                movePlayerToCell(currentPlayer, snakeEnd);
                System.out.println("Oh no! " + currentPlayer.getName() + " slides down to position: " + snakeEnd);
                nextPlayerIndex = (nextPlayerIndex + 1) % players.size();
            } else if (targetCell.getObstacle().getType() == ObstacleType.LADDER) {
                int ladderEnd = targetCell.getObstacle().getEnd();
                movePlayerToCell(currentPlayer, ladderEnd);
                System.out.println("Yay! " + currentPlayer.getName() + " climbs up to position: " + ladderEnd);
                System.out.println(currentPlayer.getName() + " gets another turn!");
            }
        } else {
            movePlayerToCell(currentPlayer, newPosition);
            System.out.println(currentPlayer.getName() + " moves to position: " + newPosition);
            nextPlayerIndex = (nextPlayerIndex + 1) % players.size();
        }

        // Win check
        checkWinner(currentPlayer, totalCells);

    }

    private void checkWinner(Player currentPlayer, int totalCells) {
        if (currentPlayer.getCurrentPosition() == totalCells) {
            status = GameStatus.COMPLETED;
            winner = currentPlayer;
            System.out.println("Game Over! The winner is " + currentPlayer.getName());
            return;
        }
    }


    private void movePlayerToCell(Player player, int newPosition) {
        Cell oldCell = board.getGrid().get(player.getCurrentPosition() - 1);
        oldCell.getPlayers().remove(player);

        Cell newCell = board.getGrid().get(newPosition - 1);
        newCell.getPlayers().add(player);
        player.setCurrentPosition(newPosition);
    }



    public static Builder getBuilder(){
        return new Builder();
    }

    public static class Builder{
        private int dimension;
        private List<Player> players;
        private int diceSides;

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }
        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }
        public Builder setDice(int diceSides) {
            this.diceSides = diceSides;
            return this;
        }

        private boolean validate(List<Player> players , int diceSides) {
            long botCount = players.stream()
                    .filter(player -> PlayerType.BOT.equals(player.getType()))
                    .count();

            if(diceSides != 6){
                throw new RuntimeException("Dice should have at least 6 sides");
            }
            if (botCount > 1){
                throw new RuntimeException("Only one bot is allowed");
            }

            return true;
        }

        public Game build(){
            if(validate(this.players, this.diceSides)){
                return new Game(this);
            }
            throw new RuntimeException("Game cannot be created");
        }

    }
}
