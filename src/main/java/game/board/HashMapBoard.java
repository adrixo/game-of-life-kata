package game.board;

import game.Cell;
import game.Coordinate;

import java.util.ArrayList;
import java.util.HashMap;

public class HashMapBoard implements Board {
    // hashmap with all the cells
    HashMap<Coordinate, Cell> board;
    private Coordinate bounds;

    public HashMapBoard(boolean[][] board) {
        setUpBoardFrom(board);

    }

    @Override
    public void nextGen() {
        // now we can extract this logic as we want
        for (Cell cell : board.values()) {
            cell.calculateNeighbours();
        }

        for (Cell cell : board.values()) {
            cell.applyRules();
        }
    }

    private void setUpBoardFrom(boolean[][] board) {
        bounds = getBoardBounds(board);
        this.board = new HashMap<>();
        createCells(board);
        addNeighboursToCells();
    }

    private void addNeighboursToCells() {
        for(Cell cell : this.board.values()) {
            ArrayList<Coordinate> neighbourPositions = cell.position.getNeighbours();
            ArrayList<Cell> cellNeighbours = new ArrayList<>();
            for (Coordinate neighbourPosition: neighbourPositions) {
                if (!this.board.containsKey(neighbourPosition))
                    continue;

                Cell neighbour = this.board.get(neighbourPosition);
                cellNeighbours.add(neighbour);
            }
            cell.setNeighbours(cellNeighbours);
        }
    }

    private void createCells(boolean[][] board) {
        for (int x = 0; x < bounds.x; x++) {
            for (int y = 0; y < bounds.y; y++) {
                Coordinate position = new Coordinate(x, y);
                Cell cell = new Cell(board[x][y], position);
                this.board.put(position, cell);
            }
        }
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
