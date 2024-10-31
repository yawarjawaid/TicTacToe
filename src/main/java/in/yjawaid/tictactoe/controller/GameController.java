package in.yjawaid.tictactoe.controller;

import in.yjawaid.tictactoe.model.GameState;
import in.yjawaid.tictactoe.model.Player;
import in.yjawaid.tictactoe.services.GameServices;
import in.yjawaid.tictactoe.services.strategies.winningstrategy.WinningStrategy;

import java.util.List;

public class GameController {

    private GameServices gameServices;

    public GameController()
    {
        this.gameServices = new GameServices();
    }
    public void startGame(List<Player> players, List<WinningStrategy> winningStrategies){

        gameServices.startGame(players, winningStrategies);

    }

    public void makeMove(){
        gameServices.makeMove();
    }

    public GameState getGameState()  {
        return gameServices.getGameState();
    }

    public Player getWinner() {
        return gameServices.getWinner();
    }
    public void printBoard(){
        gameServices.printBoard();
    }
}
