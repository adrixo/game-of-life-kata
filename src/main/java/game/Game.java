package game;

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
