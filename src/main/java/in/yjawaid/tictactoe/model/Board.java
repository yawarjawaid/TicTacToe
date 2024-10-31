package in.yjawaid.tictactoe.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class Board {
    private int dimension;
    private List<List<Cell>>  board;

    public Board(int dimension) {
        this.dimension = dimension;
        this.board = new ArrayList<List<Cell>>();

        for(int i = 0; i< dimension; i++)
        {
            List<Cell> rows = new ArrayList<>();
            for(int j=0; j<dimension; j++) {
                rows.add( new Cell(i,j));
            }
            this.board.add(rows);
        }
    }

    public void printBoard() {
        for( List<Cell> cells : board){
            for(Cell cell : cells){
                if(cell.getCellState() == CellState.EMPTY){
                    System.out.print("| |");
                } else {
                    System.out.print("|" + cell.getPlayer().getSymbol().getSymbol() +  "|");
                }

            }
            System.out.println();
        }
    }

}
