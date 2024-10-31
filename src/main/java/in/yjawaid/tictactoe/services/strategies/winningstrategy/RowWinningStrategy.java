package in.yjawaid.tictactoe.services.strategies.winningstrategy;

import in.yjawaid.tictactoe.model.Board;
import in.yjawaid.tictactoe.model.Move;
import in.yjawaid.tictactoe.model.Symbol;

import java.util.HashMap;
import java.util.Map;

public class RowWinningStrategy implements WinningStrategy{

    private Map<Integer, Map<Symbol,Integer>> rowMap = new HashMap<>();


    @Override
    public boolean isWinning(Board board, Move move) {
        int row = move.getCell().getRow();
        Symbol symbol = move.getPlayer().getSymbol();

        //check if the current row is present in map
        if(!rowMap.containsKey((row)))
        {
            rowMap.put(row, new HashMap<>());
        }

        Map<Symbol, Integer>  rowCount = rowMap.get(row);

        //check if the symbol is present in the row
        if(!rowCount.containsKey(symbol))
        {
            rowCount.put(symbol,0);
        }
        rowCount.put(symbol, rowCount.get(symbol)+1);

        return rowCount.get(symbol) == board.getDimension();
    }
}




















