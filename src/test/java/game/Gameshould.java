package game;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Gameshould {

    Game game;

    @Test
    public void
    keep_empty_board_when_input_empty_board() {
        boolean[][] emptyBoard = new boolean[10][10];
        game = new Game(emptyBoard);
        game.nextGen();
        assertThat(emptyBoard).isEqualTo(game.getBoard());
    }

    @Test public void
    keep_cells_alive_when_they_should_not_die() {
        boolean[][] inputBoard = {
                {false, true, false, false},
                {true, false, true, false},
                {true, false, true, false},
                {false, true, false, false}
        };
        game = new Game(inputBoard);
        game.nextGen();
        game.nextGen();
        game.nextGen();
        assertThat(inputBoard).isEqualTo(game.getBoard());
    }

    @Test public void
    cells_die_from_under_population() {
        boolean[][] inputBoard = {
                {false, false, false, false},
                {true, false, false, false},
                {false, false, false, true},
                {false, false, true, false}
        };
        boolean[][] expectedBoard = new boolean[4][4];
        game = new Game(inputBoard);
        game.nextGen();
        assertEquals(expectedBoard, game.getBoard());
        assertThat(inputBoard).isEqualTo(game.getBoard());
    }
}