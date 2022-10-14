package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Gameshould {

    Game game;

    @Test
    public void
    keep_empty_board_when_input_empty_board() {
        boolean[][] emptyBoard = new boolean[10][10];
        game = new Game(emptyBoard);
        game.nextGen();
        assertEquals(emptyBoard, game.getBoard());
    }

    @Test public void
    keep_cells_alive_when_they_should_not_die() {
        boolean[][] aliveCells = {
                {false, true, false, false},
                {true, false, true, false},
                {true, false, true, false},
                {false, true, false, false}
        };
        game = new Game(aliveCells);
        game.nextGen();
        game.nextGen();
        game.nextGen();
        assertEquals(aliveCells, game.getBoard());
    }

    @Test public void
    cells_die_from_under_population() {
        boolean[][] board = {
                {false, false, false, false},
                {true, false, false, false},
                {false, false, false, true},
                {false, false, true, false}
        };
        boolean[][] expectedBoard = new boolean[4][4];
        game = new Game(board);
        game.nextGen();
        assertEquals(expectedBoard, game.getBoard());
    }
}