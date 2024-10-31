package in.yjawaid.tictactoe.model;

import in.yjawaid.tictactoe.services.BotPlayingStrategyFactory;
import in.yjawaid.tictactoe.services.strategies.botplayingstrategy.BotPlayingStrategy;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bot extends Player {

    private BotDifficultyLevel difficultyLevel;

    public Bot(String name, Symbol symbol, BotDifficultyLevel difficultyLevel) {
        super(name, symbol, PlayerType.BOT);
        this.difficultyLevel = difficultyLevel;
    }

    public Cell makeMove(Board board) {
        System.out.println(this.getName() + "'s turn");
        BotPlayingStrategy botPlayingStrategy = BotPlayingStrategyFactory.getBotPlayingStrategy(difficultyLevel);
        return botPlayingStrategy.makeMove(board);
    }
}
