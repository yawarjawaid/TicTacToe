package in.yjawaid.tictactoe.services.strategies.botplayingstrategy;

import in.yjawaid.tictactoe.model.Board;
import in.yjawaid.tictactoe.model.Cell;

public interface BotPlayingStrategy {

    public Cell makeMove(Board board);
}
