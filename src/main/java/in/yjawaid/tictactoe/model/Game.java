package in.yjawaid.tictactoe.model;

import in.yjawaid.tictactoe.services.strategies.winningstrategy.WinningStrategy;
import lombok.Getter;
import lombok.Setter;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
@Setter
public class Game {

    private List<Player> players;
    private Board board;
    private Player winner;
    private List<Move> moves;
    private GameState gameState;
    private int nextPlayerTurn;
    List<WinningStrategy> winningStrategies;

    private Game(List<Player> players, List<WinningStrategy> winningStrategies) {
        this.players = players;
        int dimension = players.size() + 1;
        this.board = new Board(dimension);
        this.winningStrategies = winningStrategies;
        this.moves = new ArrayList<>();
        this.gameState = GameState.IN_PROGRESS;
        Random random = new Random();
        this.nextPlayerTurn = random.nextInt(players.size());
    }



        //Builder

        public static Builder getBuilder(){
            return new Builder();
        }

        public static class Builder{
            private List<Player> players = new ArrayList<>();
            private List<WinningStrategy> winningStrategies = new ArrayList<>();

            public Builder setPlayers(List<Player> players) {
                this.players = players;
                return this;

            }

            public Builder setWinningStrategies(List<WinningStrategy> winningStrategies) {
                this.winningStrategies = winningStrategies;
                return this;
            }
            public Game build() {
                //validations
                validate();
                return new Game(players, winningStrategies);
            }
            private void validate(){

                if(players == null || players.size() <  2)
                    throw new IllegalArgumentException("Atleast 2 players are required to start the game");
                if (winningStrategies == null || winningStrategies.isEmpty())
                    throw new IllegalArgumentException("Atleast one strategy is required to start the game");
            }
            // More validations can be added here
            // Number of bots in the game

        }


}
