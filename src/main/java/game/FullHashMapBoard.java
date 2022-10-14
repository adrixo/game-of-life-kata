package game;

import java.util.HashMap;

public class FullHashMapBoard implements Board {
    final HashMap<Coordinate, Boolean> board;
    private final Coordinate bounds;

    public FullHashMapBoard(boolean[][] board) {
        bounds = getBoardBounds(board);
        this.board = setUpBoardFrom(board);

    }

    private HashMap<Coordinate, Boolean> setUpBoardFrom(boolean[][] board) {
        HashMap<Coordinate, Boolean> hashmapBoard = new HashMap<>();
        for (int x = 0; x < bounds.x; x++) {
            for (int y = 0; y < bounds.y; y++) {
                hashmapBoard.put(new Coordinate(x, y), board[x][y]);
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
                boolean cellIsAlive = board.get(new Coordinate(x, y));
                parsedBoard[x][y] = cellIsAlive;
            }
        }
        return parsedBoard;
    }

}
