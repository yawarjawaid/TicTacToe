package in.yjawaid.tictactoe.services.strategies.winningstrategy;

import in.yjawaid.tictactoe.model.Board;
import in.yjawaid.tictactoe.model.Move;

public interface WinningStrategy {
    boolean isWinning(Board board, Move move);
}
