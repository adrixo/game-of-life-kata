package game;

import java.util.ArrayList;
import java.util.HashMap;

public class FullHashMapBoard implements Board {
    // Responsability of apply rules on board

    final HashMap<Coordinate, Cell> board;
    private final Coordinate bounds;

    public FullHashMapBoard(boolean[][] board) {
        bounds = getBoardBounds(board);
        this.board = setUpBoardFrom(board);

    }

    private HashMap<Coordinate, Cell> setUpBoardFrom(boolean[][] board) {
        HashMap<Coordinate, Cell> hashmapBoard = new HashMap<>();
        for (int x = 0; x < bounds.x; x++) {
            for (int y = 0; y < bounds.y; y++) {
                hashmapBoard.put(new Coordinate(x, y), new Cell(board[x][y]));
            }
        }
        return hashmapBoard;
    }

    private Coordinate getBoardBounds(boolean[][] board) {
        return new Coordinate(board.length, board[0].length);
    }

    @Override
    public boolean[][] getBoard() {
        boolean[][] parsedBoard = new boolean[bounds.x][bounds.y];

        for (int x = 0; x < bounds.x; x++) {
            for (int y = 0; y < bounds.y; y++) {
                boolean cellIsAlive = board.get(new Coordinate(x, y)).status;
                parsedBoard[x][y] = cellIsAlive;
            }
        }
        return parsedBoard;
    }

    @Override
    public void nextGen() {
    }

}
