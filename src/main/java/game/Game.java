package game;

import java.util.HashMap;

public class Game {

    private final HashMap<Coordinate, Boolean> board;
    private final int boardSize;

    public Game(boolean[][] board) {
        this.boardSize = board[0].length;
        this.board = booleanBoardToHashmap(board);
    }

    public void nextGen() {
    }

    private HashMap<Coordinate, Boolean> booleanBoardToHashmap(boolean[][] board) {
        HashMap<Coordinate, Boolean> hashmapBoard = new HashMap<>();
        for (int x = 0; x < boardSize; x++) {
            for (int y = 0; y < boardSize; y++) {
                hashmapBoard.put(new Coordinate(x, y), board[x][y]);
            }
        }
        return hashmapBoard;
    }

    public boolean[][] getBoard() {
        boolean[][] parsedBoard = new boolean[boardSize][boardSize];

        for (int x = 0; x < boardSize; x++) {
            for (int y = 0; y < boardSize; y++) {
                boolean cellIsAlive = board.get(new Coordinate(x, y));
                parsedBoard[x][y] = cellIsAlive;
            }
        }
        return parsedBoard;
    }
}
