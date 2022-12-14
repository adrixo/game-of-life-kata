package game.board;

import game.Cell;
import game.Coordinate;

import java.util.ArrayList;
import java.util.HashMap;

public class FullHashMapBoard implements Board {
    // Responsibility of apply rules on board
    // hashmap with all the cells

    final HashMap<Coordinate, Cell> board;
    private final Coordinate bounds;

    public FullHashMapBoard(boolean[][] board) {
        bounds = getBoardBounds(board);
        this.board = setUpBoardFrom(board);

    }

    @Override
    public void nextGen() {
        ArrayList<Cell> cellsToKill = new ArrayList<>();
        ArrayList<Cell> cellsToBorn = new ArrayList<>();
        for(Cell cell : board.values()) {
            int neighbours = getAliveNeighboursOf(cell);
            if (cell.isAlive && (neighbours <= 1 || neighbours >= 4) ) {
                cellsToKill.add(cell);
            }
            if (!cell.isAlive && neighbours == 3)
                cellsToBorn.add(cell);
        }
        killCells(cellsToKill);
        bornCells(cellsToBorn);
    }

    private void killCells(ArrayList<Cell> cells) {
        for (Cell cell : cells) {
            cell.kill();
        }
    }

    private void bornCells(ArrayList<Cell> cells) {
        for (Cell cell : cells) {
            cell.born();
        }
    }

    private int getAliveNeighboursOf(Cell cell) {
        int neighbours = 0;
        Coordinate position = cell.position;
        for (Coordinate neighbourPosition : cell.position.getNeighbours()) {
            if (!board.containsKey(neighbourPosition))
                continue;

            Cell neighbour = board.get(neighbourPosition);
            if (neighbour.isAlive)
                neighbours++;
        }
        return neighbours;
    }

    private HashMap<Coordinate, Cell> setUpBoardFrom(boolean[][] board) {
        HashMap<Coordinate, Cell> hashmapBoard = new HashMap<>();
        for (int x = 0; x < bounds.x; x++) {
            for (int y = 0; y < bounds.y; y++) {
                Coordinate position = new Coordinate(x, y);
                Cell cell = new Cell(board[x][y], position);
                hashmapBoard.put(position, cell);
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
                boolean cellIsAlive = board.get(new Coordinate(x, y)).isAlive;
                parsedBoard[x][y] = cellIsAlive;
            }
        }
        return parsedBoard;
    }

}
