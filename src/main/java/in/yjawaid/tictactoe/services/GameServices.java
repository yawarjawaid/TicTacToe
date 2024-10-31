package in.yjawaid.tictactoe.services;

import in.yjawaid.tictactoe.model.*;
import in.yjawaid.tictactoe.services.strategies.winningstrategy.WinningStrategy;

import java.util.List;

public class GameServices {

    private Game game;
    public void startGame(List<Player> players, List<WinningStrategy> winningStrategies ){
        game = Game.getBuilder()
                .setPlayers(players)
                .setWinningStrategies(winningStrategies)
                .build();

         
    }

    private boolean checkWinner(Move move){
        for(WinningStrategy strategy : game.getWinningStrategies()){
            if( strategy.isWinning(game.getBoard(), move)){
                return  true;
            }
        }
        return  false;
    }

    public void makeMove(){

        Player currentPlayer = game.getPlayers().get(game.getNextPlayerTurn());
        Cell moveCell = currentPlayer.makeMove(game.getBoard());

        // valid move, we can execute on the board
        Cell currentCell = game.getBoard().getBoard().get(moveCell.getRow()).get(moveCell.getCol());
        currentCell.setCellState(CellState.FILLED);
        currentCell.setPlayer(currentPlayer);

        Move finalMove = new Move(currentPlayer,moveCell);
        game.getMoves().add(finalMove);

        int nextPlayerIndex = game.getNextPlayerTurn();
        nextPlayerIndex = (nextPlayerIndex +1 ) % game.getPlayers().size();
        game.setNextPlayerTurn(nextPlayerIndex);

        //check Winner or draw
        if(checkWinner(finalMove)){
            game.setWinner(currentPlayer);
            game.setGameState(GameState.ENDED);
        }else if (game.getMoves().size() == game.getBoard().getDimension() * game.getBoard().getDimension()){
            game.setGameState(GameState.DRAW);
        }



    }
    public GameState getGameState(){

        return  game.getGameState();

    }
    public Player getWinner(){

        return game.getWinner();

    }
    public void printBoard(){
        game.getBoard().printBoard();
    }
}
