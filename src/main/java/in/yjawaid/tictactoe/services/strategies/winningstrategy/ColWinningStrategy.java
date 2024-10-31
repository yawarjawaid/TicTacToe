package in.yjawaid.tictactoe.services.strategies.winningstrategy;

import in.yjawaid.tictactoe.model.Board;
import in.yjawaid.tictactoe.model.Move;
import in.yjawaid.tictactoe.model.Symbol;

import java.util.HashMap;
import java.util.Map;

public class ColWinningStrategy implements WinningStrategy{
    private Map<Integer, Map<Symbol, Integer>> colMap = new HashMap<>();

    @Override
    public boolean isWinning(Board board, Move move) {
        int col = move.getCell().getCol();
        Symbol symbol = move.getPlayer().getSymbol();

        // check if current column is present in map
        if (!colMap.containsKey(col)) {
            colMap.put(col, new HashMap<>());
        }

        Map<Symbol, Integer> colCount = colMap.get(col);

        // Check if current symbol is present in the map
        if (!colCount.containsKey(symbol)) {
            colCount.put(symbol, 0);
        }

        colCount.put(symbol, colCount.get(symbol) + 1);
        return colCount.get(symbol) == board.getDimension();
    }
}
