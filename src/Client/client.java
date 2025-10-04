package Client;

import controller.GameController;
import models.*;

import java.util.ArrayList;
import java.util.List;

public class client {
    public static void main(String[] args) {
        System.out.println("Welcome to Snake and Ladder Game");
        GameController gameController = new GameController();
        List<Player> players = new ArrayList<>();
        HumanPlayer player1 = new HumanPlayer("Player 1", new Symbol('X'), PlayerType.HUMAN);
        HumanPlayer player2 = new HumanPlayer("Player 2", new Symbol('O'), PlayerType.HUMAN);
        players.add(player1);
        players.add(player2);
        int dimension = 10;
        int diceSides = 6;
        Game game = gameController.startGame(dimension, players, diceSides);
        gameController.display(game);
        while(game.getStatus() == GameStatus.IN_PROGRESS){
            gameController.playerTurn(game);
            gameController.display(game);
        }
    }
}
