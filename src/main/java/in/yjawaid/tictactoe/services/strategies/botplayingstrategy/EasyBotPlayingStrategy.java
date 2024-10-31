package in.yjawaid.tictactoe.services.strategies.botplayingstrategy;

import in.yjawaid.tictactoe.model.Board;
import in.yjawaid.tictactoe.model.Cell;
import in.yjawaid.tictactoe.model.CellState;

public class EasyBotPlayingStrategy implements BotPlayingStrategy {
    public Cell makeMove(Board board) {
        // Generate a random move
        int row, col;
        do {
            row = (int) (Math.random() * board.getDimension());
            col = (int) (Math.random() * board.getDimension());
        } while (board.getBoard().get(row).get(col).getCellState() != CellState.EMPTY);

        return new Cell(row, col);
    }

}
