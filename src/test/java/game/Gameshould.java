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

}