package game;

import game.board.Board;
import game.board.FullHashMapBoard;

public class Game {

    private final Board board;

    public Game(boolean[][] board) {
        this.board = new FullHashMapBoard(board);
    }

    public void nextGen() {
        this.board.nextGen();
    }

    public boolean[][] getBoard() {
        return board.getBoard();
    }

}
