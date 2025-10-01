package controller;

import models.Game;
import models.Player;

import java.util.List;

public class GameController {

    public Game startGame(
            int dimension,
            List<Player> players,
            int diceSides
    ){
        return Game.getBuilder()
                .setDimension(dimension)
                .setPlayers(players)
                .setDice(diceSides)
                .build();
    }

    public void playerTurn(Game game){
        game.playerTurn();

    }

}
