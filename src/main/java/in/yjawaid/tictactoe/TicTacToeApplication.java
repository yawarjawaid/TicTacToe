package in.yjawaid.tictactoe;

import in.yjawaid.tictactoe.controller.GameController;
import in.yjawaid.tictactoe.model.*;
import in.yjawaid.tictactoe.services.strategies.winningstrategy.ColWinningStrategy;
import in.yjawaid.tictactoe.services.strategies.winningstrategy.DiagonalWinningStrategy;
import in.yjawaid.tictactoe.services.strategies.winningstrategy.RowWinningStrategy;
import in.yjawaid.tictactoe.services.strategies.winningstrategy.WinningStrategy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class TicTacToeApplication {

	public static void main(String[] args) {

		//SpringApplication.run(TicTacToeApplication.class, args);
		playTicTacToe();
	}
	private  static void playTicTacToe()
	{
		System.out.println("Let's play TicTacToe");
		List<Player> players = new ArrayList<>();

		players.add(new Player("Yawar", new Symbol('Y'), PlayerType.HUMAN));
		//players.add(new Player("Jawaid", new Symbol('J'), PlayerType.HUMAN));

		players.add(new Bot("Bot1", new Symbol('B'), BotDifficultyLevel.EASY));
		//players.add(new Bot("Bot2", new Symbol('C'), BotDifficultyLevel.EASY));

		List<WinningStrategy> winningStrategies = List.of(
				new RowWinningStrategy(),
				new ColWinningStrategy(),
				new DiagonalWinningStrategy()
		);

		GameController gameController = new GameController();
		gameController.startGame(players, winningStrategies);

		System.out.println(gameController.getGameState());

		while(gameController.getGameState() == GameState.IN_PROGRESS) {
				gameController.printBoard();
				gameController.makeMove();
		}

		//Game over
		System.out.println("Game over");
		gameController.printBoard();
		if(gameController.getGameState() == GameState.ENDED){
			System.out.println("Winner is " + gameController.getWinner().getName());
		} else {
			System.out.println("It's a draw");
		}
	}

}































