package game;

import game.board.Board;
import game.board.FullHashMapBoard;
import game.board.HashMapBoard;

public class Game {

    private final Board board;

    public Game(boolean[][] board) {
        this.board = new HashMapBoard(board);
    }

    public void nextGen() {
        this.board.nextGen();
    }

    public boolean[][] getBoard() {
        return board.getBoard();
    }

}
