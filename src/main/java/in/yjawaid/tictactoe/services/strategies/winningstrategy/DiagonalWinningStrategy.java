package in.yjawaid.tictactoe.services.strategies.winningstrategy;

import in.yjawaid.tictactoe.model.Board;
import in.yjawaid.tictactoe.model.Move;
import in.yjawaid.tictactoe.model.Symbol;

import java.util.HashMap;
import java.util.Map;

public class DiagonalWinningStrategy implements  WinningStrategy{
    private Map<Symbol, Integer> leftDiagonal = new HashMap<>();
    private Map<Symbol, Integer> rightDiagonal = new HashMap<>();


    @Override
    public boolean isWinning(Board board, Move move) {

        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        Symbol symbol = move.getPlayer().getSymbol();
        //left diagonal

        if( row == col) {
            if (!leftDiagonal.containsKey(symbol)) {
                leftDiagonal.put(symbol, 0);
            }
            leftDiagonal.put(symbol, leftDiagonal.get(symbol) + 1);
            if (leftDiagonal.get(symbol) == board.getDimension()) return true;
        }

            //right diagonal

        if( row+col == board.getDimension() -1){
            if( !rightDiagonal.containsKey(symbol)){
                rightDiagonal.put(symbol,0);
            }
            rightDiagonal.put(symbol, rightDiagonal.get(symbol) + 1 );
            return rightDiagonal.get(symbol) == board.getDimension();

        }

        return false;

    }
}
